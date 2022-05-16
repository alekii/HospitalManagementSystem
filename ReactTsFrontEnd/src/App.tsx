import { Box } from "@chakra-ui/react";
import { Route, Routes } from "react-router-dom"; 
import Admin from "./components/admin/admin";
import Footer from "./components/common/footer";
import Header from "./components/common/header";
import Home from "./components/home";
import Revenue from "./components/admin/revenue";
import Employees from './components/admin/employees';
import NotFound from "./components/NotFound";
import AddNewPatient from "./components/doctor/addnewpatient";
import Doctor from './components/doctor/doctor';
import Patient from "./components/doctor/patient";
import AddNewEmployee from "./components/admin/addnewemployee";
import AddNewPatientMedication from "./components/doctor/addnewpatientmediaction";
import PatientDetail from './components/doctor/patientdetail';
import Receptionist from './components/reception/receptionist'; 
import Pharmacist from "./components/pharmacy/pharmacist";
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
              <Route path="Employees" element={<Employees/>}/>
              <Route path="Employees/:careerName" element={<Employees/>}>
                <Route path="add" element={<AddNewEmployee/>}/>
              </Route>
            </Route>
            <Route path="Receptionist" element={<Receptionist/>}> 
            </Route>
            <Route path=" Pharmacist" element={<Pharmacist/>}>  
            </Route>
            <Route path="/doctor" element={<Doctor/>}>
              <Route path="patients" element={<Patient/>}>
                <Route path="add" element={<AddNewPatient/>}/>
                <Route path="details" element={<PatientDetail/>}>
                  <Route path="medication/add" element={<AddNewPatientMedication/>}/>
              </Route>
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