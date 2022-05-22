import {
  Box, 
} from "@chakra-ui/react"; 
import httpService from "../../service/httpService";
import Form from "../common/form";
import FormProps from "./../common/interface/formprops";
import config from "../../config/config.json";
import authService from "../../service/authService";
import React from "react";


const doctors = [
  {name:"Doctor one", room:"Lab"},
  {name:"Doctor two", room:"Clinic"},
  {name:"Doctor three", room:"Emergency"},
  {name:"Doctor four", room:"Nutririon"},
]

const FormItems: Array<FormProps> = [
  {
    input: [
      { id: "patientName", type: "text", label: "Customer Name" }, 
    ],
    select: [
      { id: "room",label:"Room",options:  [] }, 
    ], 
  },
   
];

const rooms:string[] = [] 

doctors.map(d=>{
  rooms.push(d.room)
})

FormItems.map((f:any)=>{
   f.select[0].options = rooms;
})

function AddNewAppointment() {

  const [message, setMessage] = React.useState("")

  async function getFormData(values:any){  
    console.log(JSON.stringify(values,null,2))
    const endPoint = config.apiEndpoint+'/appointment/new'
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

  return (  <Box
    w="50%"
    mt="50px"  
  > 
        <Form onSubmit={getFormData} input={FormItems[0].input} select={FormItems[0].select}></Form>
    
  </Box>
  )
}

export default AddNewAppointment;