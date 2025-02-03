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
  	text-align: center;
  	font-weight: 700;
  }
  .img-container{
  	 width: 100px;
  	 height: 100px;
  	 margin: 30px auto 15px;   	 
  }
  .img-container img{
  	  width: 100%;
  	  height: 100%;
  }

`

function About() {
  return (
    <Wrapper>
      <div className="hero">
        <h1>About Us</h1>
      </div>
      <div className="container content p-3 mx-2">
        <div className="img-container">
          <img src="/images/vision.png" alt="vision" />
        </div>
        <h3>Vision</h3>
        <p>
        To revolutionize the way people travel by providing a seamless, personalized, and cost-effective flight booking experience, empowering travelers to explore the world with ease and confidence.
        </p>
        <div className="img-container">
          <img src="/images/mission.png" alt="mission" />
        </div>
        <h3>Mission</h3>
        <p>
      To simplify the travel planning process by delivering a fast, easy, and secure flight booking experience that exceeds our customers' expectations, while providing unparalleled customer service, innovative technology, and unmatched value.
        </p>
        <div className="img-container">
          <img src="/images/story.png" alt="story" />
        </div>
        <h3>Our Story</h3>
        <p>
It was January 2020 when PiTravel first took to the skies. Founded by a group of passionate travelers and aviation enthusiasts, One of the company's missions was to revolutionize the flying experience with a focus on comfort, convenience, and community.
     </p>
     <p>
The first PiTravel flight departed from New York's JFK Airport, bound for Los Angeles. On board, passengers were treated to sleek, modern aircraft, complete with plush seats, ample legroom, and personalized in-flight entertainment.
    </p>
    <p>
As the plane soared through the skies, PiTravel's CEO, Idoko Bryan, stood at the front of the cabin, welcoming passengers and sharing his vision for the company. "At PiTravel, we're not just about getting you from point A to point B," he said. "We're about creating a travel experience that's truly unforgettable."
    </p>
    <p>
Over the next few months, PiTravel expanded its route network, adding flights to destinations across the United States, Europe, Africa and Asia. The company's commitment to excellence earned it a loyal following among travelers, who praised PiTravel's friendly staff, comfortable aircraft, and innovative amenities.
    </p>
      <p>
One year after its launch, PiTravel had established itself as a major player in the aviation industry. As the company looked to the future, Bryan and his team remained dedicated to their core values: comfort, convenience, community, and a passion for exploration.
       </p>
      </div>
    </Wrapper>
  )
}

export default About