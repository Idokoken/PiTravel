import React from 'react'
import styled from 'styled-components'
//import { link } from "react-router-dom";
//import { Tablet } from "../Responsive";

const Wrapper = styled.div`
  padding: 0;
  margin: 0;
  font-family: var(--primary-font);
  
  .hero{
  	width: 100%;
  	height: 20vh;
  	// background: var(--secondary-color);
    background: linear-gradient(92.05deg, #B02323 61.11%, #2670DF 98.82%);
  	display: flex;
  	justify-content: center;
  	align-items: center;
  	padding: 20px;
  }
  
  .hero h1{
  	font-weight: 700;
  	color: white;
  }
  .content{
  	min-height: 40vh;
  }

`

function BaggagePolicy() {
  return (
    <Wrapper>
      <div className="hero">
        <h1>Baggage Policy</h1>
      </div>
      <div className="container content py-3">
        Baggage Policy
      </div>
    </Wrapper>
  )
}

export default BaggagePolicy