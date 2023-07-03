import React, { useState, useEffect } from 'react';
import axios from 'axios';
import { useLocation } from 'react-router-dom';
import './PaymentPage.css';

const PaymentPage = () => {
  const location = useLocation();
  const { bookingId, totalFare, flightNumber, origin, destination, flightDate ,passengers} = location.state;

  const [approvalUrl, setApprovalUrl] = useState('');
  const [error, setError] = useState('');

  useEffect(() => {
    const initiatePayment = async () => {
      try {
        const response = await axios.post('http://localhost:8086/booking/api/initiatePayment', {
          bookingId,
          totalFare,
        });

        const approvalUrl = response.data;
        setApprovalUrl(approvalUrl);
        setError('');
      } catch (error) {
        setError('Failed to initiate payment: ' + error.message);
        setApprovalUrl('');
      }
    };

    initiatePayment();
  }, [bookingId, totalFare]);

  const handlePay = () => {
    window.location.href = approvalUrl;
  };

  return (
    <div className="payment-container">
    {error && <p className="error-message">{error}</p>}
    <div className="payment-info">
      <p>Booking ID: {bookingId}</p>
      <p>Total Fare: {totalFare}</p>
      <p>Flight Number: {flightNumber}</p>
      <p>Origin: {origin}</p>
      <p>Destination: {destination}</p>
      <p>Flight Date: {flightDate}</p>
      </div>
      
      {passengers.map((passenger, index) => (
        <div key={index} className="passenger-info">
          <p>Passenger {index + 1}:</p>
          <p>FirstName: {passenger.firstname}</p>
          <p> LastName:{passenger.lastname}</p>
          <p>Age: {passenger.age}</p>
          <p>Gender: {passenger.gender}</p>
        </div>
      ))}
      
      {approvalUrl ? (
        <>
          {/* <h2>Payment</h2>
          <p>Approval URL: {approvalUrl}</p> */}
          <button className="payment-button" onClick={handlePay}>Pay</button>
        </>
      ) : (
        <p className="loading-message">Loading payment information...</p>
      )}
      
    </div>

  );
};

export default PaymentPage;