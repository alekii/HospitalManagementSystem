import React from 'react'; 
import { IconType } from 'react-icons';
export default interface TableProps{
    heading:any[];
    bodyvalues:any[];
    icon:IconType;
    children?:React.ReactNode
}