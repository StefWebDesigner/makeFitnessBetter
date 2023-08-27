import React from 'react';
import Login from "../authenticationComponents/Login";
import MainNavigation from "../navigationComponents/MainNavigation";
import {Button, Card, Container} from "react-bootstrap";

const HomepageComponent = () => {
    return (
        <>
            <MainNavigation/>
            <Login/>


            <Container>

                {/* Warning label....Frontend Section is a work on progress. Backend read for binding content*/}
                <cite className="progress-warning"> *Frontend application is still undergoing progress. Backend ready for round one of binding endpoints *</cite>

                <h1 className="home-title"> Making Fitness Better</h1>

                <p className="home-description">
                    Designed to make tracking exerise logs faster, organized with easy search features, and back up capabilites
                </p>

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
                    <Button className="home-signup-button">
                        <h2 className="home-signin"> Sign up NOW!</h2>
                    </Button>
                </div>



            </Container>



        </>
    );
};

export default HomepageComponent;