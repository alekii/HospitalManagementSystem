 import {
  Box, 
} from "@chakra-ui/react"; 
import Form from "../common/form";
import FormProps from "./../common/interface/formprops";
import { useLocation } from 'react-router-dom'; 
import config from '../../config/config.json'
import httpService from "../../service/httpService";

function AddNewEmployee() { 
const FormItems: Array<FormProps> = [
  {
    input: [
      { id: "firstName", type: "text", label: "First Name" },
      { id: "lastName", type: "text", label: "Last Name" },
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

  async function getFormData(values:any){ 
      const endPoint = config.apiEndpoint+'/admin/employees/doctors/add';
      const res = httpService.post(endPoint, values)
      console.log(res)
      console.log(JSON.stringify(values,null,2))
      
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