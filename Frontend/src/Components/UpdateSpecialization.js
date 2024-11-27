import React, { useState } from "react";
import axios from "axios";
import Navbar from "./Navbar";

const UpdateSpecialization = () => {
  const [id, setId] = useState("");
  const [formData, setFormData] = useState({
    code: "",
    name: "",
    description: "",
    year: "",
    credits_required: "",
  });
  const [message, setMessage] = useState("");

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const token = localStorage.getItem("token");
      const response = await axios.put(
        `http://localhost:8080/api/v1/specialization/${id}`,
        formData,
        { headers: { Authorization: `Bearer ${token}` } }
      );
      setMessage("Specialization updated successfully.");
    } catch (error) {
      setMessage("Error updating specialization.");
    }
  };

  return (
    <>
    <Navbar/>
    <div className="container mt-5">
      <h2 className="text-center">Update Specialization</h2>
      {message && <div className="alert alert-info">{message}</div>}
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label htmlFor="id" className="form-label">Specialization ID</label>
          <input type="text" className="form-control" id="id" onChange={(e) => setId(e.target.value)} required />
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
        <button type="submit" className="btn btn-warning w-100">Update</button>
      </form>
    </div>
    </>
  );
};

export default UpdateSpecialization;
