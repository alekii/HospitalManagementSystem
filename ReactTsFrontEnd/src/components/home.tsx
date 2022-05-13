import { Box, Button, Flex, Image, Text } from "@chakra-ui/react";

function Home() {
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
          <Box margin="4" zIndex='3'>
            <Image
              src="/stethescope.jpeg"
              borderTopRadius="20px"
              h="300px"
              w="350px"
            />
            <Button bg="#5c6865" color="white" w="100%" h="12" fontSize="18px">
              Doctor Log In
            </Button>
          </Box>
          <Box margin="4" zIndex='3'>
            <Image
              src="/cc1.jpg"
              borderTopRadius="20px"
              h="300px"
              w="350px"
            />
            <Button bg="#5c6865" color="white" w="100%" h="12" fontSize="18px">
              Receptionist Log In
            </Button>
          </Box>
          <Box margin="4" zIndex='3'>
            <Image
              src="/drugs.jpeg"
              borderTopRadius="20px"
              h="300px"
              w="350px"
            />
            <Button bg="#5c6865" color="white" w="100%" h="12" fontSize="18px">
            Pharmacist Log In
            </Button>
          </Box>
        </Flex>
      </Box>
    </>
  );
}

export default Home;
