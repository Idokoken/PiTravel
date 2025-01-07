import React from 'react'
import Slider from 'react-slick';
import "slick-carousel/slick/slick.css";
import "slick-carousel/slick/slick-theme.css";
import { Tablet } from './../Responsive';
import styled from "styled-components";

const Wrapper = styled.div`
  min-height: 50vh;
  margin: 0;
  padding: 0;
  font-family: "Poppins", sans-serif;


  .slider-container {
  position: relative;
}

.slider-item {
  position: relative;
}

.slider-image {
  width: 100%;
  height: 600px;
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
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  z-index: 2; /* Ensure the text is on top */
}
  

.slider-content h2 {
  font-size: 24px;
  font-weight: bold;
  margin-bottom: 10px;
  font-weight: 700;
  ${Tablet({ fontSize: '55px', margin: "20px 0" })}
}

.slider-content p {
  font-size: 18px;
  margin-bottom: 20px;
  font-weight: 500;
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
            img: '/images/gallery1.jpg',
            title: 'Slide 1',
            description: 'This is the first slide',
        },
        {
            img: '/images/gallery2.jpg',
            title: 'Slide 2',
            description: 'This is the second slide',
        },
        {
            img: '/images/gallery3.jpg',
            title: 'Slide 3',
            description: 'This is the third slide',
        },
    ];

    return (
        <Wrapper>

            <Slider {...settings}>
                {slides.map((slide, index) => (
                    <div key={index}>
                        <div className="slider-item">
                            <img src={slide.img} alt={`Slide ${index}`} className="slider-image" />
                            <div className="slider-overlay"></div> {/* Transparent overlay */}
                            <div className="slider-content">
                                <h2>{slide.title}</h2>
                                <p>{slide.description}</p>
                            </div>
                        </div>
                    </div>
                ))}
            </Slider>

        </Wrapper>
    )
}

export default ImageSlider