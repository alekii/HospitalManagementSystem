import { Box, TableCaption } from "@chakra-ui/react";
import TableUtil from '../common/tableutil';
import TableProps from '../common/interface/tableprops'
import { FiEdit, FiPenTool, FiX } from "react-icons/fi";
import React from "react";
import { useLocation, useNavigate } from 'react-router-dom';

const linkToPatientDetail = '/doctor/patients/details'
const TableItems: Array<TableProps> = [
    {
        heading: ['First Name', 'Last Name', 'Age', 'Gender','Action'],
        bodyvalues: [ 
            ['Amoh','Justin', '54', 'Male'], 
            ['Augusto','Joel','38','Male'],
            ['Wade ', 'John', '37', 'Male'],
        ],
        icon:FiEdit,
        tablecaption:'Listing all patients'
    },
]

function FindAllPatients() {
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
            <TableUtil tablecaption={TableItems[0].tablecaption} handleClick={edit} icon={TableItems[0].icon} heading={TableItems[0].heading} bodyvalues={TableItems[0].bodyvalues}></TableUtil>
         </Box>
    );
}

export default FindAllPatients;
