import React from 'react';
import Login from "../authenticationComponents/Login";
// @ts-ignore
import MainNavigation from "../navigationComponents/MainNavigation";
import {Button, Card, Container} from "react-bootstrap";
import {useNavigate} from "react-router-dom";

const HomepageComponent = () => {

    const navigate=useNavigate();


    function NavigateToRegistrationForm(){
        navigate("/registration");

    }


    return (
        <>
            <MainNavigation/>
            <Login/>


            <Container className = 'page-container'>

                {/* Warning label....Frontend Section is a work on progress. Backend read for binding content*/}
                <cite className="progress-warning"> *Frontend application is still undergoing progress. Backend ready for round one of binding endpoints *</cite>

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