import httpService from "./httpService";
import {authEndpoint} from '../config/config.json'
import jwt_decode from 'jwt-decode'; 

export function login(values:any){
return httpService.post(authEndpoint,values)
}

 

export default{
    login 
}