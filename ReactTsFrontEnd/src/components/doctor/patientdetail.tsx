import { Box, Button } from '@chakra-ui/react'
import React from 'react'
import { Link, Outlet } from 'react-router-dom'

function PatientDetail() {
  return ( 
      <Box  w="90%"
      mt="50px"  
      display='flex'
      justifyContent='space-evenly'
  >
      <Box w='25%'>
           <p><strong>Name: </strong>Patient one</p>
           <p><strong>Age: </strong>34</p> 
           <Link to='/doctor/patients/details/medication/add' >
           <Button
            color="white" 
            _hover={{bg:'#199999'}}
             bg="#5c6865" 
             mt="8" 
             w='100%'
             >Add Medication
             </Button> 
             </Link>
             </Box>
             <Outlet/>
      </Box>
  )
}

export default PatientDetail;