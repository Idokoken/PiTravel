import { useState } from 'react';
// import { Link } from "react-router-dom";
import { Tablet } from './../Responsive';
import styled from "styled-components";



const Wrapper = styled.div`;
  margin: 0;
  padding: 20px 5px;
  font-family: "Poppins", sans-serif;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  ${Tablet({ flexDirection: 'row' })}

  form button{
    padding: 5px 10px;
    background: var(--primary-color);
    color: white;
    font-weight: 500;
    border-radius: 5px;
    border: 0;
    text-decoration: none;
    margin-top: 10px;
    ${Tablet({ marginTop: '0', marginLeft: '10px' })}
  }
    form input{
    padding: 3px 10px;;
    font-weight: 500;
    border-radius: 5px;
    border: 2px solid rgba(0, 0, 0, 0.4);
    text-decoration: none;
  }
  form{
    margin: 0;
    padding: 10px;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    ${Tablet({ flexDirection: 'row' })}
    }

  `


function SubscribeForm() {
  const [email, setEmail] = useState('');
  const [message, setMessage] = useState('');

  const handleSubmit = async (e) => {
    e.preventDefault();
    try {
      // await database.collection('subscribers').add({ email });
      setMessage('Thank you for subscribing!');
      setEmail('');
    } catch (error) {
      setMessage('There was an error. Please try again.');
    }
  };

  return (
    <Wrapper>
      <h3>Join Our Mailing list</h3>
      <form onSubmit={handleSubmit}>
        <input
          type="email"
          value={email}
          onChange={(e) => setEmail(e.target.value)}
          placeholder="Enter your email"
          required
        />
        <button type="submit">Subscribe</button>
      </form>
      {message && <p>{message}</p>}
    </Wrapper>
  );
};


export default SubscribeForm;