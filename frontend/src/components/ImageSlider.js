import React, { useState, useEffect } from 'react'
import { Tablet } from './../Responsive';
import styled from "styled-components";
import { Link } from "react-router-dom";
import Image1 from "./items/image1.png"
import Image2 from "./items/image2.png"

const Wrapper = styled.div`
  min-height: 50vh;
  margin: 0;
  padding: 0;
  font-family: "Poppins", sans-serif;


 .slider-container {
  position: relative;
  width: 100vw;
  display: flex;
  align-items: center;
  justify-content: center;
  
}

.slider {
  width: 100vw;
  height: 50vh;
  overflow: hidden;
  position: relative;
   ${Tablet({ height: '70vh' })}
   
}

.slide-image {
  width: 100%;
  height: 100%;
  object-fit: cover;
  display: block;
  opacity: 0; /* Hidden by default */
  transition: opacity 2s ease-in-out, transform 5s ease-in-out;
  position: absolute;
  
}
.slide-image.active {
  opacity: 1; /* Only the active image is visible */
  transform: scale(1);
}

.overlay-text {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  color: white;
  width: 100%;
  text-align: center;
  padding: 10px 20px;
  border-radius: 5px;
  z-index: 1; 
}


  h1 {
    margin: 20px 0;
    font-weight: 700;
    ${Tablet({ fontSize: '55px', margin: "30px 0" })}
  }
  p{
    font-weight: 500;
    ${Tablet({ fontSize: '20px', width: "725px" })}
  }
   a{
    padding: 10px 15px;
    background: var(--primary-color);
    color: white;
    font-size: 20px;
    font-weight: 500;
    border-radius: 10px;
    text-decoration: none;
  }


`

function ImageSlider() {
  const images = [Image1, Image2];

  const [currentIndex, setCurrentIndex] = useState(0);

  useEffect(() => {
    const interval = setInterval(() => {
      setCurrentIndex((prevIndex) =>
        prevIndex === images.length - 1 ? 0 : prevIndex + 1
      );
    }, 3000); // Change every 3 seconds

    return () => clearInterval(interval);
  }, [images.length]);

  return (
    <Wrapper>

      <div className="slider-container">
        <div className="slider">

          {images.map((image, index) => (
            <img
              key={index}
              src={image}
              alt={`Slide ${index + 1}`}
              className={`slide-image ${index === currentIndex ? 'active' : ''}`}
            />
          ))}
          <div className="overlay-text">

            <h1>Travel Safely with PiTravel</h1>
            <p>
              Exploring the world with PiTravel
            </p>
            <Link to="/" className="">BOOK YOUR TICKET NOW</Link>
          </div>
        </div>
      </div>

    </Wrapper>
  )
}

export default ImageSlider