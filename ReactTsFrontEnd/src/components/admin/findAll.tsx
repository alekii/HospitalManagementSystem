import { Box} from "@chakra-ui/react";
import TableUtil from '../common/tableutil';
import TableProps from '../common/interface/tableprops'
import { FiEdit, } from "react-icons/fi";
import React from "react";
import { useNavigate, useLocation } from 'react-router-dom';
import config from '../../config/config.json'
import httpService from "../../service/httpService";

const linkToPatientDetail = '/doctor/patients/details'

function FindAllEmployeesByCareerName() {
    const [bodyValues, setBodyValues] = React.useState([])
    const [dataPresent, setDataPresent] = React.useState(false)
    const location = useLocation()
    //I know the type, right?
    const jobFunction = location.state.toLowerCase() 

    const TableItems: Array<TableProps> = [
        {
            heading: ['FirstName', 'Last Name', 'Age', 'Gender','Email','Speciality','Room Assigned','Action'],
            bodyvalues: [ 
            ],
            icon:FiEdit,
            tablecaption:'Listing all '+jobFunction
        },
    ]
    
    React.useEffect(()=>{
         fetchEmployee(); 
    },[])


    async function fetchEmployee(){
        const endPoint = config.apiEndpoint+'/admin/employees/'+jobFunction+'/find/all' 
        const response = await httpService.get(endPoint); 
        setDataPresent(true)
        setBodyValues(response.data)
    }

    const navigate = useNavigate() 
    
    const edit=(event:React.MouseEventHandler<HTMLTableColElement>,index:number)=>{ 
      navigate(linkToPatientDetail, {state:{id:index}})
     }
    if(dataPresent===false){
        return (
            <Box w="80%" margin='50px 0 0 0'>
              <p>No Data</p>
              </Box>
        );
    } 
   
    return (
        <Box w="80%" margin='50px 0 0 0'>
            <TableUtil icon={TableItems[0].icon} tablecaption={TableItems[0].tablecaption} handleClick={edit} heading={TableItems[0].heading} bodyvalues={bodyValues}></TableUtil>
         </Box>
    );
}

export default FindAllEmployeesByCareerName;
