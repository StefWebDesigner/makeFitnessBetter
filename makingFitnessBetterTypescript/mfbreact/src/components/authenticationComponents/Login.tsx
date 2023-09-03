import React, {useContext, useState} from 'react';
import axios from "axios";
import {useNavigate} from "react-router-dom";
import Auth from "../../services/Auth";
import {AuthContext} from "../../dataStore";
import { Form, Button, FormGroup, FormLabel, FormControl, FormCheck } from 'react-bootstrap';
// import {Button, FormCheck, FormControl, FormGroup, FormLabel} from "react-bootstrap";

const Login = () => {

    let auth : Auth = new Auth();
    const authContext = useContext(AuthContext);

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    // const [remember, setRemember] = useState(false);
    const [error,setError]=useState(false);
    const [message,setMessage]=useState("")
    const navigate=useNavigate();

    function loginUser(e:any){
        e.preventDefault();
        auth.login(username,password).then((response)=>{
            console.log(response.data);

            if(response.data.token){
                localStorage.setItem("token",response.data.token);
                console.log(localStorage.getItem("token"));

                // localStorage.setItem("id",response.data.id);
                // console.log(response.data.id);

                localStorage.setItem("email", response.data.email);

                localStorage.setItem("role",response.data.role);
                console.log(localStorage.getItem("role"));

                authContext.setToken(response.data.token);
            }

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
        {/* **************************** Best of making forms*/}
        {/*<Form inline>*/}
        {/*    <Row>*/}
        {/*        <Col xs="auto">*/}
        {/*            <Form.Control*/}
        {/*                type="text"*/}
        {/*                placeholder="Search"*/}
        {/*                className=" mr-sm-2"*/}
        {/*            />*/}
        {/*        </Col>*/}
        {/*        <Col xs="auto">*/}
        {/*            <Button type="submit">Submit</Button>*/}
        {/*        </Col>*/}
        {/*    </Row>*/}
        {/*</Form>*/}
        {/*</Navbar>*/}

            <Form className="login-form-container" onSubmit={loginUser}>
                <div className="login-form-background">
                    <FormGroup>
                        <FormLabel className="login-form-label"> Username</FormLabel>
                        <FormControl
                            type="text"
                            name="username"
                            placeholder="username"
                            onChange={(e) => (setUsername(e.target.value))}
                        />
                    </FormGroup>
                    <FormGroup>
                        <FormLabel className="login-form-label">Password</FormLabel>
                        <FormControl
                            type="password"
                            name="password"
                            placeholder="password"
                            onChange={(e) => (setPassword(e.target.value))}
                        />
                    </FormGroup>

                    {/*<FormCheck*/}
                    {/*    className="login-form-label"*/}
                    {/*    type="checkbox"*/}
                    {/*    label="rememberme"*/}
                    {/*    defaultChecked={false}*/}
                    {/*    onChange={(e) => setRemember(!remember)}*/}
                    {/*/>*/}

                    <div className="login-form-button-group">
                        <Button
                            className="login-form-button"
                            type="submit"
                        >
                            Enter
                        </Button>
                    </div>


                    <div>
                        {error && (<>{message}</>)}
                    </div>

                </div>


            </Form>
            
        </>
    );
};

export default Login;