import { Box, Button, FormControl, FormLabel, Input, Select } from '@chakra-ui/react'
 
function AddNewEmployee() {
  return (  <Box
    w="50%"
    mt="50px" 

  > 
      <FormControl isRequired>
        <FormLabel htmlFor="first-name">First Name</FormLabel>
        <Input id="first-name" type="text"/>
        <FormLabel htmlFor="last-name">Last Name</FormLabel>
        <Input id="last-name"/>
        <FormLabel htmlFor="Age">Age</FormLabel>
        <Input id="age"/>
        <FormLabel htmlFor="gender">Gender</FormLabel>
        <Select id="gender">
          <option>Male</option>
          <option>Female</option>
        </Select>
        <FormLabel htmlFor="email">email</FormLabel>
        <Input id="email" type="email"></Input>
        <FormLabel htmlFor="speciality">Speciality</FormLabel>
        <Input id="speciality" type="text"></Input>
        <Button type="submit" color="white" _hover={{bg:'#199999'}} bg="#5c6865" mt="8" w='100%'>Submit</Button>
      </FormControl> 
  </Box>
  )
}

export default AddNewEmployee