import { Box} from "@chakra-ui/react";
import TableUtil from '../common/tableutil';
import TableProps from '../common/interface/tableprops'
import { FiEdit, } from "react-icons/fi";
import React from "react";
import { useNavigate } from 'react-router-dom';
import authService from "../../service/authService";
import httpService from "../../service/httpService";
import config from "../../config/config.json";


const linkToPatientDetail = '/doctor/patients/details'
const TableItems: Array<TableProps> = [
    {
        heading: ['Name', 'Room', 'Appointment Date'],
        bodyvalues: [  
        ],
        icon:FiEdit,
        tablecaption:'Listing all patients'
    },
]

function FindAllAppointments() {
    const navigate = useNavigate() 
    const [bodyValues, setBodyValues] = React.useState([[]]);
    const [dataPresent, setDataPresent] = React.useState(false);

    const [message, setMessage] = React.useState("")
    React.useEffect(() => {
        fetchAppointments();
    }, []); 
    async function fetchAppointments(){  
    const endPoint = config.apiEndpoint+'/appointment/find/all'
    const res = await httpService.get(endPoint).then(response=>{ 
        let appointmentArr:any = []
        let tableBodyValues:any[] = []

        response.data.map((res:any,index:number)=>{
            appointmentArr[0] = res.patientName
            appointmentArr[1] = res.room
            let date = new Date(res.appointmentTime)
            let dateStr = date.getDate()+"/"+(date.getMonth()+1)+"/"+date.getFullYear()
            appointmentArr[2] = dateStr
            tableBodyValues[index] = appointmentArr
            appointmentArr=[]
        }) 
        setBodyValues(tableBodyValues)  
        setDataPresent(true);
      }).catch((error)=>{ 
        setMessage(error)
      })
    } 
    const edit=(event:React.MouseEventHandler<HTMLTableColElement>,index:number)=>{ 
      navigate(linkToPatientDetail, {state:{id:index}})
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
            <TableUtil tablecaption={TableItems[0].tablecaption} handleClick={edit} heading={TableItems[0].heading} bodyvalues={bodyValues}></TableUtil>
         </Box>
    );
}

export default FindAllAppointments;
