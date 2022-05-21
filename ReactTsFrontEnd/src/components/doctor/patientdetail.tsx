import { Box} from "@chakra-ui/react"; 
import { useLocation } from "react-router-dom"; 
import httpService from "../../service/httpService";
import Form from "../common/form";
import FormProps from "./../common/interface/formprops";
import config from "../../config/config.json";
import React from "react";


const FormItems: Array<FormProps> = [
  {
    input: [
      { id: "diagnosis", type: "text", label: "Diagnosis" },
      { id: "drugs", type: "text", label: "Drugs" },
      { id: "treatment", type: "text", label: "Treatment For:" },
      { id: "treatmentAmount", type: "text", label: "Treatment Amount" },
    ],
     
  },
   
];
function PatientDetail() { 
  const loc = useLocation();
  const patientDetails = loc.state?.patientDetails;  
  const [message, setMessage] = React.useState("") 

  async function getFormData(values:any){ 
    values['patientId'] = patientDetails[0] 
    const endPoint = config.apiEndpoint + '/doctor/patients/medication/add'
     await httpService.post(endPoint,values).then(response=>{
      setMessage(response.data);  
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
    <Box w="90%" mt="50px" display="flex" justifyContent="space-evenly">
      <Box w="25%">
        <p>
          <strong>Name: </strong>{patientDetails[1]} {patientDetails[2]}
        </p>
        <p>
          <strong>Age: </strong>{patientDetails[3]}
        </p> 
      </Box>
      <Box w="50%" maxWidth="410px">
         <Form onSubmit={getFormData} input={FormItems[0].input} select={FormItems[0].select}></Form>
     </Box>
    </Box>
  );
}

export default PatientDetail;
