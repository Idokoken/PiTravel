import React from 'react'
import styled from 'styled-components'
import Header from "../components/Header";
import Footer from "../components/Footer";
import { Tablet } from '../Responsive';

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
`


function TravelServices() {
    return (
        <>
            <Header />
            <Wrapper>
                <div className="hero">
                    <h1>Travel Services</h1>
                </div>
                <div className="container content p-3">
                    <h2>We are here to help you!</h2>

                    <p>Here are some frequently asked questions (FAQs):</p>

                    <h5>General Questions</h5>





                </div>
            </Wrapper>
            <Footer />
        </>
    )
}

export default TravelServices