import httpService from "./httpService";
import {authEndpoint} from '../config/config.json'
import jwt_decode from 'jwt-decode';  

const authToken = "Authorization"

export function login(values:any){
return httpService.post(authEndpoint,values)
}

export function getCurrentUser(){
   const token = localStorage.getItem(authToken)
   if(token!==null){
   const jwtDecoded:any[] = jwt_decode(token)
   return jwtDecoded.sub
   }
   return null;

}

export default{
    login,
    getCurrentUser
}
 
 