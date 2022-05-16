import SideBarMenu from '../sidebarmenu'
import { 
  FiDollarSign,
  FiUsers,
} from "react-icons/fi";  
import LinkItemProps from '../linkitemprops';


const LinkItems: Array<LinkItemProps> = [ 
  { linkName: "Sell Drugs", icon: FiUsers }
  
];


export default function Pharmacist(){
  return (
    <SideBarMenu LinkItems={LinkItems} >

    </SideBarMenu>
  )
}
 