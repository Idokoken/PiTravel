import React, { useState, useEffect } from 'react'
import { Link, useNavigate } from "react-router-dom";
import styled from 'styled-components'
import { Tablet, Desktop } from "../Responsive";
import axios from "axios";
import { BASE_URL } from "../API";
import { useAppContext } from '../context/AppContext'




//css section
const Wrapper = styled.div`
  width: 100vw;
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
  background: var(--primary-color);
  font-family: var(--primary-font);

  .main {
    background: white;
    width: 80%;
    min-height: 80vh;
    display: flex;
    flex-direction: column;
    align-items: center;
    border-radius: 20px;
    ${Tablet({ width: "50%" })}
    ${Desktop({ width: "40%" })}
  }
  .heading {
    display: flex;
    margin: 30px 0;
    font-family: "Rampart One", cursive;
    align-items: center;
    flex-direction: column;
    justify-content: center;
    text-decoration: none;
  }
  img {
    width: 30px;
    height: 30px;
    margin-right: 10px;
  }
  h4{
    font-family: 'Oleo Script Swash Caps';
    font-weight: bold;
    font-size: 30px;
    color: var(--primary-color);
  }

  h2 {
    color: black;
    font-weight: 600;
    font-family: 'Abril Fatface';
  }
  form {
    display: flex;
    flex-direction: column;
    width: 100%;
    padding: 30px;
  }
  label {
    margin-top: 15px;
  }
  label:nth-child(1) {
    margin-top: 0;
  }
  input {
    margin-bottom: 20px;
    border-radius: 0 20px 20px 0;
    background: #D9D9D9;
    font-size: 20px;
   
  }
  .btn {
    font-weight: 400;
    color: white;
    padding: 5px;
    margin-top: 10px;
    background: linear-gradient(90.85deg, #000000 2.03%, #2670DF 99.71%);
    border: 3px solid #FFFFFF;
    border-radius: 15px;
    font-size: 20px;
  }
  .login {
    display: flex;
    align-items: center;
    margin-bottom: 20px;
    padding: 0;
    font-size: 14px;
    align-self: start;
    padding-left: 30px;
  }
  .link {
    text-decoration: none;
    color: blue;
    margin: 0;
    padding: 0;
  }
  p {
    margin: 0;
    padding: 0;
    margin-right: 5px;
  }
`;

const Register = () => {
  const navigate = useNavigate();
  const { user, isLoading } =
    useAppContext();
  const initialValues = {
    name: "",
    email: "",
    password: "",
    isMember: false,
  };
  const [values, setValues] = useState(initialValues);

  const handleChange = (e) => {
    const { name, value } = e.target;
    setValues({ ...values, [name]: value });
  };

  const handleSubmit = async (e) => {
    e.preventDefault();
    const { name, email, password, isMember } = values;
    if (!email || !password || (!name && !isMember)) {
      console.log("all fields are required")
      // return;
    }
    if (isMember) {
      console.log("already a member");
    }
    try {
      const response = await axios.post(BASE_URL + '/auth', { name, email, password });
      console.log(response)
    } catch (error) {
    }

  };

  useEffect(() => {
    if (user) {
      navigate("/");
    }
  }, [user, navigate]);

  return (
    <Wrapper>
      <div className="main">
        <Link className="heading" to='/'>
          <h4>PiTravel</h4>
          <img src="/images/brand.png" alt="brand" />
        </Link>
        <h2>Register</h2>

        <form onSubmit={handleSubmit}>

          <input
            type="text"
            required
            name="name"
            placeholder="Full Name"
            className="form-control"
            value={values.name}
            onChange={handleChange}
          />

          <input
            type="email"
            required
            name="email"
            placeholder="Email"
            className="form-control"
            value={values.email}
            onChange={handleChange}
          />

          <input
            type="password"
            required
            name="password"
            placeholder="Password"
            className="form-control"
            value={values.password}
            onChange={handleChange}
          />
          <button className="btn" type="submit" disabled={isLoading}>
            Submit
          </button>
        </form>
        <div className="login">
          <p>Already a member?</p>
          <Link className="link" to="/login">
            Login
          </Link>
        </div>
      </div>
    </Wrapper>
  );
};

export default Register;
