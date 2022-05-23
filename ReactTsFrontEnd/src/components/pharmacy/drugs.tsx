import { Box, Button,FormControl,Icon,Input, VStack} from "@chakra-ui/react"; 
 import { FiSearch, FiShoppingCart } from "react-icons/fi";
import { Link, Outlet, useNavigate } from 'react-router-dom';
import { useForm } from "react-hook-form";
import React from "react";
import { store } from "../../store/store";


const Drugs = () => {  
const linkToCart = '/Pharmacist/Drugs/cart'
const {handleSubmit, register, formState:{errors, isSubmitting}} = useForm() 
const navigate = useNavigate()
const [drugCartQuantity,setDrugCartQuantity] = React.useState(0)

store.subscribe(()=>{
  getcartQuantity(store.getState().drugs)
})
 
function searchDrugByName(values: any) { 
    navigate("/Pharmacist/Drugs/search/"+values.drugName)
  } 

  function getcartQuantity(drugsInCart:any[]){ 
    let cartQuantity = 0; 
    drugsInCart.map((drug:any)=>{
      cartQuantity+=drug.drugQuantity
     })
    setDrugCartQuantity(cartQuantity)
  }
    return (
      <Box ml="100px">  
        <Box display="flex" justifyContent="space-between"> 
          <Box> 
            <form onSubmit={handleSubmit(searchDrugByName)}>
            <FormControl display="flex">
              <Input id="drugName" type="text" w="300px" placeholder="Find Drug by Name" {...register("drugName")}/>
              <Button 
              borderLeftRadius="0"
               w="50px"
                type="submit" 
                isLoading={isSubmitting}>
                <FiSearch />
              </Button>
            </FormControl>
           </form> 
          </Box> 
          <Link to={linkToCart}>
          <VStack cursor='pointer'>
              <Box as='p' ml='4px'>{drugCartQuantity}</Box>
              <Icon mt='-0.4rem !important'  fontSize='25px'><FiShoppingCart/></Icon>
          </VStack>
          </Link>
             <Button mr="20">Print Receipt</Button> 
        </Box> 
       <Outlet/>
      </Box>
    );
  };

  export default Drugs;