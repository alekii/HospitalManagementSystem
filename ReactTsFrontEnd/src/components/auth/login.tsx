import {
    Box, 
  } from "@chakra-ui/react"; 
  import Form from "../common/form";
  import FormProps from "./../common/interface/formprops";
  import {useParams } from 'react-router-dom'; 
  import config from '../../config/config.json' 
  import { useNavigate } from 'react-router-dom';
  import {login} from '../../service/authService'
  import React from "react";


  const Login=({getUserProfile}:any)=> {  
  const [errors, setErrors] = React.useState('')
  const FormItems: Array<FormProps> = [
    {
      input: [
        { id: "username", type: "text", label: "Username" },
        { id: "password", type: "password", label: "Password" }, 
      ], 
    }, 
  ];
   
   const location = useParams() 
   const navigate = useNavigate() 
   const navaigationUrl = '/'+location.careerName
  
    async function getFormData(values:any){     
            const response = await login(values).then(response=>{ 
              localStorage.setItem("Authorization",response.headers.authorization)  
               getUserProfile(response.data.username, response.data.roles[0])
               setErrors('')
               navigate(navaigationUrl)
            }).catch((ex)=>{
              if(ex.response && ex.response.status===400){
                  setErrors('invalid username or password')
              }
            })
    } 

    return (  
    <Box
      w="50%"
      m="50px auto 0 auto"  
    > 
        <Form onSubmit={getFormData} input={FormItems[0].input} select={FormItems[0].select}></Form>
     <Box as='p' color='red' > {errors}</Box>
    </Box>
    )
  }
  
  export default Login