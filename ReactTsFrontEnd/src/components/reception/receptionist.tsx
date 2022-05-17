import SideBarMenu from '../sidebarmenu'
import { 
  FiDollarSign,
  FiUsers,
} from "react-icons/fi";  
import LinkItemProps from '../common/interface/linkitemprops';
import { Box, Flex } from '@chakra-ui/react';
import { Outlet } from 'react-router-dom';


const LinkItems: Array<LinkItemProps> = [
  { linkName: "Appointments", icon: FiUsers },
  { linkName: "Bill", icon: FiUsers }
  
];


export default function Receptionist(){
  return (
    <Flex>
    <SideBarMenu LinkItems={LinkItems} > 
    </SideBarMenu>
    <Box ml="250px" mt="4" w="100%">
      <Outlet/>
    </Box>
    </Flex>

  )
}
 