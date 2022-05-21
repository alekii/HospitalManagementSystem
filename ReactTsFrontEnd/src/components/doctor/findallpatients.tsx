import { Box, TableCaption } from "@chakra-ui/react";
import TableUtil from '../common/tableutil';
import TableProps from '../common/interface/tableprops'
import { FiEdit, FiPenTool, FiX } from "react-icons/fi";
import React from "react";
import { useLocation, useNavigate } from 'react-router-dom';
import httpService from "../../service/httpService";
import authService from "../../service/authService";
import config from "../../config/config.json";

const linkToPatientDetail = '/doctor/patients/details'
const TableItems: Array<TableProps> = [
    {
        heading: ['Id','First Name', 'Last Name', 'Age', 'Gender','Action'],
        bodyvalues: [  
        ],
        icon:FiEdit,
        tablecaption:'Listing all patients'
    },
]

function FindAllPatients() {
    const navigate = useNavigate()  
    const [bodyValues, setBodyValues] = React.useState([[]]);
    const [dataPresent, setDataPresent] = React.useState(false);

    const [message, setMessage] = React.useState("")
    React.useEffect(() => {
        fetchPatients();
    }, []);

    async function fetchPatients(){ 
      const docUsername = authService.getCurrentUser(); 
      if(docUsername!==null){ 
      const endPoint = config.apiEndpoint+'/doctor/patients/find/all/'+docUsername
      const res = await httpService.get(endPoint).then(response=>{  
        setBodyValues(response.data);  
        setDataPresent(true);
      }).catch((error)=>{ 
        setMessage(error)
      })
    } 
    }

    const edit=(event:React.MouseEventHandler<HTMLTableColElement>,index:number)=>{ 
     const patientDetails=bodyValues[index] 
      navigate(linkToPatientDetail, {state:{patientDetails:patientDetails}})
     }

    let totalAmount = 0;
  
    TableItems[0].bodyvalues.map(s => {
        totalAmount += s[3]
    })

    if (dataPresent === false) {
        return (
            <Box w="80%" margin="50px 0 0 0">
                <p>No Data</p>
            </Box>
        );
    }
    return (
        <Box w="80%" margin='50px 0 0 0'>
            <TableUtil tablecaption={TableItems[0].tablecaption} handleClick={edit} icon={TableItems[0].icon} heading={TableItems[0].heading} bodyvalues={bodyValues}></TableUtil>
         </Box>
    );
}

export default FindAllPatients;
