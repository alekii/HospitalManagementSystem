import { IconType } from "react-icons";
import { 
  Box,
  Flex, 
  useColorModeValue,
  Icon, 
} from "@chakra-ui/react";
import { FiDollarSign, FiUsers } from "react-icons/fi";
import { Link, Outlet } from "react-router-dom";
import { ReactNode } from "react";

interface LinkItemProps {
  name: string;
  icon: IconType;
}

const LinkItems: Array<LinkItemProps> = [
  { name: "Revenue", icon: FiDollarSign },
  { name: "Employees", icon: FiUsers },
];

export default function Admin() {
  return (
    <Flex>
      <Box
        minH="100vh"
        bg={useColorModeValue("white", "gray.900")}
        w={{ base: "none", md: 60 }}
        borderRight="1px"
        borderRightColor={useColorModeValue("gray.200", "gray.700")}
        pos="fixed"
        h="full"
        pt="4"
      >
        {LinkItems.map((link) => {
          return (
            <NavItem key={link.name} icon={link.icon}>
              {link.name}
            </NavItem>
          );
        })}
      </Box>
      <Box ml={{ md: 60 }} mt="4" w="100%">
        <Outlet/>
      </Box>
    </Flex>
  );
}
interface NavItemProps {
  icon: IconType;
  children: string;
}

const NavItem = ({ icon, children, ...rest }: NavItemProps) => {
  return (
    <Link to={children}>
      <Flex
        align="center"
        py="4"
        px="4"
        mx="4"
        _hover={{
          bg: "cyan.400",
          color: "white",
        }}
        borderRadius="lg"
        fontSize="18"
      >
        <Icon mr="4" fontSize="16" as={icon}></Icon>
        {children}
      </Flex>
    </Link>
  );
};


