import { FiX } from "react-icons/fi";
import {
  Table,
  TableCaption,
  TableContainer,
  Tbody,
  Td,
  Th,
  Icon,
  Thead,
  Tr,
} from "@chakra-ui/react";


function TableUtil({handleClick, heading, bodyvalues, icon }: any) {
  return (
    <TableContainer>
      <Table variant="striped" colorScheme="teal">
        <TableCaption>Drugs Shopping Cart</TableCaption>
        <Thead>
          <Tr>
            {heading.map((tableHeading: any, index: number) => {
              return <Th key={tableHeading}>{tableHeading}</Th>;
            })}
          </Tr>
        </Thead>
        <Tbody>
          {bodyvalues.map((tableBody: any, index: number) => { 
            return (
              <Tr key={index}>
                {tableBody.map((value: any, key: number) => { 
                  return <Td key={key}>{value}</Td>;
                })}
                {icon && (
                  <Td
                    key={index + "5"}
                    fontSize="20px"
                    cursor="pointer"
                    onClick={(event) => handleClick(event, index)}
                  >
                    <Icon as={icon}></Icon>
                  </Td>
                )}
              </Tr>
            );
          })}
        </Tbody>
      </Table>
    </TableContainer>
  );
}

export default TableUtil;
