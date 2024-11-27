import React from "react";
import { Link } from "react-router-dom";

const LandingPage = () => {
  return (
    <div className="container text-center mt-5">
      <h1>Specialization Management</h1>
      <p className="lead">Choose an action:</p>
      <div className="d-flex justify-content-center gap-3">
        <Link to="/create-specialization" className="btn btn-primary">Create Specialization</Link>
        <Link to="/read-specialization" className="btn btn-info">View Specializations</Link>
        <Link to="/update-specialization" className="btn btn-warning">Update Specialization</Link>
        <Link to="/delete-specialization" className="btn btn-danger">Delete Specialization</Link>
        <Link to="/add-courses" className="btn btn-secondary">Add Courses</Link>
      </div>
    </div>
  );
};

export default LandingPage;
