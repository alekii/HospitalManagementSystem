import { Box, Button,FormControl,Icon,Input, VStack} from "@chakra-ui/react"; 
 import { FiSearch, FiShoppingCart } from "react-icons/fi";
import { Link, Outlet } from 'react-router-dom';


const Drugs = () => {  
const linkToCart = '/Pharmacist/Drugs/cart'
 
    return (
      <Box ml="100px">  
        <Box display="flex" justifyContent="space-between"> 
          <Box>
            <FormControl display="flex">
              <Input id="searchAppointment" type="text" w="300px" placeholder="Find Drug by Name"/>
              <Button borderLeftRadius="0" w="50px">
                <FiSearch />
              </Button>
            </FormControl>
          </Box> 
          <Link to={linkToCart}>
          <VStack cursor='pointer'>
              <Box as='p' ml='4px'>3</Box>
              <Icon mt='-0.4rem !important'  fontSize='25px'><FiShoppingCart/></Icon>
          </VStack>
          </Link>
             <Button mr="20">Print Receipt</Button> 
        </Box> 
       <Outlet/>
      </Box>
    );
  };

  export default Drugs;