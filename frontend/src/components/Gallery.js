import React from 'react'
import styled from 'styled-components'
//import { link } from "react-router-dom";
//import { Tablet } from "../Responsive";

const Wrapper = styled.div`
  padding: 0;
  margin: 0;
  font-family: var(--primary-font);

`


function Gallery() {
    return (
      <Wrapper>
        <div className="our-gallery" id="gallery">
            <h3>Explore Our Self Defense Training Gallery</h3>
            <div className="gallery">
                <div className="img-container">
                    <img src="/images/gallery1.jpg" alt="gallery" />
                </div>
                <div className="img-container">
                    <img src="/images/gallery2.jpg" alt="gallery" />
                </div>
                <div className="img-container">
                    <img src="/images/gallery3.jpg" alt="gallery" />
                </div>
                <div className="img-container">
                    <img src="/images/gallery4.jpg" alt="gallery" />
                </div>
                <div className="img-container">
                    <img src="/images/gallery5.jpg" alt="gallery" />
                </div>
                <div className="img-container">
                    <img src="/images/gallery6.jpg" alt="gallery" />
                </div>
            </div>
        </div>
       </Wrapper>
    )
}

export default Gallery