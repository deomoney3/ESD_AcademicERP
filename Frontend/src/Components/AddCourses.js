import React, { useState } from "react";
import axios from "axios";
import Navbar from "./Navbar";

const AddCourses = () => {
  const [formData, setFormData] = useState({
    specialization_id: "",
    course_id: "",
  });
  const [message, setMessage] = useState("");

  const handleChange = (e) => {
    setFormData({ ...formData, [e.target.name]: e.target.value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const token = localStorage.getItem("token");
      const response = await axios.post(
        "http://localhost:8080/api/v1/specialization/courses",
        formData,
        { headers: { Authorization: `Bearer ${token}` } }
      );
      console.log("DATA",response.data);
      if(response.data === "Specialization Not Found"){
        setMessage("The Specialization Not Found.")
      }
     else if (response.data === "Course Not Found") {
        setMessage("The course was not found.");
      } else {
        setMessage("Course added successfully.");
      }
    } catch (error) {
      setMessage(
        error.response?.data?.message || "Error adding course to specialization."
      );
    }
  };

  return (
    <>
    <Navbar/>
    <div className="container mt-5">
      <h2 className="text-center">Add Course to Specialization</h2>
      {message && <div className={`alert ${message.includes("Error") ? "alert-danger" : "alert-success"}`}>{message}</div>}
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label htmlFor="specialization_id" className="form-label">
            Specialization ID
          </label>
          <input
            type="text"
            className="form-control"
            id="specialization_id"
            name="specialization_id"
            onChange={handleChange}
            value={formData.specialization_id}
            required
          />
        </div>
        <div className="mb-3">
          <label htmlFor="course_id" className="form-label">
            Course ID
          </label>
          <input
            type="text"
            className="form-control"
            id="course_id"
            name="course_id"
            onChange={handleChange}
            value={formData.course_id}
            required
          />
        </div>
        <button type="submit" className="btn btn-primary w-100">
          Add Course
        </button>
      </form>
    </div>
    </>
  );
};

export default AddCourses;
