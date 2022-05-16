import SideBarMenu from '../sidebarmenu'
import { 
  FiDollarSign,
  FiUsers,
} from "react-icons/fi";  
import LinkItemProps from '../linkitemprops';


const LinkItems: Array<LinkItemProps> = [
  { linkName: "Patients", icon: FiUsers },
  
];


export default function Doctor(){
  return (
    <SideBarMenu LinkItems={LinkItems} >

    </SideBarMenu>
  )
}
 