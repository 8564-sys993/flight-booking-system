import React from 'react';
import { useLocation } from 'react-router-dom';

const FlightsPage1 = () => {
  const location = useLocation();
  const searchResults = location.state?.searchResults || [];

  return (
    <div>
      <h1></h1>
      {searchResults.length > 0 ? (
        <table className="flight-table">
        <thead>
          <tr>
            <th>Flight Number</th>
            <th>Origin</th>
            <th>Destination</th>
            <th>Flight Date</th>
            <th>Departure Time</th>
            <th>Arrival Time</th>
            <th>Fare</th>
            <th>Action</th>
          </tr>
        </thead>
        <tbody>
          {searchResults.map((flight) => (
            <tr key={flight.id}>
              <td>{flight.flightNumber}</td>
              <td>{flight.origin}</td>
              <td>{flight.destination}</td>
              <td>{flight.flightDate}</td>
              <td>{flight.departureTime}</td>
              <td>{flight.arrivalTime}</td>
              <td>{flight.fare ? `${flight.fare.fare}` : 'N/A'}</td>
              <td>
                <button
                  className="book-button"
                  onClick={() => handleBookFlight(flight.flightNumber)}
                >
                  Book
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
      ) : (
        <p>No search results found.</p>
      )}
    </div>
  );
};

export default FlightsPage1;

