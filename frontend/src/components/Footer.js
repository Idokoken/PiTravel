import React from "react";
import { Link } from "react-router-dom";
import styled from "styled-components";
import { Tablet } from "../Responsive";


const Wrapper = styled.footer`
  padding: 0;
  margin: 0;
  font-family: var(--primary-font);
  background: black;
  color: white;

  .footer {
    width: 100vw;
    display: flex;
    padding: 20px;
    flex-wrap: wrap;
  }

  .footer .item {
    flex: 100%;
    ${Tablet({ flex: "23%" })}
    display: flex;
    flex-direction: column;
    margin-top: 30px;
    ${Tablet({ alignItems: "center" })}
    
  }
  .footer .item .icon-header h3 {
    font-size: 30px;
    
    font-family: "Oleo Script Swash Caps", serif;
    font-style: italic;
    font-weight: 700;
    
  }
  .footer .item h3 {
    color: var(--primary-color);
    font-weight: 500;
    margin-bottom: 0;
    padding-bottom: 0;
  }
  .bottom {
  	 background: var(--secondary-color);
    display: flex;
    justify-content: center;
    align-items: center;
  }
  .copywite {
    margin: 10px;
    font-family: "Abril Fatface", serif;
    ${Tablet({ fontSize: "20px" })}
  }
 .footer-logo{
    width: 30px;
    height: 30px;
  }
  .brand {
    align-self: flex-start;
  }
  .icon-header {
    display: flex;
  }
  .icons-container {
    display: flex;
    align-items: center;
    gap: 10px;
    padding: 10px;
  }
  .icon-container {
    display: flex;
    justify-content: center;
    align-items: center;
    height: 40px;
    width: 40px;
    border-radius: 50%;
    border: 2px solid black;
    margin-right: 20px;
  }
  .icon {  
    height: 100%;
    width: 100%;
  }
  .ruler{
  	  color: var(--secondary-color);
  	  border: 3px solid var(--secondary-color);
  	  width: 50%;
  }
  a {
    text-decoration: none;
    color: inherit;
  }
  a:hover {
    color: #0a0f83;
    font-weight: 700;
  }
`;

function Footer() {
  return (
    <Wrapper>
      <div className="footer">
        <div className="item">
          <div className="icon-header">
            <img className="footer-logo" src="/images/brand.png" alt="brand" />{" "}
            <h3 className="ms-2">PiTravel</h3>
          </div>
          <p>Bringing You closer to your destination</p>
          
          <h4>Follow Us</h4>
          <div className="icons-container">
          <Link className="icon-container" to="/">
              <img className="icon" src="/images/x.png" alt="x" />
            </Link>
            <Link className="icon-container" to="/">
              <img className="icon" src="/images/facebook2.png" alt="facebook" />
            </Link>

            <Link className="icon-container" to="/">
              <img className="icon" src="/images/instagram2.jpeg" alt="instagram" />
            </Link>
            <Link className="icon-container" to="/">
              <img className="icon" src="/images/youtube.png" alt="youtube" />
            </Link>

          </div>
          
        </div>

        <div className="item">
          <h3>Information</h3>
          <hr className="ruler" />
          <p>
            <Link to="/faqs">FAQs</Link>
          </p>
          <p>
            <Link to="/terms">Terms & Conditions</Link>
          </p>
          <p>
            <Link to="/routes">Routes</Link>
          </p>
             <p>
            <Link to="/departure-arrivals">Departure & Arrivals</Link>
          </p>
          <p>
            <Link to="/baggage-policy">Gaggage Allowance</Link>
          </p>

        </div>
       
        
        <div className="item">
          <h3>About Us</h3>
          <hr className="ruler" />
          <p>
            <Link to="/">Home</Link>
          </p>
          <p>
            <Link to="/contact">Contact</Link>
          </p>
          <p>
            <Link to="/about">About Us</Link>
          </p>
          <p>
            <Link to="/Careers">Careers</Link>
          </p>
          <p>
            <Link to="/media-center">Media Center</Link>
          </p>

        </div>       
        
        <div className="item">
          <h3>Book</h3>
          <hr className="ruler" />
          <p>
            <Link to="/bookings">Book Flight</Link>
          </p>
          <p>
            <Link to="/travel-services">Travel Services</Link>
          </p>
          <p>
            <Link to="/transportation">Transportation</Link>
          </p>
          <p>
            <Link to="/search-flight">Search for Flight</Link>
          </p>

        </div>
          
      </div>
      
      
      <div className="bottom">
        <p className="copywite">
          All Right reversed &copy; PiTravel 2024{" "}

        </p>
      </div>
    </Wrapper>
  );
}

export default Footer;