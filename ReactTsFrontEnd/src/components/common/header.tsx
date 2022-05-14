import { Box, useColorModeValue, Flex, VStack,Text, HStack, MenuList, MenuItem, useColorMode, Menu, MenuButton } from "@chakra-ui/react";
import { FiChevronDown } from "react-icons/fi";
import { Link } from "react-router-dom";

function Header() {
  return (
    <Box
      bg="teal"
      h="16"
      borderBottom={2}
      borderBottomColor="teal"
      position="fixed"
      w="100%"
      borderBottomWidth="2"
      zIndex="4"
    > 
      <Flex justify="flex-end">
        {/* <Button
          position="absolute"
          top="50%"
          transform="translateY(-50%)"
          mr="3"
        > 
          Admin
        </Button> */}
        <Menu>
        <MenuButton 
          position="absolute"
          top="50%"
          transform="translateY(-50%)"
          mr='12'>
        <HStack >
        <VStack  spacing='1px' alignItems='flex-start' color='#f3f4f5'>
          <Text fontSize='sm'>User 1</Text>
          <Text fontSize='xs'>Admin</Text>
        </VStack>
        <Box >
          <FiChevronDown color="f3f4f5"/>
        </Box>
        </HStack>
        </MenuButton>
        <MenuList  
             bg={useColorModeValue('white', 'gray.900')}
             borderColor={useColorModeValue('gray.200','gray.700')}
             >
          <Link to="/"><MenuItem>Sign out</MenuItem></Link>
        </MenuList>
        </Menu>
      </Flex> 
    </Box>
  );
}

export default Header;
