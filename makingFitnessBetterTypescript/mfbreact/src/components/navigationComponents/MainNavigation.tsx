import React from 'react';

import {Link} from "react-router-dom";
import {IoMdLogIn} from "react-icons/io";
import {FiLogOut} from "react-icons/fi";
import {MdAccountCircle} from "react-icons/md";
import {BsCartCheck} from "react-icons/bs";
import {ImHome} from "react-icons/im";
import {GrLogin} from "react-icons/gr";
import {LuLogOut} from "react-icons/lu";
import {GiHamburgerMenu} from "react-icons/gi";



import {MdOutlineAssignmentInd} from "react-icons/md";
import brandLogo from '../images/placeholder.png';


import Nav from 'react-bootstrap/Nav';
import Navbar from 'react-bootstrap/Navbar';
import NavDropdown from 'react-bootstrap/NavDropdown';
import { Container } from 'react-bootstrap';

// import brandLogo from './images/placeholder.png';








const MainNavigation = () => {
    // @ts-ignore
    return (
        <>
            <Navbar expand="lg" className="bg-body-tertiary">
                <Container>
                    <Navbar.Brand href="#home">
                        <img
                            alt=""
                            src={brandLogo}
                            width="30"
                            height="30"
                            className="d-inline-block align-top"
                        />
                        Make Fitness Better
                    </Navbar.Brand>
                    <Navbar.Toggle aria-controls="basic-navbar-nav" />
                    <Navbar.Collapse id="basic-navbar-nav">
                        {/*<Nav className="me-auto">*/}
                        <Nav className="me-auto">


                        <Link to="/" className="main-nav-link">
                            <ImHome
                                size={35}
                                color="blue"
                            />
                        </Link>
                        <Link
                            to="/register"
                            className="main-nav-link"
                        >
                            <MdOutlineAssignmentInd size = {35} color="blue"
                            />
                        </Link>
                                <Link
                                    to="/login"
                                    className="main-nav-link"
                                >
                                    <GrLogin size={35} color="red"/>
                                </Link>

                                {/*To be added after optomiozing the menu*/}
                                {/*<Link*/}
                                {/*    className=""*/}
                                {/*    to="/"*/}
                                {/*>*/}
                                {/*    <LuLogOut size={35}/>*/}
                                {/*</Link>*/}

                            {/*<Nav.Link href="#home">Home</Nav.Link>*/}
                            {/*<Nav.Link href="#link">Link</Nav.Link>*/}
                            {/*<NavDropdown title="Dropdown" id="basic-nav-dropdown">*/}
                            {/*    <NavDropdown.Item href="#action/3.1">Action</NavDropdown.Item>*/}
                            {/*    <NavDropdown.Item href="#action/3.2">*/}
                            {/*        Another action*/}
                            {/*    </NavDropdown.Item>*/}
                            {/*    <NavDropdown.Item href="#action/3.3">Something</NavDropdown.Item>*/}
                            {/*    <NavDropdown.Divider />*/}
                            {/*    <NavDropdown.Item href="#action/3.4">*/}
                            {/*        Separated link*/}
                            {/*    </NavDropdown.Item>*/}
                            {/*</NavDropdown>*/}
                        </Nav>
                    </Navbar.Collapse>
                </Container>
            </Navbar>







        {/*<Container>*/}
        {/*                <Nav className="main-nav-container">*/}
        {/*                    /!*Container for the brand related content*!/*/}
        {/*                    <div className="main-nav-brand-container">*/}
        {/*                        <img src = {brandLogo} className = "brand-logo"/>*/}
        {/*                        <h1> Brand</h1>*/}
        {/*                    </div>*/}

        {/*                    /!*Container for the links that will change throughout the application*!/*/}

        {/*                    <div>*/}


        {/*                        <Button*/}
        {/*                        >*/}
        {/*                            <GiHamburgerMenu className="main-nav-sandwich-icon" size={35} />*/}
        {/*                        </Button>*/}

        {/*                        <div className="main-nav-link-container">*/}
        {/*                            <Link to="/">*/}
        {/*                                <ImHome*/}
        {/*                                    size={35}*/}
        {/*                                />*/}
        {/*                            </Link>*/}
        {/*                            <Link*/}
        {/*                                className=""*/}
        {/*                                to="/register"*/}
        {/*                            >*/}
        {/*                                <MdOutlineAssignmentInd size = {35}/>*/}
        {/*                            </Link>*/}
        {/*                            <Link*/}
        {/*                                className=""*/}
        {/*                                to="/login"*/}
        {/*                            >*/}
        {/*                                <GrLogin*/}
        {/*                                    size={35}*/}
        {/*                                />*/}
        {/*                            </Link>*/}

        {/*                            /!*To be added after optomiozing the menu*!/*/}
        {/*                            /!*<Link*!/*/}
        {/*                            /!*    className=""*!/*/}
        {/*                            /!*    to="/"*!/*/}
        {/*                            /!*>*!/*/}
        {/*                            /!*    <LuLogOut size={35}/>*!/*/}
        {/*                            /!*</Link>*!/*/}
        {/*                        </div>*/}
        {/*                    </div>*/}



        {/*                </Nav>*/}
        {/*</Container>*/}





        </>
    );
};

export default MainNavigation;