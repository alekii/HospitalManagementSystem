import { Box, Button, FormControl, FormLabel, Input, Select } from '@chakra-ui/react'
 
function AddNewEmployee() {
  return (  <Box
    w="50%"
    mt="100px" 

  > 
      <FormControl isRequired>
        <FormLabel htmlFor="first-name">First Name</FormLabel>
        <Input id="first-name" type="text"></Input>
        <FormLabel htmlFor="last-name">Last Name</FormLabel>
        <Input id="last-name"></Input>
        <FormLabel htmlFor="Age">Age</FormLabel>
        <Input id="age"></Input>
        <FormLabel htmlFor="gender">Gender</FormLabel>
        <Select id="gender">
          <option>Male</option>
          <option>Female</option>
        </Select>
        <FormLabel htmlFor="email">email</FormLabel>
        <Input id="email" type="email"></Input>
        <FormLabel htmlFor="speciality">Speciality</FormLabel>
        <Input id="speciality" type="text"></Input>
        <Button type="submit" color="white" bg="teal" mt="8" w='100%'>Submit</Button>
      </FormControl> 
  </Box>
  )
}

export default AddNewEmployee