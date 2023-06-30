import React from "react";
import { Link } from "react-router-dom";

export default function Navbar() {
  return (
    <div>
      <div class="b1">
      <nav className="navbar navbar-expand-lg">
        <div className="container-fluid">
          <Link className="navbar-brand w" to="/">
            Patient Table
          </Link>
          <Link className="btn btn-outline-light" to="/addpatient">
            Add Patient
          </Link>
        </div>
      </nav>
    </div>
    </div>
  );
}