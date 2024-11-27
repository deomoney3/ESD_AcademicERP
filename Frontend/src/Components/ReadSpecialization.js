import React, { useEffect, useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";
import Navbar from "./Navbar";

const ReadSpecialization = () => {
  const [specializations, setSpecializations] = useState([]);
  const [error, setError] = useState("");
  const navigate = useNavigate();

  useEffect(() => {
    const fetchSpecializations = async () => {
      try {
        const token = localStorage.getItem("token");
        const response = await axios.get("http://localhost:8080/api/v1/specialization", {
          headers: { Authorization: `Bearer ${token}` },
        });
        setSpecializations(response.data);
      } catch (error) {
        setError("Error fetching specializations.");
      }
    };

    fetchSpecializations();
  }, []);

  const handleSpecializationClick = (id) => {
    navigate(`/specializations/${id}/courses`);
  };

  return (
    <>
    <Navbar/>
    <div className="container mt-5">
      <h2 className="text-center">View Specializations</h2>
      {error && <div className="alert alert-danger">{error}</div>}

      {specializations.length > 0 ? (
        <table className="table table-bordered table-striped mt-3">
          <thead className="table-dark">
            <tr>
              <th>Specialization ID</th>
              <th>Code</th>
              <th>Name</th>
              <th>Description</th>
              <th>Credits Required</th>
              <th>Year</th>
            </tr>
          </thead>
          <tbody>
            {specializations.map((spec) => (
              <tr key={spec.specialization_id}>
                <td>
                  <button
                    className="btn btn-link p-0"
                    onClick={() => handleSpecializationClick(spec.specialization_id)}
                  >
                    {spec.specialization_id}
                  </button>
                </td>
                <td>{spec.code}</td>
                <td>{spec.name}</td>
                <td>{spec.description}</td>
                <td>{spec.credits_required}</td>
                <td>{spec.year}</td>
              </tr>
            ))}
          </tbody>
        </table>
      ) : (
        <p className="text-center mt-4">No specializations available to display.</p>
      )}
    </div>
    </>
  );
};

export default ReadSpecialization;
