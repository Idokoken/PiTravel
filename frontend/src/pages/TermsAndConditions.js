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
  	background: var(--secondary-color);
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

function TermsAndConditions() {
    return (
        <Wrapper>
          
          <div className="hero">
              <h1>terms and condition</h1>
            </div>
            <div className="container content py-3">
             terms and condition
            </div>
        </Wrapper>
    )
}

export default TermsAndConditions