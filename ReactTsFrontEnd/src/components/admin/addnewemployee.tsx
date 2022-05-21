import { Box } from "@chakra-ui/react";
import Form from "../common/form";
import FormProps from "./../common/interface/formprops";
import { useLocation } from "react-router-dom";
import config from "../../config/config.json";
import httpService from "../../service/httpService";
import React from "react";
import axios from "axios";

function AddNewEmployee() { 
  const FormItems: Array<FormProps> = [
    {
      input: [
        { id: "firstName", type: "text", label: "First Name" },
        { id: "lastName", type: "text", label: "Last Name" },
        { id: "age", type: "text", label: "Age" },
        { id: "email", type: "email", label: "Email" },
      ],

      select: [{ id: "gender", label: "Gender", options: ["Male", "Female"] }],
    },
    {
      input: [
        { id: "username", type: "text", label: "UserName" },
        { id: "password", type: "text", label: "Password" },
      ],
    },
  ];

  const location = useLocation();
  const jobFunction = location.state;
  const jobFunctionLowerCase = jobFunction.toLowerCase();
  const [formChanges, setFormChanges] = React.useState({username:"",password:"", errors:""}) 
  const [successMessage,setSuccessMessage] = React.useState("")

     React.useEffect(()=>{
     setSuccessMessage('')
     setFormChanges({username:"",password:"", errors:""})
     },[])

  if (location.state === "Doctors") {
    FormItems[0].input?.push({
      id: "speciality",
      type: "text",
      label: "Speciality",
    });
    FormItems[0].select?.push({
      id: "room",
      label: "Assign Room",
      options: ["Room1", "Room 2"],
    });
  }

  async function createUserNameAndPassword(values: any) { 
    const endPoint = config.signUpEndpoint
    const role = jobFunctionLowerCase.slice(0, jobFunctionLowerCase.length - 1);
    values["role"] = [role];
    const unInterruptedAxiosRequest = axios.create(); 
    const res = await unInterruptedAxiosRequest.post(endPoint, values).then((response)=>{ 
      setFormChanges({username:response.data.message,password:values.password,errors:""}) 
    }).catch((error)=>{ 
      setFormChanges({username:"",password:"",errors:"Username Already Exists"})  
    })  
  }

  async function createUserDetails(values: any) { 
    values["userName"]=formChanges.username 
    const endPoint = config.apiEndpoint + "/admin/employees/" + jobFunctionLowerCase + "/add";
    const unInterruptedAxiosRequest = axios.create(); 
    const res = await httpService.post(endPoint, values).then((response)=>{  
      console.log(response.data)
      setSuccessMessage(response.data) 
    }).catch((error)=>{ 
       setSuccessMessage("err!") 
    
    })
  }

  if(successMessage!=""){
    console.log(successMessage)
    return( 
   <p>{successMessage}</p>
    )
  }
 
  return (
    <Box w="90%" mt="30px" display="flex" justifyContent="space-evenly">  
    {formChanges.username==="" &&
      <Box w="30%"> 
        <Form
          onSubmit={createUserNameAndPassword}
          input={FormItems[1].input}
          select={FormItems[1].select}
        ></Form>
        <p color="red">{formChanges.errors}</p>
      </Box>
    }
      {formChanges.username!=="" &&
      <Box w="50%" maxWidth="410px">
        <Box pb="4">
        <Box as="h4" fontSize="18px" pb="2">Generated values for new {jobFunction.slice(0,jobFunction.length-1)}</Box>
        <Box as="p"><strong>Username: </strong> {formChanges.username}</Box> 
        <Box as="p"><strong>Password: </strong> {formChanges.password}</Box>
        </Box>
        <Form
          onSubmit={createUserDetails}
          input={FormItems[0].input}
          select={FormItems[0].select}
        ></Form>
      </Box>
}
 
    </Box>
  );
}

export default AddNewEmployee;
