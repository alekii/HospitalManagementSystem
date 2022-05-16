 import SideBarMenu from '../sidebarmenu'
import { 
  FiDollarSign,
  FiUsers,
} from "react-icons/fi";  
import LinkItemProps from '../linkitemprops';


const LinkItems: Array<LinkItemProps> = [
  { linkName: "Revenue", icon: FiDollarSign },
  {
    linkName: "Employees",
    icon: FiUsers,
    childLi: [
      { linkName: "Receptionists", link: "/admin/Employees/receptionists" },
      { linkName: "Doctors", link: "/admin/Employees/doctors" },
      { linkName: "Pharmacists", link: "/admin/Employees/pharmacists" },
    ],
  },
];


export default function Admin(){
  return (
    <SideBarMenu LinkItems={LinkItems} >

    </SideBarMenu>
  )
}
 