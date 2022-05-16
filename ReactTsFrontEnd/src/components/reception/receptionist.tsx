import SideBarMenu from '../sidebarmenu'
import { 
  FiDollarSign,
  FiUsers,
} from "react-icons/fi";  
import LinkItemProps from '../linkitemprops';


const LinkItems: Array<LinkItemProps> = [
  { linkName: "Appointements", icon: FiUsers },
  { linkName: "Bill Generator", icon: FiUsers }
  
];


export default function Receptionist(){
  return (
    <SideBarMenu LinkItems={LinkItems} >

    </SideBarMenu>
  )
}
 