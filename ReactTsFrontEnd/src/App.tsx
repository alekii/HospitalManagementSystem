import { Box } from "@chakra-ui/react";
import { Route, Routes, useNavigate } from "react-router-dom";
import Admin from "./components/admin/admin";
import Footer from "./components/common/footer";
import Header from "./components/common/header";
import Home from "./components/home";
import Revenue from "./components/admin/revenue";
import Employees from "./components/admin/employees";
import NotFound from "./components/NotFound";
import AddNewPatient from "./components/doctor/addnewpatient";
import Doctor from "./components/doctor/doctor";
import Patient from "./components/doctor/patient";
import AddNewEmployee from "./components/admin/addnewemployee";
import PatientDetail from "./components/doctor/patientdetail";
import Receptionist from "./components/reception/receptionist";
import Pharmacist from "./components/pharmacy/pharmacist";
import PatientBill from "./components/reception/patientbill";
import Appointments from "./components/reception/appointments";
import SingleBill from "./components/reception/singlebill";
import AddNewAppointment from "./components/reception/addnewappointment";
import Drugs from "./components/pharmacy/drugs";
import Cart from "./components/pharmacy/cart";
import FindAllPatients from "./components/doctor/findallpatients";
import FindAllAppointments from "./components/reception/findallappointments";
import FindPatientBill from "./components/reception/findpatientbill";
import Login from "./components/auth/login";
import FindAllEmployeesByCareerName from "./components/admin/findAll";
import React from "react";
import ProtectedRoutes from "./components/protectedroutes";
import jwt_decode from "jwt-decode";

export default function App() {
  const navigate = useNavigate();
  const [userProfile, setUserProfile] = React.useState({
    username: "",
    role: "",
  });

  React.useEffect(() => {
    const jwt = localStorage.getItem("Authorization");
    if (jwt !== null) {
      const user: any = jwt_decode(jwt);
      setUserProfile({ username: user.sub, role: user.role });
    }
  }, []);

  function getUserProfile(username: string, role: string) {
    const userProfileData = { username: username, role: role };
    setUserProfile(userProfileData);
  }

  function signOut() {
    userProfile.username = "";
    userProfile.role = "";
    setUserProfile(userProfile);
    localStorage.clear();
    navigate("/");
  }

  return (
    <>
      <Box minW="1200px">
        <Header userProfile={userProfile} signOut={signOut}></Header>
        <Box pt="16">
          <Routes>
            <Route path="/" element={<Home />} />

            <Route
              element={
                <ProtectedRoutes
                  role={"admin"}
                  hasRole={
                    !!userProfile.username && userProfile.role === "ADMIN"
                  }
                />
              }
            >
              <Route path="/admin" element={<Admin />}>
                <Route path="Revenue" element={<Revenue />}></Route>
                <Route path="Employees" element={<Employees />} />
                <Route path="Employees/:careerName" element={<Employees />}>
                  <Route path="add" element={<AddNewEmployee />} />
                  <Route path="find">
                    <Route
                      path="all"
                      element={<FindAllEmployeesByCareerName />}
                    />
                  </Route>
                  <Route path="find" element={<AddNewEmployee />} />
                </Route>
              </Route>
            </Route> <Route
              element={
                <ProtectedRoutes
                  role={"receptionist"}
                  hasRole={
                    !!userProfile.username && userProfile.role === "RECEPTIONIST"
                  }
                />
              }
            >
            <Route path="Receptionist" element={<Receptionist />}>
              <Route path="Appointments" element={<Appointments />}>
                <Route path="add" element={<AddNewAppointment />} />
                <Route path="all" element={<FindAllAppointments />} />
              </Route>
              <Route path="Bill" element={<PatientBill />}>
                <Route path="view" element={<SingleBill />} />
                <Route path="find" element={<FindPatientBill />} />
              </Route>
            </Route>
            </Route>
            <Route
              element={
                <ProtectedRoutes
                  role={"pharmacist"}
                  hasRole={
                    !!userProfile.username && userProfile.role === "PHARMACIST"
                  }
                />
              }
            >
            <Route path="Pharmacist" element={<Pharmacist />}>
              <Route path="Drugs" element={<Drugs />}>
                <Route path="cart" element={<Cart />} />
              </Route>
            </Route>
            </Route>
            <Route
              element={
                <ProtectedRoutes
                  role={"doctor"}
                  hasRole={
                    !!userProfile.username && userProfile.role === "DOCTOR"
                  }
                />
              }
            >
            <Route path="/doctor" element={<Doctor />}>
              <Route path="patients" element={<Patient />}>
                <Route path="add" element={<AddNewPatient />} />
                <Route path="all" element={<FindAllPatients />} />
                <Route path="details" element={<PatientDetail />}></Route>
              </Route>
            </Route>
            </Route>
            <Route path="/auth">
              <Route
                path="login/:careerName"
                element={<Login getUserProfile={getUserProfile} />}
              />
            </Route>
            <Route path="*" element={<NotFound />} />
          </Routes>
        </Box>
        <Footer></Footer>
      </Box>
    </>
  );
}
