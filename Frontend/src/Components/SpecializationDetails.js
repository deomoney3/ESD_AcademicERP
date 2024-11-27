import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import axios from "axios";
import Navbar from "./Navbar";

const SpecializationDetails = () => {
  const { id } = useParams();
  const [data, setData] = useState(null);
  const [error, setError] = useState("");
  const [loading, setLoading] = useState(true);

  useEffect(() => {
    const fetchSpecializationWithCourses = async () => {
      try {
        const token = localStorage.getItem("token");
        const response = await axios.get(`http://localhost:8080/api/v1/specialization/${id}/courses`, {
          headers: { Authorization: `Bearer ${token}` },
        });
        setData(response.data.courses); // Set only the courses array
      } catch (error) {
        setError("Error fetching specialization courses.");
      } finally {
        setLoading(false);
      }
    };

    fetchSpecializationWithCourses();
  }, [id]);

  if (loading) {
    return <p className="text-center mt-4">Loading specialization courses...</p>;
  }

  if (error) {
    return <div className="alert alert-danger">{error}</div>;
  }

  if (!data || data.length === 0) {
    return <p className="text-center mt-4">No courses found for this specialization.</p>;
  }

  return (
    <>
    <Navbar/>
    <div className="container mt-5">
      <h2 className="text-center">Specialization Courses</h2>
      <table className="table table-bordered table-striped mt-3">
        <thead className="table-dark">
          <tr>
            <th>Course ID</th>
            <th>Code</th>
            <th>Name</th>
            <th>Description</th>
            <th>Credits</th>
            <th>Faculty</th>
            <th>Capacity</th>
            <th>Term</th>
          </tr>
        </thead>
        <tbody>
          {data.map((course) => (
            <tr key={course.course_id}>
              <td>{course.course_id}</td>
              <td>{course.course_code}</td>
              <td>{course.name}</td>
              <td>{course.description}</td>
              <td>{course.credits}</td>
              <td>{course.faculty}</td>
              <td>{course.capacity}</td>
              <td>{course.term}</td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
    </>
  );
};

export default SpecializationDetails;
