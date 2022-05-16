import { Box, Button, FormControl, FormLabel, Input, Select } from '@chakra-ui/react'
 
function AddNewPatientMedication() {
  return (  <Box
    w="50%" 
   maxWidth='410px'
  > 
      <FormControl isRequired> 
        <FormLabel htmlFor="diagnosis">Diagnosis</FormLabel>
        <Input id="diagnosis"/>
        <FormLabel htmlFor="drugs">Drugs</FormLabel>
        <Input id="drugs"/>
        <FormLabel htmlFor="treatment">Treatment For:</FormLabel> 
        <Input id="treatment"/>
        <Button type="submit" color="white" _hover={{bg:'#199999'}} bg="#5c6865" mt="8" w='100%'>Save Medication</Button>
      </FormControl> 
  </Box>
  )
}

export default AddNewPatientMedication;