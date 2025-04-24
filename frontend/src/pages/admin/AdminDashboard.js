import React from 'react'
import { Link } from "react-router-dom";
import styled from 'styled-components'
// import axios from "axios";
// import { Tablet, Desktop } from "../Responsive";
// import { BASE_URL } from "../API";
// import { useAppContext } from '../context/AppContext'


const Wrapper = styled.div`
  font-family: var(--primary-font);
  `

function AdminDashboard() {
    return (
        <Wrapper>

            <div className="admin pt-5">
                <h2 className="text-bold">Welcome to the Admin Dashboard</h2>

                <section className="menu">
                    <Link to="/admin">
                        <div className="one">
                            <p>
                                <span><i className="fa-solid fa-train"></i>
                                </span>Trains
                            </p>
                            <h6>plane nos</h6>
                        </div>
                    </Link>
                    <Link to="/admin/users">
                        <div className="one">
                            <p><span><i className="fa-solid fa-users"></i></span>Users</p>
                            <h6>user nos</h6>
                        </div>
                    </Link>
                    <Link to="/reservations">
                        <div className="one">
                            <p><span><i className="fa-solid fa-ticket"></i></span>Reservations</p>
                            <h6>booking nos</h6>
                        </div>
                    </Link>
                </section>
                <section className="reservations mt-3">
                    <h2>Manage Reservations</h2>
                    <Link to="/trains/add" className="m-3 btn add">Add New Train</Link>



                    <table className="table table-striped table-responsive-sm">
                        <thead>
                            <tr>
                                <th>ID</th>
                                <th>Train Coach</th>
                                <th>Origin</th>
                                <th>Destination</th>
                                <th>Actions</th>
                            </tr>
                        </thead>
                        <tbody>
                            <tr>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td></td>
                                <td className="" colspan="2">
                                    <Link className="btn btn-secondary edit" to="/editplane">
                                        <i className="fa-solid fa-pen-to-square"></i>
                                    </Link>
                                    <Link className="btn btn-danger del" to="delete">
                                        <i className="fa-solid fa-trash"></i>
                                    </Link>
                                    <Link className="btn btn-primary view" to="plane">
                                        View Train
                                    </Link>
                                </td>
                            </tr>
                        </tbody>
                    </table>
                    <div className="no-data">
                        <h5>There is no available Train for reservation at the moment</h5>
                        <p>Please add Train</p>
                    </div>
                </section>

            </div>

        </Wrapper >
    )
}

export default AdminDashboard