import { Box} from "@chakra-ui/react"; 
import { useLocation } from "react-router-dom"; 
import Form from "../common/form";
import FormProps from "./../common/interface/formprops";

const FormItems: Array<FormProps> = [
  {
    input: [
      { id: "diagnosis", type: "text", label: "Diagnosis" },
      { id: "drugs", type: "text", label: "Drugs" },
      { id: "treatment", type: "text", label: "Treatment For" },
    ],
     
  },
   
];
function PatientDetail() { 
  const loc = useLocation();
  const patientId = loc.state?.id; 

  function getFormData(values:any){ 
    return new Promise<void>((resolve)=>{
        setTimeout(()=>{
            console.log(JSON.stringify(values,null,2))
            resolve()
        },100)
    })
  }

  return (
    <Box w="90%" mt="50px" display="flex" justifyContent="space-evenly">
      <Box w="25%">
        <p>
          <strong>Name: </strong>Patient one
        </p>
        <p>
          <strong>Age: </strong>34
        </p> 
      </Box>
      <Box w="50%" maxWidth="410px">
         <Form onSubmit={getFormData} input={FormItems[0].input} select={FormItems[0].select}></Form>
     </Box>
    </Box>
  );
}

export default PatientDetail;
