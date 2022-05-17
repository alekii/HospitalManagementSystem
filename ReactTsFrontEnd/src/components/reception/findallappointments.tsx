import { Box} from "@chakra-ui/react";
import TableUtil from '../common/tableutil';
import TableProps from '../common/interface/tableprops'
import { FiEdit, } from "react-icons/fi";
import React from "react";
import { useNavigate } from 'react-router-dom';

const linkToPatientDetail = '/doctor/patients/details'
const TableItems: Array<TableProps> = [
    {
        heading: ['Name', 'Appointment Date'],
        bodyvalues: [ 
            ['Amo Justin', 'Monday'], 
            ['Augusto Joel','Tuesday'],
            ['Wade John', 'Tuesday'],
        ],
        icon:FiEdit,
        tablecaption:'Listing all patients'
    },
]

function FindAllAppointments() {
    const navigate = useNavigate() 
    
    const edit=(event:React.MouseEventHandler<HTMLTableColElement>,index:number)=>{ 
      navigate(linkToPatientDetail, {state:{id:index}})
     }

    let totalAmount = 0;
  
    TableItems[0].bodyvalues.map(s => {
        totalAmount += s[3]
    })

    return (
        <Box w="80%" margin='50px 0 0 0'>
            <TableUtil tablecaption={TableItems[0].tablecaption} handleClick={edit} heading={TableItems[0].heading} bodyvalues={TableItems[0].bodyvalues}></TableUtil>
         </Box>
    );
}

export default FindAllAppointments;
