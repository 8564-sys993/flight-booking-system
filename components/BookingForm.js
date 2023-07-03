import React, { useState } from 'react';
import axios from 'axios';
import { useLocation, useNavigate } from 'react-router-dom';
import './BookingForm.css';
import img from '../assets/im4.jpg';

const BookingForm = () => {
  const location = useLocation();
  const navigate = useNavigate();
  const { flightNumber, origin, destination, fare, flightDate } = location.state;

  const [passengers, setPassengers] = useState([]);
  const [showConfirmation, setShowConfirmation] = useState(false);
  const [showPassengerDetails, setShowPassengerDetails] = useState(false);
  const [bookingId, setBookingId] = useState('');

  const handlePassengerChange = (index, field, value) => {
    const updatedPassengers = [...passengers];
    updatedPassengers[index][field] = value;
    setPassengers(updatedPassengers);
  };

  const handleAddPassenger = () => {
    setPassengers([...passengers, { firstname: '', lastname: '', age: '', gender: '' }]);
  };

  const handleRemovePassenger = (index) => {
    const updatedPassengers = [...passengers];
    updatedPassengers.splice(index, 1);
    setPassengers(updatedPassengers);
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    setShowConfirmation(true);
  };

  const handleConfirmBooking = async (e) => {
    e.preventDefault();

    try {
      const bookingRequest = {
        flightNumber,
        origin,
        destination,
        fare,
        flightDate,
        passengers,
      };

      const response = await axios.post('http://localhost:8086/booking/bookings', bookingRequest);

      // Handle the successful booking response here
      const data = response.data;
      console.log('booking id:', data);
      setBookingId(data.bookingId);

      navigate('/payment', {
        state: {
          bookingId: data, // Update the property name to "bookingId"
          totalFare: fare,
          flightNumber,
          origin,
          destination,
          flightDate,
          passengers: passengers,
        },
      });

      setShowConfirmation(false);
    } catch (error) {
      // Handle any errors that occurred during the booking request
    }
  };

  const togglePassengerDetails = () => {
    setShowPassengerDetails(!showPassengerDetails);
  };

  return (
    <div className="booking-container">
      <div className="booking-content">
        <div className="booking-image">
          <img src={img} alt="Navbar Picture" />
        </div>
        <div className="booking-form">
          <form onSubmit={handleSubmit}>
            <div className="form-group">
              <label>Flight Number:</label>
              <input type="text" value={flightNumber} disabled className="form-control" />
            </div>
            <div className="form-group">
              <label>Origin:</label>
              <input type="text" value={origin} disabled className="form-control" />
            </div>
            <div className="form-group">
              <label>Destination:</label>
              <input type="text" value={destination} disabled className="form-control" />
            </div>
            <div className="form-group">
              <label>Fare:</label>
              <input type="text" value={fare} disabled className="form-control" />
            </div>
            <div className="form-group">
              <label>Flight Date:</label>
              <input type="text" value={flightDate} disabled className="form-control" />
            </div>

            {passengers.map((passenger, index) => (
              <div key={index} className={`passenger-details ${showPassengerDetails ? 'show' : ''}`}>
                <label>First Name:</label>
                <input
                  type="text"
                  value={passenger.firstname}
                  onChange={(e) => handlePassengerChange(index, 'firstname', e.target.value)}
                  className="form-control"
                />
                <label>Last Name:</label>
                <input
                  type="text"
                  value={passenger.lastname}
                  onChange={(e) => handlePassengerChange(index, 'lastname', e.target.value)}
                  className="form-control"
                />
                <label>Age:</label>
                <input
                  type="text"
                  value={passenger.age}
                  onChange={(e) => handlePassengerChange(index, 'age', e.target.value)}
                  className="form-control"
                />
                <label>Gender:</label>
                <input
                  type="text"
                  value={passenger.gender}
                  onChange={(e) => handlePassengerChange(index, 'gender', e.target.value)}
                  className="form-control"
                />
                <button
                  type="button"
                  onClick={() => handleRemovePassenger(index)}
                  className="btn btn-primary"
                >
                  Remove
                </button>
              </div>
            ))}
            <button type="button" onClick={handleAddPassenger} className="btn btn-primary">
              Add Passenger
            </button>
            <button type="button" onClick={togglePassengerDetails} className="btn btn-primary">
              {showPassengerDetails ? 'Hide Passenger Details' : 'Show Passenger Details'}
            </button>

            <button type="submit" className="btn btn-primary">
              Book Flight
            </button>
          </form>
        </div>
      </div>

      {showConfirmation && (
        <div className="confirmation-popup slide-down-animation">
          <h3>Confirm Booking</h3>
          {/* Display booking details and other information */}
          {/* ... */}

          <button onClick={handleConfirmBooking} className="btn btn-confirm">
            Confirm
          </button>
          <button onClick={() => setShowConfirmation(false)} className="btn btn-cancel">
            Cancel
          </button>
        </div>
      )}
    </div>
  );
};

export default BookingForm;
