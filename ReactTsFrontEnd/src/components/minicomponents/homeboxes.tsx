import { Button,Box,Image } from '@chakra-ui/react' 

interface careerProps{ 
    items:string[]

   }

const HomeBoxes=(props:any)=> {
  return (
      props.items.map((prop:any)=>{ 
            <Box margin="4">
            <Image
              src="/stethescope.jpeg"
              borderTopRadius="20px"
              h="300px"
              w="350px"
            />
            <Button bg="#5c6865" color="white" w="100%" h="12" fontSize="18px">
              {prop.name} Log In
            </Button>
          </Box> 
      })
   
  )
}

export default HomeBoxes