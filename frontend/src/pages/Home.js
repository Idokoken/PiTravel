import React from "react";
import { Link } from "react-router-dom";
import { Tablet } from './../Responsive';
import styled from "styled-components";
import SubscribeForm from "../components/SubscribeForm";
import Stories from "../components/Stories";


const Wrapper = styled.div`
  min-height: 50vh;
  margin: 0;
  padding: 0;
  font-family: "Poppins", sans-serif;
  
  //  a {
  //   padding: 10px 15px;
  //   background: var(--primary-color);
  //   color: white;
  //   font-size: 20px;
  //   font-weight: 500;
  //   border-radius: 30px;
  //   text-decoration: none;
  // }
  .more a:hover {
    // color: #0a0f83;
    // font-weight: 700;
  }
  .hero {
  position: relative;
  z-index: -2;
  height: 50vh;
  width: 100%;
  background-image: url("/images/items/home.png");
  background-size: cover;
  display: flex;
  flex-direction: column;
  justify-content: center;
  align-items: center;
  color: white;
  padding: 20px;
  ${Tablet({ height: '70vh' })}
  }
  .hero .hero-bg{
    position: absolute;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.3);
    z-index: -1;
}
  .hero h1 {
    margin: 20px 0;
    font-weight: 700;
    ${Tablet({ fontSize: '55px', margin: "30px 0" })}
  }
  .hero p{
    font-weight: 500;
    ${Tablet({ fontSize: '20px', width: "725px" })}
  }
  .hero a{
    padding: 10px 15px;
    background: var(--primary-color);
    color: white;
    font-size: 20px;
    font-weight: 500;
    border-radius: 10px;
    text-decoration: none;
  }
  .about{
      padding: 30px 20px;
      display: flex;
      flex-direction: column;
      align-items: center;
      justify-content: center;
      width: 100%;
  }
  
  




`;


const Home = () => {


  return (
    <Wrapper>
      <div className="hero" id="home">
        <div className='hero-bg'></div>
        <h1>travel Safely with PiTravel</h1>
        <p>
          Exploring the world with PiTravel
        </p>
        <Link to="/" className="">BOOK YOUR TICKET NOW</Link>
      </div>

      <section className="bookings">

      </section>

      <section className="holidays">
        <h3>Explore </h3>
      </section>



      <section>
        <Stories />
      </section>
      <section className="subscribe">
        <SubscribeForm />
      </section>

    </Wrapper>
  );
};

export default Home;
