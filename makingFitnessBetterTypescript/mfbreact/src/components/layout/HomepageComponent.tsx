import React, {useState} from 'react';
import Login from "../authenticationComponents/Login";

// @ts-ignore
import MainNavigation from "../navigationComponents/MainNavigation";
import {Button, Card, Container, Form, Modal} from "react-bootstrap";
import {useNavigate} from "react-router-dom";
import LoginModal from "../authenticationComponents/LoginModal";
import styles from "./Modal.module.css";


const HomepageComponent = () => {

    const navigate=useNavigate();


    function NavigateToRegistrationForm(){
        navigate("/registration");

    }

    const [show, setShow] = useState(false);


    const handleClose = () => setShow(false);

    const handleShow = () => setShow(true);


    const onLoginFormSubmit = (e : any) => {

        e.preventDefault();

        handleClose();

    };



    // @ts-ignore
    return (
        <>

            <MainNavigation/>
            <Login/>
            <div

                // className="d-flex align-items-center justify-content-center"
                //
                // style={{ height: "100vh" }}

            >

                <Button variant="primary" onClick={handleShow}>

                    Launch Form modal

                </Button>

            </div>

            <Modal show={show} onHide={handleClose}>

                <Modal.Header closeButton>

                    <Modal.Title>Login Form</Modal.Title>

                </Modal.Header>

                <Modal.Body>

                    <LoginModal onSubmit={onLoginFormSubmit} />

                </Modal.Body>

                <Modal.Footer>

                    <Button variant="secondary" onClick={handleClose}>

                        Close Modal

                    </Button>

                </Modal.Footer>

            </Modal>



            <Container className = 'page-container'>

                {/* Warning label....Frontend Section is a work on progress. Backend read for binding content*/}
                <cite className="progress-warning"> *Frontend application is still undergoing progress. Backend ready for round one of binding endpoints *</cite>

                <p>Test Login Modal</p>








                <h1 className="home-title"> Making Fitness Better</h1>

                <div className="home-description-group">
                    <h3 className="home-description-first">
                        Redefine
                    </h3>
                    <p className="home-description">
                        Fitness
                    </p>
                </div>
                <div className="home-description-group">
                    <h3 className="home-description-first">
                        Redefine
                    </h3>
                    <p className="home-description">
                        Tracking
                    </p>
                </div>
                <div className="home-description-group">
                    <h3 className="home-description-first">
                        Redefine
                    </h3>
                    <p className="home-description">
                        Your Time
                    </p>
                </div>

                <Card className = "home-card">
                    <Card.Body>
                        <blockquote className="blockquote mb-0">
                            <p>
                                Motivation Quote that will generate from backend
                            </p>
                            <footer className="blockquote-footer">
                                Someone famous in <cite title="Source Title">Writer Name here</cite>
                            </footer>
                        </blockquote>
                    </Card.Body>
                </Card>


                <div className="home-signup-button-container">
                    <Button
                        className="home-signup-button"
                        onClick={NavigateToRegistrationForm}
                    >
                        <h2 className="home-signin"> Sign up NOW!</h2>
                    </Button>
                </div>



            </Container>


            </>
    );
};

export default HomepageComponent;