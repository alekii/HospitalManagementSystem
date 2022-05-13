import { Box, Button, Flex } from '@chakra-ui/react';

function Header(){
  return(
      <Box
      bg="teal" 
      h='16' 
      borderBottom={2}
      borderBottomColor="teal" 
      position='fixed'
      w='100%'
      borderBottomWidth='2'
      zIndex='4'
      >
          <Flex 
          justify='flex-end'>
              <Button 
              position='absolute'
              top='50%'
              transform='translateY(-50%)'
              mr='3'
               > Admin </Button> 
          </Flex>
      </Box>
  )
}

export default Header;