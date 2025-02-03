import React from 'react'
import styled from 'styled-components'
//import { Link } from "react-router-dom";
import { Tablet } from "../Responsive";
import SubscribeForm from "../components/SubscribeForm";


const Wrapper = styled.div`
  .hero{
  	width: 100%;
  	height: 20vh;
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
  

h2{
    color: rgba(0, 0, 0, 0.5);
    font-weight: 700;
}
h5{
    font-size: 16px;
    ${Tablet({ fontSize: '20px' })}
}
a{
    padding: 5px 10px;
    background: var(--primary-color);
    color: white;
    font-size: 20px;
    font-weight: 500;
    border-radius: 5px;
    text-decoration: none;
}
.address{
    width: 100%;
    display: grid;
    grid-template-columns: 100%;
    background: rgba(53, 8, 112, 0.2);;
    grid-gap: 10px;
    border-radius: 20px;
    padding: 30px 10px;
    ${Tablet({
    display: 'grid', gridTemplateColumns: '45% 45%', padding: '30px', borderRadius: '30px'
})}
}
.address .one{
    display: flex;
    flex-direction: column;  
    margin: 5px;
}
.address .one div{
    word-break: break-all;
    margin-left: 10px;
    margin-right: 5px;
    display: flex;
    align-items: center;

}
.address .one p{
    margin: 8px 10px;
    font-size: 14px;
    ${Tablet({ margin: '10px 0', fontSize: '16px' })}
    
}
.address .one span{
  flex-shrink: 0;
  display: flex;
  justify-content: center;
  align-items: center;
  color: var(--primary-color);
  background: white;
  width: 40px;
  height: 40px;
  border-radius: 50%;
}
`

function Contact() {
    return (
        <Wrapper>
            <div className="hero">
                <h1>Contact Us</h1>
            </div>
            <div className="container py-3">
        <p className="my-3">If you have questions about any of our services, you can reach us through any of the following platforms. We will get back to you as soon as possible.
        </p>
                  
    <div className="address">
       <div className="one">
         <div className="">
            <span className="me-1"><i className="fa-solid icon fa-location-dot"></i></span>
             <h4>Office Hours</h4>
          </div>   
          <p>Opens <strong>24/7</strong>, Monday - Sunday</p>
                  
       </div>
       <div className="one">
         <div className="">
            <span className="me-1"><i className="fa-solid icon fa-phone"></i></span>
             <h4>Our Hotline</h4>
          </div>   
          <p>+2348062538412</p>
          <p>+2347033655544</p>
       </div>
        <div className="one">
         <div className="">
            <span className="me-1"><i className="fa-solid icon fa-envelope-circle-check"></i></span>
             <h4>Email Address</h4>
          </div>   
          <p>Info@pitravel.com</p>                           <p>Support@pitravel.com</p>
       </div>
            
      </div>
      </div>
      
      <form className="p-4">
  <h2>Send Us a message and lets' know how we can help you</h2>
  <div className="mb-3">
    <label for="email" className="form-label">Email</label>
    <input type="email" className="form-control" id="email" />  
  </div>
  
  <div className="mb-3">
    <label for="name" className="form-label">Name</label>
    <input type="text" className="form-control" id="name" />  
  </div>
  
  <div className="mb-3">
    <label for="name" className="form-label">Phone Number</label>
    <input type="number" className="form-control" id="name" />  
  </div>
  
   <div className="mb-3">
    <label for="message" className="form-label">Message</label>
    <textarea className="form-control" id="message"  />  
  </div>  
  
  <button type="submit" className="btn btn-primary">Submit</button>
  
</form>
          
        <section className="subscribe">
          <SubscribeForm />
        </section>

        </Wrapper>
    )
}

export default Contact