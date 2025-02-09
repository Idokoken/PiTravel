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
  .openings{
  	background: var(--primary-color);
  	color: white;
  	display: flex;
  	flex-direction: column;
  	justify-content: center;
  	align-items: center;
  	padding: 30px;
  	border-radius: 20px;
  	border: 10px solid var(--secondary-color);
  }

`

function Careers() {
  return (
    <Wrapper>
      <div className="hero">
        <h1>Careers</h1>
      </div>
      <div className="container content p-3">
        <p>
At PiTravel, we're passionate about revolutionizing the flying experience. We're looking for talented and dedicated individuals to join our team and help us take our mission to new heights.
    </p>
   <p>
We're a dynamic and innovative company that values teamwork, creativity, and excellence. Our culture is built on:
  </p>
  <ul>
<li>Collaboration and open communication
</li>
<li>Embracing diversity and individuality
</li>
<li>Fostering a culture of continuous learning and growth
</li>
<li>
  Prioritizing safety, quality, and customer satisfaction
</li>
  </ul>
<p>
We offer a range of exciting career opportunities across various fields, including:
</p>
<ul>
<li>Aviation and operations </li>
<li>Customer service and relations</li>
<li> Marketing and communications </li>
<li> Technology and data analytics </li>
<li> Finance and administration </li>
</ul>
<h4>What We Offer</h4>
<p>As a PiTravel team member, you'll enjoy:
</p>
<ul>
<li>Competitive salaries and benefits
</li>
<li>Opportunities for professional growth and development
</li>
<li>
 A dynamic and supportive work environment
</li>
<li>
Recognition and rewards for outstanding performance
</li>
<li> The chance to be part of a innovative and rapidly growing company
</li>
</ul>

      <p>
we'd love to hear from you. keep an eye on our job openings for an opportunity to join the PiTravel team!
      </p>
      
      <div className="openings">
        <h3 className="mb-3">Job Openings!</h3>
        <p>Currently we do not have any  job offer available</p>
      </div>
      </div>
    </Wrapper>
  )
}

export default Careers