import { Navigate, Outlet } from "react-router-dom"; 
import { useNavigate } from "react-router-dom";
import { useLocation } from "react-router-dom";

const ProtectedRoutes = ({ hasRole, role }: any) => { 
  const navigate = useNavigate();
  const location = useLocation();
  const navigateUrl = "/auth/login/" + role.toLowerCase();

  if (!hasRole) {
    return <Navigate to={navigateUrl} state={{ from: location }} replace />;
  }
  return <Outlet />;
};
export default ProtectedRoutes;
