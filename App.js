import React from 'react';
import './App.css';
import { BrowserRouter as Router,Routes,Route } from 'react-router-dom';
import Login from './components/Login';
import Register from './components/Register';
import Navbar from './components/Navbar';
import FlightPage from './components/FlightPage';
import FlightsPage1 from './components/FlightPage1';
import BookingForm from './components/BookingForm';
import PaymentPage from './components/payment';
import ProfilePage from './components/ProfilePage';


const App = () => {
    return (
        <Router>
        
        <Routes>
        <Route path="/login" element={<Login />} />
          <Route path="/register" element={<Register />} />
          <Route path="/home" element={<Navbar />} />
          <Route path="/flights" element={<FlightPage />} />
          <Route path="/flights1" element={<FlightsPage1 />} />
          <Route path="/book-flight" element={<BookingForm/>}/>
          <Route path="/payment" element={<PaymentPage/>} />
          <Route path='/profile' element={<ProfilePage/>}/>
        </Routes>
        
      </Router>
      
    );
  };
  
  export default App;
  
  
  
  
  
  
  
  