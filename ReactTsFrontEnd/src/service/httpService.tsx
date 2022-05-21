import axios from "axios"; 


function getAccessToken(){
    const accessToken = window.localStorage.getItem("Authorization");
    return accessToken;
}

axios.interceptors.request.use((config:any)=>{
    const token = getAccessToken();
    if(token) {
        config.headers['Authorization'] = token; 
    }
    return config; 
},
(error)=>{
    return Promise.reject(error);
})


axios.interceptors.response.use(null,(error:any)=>{
const expectedError = 
           error.response && 
           error.response.status>=400 && 
           error.response.status<500; 
if(expectedError){ 
    alert("An unexpected error occured")
}
 
return Promise.reject(error)
})

export default{
    get:axios.get,
    post:axios.post,
    put:axios.put,
    delete:axios.delete
}