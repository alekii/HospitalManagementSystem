import { Box } from "@chakra-ui/react";
import Footer from "./components/common/footer";
import Header from "./components/common/header";
import Home from "./components/home";

export default function Example() {
  return (
    <>
      <Box minW="1200px">
        <Header></Header>
        <Box pt="16">
          <Home></Home>
        </Box>
      <Footer></Footer>
      </Box>
    </>
  );
}
