import { Box, Button,FormControl,Input} from "@chakra-ui/react"; 
 import { FiSearch } from "react-icons/fi";
import { Link, Outlet } from 'react-router-dom';


const linkToAll = '/Receptionist/Appointments/all'
const linkToAdd = '/Receptionist/Appointments/add'

const Appointments = () => {  
 
    return (
      <Box ml="100px">  
        <Box display="flex" justifyContent="space-between">
          <Link to={linkToAll}>
          <Button mr="20">Find All</Button>
          </Link>
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