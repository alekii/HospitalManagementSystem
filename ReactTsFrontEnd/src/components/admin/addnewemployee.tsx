 import {
  Box, 
} from "@chakra-ui/react"; 
import Form from "../common/form";
import FormProps from "./../common/interface/formprops";

const FormItems: Array<FormProps> = [
  {
    input: [
      { id: "first-name", type: "text", label: "First Name" },
      { id: "last-name", type: "text", label: "Last Name" },
      { id: "age", type: "text", label: "Age" },
      { id: "email", type: "email", label: "Email" },
      { id: "speciality", type: "text", label: "Speciality" },
    ],
    
    select: [{ id: "gender",label:"Gender",options: ["Male", "Female"] }],
  },
   
];
function AddNewEmployee() {

  function getFormData(values:any){ 
    return new Promise<void>((resolve)=>{
        setTimeout(()=>{
            console.log(JSON.stringify(values,null,2))
            resolve()
        },100)
    })
  }
  return (  
  <Box
    w="50%"
    mt="50px"  
  > 
      <Form onSubmit={getFormData} input={FormItems[0].input} select={FormItems[0].select}></Form>
    
  </Box>
  )
}

export default AddNewEmployee