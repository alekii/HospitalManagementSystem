import {
  Box, 
} from "@chakra-ui/react"; 
import React from "react";
import config from "../../config/config.json";
import authService from "../../service/authService";
import httpService from "../../service/httpService";
import Form from "../common/form";
import FormProps from "./../common/interface/formprops";

const FormItems: Array<FormProps> = [
  {
    input: [
      { id: "firstName", type: "text", label: "First Name" },
      { id: "lastName", type: "text", label: "Last Name" },
      { id: "age", type: "text", label: "Age" },
    ],
    
    select: [
    { id: "gender",label:"Gender",options: ["Male", "Female"] },
  ]
  },
   
];
function AddNewPatient() {

const [message, setMessage] = React.useState("")

async function getFormData(values:any){ 
  const docUsername = authService.getCurrentUser();
  if(docUsername!==null){
  values["doctorUsername"] = docUsername
  } 
  const endPoint = config.apiEndpoint+'/doctor/patients/add'
  const res = await httpService.post(endPoint,values).then(response=>{ 
    setMessage(response.data)
  }).catch((error)=>{ 
    setMessage(error)
  })
}

if(message!==""){
  return (
    <p>{message}</p>
  )
}
  return (
    <Box w="50%" mt="50px">
      <Form onSubmit={getFormData} input={FormItems[0].input} select={FormItems[0].select}></Form>
    </Box>
  );
}

export default AddNewPatient;
