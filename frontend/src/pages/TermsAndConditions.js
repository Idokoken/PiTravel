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
  h5{
  	font-weight: 700;
  }
`

function TermsAndConditions() {
  return (
    <Wrapper>

      <div className="hero">
        <h1>Terms and Condition</h1>
      </div>
      <div className="container content p-3">
        

<h3>Introduction</h3>
<p>These Terms and Conditions ("Terms") govern your use of the PiTravel website, mobile application, and services (collectively, the "Platform").</p>
<p>1.2 By accessing or using the Platform, you agree to be bound by these Terms. </p>

<h5>2. Definitions</h5>
<p>2.1 "PiTravel" refers to PiTravel ltd, an airplane travel company with its principal place of business at Lagos, Nigeria.
</p>
<p>2.2 "User" refers to you, the individual accessing or using the Platform.
</p>
<p>2.3 "Services" refers to the travel booking and related services offered by PiTravel through the Platform.
</p>
<h5>3. Use of the Platform</h5>
<p>3.1 You must be at least 18 years old to use the Platform.</p>
<p>3.2 You agree to provide accurate and complete information when creating an account or booking travel through the Platform.
</p>
<p>3.3 You are responsible for maintaining the confidentiality of your account login credentials.
</p>
<h5>4. Booking and Payment</h5>
<p>4.1 All bookings made through the Platform are subject to the terms and conditions of the applicable airline, hotel, or other travel partner.
</p>
<p>4.2 You agree to pay all amounts owed to PiTravel and/or its suppliers in accordance with the payment terms presented on the Platform.
</p>
<h5>5. Cancellations and Refunds</h5>
<p>5.1 Cancellations and refunds are subject to the policies of the applicable airline, hotel, or other travel supplier.
</p>
<p>5.2 PiTravel reserves the right to charge cancellation fees in accordance with its policies.
</p>

<h5>6. Liability and Indemnification</h5>
<p>6.1 PiTravel shall not be liable for any damages or losses arising from your use of the Platform, except to the extent caused by PiTravel's gross negligence or willful misconduct.
</p>
<p>6.2 You agree to indemnify and hold harmless PiTravel and its affiliates, officers, directors, employees, and agents from any claims, demands, or damages arising from your breach of these Terms.
</p>

<h5>7. Intellectual Property</h5>
<p>7.1 The Platform and all content, software, and materials available on or through the Platform are the property of PiTravel and/or its licensors.
</p>
<p>7.2 You agree not to reproduce, distribute, or display any content from the Platform without PiTravel's prior written consent.
</p>

<h5>8. Governing Law and Jurisdiction
</h5>
<p>8.1 These Terms shall be governed by and construed in accordance with the laws of Nigeria.
</p>
<p>8.2 Any disputes arising from these Terms shall be resolved through binding arbitration in accordance with the rules of the [Arbitration Association].
</p>
<h5>9. Changes to these Terms</h5>
<p>9.1 PiTravel reserves the right to modify or update these Terms at any time without prior notice.
</p>
<p>9.2 Your continued use of the Platform after any changes to these Terms shall constitute your acceptance of such changes.
</p>

<h5>10. Contact Us</h5>
<p>10.1 If you have any questions or concerns about these Terms or the Platform, please contact us at mailto:support@pitravel.com.
</p>

<p>By using the Platform, you acknowledge that you have read, understood, and agree to be bound by these Terms.
</p>


      </div>
    </Wrapper>
  )
}

export default TermsAndConditions