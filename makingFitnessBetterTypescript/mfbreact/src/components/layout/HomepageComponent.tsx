import React, {useContext, useState} from 'react';
import Login from "../authenticationComponents/Login";

// @ts-ignore
import MainNavigation from "../navigationComponents/MainNavigation";
import {Button, Card, Container, Form, Modal} from "react-bootstrap";
import {useNavigate} from "react-router-dom";
import LoginModal from "../authenticationComponents/LoginModal";
import styles from "./Modal.module.css";
import Auth from "../../services/Auth";
import {AuthContext} from "../../dataStore";


const HomepageComponent = () => {

    const navigate=useNavigate();

    let auth : Auth = new Auth();
    const authContext = useContext(AuthContext);


    function NavigateToRegistrationForm(){
        navigate("/registration");

    }

    const [show, setShow] = useState(false);

    const handleClose = () => setShow(false);
    const handleShow = () => setShow(true);

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    // const [remember, setRemember] = useState(false);
    const [error,setError]=useState(false);
    const [message,setMessage]=useState("")


    function loginUser(e:any){
        e.preventDefault();
        auth.login(username,password).then((response)=>{
            console.log(response.data);

            if(response.data.token){
                localStorage.setItem("token",response.data.token);
                localStorage.setItem("email", response.data.email);
                localStorage.setItem("role",response.data.role);
                authContext.setToken(response.data.token);
            }

            const currentUser = auth.getUser(username).then((response) => {
                if(response.data){
                    localStorage.setItem("id",response.data.memberId);
                    localStorage.setItem("username",response.data.username);
                }
            });

            navigate("/");

        }).catch(err=>{
            setMessage(err.response.data.exception);
            setError(true)
        });
        // localStorage.setItem("remember-me",String(remember));
    }



    // @ts-ignore
    return (
        <>

            <MainNavigation/>
            {/*<Login onSubmit={undefined}/>*/}
            <div>
                <Button variant="primary" onClick={handleShow}>
                    Launch Form modal
                </Button>
            </div>

            <Modal show={show} onHide={handleClose}>
                <Modal.Header closeButton>
                    <Modal.Title>Login Form</Modal.Title>
                </Modal.Header>
                <Modal.Body>
                    <Login onSubmit={loginUser} username={username} setUsername={setUsername} password={password}
                           setPassword={setPassword} />

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