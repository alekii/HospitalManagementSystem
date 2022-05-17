import { Box } from "@chakra-ui/react";
import TableUtil from '../common/tableutil';
import TableProps from '../common/interface/tableprops'
import { FiX } from "react-icons/fi";
import React from "react";


const TableItems: Array<TableProps> = [
    {
        heading: ['Drug Name', 'Amount', 'Quantity', 'SubTotal', 'Action'],
        bodyvalues: [ 
            ['Amoxil','30', '10', 300], 
            ['Aspirin','200','3',600],
            ['Mara Moja', '3', '10', 30],
        ],
        icon:FiX,
        tablecaption:'Drugs Shopping Cart'
    },
]

function Cart() {
    let [tableItems,setTableItems] = React.useState(TableItems)
    const removeItem=(event:React.MouseEventHandler<HTMLTableColElement>,index:number)=>{ 
        tableItems = TableItems[0].bodyvalues.splice(index,1)
        setTableItems(tableItems) 
    }

    let totalAmount = 0;
  
    TableItems[0].bodyvalues.map(s => {
        totalAmount += s[3]
    })

    return (
        <Box w="80%" margin='50px 0 0 0'>
            <TableUtil tablecaption={TableItems[0].tablecaption} handleClick={removeItem} icon={TableItems[0].icon} heading={TableItems[0].heading} bodyvalues={TableItems[0].bodyvalues}></TableUtil>
            <Box as='p' textAlign='end' fontSize='17px'><strong>Total: </strong>Kshs {totalAmount}</Box>
        </Box>
    );
}

export default Cart;
