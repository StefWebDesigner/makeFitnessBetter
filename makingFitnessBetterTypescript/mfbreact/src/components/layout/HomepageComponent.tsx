import React from 'react';
import Login from "../authenticationComponents/Login";
import MainNavigation from "../navigationComponents/MainNavigation";
import {Card, Container} from "react-bootstrap";

const HomepageComponent = () => {
    return (
        <>
            <MainNavigation/>
            <Login/>


            <Container>
                <h1 className="home-title"> Making Fitness Better</h1>

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
            </Container>



        </>
    );
};

export default HomepageComponent;