import React from 'react'
import styled from 'styled-components'
// import axios from "axios";
// import { BASE_URL } from "../API";
//import { link } from "react-router-dom";
//import { Tablet } from "../Responsive";

const Wrapper = styled.div`
  padding: 0;
  margin: 0;
  font-family: var(--primary-font);
  padding: 30px;
  margin: 30px;
  border-radius: 10px;
  background: rgba(217, 217, 217, 1);

form{
    display: flex;
    justify-content: center;
    align-items: center;
    flex-wrap: wrap;
}
div{
    display: flex;
    flex-direction: column;
    margin-right: 20px;
    margin-bottom: 10px;
}
div input{
    outline: none;
    font-weight: 500;
    color: rgba(0, 0, 0, 0.5);
    padding: 10px;
    border: none;
}
div input[type="number"]{
    max-width: 150px;
}
select{
    outline: none;
    font-weight: 500;
    padding: 10px;
    border: none;
    color: rgba(0, 0, 0, 0.5);
}
select option{
    margin-bottom: 5px;
}
.search{
    background: var(--primary-color);
  /*  box-shadow: inset -2px -2px 5px rgba(0, 0, 0, 0.5), inset 2px 2px 5px rgba(255, 255, 255, 0.5); */
    border-radius: 10px;
    border: none;
    padding: 20px 10px;
    color: white;
    font-weight: 500;
}




`

function Booking() {
  return (
    <Wrapper>


      <form className="details">
        <div className="">
          <span>Origin</span>
          <input type="text" id="origin" name="orgin" placeholder="origin" />
        </div>
        <div className="">
          <span>Destination</span>
          <input type="text" id="destination" name="destination" placeholder="destination" />
        </div>
        <div className="">
          <span>Departure Date</span>
          <input type="date" id="departureDate" name="departureDate" placeholder="" />
        </div>
        <div className="search-container">
          <button className="search" type="submit">Check Availability</button>
        </div>
      </form>


    </Wrapper>
  )
}

export default Booking;