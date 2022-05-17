 import SideBarMenu from '../sidebarmenu'
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
      { linkName: "Doctors", link: "/admin/Employees/doctors" }, 
      { linkName: "Receptionists", link: "/admin/Employees/receptionists" },
      { linkName: "Pharmacists", link: "/admin/Employees/pharmacists" },
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
 