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
  h5{
  	font-weight: 700;
  }

`

function FAQs() {
  return (
    <Wrapper>
      <div className="hero">
        <h1>Faqs</h1>
      </div>
      <div className="container content p-3">
        <h2>We are here to help you!</h2>
        
    <p>Here are some frequently asked questions (FAQs):</p>

<h5>General Questions</h5>
 <h5> What is PiTravel?</h5>
<p> PiTravel is an online travel agency specializing in flight bookings, offering a wide range of routes and competitive prices.</p>

<h5>How do I contact PiTravel's customer support?</h5>
<p> You can reach us through our website's contact form, email (support@pitravel.com), or phone (+1 (555) 123-4567).
</p>

<h5>Booking and Payment</h5>
<h5>How do I book a flight on PiTravel?
</h5>
<p>Simply search for your desired route and travel dates, select your flight, and follow the booking process to complete your payment.
</p>

<h5> What payment methods does PiTravel accept?</h5>
<p> We accept major credit cards (Visa, Mastercard, verve), PayPal, and bank transfers.
</p>

<h5> Can I cancel or change my booking?</h5>
<p> Please refer to our cancellation and change policies, which vary depending on the airline and fare type.
</p>

<h5>Flight Information</h5>
<h5> How do I check-in for my flight?</h5>
<p> Check-in is usually available 24 hours before departure through the airline's website or our website.
</p>

<h5> What is the baggage allowance for my flight?</h5>
<p> Baggage allowances vary by airline and fare type. Please check with the airline or our website for specific details.</p>

<h5>Can I select my seat?</h5>
<p> Seat selection is available on some flights, depending on the airline and fare type.</p>

<h5>Technical Issues</h5>
<h5> I'm having trouble booking a flight. What should I do?
</h5>
 <p>Try clearing your browser cache, checking your internet connection, or contacting our customer support team.
</p>

<h5> How do I reset my password?</h5>
<p> Click on the "Forgot Password" link on our login page and follow the instructions.
</p>

        
      </div>
    </Wrapper>
  )
}

export default FAQs