import React, { useState } from 'react';
import { loginUser } from '../components/UserService';
import './Login.css';
import img from '../assets/loginImg.jpg';
import { useNavigate } from 'react-router-dom';

const Login = () => {
  const [user, setUser] = useState({
    email: '',
    password: '',
  });
  const [error, setError] = useState('');
  const navigate = useNavigate();

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      const response = await loginUser(user);
      console.log(response);
      // Handle successful authentication and redirect to desired page
      // Replace the following line with your logic
      navigate('/home');
      alert('Login successful!');
    } catch (error) {
      setError(error.message);
    }
  };

  return (
    <div>
      <div className="register-background">
        <img className="register-background-video" src={img} alt="Background" />
      </div>

      <div className="Auth-form-container">
        <form className="Auth-form" onSubmit={handleSubmit}>
          <div className="Auth-form-content">
            <h3 className="Auth-form-title">Sign In</h3>
            <div className="form-group mt-3">
              <input
                type="email"
                className="form-control mt-1"
                placeholder="Enter email"
                value={user.email}
                onChange={(e) => setUser({ ...user, email: e.target.value })}
              />
            </div>
            <div className="form-group mt-3">
              <input
                type="password"
                id="password"
                className="form-control mt-1"
                placeholder="Enter password"
                value={user.password}
                onChange={(e) => setUser({ ...user, password: e.target.value })}
              />
            </div>
            <div className="mb-3">
              <div className="custom-control custom-checkbox">
                <input
                  type="checkbox"
                  className="custom-control-input"
                  id="customCheck1"
                />
                <label className="custom-control-label" htmlFor="customCheck1">
                  Remember me
                </label>
              </div>
            </div>
            <div className="d-grid gap-2 mt-3">
              <button type="submit" className="btn btn-primary">
                Submit
              </button>
            </div>
            <p className="forgot-password text-right mt-2">
              Forgot <a href="#">password?</a>
            </p>
          </div>
        </form>
      </div>
    </div>
  );
};

export default Login;
