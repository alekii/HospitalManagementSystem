 import SideBarMenu from '../common/sidebarmenu'
import { 
  FiDollarSign,
  FiUsers,
} from "react-icons/fi";  
import LinkItemProps from '../common/interface/linkitemprops';
import { Box, Flex } from '@chakra-ui/react';
import { Outlet } from 'react-router-dom';


const LinkItems: Array<LinkItemProps> = [
  { linkName: "Revenue", icon: FiDollarSign },
  {
    linkName: "Employees",
    icon: FiUsers,
    childLi: [
      { linkName: "Doctors", link: "/admin/Employees/Doctors" }, 
      { linkName: "Receptionists", link: "/admin/Employees/Receptionists" },
      { linkName: "Pharmacists", link: "/admin/Employees/Pharmacists" },
    ],
  },
];


export default function Admin(){ 
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
 