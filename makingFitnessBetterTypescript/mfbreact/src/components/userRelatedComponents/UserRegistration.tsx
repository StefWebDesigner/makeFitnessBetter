import React, {useState} from 'react';
import {Button, Form, FormControl, FormGroup, FormLabel} from "react-bootstrap";
import UserService from "../../services/UserService";

const UserRegistration = () => {
    let userService : UserService = new UserService();


    // interface FormData {
    //     username: string;
    //     password: string;
    //     email : string;
    //     role : string;
    //
    // }
    //
    // const [formRegstration, setFormRegstration] = React.useState<FormData>(
    //     {
    //         username : "",
    //         password : "",
    //         email : "",
    //         role : ""
    //     }
    //
    // );

    const [username, setUsername] = useState("");
    const [password, setPassword] = useState("");
    const [email, setEmail] = useState("");
    const [role, setRole] = useState("");


    function registerUserForm(e : any){
        e.preventDefault()
        userService.registerUser(username, password, email, role).then(response=> {
            if(response.data){
                setUsername(response.data.username);
                setPassword(response.data.package)
                setEmail(response.data.email);
                setRole(response.data.role);
                console.log("Regiration was successful")
            } else {
                console.log("not sucessful")
            }
        });

    }






    return (
        <>
            <h1>Let's Register For An Account</h1>

            <p>Form content to be added</p>

            <Form onSubmit = {registerUserForm}>
                <FormGroup>
                    <FormLabel>Username</FormLabel>
                    <FormControl
                        type="text"
                        name="username"
                        placeholder="username"
                        onChange={(e) => (setUsername(e.target.value))}
                    />
                </FormGroup>
                <FormGroup>
                    <FormLabel> Password</FormLabel>
                    <FormControl
                        type="text"
                        name="password"
                        placeholder="password"
                        onChange={e => (setPassword(e.target.value))}
                    />
                </FormGroup>
                <FormGroup>
                    <FormLabel> Email</FormLabel>
                    <FormControl
                        type="text"
                        name="email"
                        placeholder="Email"
                        onChange={e => (setEmail(e.target.value))}
                    />
                </FormGroup>
                <FormGroup>
                    <FormLabel>role</FormLabel>
                    <FormControl
                        type="text"
                        name="role"
                        placeholder="Role"
                        onChange={e => (setRole(e.target.value))}
                    />
                </FormGroup>
                <Button
                    type="submit"
                >
                    Enter
                </Button>



            </Form>



        </>
    );
};

export default UserRegistration;