import { Box, Button,FormControl,Input} from "@chakra-ui/react"; 
 import { FiSearch } from "react-icons/fi";
import { Link, Outlet } from 'react-router-dom';


const Receptionistc = () => {  
const linkToAdd = '/doctor/patients/add'
 
    return (
      <Box ml="100px">  
        <Box display="flex" justifyContent="space-between">
          <Button mr="20">Find All</Button>
          <Box>
            <FormControl display="flex">
              <Input id="searchEmployeee" type="text" w="300px" />
              <Button borderLeftRadius="0" w="50px">
                <FiSearch />
              </Button>
            </FormControl>
          </Box>
         <Link to={linkToAdd}>
             <Button mr="20"   >Add New Patient</Button>
         </Link>
        </Box> 
       <Outlet/>
      </Box>
    );
  };

  export default Receptionistc;