 import {
  Box, 
} from "@chakra-ui/react"; 
import Form from "../common/form";
import FormProps from "./../common/interface/formprops";
import { useLocation } from 'react-router-dom';

function AddNewEmployee() { 
const FormItems: Array<FormProps> = [
  {
    input: [
      { id: "first-name", type: "text", label: "First Name" },
      { id: "last-name", type: "text", label: "Last Name" },
      { id: "age", type: "text", label: "Age" },
      { id: "email", type: "email", label: "Email" }, 
    ],
    
    select: [
      { id: "gender",label:"Gender",options: ["Male", "Female"] }, 
  ],
  },
   
];
 
 const location = useLocation()  
 if(location.state==='Doctors'){ 
   FormItems[0].input?.push({ id: "speciality", type: "text", label: "Speciality" })
   FormItems[0].select?.push({ id: "room",label:"Assign Room",options: ["Room1", "Room 2"] })
  
  }

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