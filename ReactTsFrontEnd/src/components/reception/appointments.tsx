import { Box, Button,FormControl,Input} from "@chakra-ui/react"; 
 import { FiSearch } from "react-icons/fi";
import { Link, Outlet } from 'react-router-dom';


const Appointments = () => {  
const linkToAdd = '/Receptionist/Appointments/add'
 
    return (
      <Box ml="100px">  
        <Box display="flex" justifyContent="space-between">
          <Button mr="20">Find All</Button>
          <Box>
            <FormControl display="flex">
              <Input id="searchAppointment" type="text" w="300px" placeholder="Search Patient"/>
              <Button borderLeftRadius="0" w="50px">
                <FiSearch />
              </Button>
            </FormControl>
          </Box>
         <Link to={linkToAdd}>
             <Button mr="20"   >Add New Appointment</Button>
         </Link>
        </Box> 
       <Outlet/>
      </Box>
    );
  };

  export default Appointments;