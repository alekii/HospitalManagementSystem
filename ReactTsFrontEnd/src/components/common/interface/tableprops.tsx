import React from 'react'; 
import { IconType } from 'react-icons';
export default interface TableProps{
    heading:any[];
    bodyvalues:any[];
    icon:IconType;
    tablecaption:string
    children?:React.ReactNode
}