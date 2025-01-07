import React from 'react'
// import { Tablet, Desktop } from './../Responsive';
import styled from "styled-components";

const Wrapper = styled.div`
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
    height: 35vh;
    padding: 0 10px;
    margin: 20px 0;
    background-image: url('/images/stories.jpg');
    background-size: cover;  
    position: relative;
    z-index: -2;
    color: white;

.hero-bg{
    position: absolute;
    width: 100%;
    height: 100%;
    background-color: rgba(0, 0, 0, 0.3);
    z-index: -1;
}
    h3{
    color: white;
    font-weight: 700;
    margin-bottom: 30px;
}
    

`

function Stories() {
    return (
        <Wrapper className="stories">
            <div className='hero-bg'></div>
            <h3>Hear from our students</h3>
            <h5>Coming soon</h5>
        </Wrapper>
    )
}

export default Stories