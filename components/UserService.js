import axios from 'axios';

const API_BASE_URL = 'http://localhost:9000/api';

export const registerUser = async (user) => {
    try {
      const response = await axios.post(`${API_BASE_URL}/register`, user);
      if (response && response.data) {
        return response.data;
      } else {
        throw new Error('Invalid response');
      }
    } catch (error) {
      throw error.response.data;
    }
  };

export const loginUser = async (user) => {
  try {
    const response = await axios.post(`${API_BASE_URL}/authenticate`, user);
    return response.data;
  } catch (error) {
    throw error.response.data;
  }
};
