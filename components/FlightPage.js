import React, { useState, useEffect } from 'react';
import axios from 'axios';
import './FlightPage.css';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';
import { useNavigate } from 'react-router-dom';

const FlightPage = () => {
  const [flights, setFlights] = useState([]);
  const [searchOrigin, setSearchOrigin] = useState('');
  const [searchDestination, setSearchDestination] = useState('');
  const [searchFlightDate, setSearchFlightDate] = useState(new Date());
  const navigate = useNavigate();
  const formatDate = (date) => {
    const day = String(date.getDate()).padStart(2, '0');
    const month = String(date.getMonth() + 1).padStart(2, '0');
    const year = String(date.getFullYear());
    return `${year}-${month}-${day}`;
  };

  useEffect(() => {
    const fetchFlights = async () => {
      try {
        const response = await axios.get('http://localhost:8085/flights/get');
        const data = response.data;
        console.log('Flights:', data);
        setFlights(data);
        // Handle the fetched data as per your requirement
      } catch (error) {
        console.log('Error fetching flights:', error);
      }
    };

    fetchFlights();
  }, []);

  const handleSearch = async () => {
    try {
      const formattedDate = formatDate(searchFlightDate);
      const response = await axios.get('http://localhost:8085/flights/search', {
        params: {
          origin: searchOrigin,
          destination: searchDestination,
          flightDate: formattedDate,
        },
      });
      const data = response.data;
      console.log('Search Results:', data);
      setFlights(data);
      // Handle the search results as per your requirement
    } catch (error) {
      console.log('Error searching flights:', error);
    }
  };

  const handleBookFlight = async (flightNumber, origin, destination, fare, flightDate) => {
    console.log(`Book flight ${flightNumber}`);

    // Redirect to the booking confirmation page and pass the booking results as state
    navigate('/book-flight', {
      state: {
        flightNumber,
        origin,
        destination,
        fare,
        flightDate,
      },
    });
  };

  return (
    <div className="flight-page">
      <h1></h1>
      <div className="search-form">
        <input
          type="text"
          placeholder="Origin"
          value={searchOrigin}
          onChange={(e) => setSearchOrigin(e.target.value)}
        />
        <input
          type="text"
          placeholder="Destination"
          value={searchDestination}
          onChange={(e) => setSearchDestination(e.target.value)}
        />
        <DatePicker
          className="search-input"
          selected={searchFlightDate}
          onChange={(date) => setSearchFlightDate(date)}
          dateFormat="yyyy-MM-dd"
          placeholderText="Flight Date"
        />

        <button onClick={handleSearch}>Search</button>
      </div>
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
          {flights.map((flight) => (
            <tr key={flight.id}>
              <td>{flight.flightNumber}</td>
              <td>{flight.origin}</td>
              <td>{flight.destination}</td>
              <td>{flight.flightDate}</td>
              <td>{flight.departureTime}</td>
              <td>{flight.arrivalTime}</td>
              <td>{flight.fare ? `${flight.fare.fare} ` : 'N/A'}</td>
              <td>
                <button
                  className="book-button"
                  onClick={() =>
                    handleBookFlight(
                      flight.flightNumber,
                      flight.origin,
                      flight.destination,
                      flight.fare ? `${flight.fare.fare} `: 'N/A',
                      flight.flightDate
                    )
                  }
                >
                  Book
                </button>
              </td>
            </tr>
          ))}
        </tbody>
      </table>
    </div>
  );
};

export default FlightPage;
