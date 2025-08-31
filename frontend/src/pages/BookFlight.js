import React from 'react'
import styled from 'styled-components'
import Header from "../components/Header";
import Footer from "../components/Footer";
import { Tablet } from '../Responsive';
import Booking from '../components/Booking';

const Wrapper = styled.div`
  padding: 0;
  margin: 0;
  font-family: var(--primary-font);
  min-height: 40vh;
  
  .hero{
  	width: 100%;
  	height: 15vh;
  	// background: var(--secondary-color);
    background: linear-gradient(92.05deg, #B02323 61.11%, #2670DF 98.82%);
  	display: flex;
  	justify-content: center;
  	align-items: center;
  	padding: 20px;
    ${Tablet({ height: "20vh" })}
  }
  
  .hero h1{
  	font-weight: 700;
  	color: white;
  }
  .content{
  	min-height: 40vh;
  }
  h3{
  	font-weight: 700;
    text-align: center;
  }

`

function BookFlight() {
  return (
    <>
      <Header />
      <Wrapper>
        <div className="hero">
          <h1>Book Flight</h1>
        </div>
        <div className="container content p-3">
          <Booking />

          <div>
            <h3 className='my-4'>Available Flights</h3>
            <p>Below is a list of some available flights</p>
          </div>


        </div>
      </Wrapper>
      <Footer />
    </>
  )
}

export default BookFlight