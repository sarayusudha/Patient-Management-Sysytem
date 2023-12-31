import axios from "axios";
import React, { useEffect,useState } from "react";
import { Link, useParams } from "react-router-dom";
export default function ViewPatient() {
    const [patient, setPatient] = useState({
        name: "",
        gender: "",
        age: "",
        phno:"",
        diagnosedwith:"",
      });
      const { id } = useParams();
      useEffect(() => {
        loadPatient();
      }, []);
      const loadPatient = async () => {
        const result = await axios.get(`http://localhost:9095/patient/${id}`);
        setPatient(result.data);
      };
      return (
        <div className="container">
          <div className="">
            <div className="col-md-6 offset-md-3 border rounded p-4 mt-2 shadow border border-primary">
              <h2 className="text-center m-4">Patient Details</h2>
             
              <div className="card border">
            <div className="card-header border border-primary">
              Details of patient id : {patient.id}
              <ul className="list-group list-group-flush">
                <li className="list-group-item">
                  <b>Name:  </b>
                  {patient.name}
                </li>
                <li className="list-group-item">
                  <b>Gender:  </b>
                  {patient.gender}
                </li>
                <li className="list-group-item">
                  <b>Age:  </b>
                  {patient.age}
                </li>
                <li className="list-group-item">
                  <b>PhoneNumber: </b>
                  {patient.phno}
                </li>
                <li className="list-group-item">
                  <b>DiagnosedWith:  </b>
                  {patient.diagnosedwith}
                </li>
                </ul>
            </div>
          </div>
          <Link className="btn blue" to={"/"}>
            Back to Home
          </Link>
        </div>
      </div>
    </div>
  );
}

