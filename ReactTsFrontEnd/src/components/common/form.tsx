import {
  Box,
  Button,
  FormControl,
  FormLabel,
  Input,
  Select,
} from "@chakra-ui/react"; 
import { useForm } from "react-hook-form";

const Form = ({ input,select,onSubmit}: any) => {  
    const {handleSubmit, register, formState:{errors, isSubmitting},} = useForm() 
      
  return (
  <form onSubmit={handleSubmit(onSubmit)}>
    <FormControl isRequired >
      {input?.map((formItem: any) => {
        return (
          <Box key={formItem.id}>
            <FormLabel htmlFor={formItem.id}>{formItem.label}</FormLabel>
            <Input id={formItem.id} type={formItem.type} {...register(formItem.id)}/> 
          </Box>
        );
      })}
  {select && 
  select.map((selectEl:any)=>{  
      return(
        <Box key={selectEl.id}>
            <FormLabel htmlFor={selectEl.id}>{selectEl.label}</FormLabel>
            <Select id={selectEl.id} {...register(selectEl.id)}>
              {selectEl.options.map((value: any) => {
                  return <option key={value} >{value}</option>;
              })}
          </Select>
        </Box>
      )
  } 
            )}
    </FormControl>
      <Button 
      isLoading={isSubmitting}
        type="submit"
        color="white"
        _hover={{ bg: "#199999" }}
        bg="#5c6865"
        mt="8"
        w="100%"  
      >
        Submit
      </Button>
      </form>
  );
};

export default Form;
