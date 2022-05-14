import { Box } from "@chakra-ui/react";
import { Route, Routes } from "react-router-dom"; 
import Admin from "./components/admin/admin";
import Footer from "./components/common/footer";
import Header from "./components/common/header";
import Home from "./components/home";
import Revenue from "./components/admin/revenue";
import Employees from './components/admin/employees';
import NotFound from "./components/NotFound";
import AddNewEmployee from "./components/admin/addnewemployee";

export default function App() {
  return (
    <>
      <Box minW="1200px">
        <Header></Header>
        <Box pt="16"> 
          <Routes> 
            <Route path="/" element={<Home/>}/>
  
            <Route path="/admin" element={<Admin/>}> 
              <Route path="Revenue" element={<Revenue/>}></Route>
              <Route path="Employees" element={<Employees/>}>
                <Route path="add" element={<AddNewEmployee/>}/>
              </Route>
            </Route>
           <Route path="*" element={<NotFound/>}/>
          </Routes>
        </Box>
      <Footer></Footer>
      </Box>
    </>
  );
}
