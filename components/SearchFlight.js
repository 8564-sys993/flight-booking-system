import React, { useState } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import './SearchFlight.css';
import DatePicker from 'react-datepicker';
import 'react-datepicker/dist/react-datepicker.css';

const SearchFlight = () => {
  const [searchOrigin, setSearchOrigin] = useState('');
  const [searchDestination, setSearchDestination] = useState('');
  const [searchFlightDate, setSearchFlightDate] = useState(new Date());
  const navigate = useNavigate();

  const formatDate = (date) => {
    const day = String(date.getDate()).padStart(2, '0');
    const month = date.toLocaleString('default', { month: 'short' });
    const year = String(date.getFullYear()).slice(-2);
    return `${day}-${month}-${year}`;
  };

  const handleSearch = async () => {
    try {
      const formattedDate = formatDate(searchFlightDate);
      const response = await axios.get('http://localhost:8085/flights/search', {
        params: {
          origin: searchOrigin,
          destination: searchDestination,
          flightDate:  formattedDate,
        },
      });
      const data = response.data;
      console.log('Search Results:', data);
      // Redirect to the flight results page and pass the search results as state
      navigate('/flights1', { state: { searchResults: data } });
    } catch (error) {
      console.log('Error searching flights:', error);
    }
  };

  return (
    <div className="search-flight-container">
      <h1>READY TO TAKE OFF?</h1>
      <div className="search-form">
        <input
        className="search-input"
          type="text"
          placeholder="Origin"
          value={searchOrigin}
          onChange={(e) => setSearchOrigin(e.target.value)}
        />
        <input
        className="search-input"
          type="text"
          placeholder="Destination"
          value={searchDestination}
          onChange={(e) => setSearchDestination(e.target.value)}
        />
        <DatePicker
          className="search-input"
          selected={searchFlightDate}
          onChange={(date) => setSearchFlightDate(date)}
          dateFormat="dd-MMM-yy"
          placeholderText="Flight Date"
        />
        <button className="search-button" onClick={handleSearch}>Search</button>
      </div>
    </div>
  );
};

export default SearchFlight;
