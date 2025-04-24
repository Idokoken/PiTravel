import React from 'react'
import Slider from 'react-slick';
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import { Tablet } from './../Responsive';
import styled from "styled-components";
import { Link } from 'react-router-dom';

const Wrapper = styled.div`
  font-family: var(--primary-font);
  margin-bottom: 20px;
  padding-bottom: 30px;
 


  .slider-container {
  width: 90%;
  height: 40vh;
  margin: 20px auto;
   ${Tablet({ height: '60vh' })}
}

.slider-item {
  position: relative;
  width: 100%;
  height: 40vh;
  margin: 30px 0;
   ${Tablet({ height: '60vh' })}
}

.slider-image {
  width: 100%;
  height: 100%;
  object-fit: cover;
}

.slider-overlay {
  position: absolute;
  top: 0;
  left: 0;
  width: 100%;
  height: 100%;
  background-color: rgba(0, 0, 0, 0.6); /* Transparent background */
}

.slider-content {
  position: absolute;
  color: white;
  padding: 10px;
  font-size: 18px;
  z-index: 2; /* Ensure the text is on top */
  top: 30%;
  left: 50%;
  transform: translate(-60%, -50%);
 
  ${Tablet({ left: "35%", transform: "translate(-60%, -60%)" })}
}
  

.slider-content h3 {
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 20px;
  font-weight: 700;
  min-width: 250px;
  ${Tablet({ fontSize: '40px', margin: "20px 0", minWidth: "400px" })}
}

 a{
    padding: 7px 10px;
    background: var(--primary-color);
    color: white;
    font-size: 18px;
    font-weight: 500;
    border-radius: 10px;
    text-decoration: none;
     ${Tablet({ fontSize: '20px' })}
  }

`

function ImageSlider() {
    const settings = {
        dots: true,
        infinite: true,
        speed: 500,
        slidesToShow: 1,
        slidesToScroll: 1,
        autoplay: true,
        autoplaySpeed: 3000,
    };


    const slides = [
        {
            img: '/images/items/story1.jpg',
            title: 'Get to know our story',
            description: 'Learn More',
        },
        {
            img: '/images/items/story2.png',
            title: 'Get to know our story',
            description: 'Learn More',
        },
        {
            img: '/images/items/story3.png',
            title: 'Get to know our story',
            description: 'Learn More',
        },
    ];

    return (
        <Wrapper>

            <Slider {...settings} className='slider-container'>
                {slides.map((slide, index) => (
                    <div key={index}>
                        <div className="slider-item">
                            <img src={slide.img} alt={`Slide ${index}`} className="slider-image" />
                            <div className="slider-overlay"></div> {/* Transparent overlay */}
                            <div className="slider-content">
                                <h3>{slide.title}</h3>
                                <Link to="/about">{slide.description}</Link>
                            </div>
                        </div>
                    </div>
                ))}
            </Slider>

        </Wrapper>
    )
}

export default ImageSlider