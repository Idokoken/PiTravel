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
  span{
  	font-weight: 700;
  }
  h5{
  	font-weight: 700;
  }
`

function BaggagePolicy() {
  return (
    <Wrapper>
      <div className="hero">
        <h1>Baggage Policy</h1>
      </div>
      <div className="container content p-3">
<h5>Checked Baggage</h5>
<p><span>1. Weight Limit</span>: The maximum weight allowed for checked baggage is 32 kg (70 lbs) per bag.
</p>
<p><span>2. Size Limit</span>: The maximum linear dimensions allowed for checked baggage are 158 cm (62 in) (length + width + height).
</p>
<p><span>3. Number of Bags</span>: Passengers are allowed to check up to 2 bags, depending on the fare class and destination.
</p>
<p><span>4. Excess Baggage</span>: Additional bags or bags exceeding the weight or size limits will incur excess baggage fees.
</p>
<h5>Carry-on Baggage</h5>
<p><span>1. Weight Limit</span>: The maximum weight allowed for carry-on baggage is 7 kg (15 lbs) per bag.
</p>
<p><span>2. Size Limit</span>: The maximum linear dimensions allowed for carry-on baggage are 55 cm x 23 cm x 40 cm (21.5 in x 9 in x 15.5 in).
</p>
<p><span>3. Number of Bags</span>: Passengers are allowed to carry one standard article and one personal article on board.
</p>

<h5>Special Items</h5>
<p><span>1. Musical Instruments</span>: Musical instruments can be carried on board or checked, subject to space availability and additional fees.
</p>
<p><span>2. Sports Equipment</span>: Sports equipment, such as bicycles or surfboards, can be checked, subject to additional fees and space availability.
</p>
<p><span>3. Pets</span>: Pets can be carried on board or checked, subject to additional fees and space availability.
</p>
<h5>Prohibited Items</h5>
<p><span>1. Dangerous Goods</span>: Items such as lithium batteries, fireworks, and flammable liquids are prohibited in checked and carry-on baggage.
</p>
<p><span>2. Sharp Objects</span>: Items such as knives, scissors, and razor blades are prohibited in carry-on baggage.
</p>

<h5>Baggage Fees</h5>
<p><span>1. Checked Baggage</span>: Fees apply for checked baggage, depending on the fare class and destination.
</p>
<p><span>2. Excess Baggage</span>: Fees apply for excess baggage, depending on the weight and size of the bag.
</p>
<p><span>3. Special Items</span>: Fees apply for special items, such as musical instruments, sports equipment, and pets.
</p>

<h5>Liability</h5>
<p><span>1. Damage</span>: The airline is liable for damage to checked baggage, up to a maximum amount.
2. *Loss*: The airline is liable for loss of checked baggage, up to a maximum amount.
</p>

<h5>Disclaimer</h5>
<p><span>1. Changes</span>: The airline reserves the right to change its baggage policy at any time.
</p>
<p><span>2. Exceptions</span>: The airline reserves the right to make exceptions to its baggage policy, subject to additional fees and space availability.
</p>
      </div>
    </Wrapper>
  )
}

export default BaggagePolicy