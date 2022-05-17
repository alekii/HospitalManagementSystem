import { Box, Button, FormControl, FormLabel, Input, Select } from '@chakra-ui/react'
 
function AddNewAppointment() {
  return (  <Box
    w="50%"
    mt="50px" 

  > 
      <FormControl isRequired>
        <FormLabel htmlFor="name">Customer Name</FormLabel>
        <Input id="name" type="text"/> 
        <FormLabel htmlFor="doctor">Doctor</FormLabel>
        <Select id="doctor">
          <option>Doctor one</option>
          <option>Doctor two</option>
        </Select> 
        <Button type="submit" color="white" _hover={{bg:'#199999'}} bg="#5c6865" mt="8" w='100%'>Save Appointment</Button>
      </FormControl> 
  </Box>
  )
}

export default AddNewAppointment;