import { Box, Button, Flex, Image, Text } from "@chakra-ui/react";
import { Link } from "react-router-dom";

interface CareerLoginProps{
  careerLogin:string;
  careerName:string;
  imgUrl:string;
}

const careerLoginItems:Array<CareerLoginProps> = [
  {careerLogin:"/auth/login/receptionist",careerName:"Receptionist", imgUrl:"cc1.jpg"},
  {careerLogin:"/auth/login/doctor",careerName:"Doctor", imgUrl:"/stethescope.jpeg"},
  {careerLogin:"/auth/login/pharmacist",careerName:"Pharmacist",imgUrl:"/drugs.jpeg"}
]

const Home=() =>{
  return (
    <>
      <Flex justifyContent="space-around">
        <Box h="400px" zIndex='3'>
          <Image src="/doc1.png" />
        </Box>
        <Box
          as="h1"
          fontWeight="900"
          fontSize="25px"
          pt="120px"
          justifySelf="center"
          color='#6e5f5f'
          zIndex='3'
        >
          We Treat God Heals
        </Box>
        <Box h="400px" zIndex='3'>
          <Image src="/doc1.png" />
        </Box>
      </Flex>
      <Box>
          <Image src="/wave1.svg" position='absolute' top='300px' minW='1340px' />
        </Box>
      <Box bg="#f3f3f3" h="400px" >
        <Flex justifyContent="space-around"> 
         {careerLoginItems.map(item=>{
           return(
             <CareerLoginCard 
               careerLogin={item.careerLogin}
               key={item.careerName}
                careerName={item.careerName}
                imgUrl={item.imgUrl}> 
             </CareerLoginCard>
           )
         })}
        </Flex>
      </Box>
    </>
  );
}

export default Home;


const CareerLoginCard = ({careerLogin,careerName,imgUrl}:CareerLoginProps) =>{
   return(
  <Box margin="4" zIndex='3'>
  <Image
    src={imgUrl}
    borderTopRadius="20px"
    h="300px"
    w="350px"
  />
 <Link to={careerLogin}>
  <Button _hover={{bg:'#199999'}} bg="#5c6865" color="white" w="100%" h="12" fontSize="18px">
  {careerName} Log In
  </Button>
  </Link>
</Box>
)
}