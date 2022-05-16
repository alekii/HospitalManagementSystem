import { IconType } from "react-icons";

export default interface LinkItemProps {
  linkName: string;
    icon: IconType;
    childLi?: any[];  
    children?:React.ReactNode
  }
  