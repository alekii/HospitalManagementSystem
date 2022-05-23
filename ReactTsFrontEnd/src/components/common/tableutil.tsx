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
  FormControl,
  Input,
  Button,
} from "@chakra-ui/react";
import { useForm } from "react-hook-form";

function TableUtil({tablecaption,handleClick, heading, bodyvalues, addToCart,icon,handleAddToCart}: any) {
  
  
  const {handleSubmit,register,formState:{errors,isSubmitting}} = useForm()
  
  
  return (
    <TableContainer>
      <Table variant="striped" colorScheme="teal">
        <TableCaption>{tablecaption}</TableCaption>
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
                {addToCart &&(
                  <Td>
                    <form onSubmit={handleSubmit(handleAddToCart)}>
                    <FormControl><Input 
                      type="text"
                      id="index" 
                      w='0'
                      h='0'
                      visibility='hidden' 
                      value={index}
                        {...register("index")}>
                          
                        </Input>
                      <Input 
                      type="text"
                      id="drugQuantity"
                       w="70px" 
                       mr='20px'
                        backgroundColor='white'
                        {...register("drugQuantity")}>

                        </Input>
                      <Button type="submit"
                              w="120px"  
                              isLoading={isSubmitting}
                      >Add To Cart</Button>
                    </FormControl>
                    </form>
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
