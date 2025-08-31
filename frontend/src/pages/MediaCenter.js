import React from 'react'
import styled from 'styled-components'
import Header from '../components/Header';
import Footer from "../components/Footer";
import { Tablet } from '../Responsive';
//import { link } from "react-router-dom";


const Wrapper = styled.div`
  padding: 0;
  margin: 0;
  font-family: var(--primary-font);
  min-height: 40vh;
  
  .hero{
  	width: 100%;
  	height: 15vh;
  	// background: var(--secondary-color);
    background: linear-gradient(92.05deg, #B02323 61.11%, #2670DF 98.82%);
  	display: flex;
  	justify-content: center;
  	align-items: center;
  	padding: 20px;
    ${Tablet({ height: "20vh" })}
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
     border-radius: 20px;  	 
  }
  .img-container img{
  	  width: 100%;
  	  height: 100%;
      object-fit: cover;
      border-radius: 20px; 
  }
  h4{
  	color: var(--primary-color);
  	font-weight: 700;
  }
  .news{
  	padding: 20px 0;
  }
  
`

function MediaCenter() {
  return (
    <>
      <Header />
      <Wrapper>
        <div className="hero">
          <h1>Media Center</h1>
        </div>

        <div className="container content p-3">
          <div className="all-news">

            <div className="news">
              <div className="img-container">
                <img src="/images/items/news.jpeg" alt="news" />
              </div>
              <h4>Heading 1, Lorem ipsum dolor sit amet, consectetur adipiscing elit
              </h4>
              <p>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed a rutrum urna, ut ornare neque. Cras id est mi. Nunc in finibus felis. Nulla laoreet, eros eget posuere lacinia, purus lacus ultricies leo, vitae aliquet arcu dui vel diam. Vestibulum maximus mi in arcu sagittis, eu eleifend orci ullamcorper. Nullam a elementum ipsum, eu dignissim turpis. Integer rhoncus cursus lacus, sit amet sodales justo pretium eu. Nulla in dolor nisl. Morbi sit amet varius lorem.
              </p>
            </div>

            <div className="news">
              <div className="img-container">
                <img src="/images/items/news2.jpeg" alt="news" />
              </div>
              <h4> heading 2, Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed
              </h4>
              <p>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed a rutrum urna, ut ornare neque. Cras id est mi. Nunc in finibus felis. Nulla laoreet, eros eget posuere lacinia, purus lacus ultricies leo, vitae aliquet arcu dui vel diam. Vestibulum maximus mi in arcu sagittis, eu eleifend orci ullamcorper. Nullam a elementum ipsum, eu dignissim turpis. Integer rhoncus cursus lacus, sit amet sodales justo pretium eu. Nulla in dolor nisl. Morbi sit amet varius lorem.
              </p>
            </div>

            <div className="news">
              <div className="img-container">
                <img src="/images/items/news3.jpeg" alt="news" />
              </div>
              <h4>heading 3, Lorem ipsum dolor sit amet, consectetur adipiscing elit
              </h4>
              <p>
                Lorem ipsum dolor sit amet, consectetur adipiscing elit. Sed a rutrum urna, ut ornare neque. Cras id est mi. Nunc in finibus felis. Nulla laoreet, eros eget posuere lacinia, purus lacus ultricies leo, vitae aliquet arcu dui vel diam. Vestibulum maximus mi in arcu sagittis, eu eleifend orci ullamcorper. Nullam a elementum ipsum, eu dignissim turpis. Integer rhoncus cursus lacus, sit amet sodales justo pretium eu. Nulla in dolor nisl. Morbi sit amet varius lorem.
              </p>
            </div>



          </div>
        </div>
      </Wrapper>
      <Footer />
    </>
  )
}

export default MediaCenter