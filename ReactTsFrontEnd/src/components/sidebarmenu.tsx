import { IconType } from "react-icons";
import { Box, Flex, useColorModeValue, Icon } from "@chakra-ui/react";
import {
  FiChevronDown,
  FiChevronRight, 
} from "react-icons/fi"; 
import { Link, Outlet } from "react-router-dom";
import React from "react"; 
import LinkItemProps from "./common/interface/linkitemprops";
 
export default function SideBarMenu({LinkItems}: Array<LinkItemProps>){ 
    return (
        <Box
          minH="100vh"
          bg={useColorModeValue("white", "gray.900")}
          w="250px"
          borderRight="1px"
          borderRightColor={useColorModeValue("gray.200", "gray.700")}
          pos="fixed"
          h="full"
          pt="4"
          cursor="pointer"
        >
          {LinkItems.map((link:any) => {
            return (
              <NavItem key={link.linkName} icon={link.icon} childLi={link.childLi}>
                {link.linkName}
              </NavItem>
            );
          })}
        </Box>
        
    );
  }

  interface NavItemProps {
    icon: IconType;
    children: string;
    childLi?: any[];
  }
  
  const NavItem = ({ icon, children, ...rest }: NavItemProps) => {
    let [isSubMenuOpen, setissubMenuOpen] = React.useState(false);
  
    const setSubMenuOpenState = (event: React.MouseEvent<HTMLDivElement>) => {
      setissubMenuOpen(!isSubMenuOpen); 
    };
  
    return (
      <Box>
        {rest.childLi !== undefined ? (
          <ListElement 
            icon={icon}
            elName={children}
            changeMenuState={setSubMenuOpenState}
            subMenuOpen={isSubMenuOpen}
          ></ListElement>
        ) : (
          <Link to={children}>
            <ListElement icon={icon} elName={children}></ListElement>
          </Link>
        )}
        {rest.childLi && isSubMenuOpen && (
          <Box pb="4" mt="6px" px="4" ml="15%" >
            {rest.childLi.map((childLink: any) => {
                console.log(childLink.link)
              return (
                <Link to={childLink.link} key={childLink.linkName}>
                  <Box 
                    py="7px"
                    _hover={{
                      bg: "#c5c6c7",
                      color: "white",
                    }}
                    borderRadius="lg"
                    display="flex"
                    alignItems='center'  
                  >
                    <Box as='p' w='69%' ml="13%" >{childLink.linkName}</Box>
                    <Icon
                      w="10%"
                      fontSize="16"
                      as={FiChevronRight}
                      float="right" 
                    ></Icon>
                  </Box>
                </Link>
              );
            })}
          </Box>
        )}
      </Box>
    );
  };
  
  const ListElement = ({ icon, elName, changeMenuState, subMenuOpen }: any) => {
    let ElementWithoutSubMenu = true;
    if (subMenuOpen === true) {
      ElementWithoutSubMenu = false;
    }
    return (
      <Flex
        align="center"
        py="4"
        px="4"
        mx="4"
        _hover={{
          bg: "#c5c6c7",
          color: "white",
        }}
        borderRadius="lg"
        fontSize="18"
        onClick={changeMenuState}
      >
        <Icon w="15%" mr="4" fontSize="16" as={icon}></Icon>
        <Box as="p" w="75%">
          {elName}
        </Box>
        {ElementWithoutSubMenu && (
          <Icon w="10%" fontSize="16" as={FiChevronRight} float="right"></Icon>
        )}
        {subMenuOpen && (
          <Icon w="10%" fontSize="16" as={FiChevronDown} float="right"></Icon>
        )}
      </Flex>
    );
  };
  