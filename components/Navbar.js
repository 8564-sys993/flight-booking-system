import { useState } from 'react'
import { NavLink } from 'react-router-dom'
import './Navbar.css'
import  Brand  from '../assets/logo1.png';
import  img  from '../assets/img1.jpg';
import { useNavigate } from 'react-router-dom';
import axios from 'axios'
import SearchFlight from './SearchFlight';



const Navbar = () => {
  const [showNavbar, setShowNavbar] = useState(false)
  const navigate = useNavigate();

  const handleShowNavbar = () => {
    setShowNavbar(!showNavbar)
  }
  const handleBookNow = async () => {
    try {
      const response = await axios.get('http://localhost:8085/flights/get');
      const flights = response.data;
      console.log('Flights:', flights);
      // Handle the fetched data as per your requirement
  
      // Redirect to the flight page with the flight data
      navigate('/flights');
    } catch (error) {
      console.log('Error fetching flights:', error);
    }
  };

  return (
    <>
    
      <nav className="navbar">
        <div className="nav-container">
          <NavLink exact to="/" className="nav-logo">
            CodeBucks
            <i className="fas fa-code"></i>
          </NavLink>
          <ul className={ showNavbar ?"nav-menu active" : "nav-menu"}>
            <li className="nav-item">
              <NavLink
                exact
                to="/"
                activeClassName="active"
                className="nav-links"
                onClick={handleShowNavbar}
              >
                Home
              </NavLink>
              </li>
              <li className="nav-item">
              <NavLink
                exact
                to="/about"
                activeClassName="active"
                className="nav-links"
                onClick={handleShowNavbar}
              >
                About
              </NavLink>
            </li>
            <li className="nav-item">
              <NavLink
                exact
                to="/profile"
                activeClassName="active"
                className="nav-links"
                onClick={handleShowNavbar}
              >
                Profile
              </NavLink>
              </li>
              <li className="nav-item">
              <NavLink
                exact
                to="/contact"
                activeClassName="active"
                className="nav-links"
                onClick={handleShowNavbar}
              >
                Contact Us
              </NavLink>
            </li>
            <li className="nav-item">
              <NavLink
                exact
                to="/login"
                activeClassName="active"
                className="nav-links"
                onClick={handleShowNavbar}
              >
                  Sign Up
              </NavLink>
            </li>
              
            </ul>
            <div className="nav-icon" onClick={handleShowNavbar}>
            <i className={showNavbar ? "fas fa-times" : "fas fa-bars"}></i>
          </div>
        </div>
      </nav>

      <div className="navbar-picture">
        <img src={img} alt="Navbar Picture" />
        <div className="navbar-text">
    <h2>Welcome to CodeBucks! </h2> <h1><br /> Convenient flight booking </h1>
    <p>FlyNow provides a convenient platform for you to book your flights hassle-free. Say goodbye to long queues and complicated booking processes.</p>
    <button className="book-now-button" onClick={handleBookNow}>
      Book Now
    </button>
  </div>
      </div>

      <SearchFlight />

      <h2>TOP VISITED PLACES THIS MONTH</h2>
    </>
      

  );
}

export default Navbar