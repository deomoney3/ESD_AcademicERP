import React, { useState } from "react";
import axios from "axios";
import Navbar from "./Navbar";

const DeleteSpecialization = () => {
  const [id, setId] = useState("");
  const [message, setMessage] = useState("");

  const handleDelete = async () => {
    try {
      const token = localStorage.getItem("token");
      await axios.delete(`http://localhost:8080/api/v1/specialization/${id}`, {
        headers: { Authorization: `Bearer ${token}` },
      });
      setMessage("Specialization deleted successfully.");
    } catch (error) {
      setMessage("Error deleting specialization.");
    }
  };

  return (
    <>
    <Navbar/>
    <div className="container mt-5">
      <h2 className="text-center">Delete Specialization</h2>
      {message && <div className="alert alert-info">{message}</div>}
      <div className="mb-3">
        <label htmlFor="id" className="form-label">Specialization ID</label>
        <input type="text" className="form-control" id="id" onChange={(e) => setId(e.target.value)} required />
      </div>
      <button className="btn btn-danger w-100" onClick={handleDelete}>Delete</button>
    </div>
    </>
  );
};

export default DeleteSpecialization;
