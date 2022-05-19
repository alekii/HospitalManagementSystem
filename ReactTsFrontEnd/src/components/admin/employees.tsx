import { Box, Button, createRenderToast, FormControl,Input} from "@chakra-ui/react"; 
import React from "react";
import { FiSearch } from "react-icons/fi";
import { Link, Outlet, useLocation, useNavigate, useParams } from 'react-router-dom';


const Employees = () => {  
const career = useParams()  
const jobFunction = career.careerName
const navigate = useNavigate();

const allowedUrls = ["Doctors", "Receptionists", "Pharmacists"]

let index = allowedUrls.indexOf(jobFunction)
console.log(index)
if(index===-1) navigate("/pagenotfound")

const linkToAdd = '/admin/Employees/'+jobFunction+'/add'
const linkTofindAllEmployeesByJobFunction = '/admin/Employees/'+jobFunction+'/find/all'
 
    return (
      <Box ml="100px">  
        <Box display="flex" justifyContent="space-between">
          <Link to={linkTofindAllEmployeesByJobFunction} state={jobFunction}>
          <Button mr="20">Find All {jobFunction}</Button>
          </Link>
          <Box>
            <FormControl display="flex">
              <Input id="searchEmployeee" type="text" w="300px" />
              <Button borderLeftRadius="0" w="50px">
                <FiSearch />
              </Button>
            </FormControl>
          </Box>
         <Link to={linkToAdd} state={jobFunction}>
             <Button mr="20" >Add New </Button>
         </Link>
        </Box> 
       <Outlet/>
      </Box>
    );
  };

  export default Employees;