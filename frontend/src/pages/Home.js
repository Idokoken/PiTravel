import React from "react";
import { Link } from "react-router-dom";
import { Tablet } from './../Responsive';
import styled from "styled-components";


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
  
  .bookings{
  	  border: 2px solid black;
  	  height: 20vh;
  }
  
  .holidays .destinations{
  	  display: grid;
  	  grid-template-columns: 100%;
  	  gap: 20px;
  	  padding: 30px;
  	  ${Tablet({gridTemplateColumns: "23% 23% 23% 23%"})}
  }
  .holidays h3{
  	  text-align: center;
  	  font-weight: 700;
  	  font-size: 27px;
  }
  .dest{
  	  border-radius: 20px;
  	  height: 50vh;
  	  display: flex;
  	  flex-direction: column;
  	  align-items: center;
  	  border: 2px solid black;
  }
  .dest .img-container{
  	 width: 100%;
  	 height: 30vh;
  	   	 
  }
  .dest .img-container img{
  	  width: 100%;
  	  height: 100%; 
  	  border-radius: 20px 20px 0 0;
  }

  .story{
  	width: 90%;
  	height: 40vh;
  	margin: 20px auto;
  	position: relative;
  z-index: -2;
  background-image: url("/images/items/story.jpeg");
  background-size: cover;
  display: flex;
  flex-direction: column;
  justify-content: space-between;
  color: white;
  ${Tablet({ height: '60vh' })}
  }
  .story .story-bg{
    position: absolute;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.5);
    z-index: -1;
  }
  .story a{
    padding: 7px 10px;
    background: var(--primary-color);
    color: white;
    font-size: 20px;
    font-weight: 500;
    border-radius: 10px;
    text-decoration: none;
  }
  .achievement{
  	  padding: 30px 20px;
  	  background: var(--secondary-color);
  	  
  }
  .achievement .contents{
  	  display: grid;
  	  grid-template-columns: 100%;
  	  justify-content: center;
  	  gap: 20px;
  	  ${Tablet({ gridTemplateColumns: '30% 30% 30%' })}  
  }
  .achievement .contents div{
  	  display: flex;
  	  flex-direction: column;
  	  align-items: center;
  	  border-radius: 10px;
  	  background: white;
  	  padding: 20px;
  }
  
  .achievement h1{
  	  color: var(--primary-color);
  	  font-weight: 700;
  	  font-size: 80px;
  }
  .achievement h3{
  	  color: white;
  	  font-weight: 700;
  	  text-align: center;
  	  margin: 30px 20px;
  	  font-size: 40px;	  
  }
  

`;


const Home = () => {


  return (
    <Wrapper>
      <div className="hero" id="home">
        <div className='hero-bg'></div>
        <h1>Travel Safely with PiTravel</h1>
        <p>
          Exploring the world with PiTravel
        </p>
        <Link to="/" className="">BOOK YOUR TICKET NOW</Link>
      </div>

      <section className="bookings">
         <h3>Bookings</h3>
      </section>
       
      <section className="holidays my-3"> 
      <h3>Explore Popular holiday Destinations</h3>
      <div className="destinations">
        
           <div className="dest">
              <div className="img-container">
                <img src="/images/items/canada.jpeg" alt="city" />
              </div>
              <p className="mt-2">Canada</p>
              <h4>Montreal</h4>
              <p>Starting from <span>$500</span></p>
           </div>
           <div className="dest">
              <div className="img-container">
                <img src="/images/items/london.jpeg" alt="city" />
              </div>
              <p className="mt-2">United Kingdom</p>
              <h4>London</h4>
              <p>Starting from <span>$750</span></p>
           </div>
              <div className="dest">
              <div className="img-container">
                <img src="/images/items/usa.jpeg" alt="city" />
              </div>
              <p className="mt-2">United State of America</p>
              <h4>Los Angeles</h4>
              <p>Starting from <span>$750</span></p>
           </div>
              <div className="dest">
              <div className="img-container">
                <img src="/images/items/dubai.jpeg" alt="city" />
              </div>
              <p className="mt-2">United Arab Emirate</p>
              <h4>Dubai</h4>
              <p>Starting from <span>$750</span></p>
           </div>
           
      </div>
      </section>
      
      <section className="story">
        <div className='story-bg'></div>
        <h3 className="m-4">Get to know our story</h3>
        <p className="m-4">
          <Link to="/stories">
            Learn More
          </Link>
        </p>
      </section>
      
      <section className="achievement">
        <h3>Achievements</h3>
        <div className="contents">
          <div>
            <h1>100 + </h1>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce vehicula lacinia purus non tincidunt. Fusce accumsan varius  consectetur ut ac augue</p>
          </div>
          <div>
            <h1>100K + </h1>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce vehicula lacinia purus non tincidunt. Fusce accumsan varius  consectetur ut ac augue</p>
          </div>
            <div>
            <h1>80% </h1>
            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Fusce vehicula lacinia purus non tincidunt. Fusce accumsan varius  consectetur ut ac augue</p>
          </div>
        </div>
      </section>

    </Wrapper>
  );
};

export default Home;