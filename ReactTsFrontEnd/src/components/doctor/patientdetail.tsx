import { Box, Button, FormControl, FormLabel, Input } from "@chakra-ui/react";
import React from "react";
import { Link, Outlet, useLocation } from "react-router-dom";

function PatientDetail() { 
  const loc = useLocation();
  const patientId = loc.state?.id; 
  return (
    <Box w="90%" mt="50px" display="flex" justifyContent="space-evenly">
      <Box w="25%">
        <p>
          <strong>Name: </strong>Patient one
        </p>
        <p>
          <strong>Age: </strong>34
        </p> 
      </Box>
      <Box w="50%" maxWidth="410px">
        <FormControl isRequired>
          <FormLabel htmlFor="diagnosis">Diagnosis</FormLabel>
          <Input id="diagnosis" />
          <FormLabel htmlFor="drugs">Drugs</FormLabel>
          <Input id="drugs" />
          <FormLabel htmlFor="treatment">Treatment For:</FormLabel>
          <Input id="treatment" />
          <Button
            type="submit"
            color="white"
            _hover={{ bg: "#199999" }}
            bg="#5c6865"
            mt="8"
            w="100%"
          >
            Save Medication
          </Button>
        </FormControl>
      </Box>
    </Box>
  );
}

export default PatientDetail;
