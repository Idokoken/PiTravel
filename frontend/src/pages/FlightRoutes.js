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
  h3{
  	font-weight: 700;
  }

`

function FlightRoutes() {
  return (
    <Wrapper>
      <div className="hero">
        <h1>flight routes</h1>
      </div>
      <div className="container content py-3">
        <h3>Domestic Routes</h3>
        <div className=""></div>
        <h3>Regional Routes</h3>
        <div className=""></div>
        <h3>International Routes</h3>
        <div className=""></div>
      </div>
    </Wrapper>
  )
}

export default FlightRoutes;