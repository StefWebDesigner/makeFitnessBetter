import React from 'react';

import {Container, Nav, Navbar, NavDropdown} from "react-bootstrap";
import {Link} from "react-router-dom";
import {IoMdLogIn} from "react-icons/io";
import {FiLogOut} from "react-icons/fi";
import {MdAccountCircle} from "react-icons/md";
import {BsCartCheck} from "react-icons/bs";
import {ImHome} from "react-icons/im";
import {GrLogin} from "react-icons/gr";
import {LuLogOut} from "react-icons/lu";
import {MdOutlineAssignmentInd} from "react-icons/md";
import brandLogo from '../images/placeholder.png';

// import brandLogo from './images/placeholder.png';








const MainNavigation = () => {
    // @ts-ignore
    return (
        <>
        <Container>
                        <Nav className="main-nav-container">
                            {/*Container for the brand related content*/}
                            <div className="main-nav-brand-container">
                                <img src = {brandLogo} className = "brand-logo"/>
                                <h1> Brand</h1>
                            </div>

                            {/*Container for the links that will change throughout the application*/}
                            <div>
                                <Link to="/">
                                    <ImHome
                                        size={35}
                                    />
                                </Link>
                                <Link
                                    className=""
                                    to="/register"
                                >
                                    <MdOutlineAssignmentInd size = {35}/>
                                </Link>
                                <Link
                                    className=""
                                    to="/login"
                                >
                                    <GrLogin
                                        size={35}
                                    />
                                </Link>

                                {/*To be added after optomiozing the menu*/}
                                {/*<Link*/}
                                {/*    className=""*/}
                                {/*    to="/"*/}
                                {/*>*/}
                                {/*    <LuLogOut size={35}/>*/}
                                {/*</Link>*/}
                            </div>


                        </Nav>
        </Container>



        </>
    );
};

export default MainNavigation;