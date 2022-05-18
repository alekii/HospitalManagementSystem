import SideBarMenu from '../common/sidebarmenu'
import { 
  FiDollarSign,
  FiUsers,
} from "react-icons/fi";  
import LinkItemProps from '../common/interface/linkitemprops';
import { Box, Flex } from '@chakra-ui/react';
import { Outlet } from 'react-router-dom';


const LinkItems: Array<LinkItemProps> = [
  { linkName: "Patients", icon: FiUsers },
  
];


export default function Doctor(){
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
 