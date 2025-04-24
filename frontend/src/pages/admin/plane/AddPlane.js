import React, { useState } from 'react'
import { Link } from "react-router-dom";
import styled from 'styled-components'
// import { Tablet, Desktop } from '../../../Responsive';
import axios from "axios";
import Header from '../../../components/Header';
import Footer from '../../../components/Footer';
import { BASE_URL } from '../../../API';
import { useAppContext } from '../../../context/AppContext'
import { POST_DATA_FAILURE, POST_DATA_REQUEST, POST_DATA_SUCCESS } from '../../../context/action';


const Wrapper = styled.div`
  font-family: var(--primary-font);
  `

function AddPlane() {
    const initialDetails = { user: "", content: "" }
    const [values, setValues] = useState(initialDetails)
    const { dispatch } = useAppContext()

    const postData = async (post) => {
        dispatch({ type: POST_DATA_REQUEST });
        try {
            const response = await axios.post(BASE_URL + '/posts', post);
            console.log(response)
            dispatch({ type: POST_DATA_SUCCESS, payload: response.data });
        } catch (error) {
            dispatch({ type: POST_DATA_FAILURE, payload: error.message });
        }
    };

    const handleSubmit = (e) => {
        e.preventDefault()
        const { user, content } = values
        const details = { user, content }
        postData(details)

        setValues(initialDetails)
    }
    const handleChange = (e) => {
        const { name, value } = e.target;
        setValues({ ...values, [name]: value });
    }

    return (
        <Wrapper>
            <Header />

            <div class="admin container my-4">
                <div class="container train">
                    <div class="back">
                        <Link to="/admin">
                            <i class="fa fa-arrow-left bg" aria-hidden="true"></i>
                        </Link>
                    </div>
                    <h2>Add Plane</h2>

                    <div></div>

                </div>

                <form onSubmit={handleSubmit}>
                    <div class="mb-3">
                        <label class="form-label" for="trainCoach">Train Coach</label>
                        <select
                            class="form-control"
                            id="trainCoach" name="trainCoach"
                            onChange={handleChange}
                            required >
                            <option value="SP0001" selected>SP0001</option>
                            <option value="SP0002">SP0002</option>
                            <option value="SP0003">SP0003</option>
                            <option value="SP0004">SP0004</option>
                            <option value="SP0005">SP0005</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="origin">Origin</label>
                        <select
                            class="form-control"
                            name="origin" id="origin"
                            onChange={handleChange}
                            placeholder="IDU(ABUJA)"
                            required>
                            <option value="idu(Abuja)" selected>IDU(ABUJA)</option>
                            <option value="kubwa(Abuja)">KUBWA(ABUJA)</option>
                            <option value="jere(Kaduna)">JERE(KADUNA)</option>
                            <option value="rigasa(Kaduna)">RIGASA(KADUNA)</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="destination">Destination</label>
                        <select
                            class="form-control"
                            name="destination"
                            id="destination"
                            placeholder="KUBWA(ABUJA)"
                            onChange={handleChange}
                            required>
                            <option value="kubwa(Abuja)">KUBWA(ABUJA)</option>
                            <option value="idu(Abuja)">IDU(ABUJA)</option>
                            <option value="jere(Kaduna)">JERE(KADUNA)</option>
                            <option value="rigasa(Kaduna)">RIGASA(KADUNA)</option>
                        </select>
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="departureDate">Journey Date</label>
                        <input
                            type="date"
                            class="form-control"
                            id="departureDate"
                            name="departureDate"
                            onChange={handleChange}
                            required />
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="departureTime">Departure Time</label>
                        <input
                            type="time"
                            class="form-control"
                            id="departureTime"
                            name="departureTime"
                            onChange={handleChange}
                            required />
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="availableSeats">Available Seats</label>
                        <input
                            type="number"
                            class="form-control"
                            id="availableSeats"
                            name="availableSeats"
                            onChange={handleChange}
                            required />
                    </div>
                    <div class="mb-3">
                        <label class="form-label" for="price">Price</label>
                        <input
                            type="number"
                            class="form-control"
                            id="price"
                            name="price"
                            onChange={handleChange}
                            required />
                    </div>
                    <div class="mb-3">
                        <button type="submit" class="btn">Submit</button>
                    </div>

                </form>

                <div class="close"><Link to="/admin" class="btn btn-info">Close</Link></div>
            </div>

            <Footer />

        </Wrapper >
    )
}

export default AddPlane