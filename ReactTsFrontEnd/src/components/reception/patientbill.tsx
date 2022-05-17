import { Box, Button,FormControl,Input} from "@chakra-ui/react"; 
 import { FiSearch } from "react-icons/fi";
import { Link, Outlet } from 'react-router-dom';


const PatientBill = () => {  
const linkToAdd = '/doctor/patients/add'
 
    return (
      <Box ml="100px">  
        <Box display="flex" justifyContent="space-between"> 
          <Box>
            <FormControl display="flex">
              <Input id="searchPatientBill" type="text" w="300px" placeholder="Search Patient by name" />
              <Button borderLeftRadius="0" w="50px" type="submit">
                <FiSearch />
              </Button>
            </FormControl>
          </Box> 
             <Button mr="20" >Print</Button> 
        </Box> 
       <Outlet/>
      </Box>
    );
  };

  export default PatientBill;