import { BrowserRouter as Router, Routes, Route } from "react-router-dom";
import LoginPage from "./Pages/LoginPage";
import LandingPage from "./Pages/LandingPage";

import "bootstrap/dist/css/bootstrap.min.css";
import CreateSpecialization from "./Components/CreateSpecialization";
import ReadSpecialization from "./Components/ReadSpecialization";
import UpdateSpecialization from "./Components/UpdateSpecialization";
import DeleteSpecialization from "./Components/DeleteSpecialization";
import SpecializationDetails from "./Components/SpecializationDetails";
import AddCourses from "./Components/AddCourses";

function App() {
  return (
    <Router>
      <Routes>
        <Route path="/" element={<LoginPage />} />
        <Route path="/landing" element={<LandingPage />} />
        <Route path="/create-specialization" element={<CreateSpecialization />} />
        <Route path="/read-specialization" element={<ReadSpecialization />} />
        <Route path="/update-specialization" element={<UpdateSpecialization />} />
        <Route path="/delete-specialization" element={<DeleteSpecialization />} />
        <Route path="/specializations/:id/courses" element={<SpecializationDetails />} />
        <Route path="/add-courses" element={<AddCourses />} />
      </Routes>
    </Router>
  );
}

export default App;
