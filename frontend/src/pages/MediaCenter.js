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
  .img-container{
  	 width: 100%;
  	 height: 30vh;
  	 margin: 30px auto 15px;   	 
  }
  .img-container img{
  	  width: 100%;
  	  height: 100%;
  }
  h4{
  	color: var(--primary-color);
  	font-weight: 700;
  }
`

function MediaCenter() {
  return (
    <Wrapper>
      <div className="hero">
        <h1>Media Center</h1>
      </div>
      <div className="container content py-3">
        <div className="all-news">
          <div className="news">
            <div className="img-container">
              <img src="/images/items/news.jpeg" alt="news" />
            </div>
            <h4>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed a rutrum urna, ut ornare neque
            </h4>
            <p>
            Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed a rutrum urna, ut ornare neque. Cras id est mi. Nunc in finibus felis. Nulla laoreet, eros eget posuere lacinia, purus lacus ultricies leo, vitae aliquet arcu dui vel diam. Vestibulum maximus mi in arcu sagittis, eu eleifend orci ullamcorper. Nullam a elementum ipsum, eu dignissim turpis. Integer rhoncus cursus lacus, sit amet sodales justo pretium eu. Nulla in dolor nisl. Morbi sit amet varius lorem.
            </p>
          </div>
        </div>
      </div>
    </Wrapper>
  )
}

export default MediaCenter