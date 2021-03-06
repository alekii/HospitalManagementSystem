import { Box, TableCaption } from "@chakra-ui/react";
import TableUtil from '../common/tableutil';
import TableProps from '../common/interface/tableprops'
import { FiEdit, FiEye, FiPenTool, FiX } from "react-icons/fi";
import React from "react";
import { useLocation, useNavigate } from 'react-router-dom';

const linkToViewBill = '/Receptionist/Bill/view'
const TableItems: Array<TableProps> = [
    {
        heading: ['First Name', 'Last Name', 'Payment Status','Action'],
        bodyvalues: [ 
            ['Amoh','Justin', 'PENDING' ], 
            ['Augusto','Joel','PENDING'],
            ['Wade ', 'John', 'PENDING'],
        ],
        icon:FiEye,
        tablecaption:'Listing PENDING Bill '
    },
]

function FindPatientBill() {
    const navigate = useNavigate() 
    
    const edit=(event:React.MouseEventHandler<HTMLTableColElement>,index:number)=>{ 
      navigate(linkToViewBill, {state:{id:index}})
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

export default FindPatientBill;
