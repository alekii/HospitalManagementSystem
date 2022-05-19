import {
    Box, 
  } from "@chakra-ui/react"; 
  import Form from "../common/form";
  import FormProps from "./../common/interface/formprops";
  import { useLocation, useParams } from 'react-router-dom';
  import axios from "axios";
  import config from '../../config/config.json'
  import httpService from "../../service/httpService";
  function Login() { 
  const FormItems: Array<FormProps> = [
    {
      input: [
        { id: "username", type: "text", label: "Username" },
        { id: "password", type: "password", label: "Password" }, 
      ],
       
    },
     
  ];
   
   const location = useParams()  
   
  
    async function getFormData(values:any){   
           const endPoint = 'http://localhost:8080/auth/login';
            //console.log(endPoint)  
            const response = await httpService.post(endPoint,values)
            localStorage.setItem("Authorization",response.headers.authorization) 
    } 

    return (  
    <Box
      w="50%"
      m="50px auto 0 auto"  
    > 
        <Form onSubmit={getFormData} input={FormItems[0].input} select={FormItems[0].select}></Form>
      
    </Box>
    )
  }
  
  export default Login