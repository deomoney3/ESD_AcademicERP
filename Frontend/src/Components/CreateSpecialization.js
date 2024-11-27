import React, { useState } from "react";
import axios from "axios";
import { useNavigate } from "react-router-dom";
import Navbar from "./Navbar";

const CreateSpecialization = () => {
  const [formData, setFormData] = useState({
    specialization_id: "",
    code: "",
    name: "",
    description: "",
    year: "",
    credits_required: "",
  });
  const [message, setMessage] = useState("");
  const navigate = useNavigate();
  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const token = localStorage.getItem("token");
      const response = await axios.post(
        "http://localhost:8080/api/v1/specialization",
        formData,
        { headers: { Authorization: `Bearer ${token}` } }
      );
      setMessage(response.data);
      console.log("DATA",response.data);
      const specializationId = response.data.specialization_id; 

      // Navigate to /add-courses with the specialization_id as a parameter
   navigate('/landing');
    } catch (error) {
      setMessage("Error creating specialization.");
    }
  };

  return (
    <>
    <Navbar/>
    <div className="container mt-5">
      <h2 className="text-center">Create Specialization</h2>
      {message && <div className="alert alert-info">{message}</div>}
      <form onSubmit={handleSubmit}>
      <div className="mb-3">
          <label htmlFor="specialization_id" className="form-label">Specialization Id</label>
          <input type="text" className="form-control" id="specialization_id" name="specialization_id" onChange={handleChange} required />
        </div>
        <div className="mb-3">
          <label htmlFor="code" className="form-label">Code</label>
          <input type="text" className="form-control" id="code" name="code" onChange={handleChange} required />
        </div>
        <div className="mb-3">
          <label htmlFor="name" className="form-label">Name</label>
          <input type="text" className="form-control" id="name" name="name" onChange={handleChange} required />
        </div>
        <div className="mb-3">
          <label htmlFor="description" className="form-label">Description</label>
          <textarea className="form-control" id="description" name="description" onChange={handleChange} required></textarea>
        </div>
        <div className="mb-3">
          <label htmlFor="year" className="form-label">Year</label>
          <input type="text" className="form-control" id="year" name="year" onChange={handleChange} required />
        </div>
        <div className="mb-3">
          <label htmlFor="credits_required" className="form-label">Credits Required</label>
          <input type="number" className="form-control" id="credits_required" name="credits_required" onChange={handleChange} required />
        </div>
        <button type="submit" className="btn btn-success w-100">Create</button>
      </form>
    </div>
    </>
  );
};

export default CreateSpecialization;
