import React, {useState} from 'react';
import MainNavigation from "../navigationComponents/MainNavigation";
import axios from "axios";
import {Button, Form, FormControl, FormGroup, FormLabel} from "react-bootstrap";

const Logs = () => {

    // const [logs, setLogs] = useState([]);


    // async function getAllLogs(){
    //     let response = await axios.get('http://localhost:8080/exercise/allExercisesInLog?id=1&entryId=2');
    //     setLogs(response.data);
    // }

    return (



        <>
            <MainNavigation/>
            <h1>Logs</h1>

            <Form>
                <FormGroup>
                    <FormLabel> Entry name </FormLabel>
                    <FormControl
                        type = "text"
                        name = "entryName"
                        placeholder = "Entry Log Name"
                    />
                </FormGroup>
                <FormGroup>
                    <FormLabel> Entry name </FormLabel>
                    <FormControl
                        type = "text"
                        name = "entryName"
                        placeholder = "Entry Log Name"
                    />
                </FormGroup>
                <Button
                    type="submit"
                >
                    Create New Entry
                </Button>
            </Form>


            



            {/*First --- GEt all Entries  and bind them*/}
            {/*Second --- Make the Post ford and bind*/}
            {/*third  --- */}



            {/*Potential Plan
                    1) use useEffect to get all the current entry of the user
                        ** This information will be used to make fetching information easier

                       --- AKA a gran submitEntryFlow
                   2) For Creation Flow
                        - have a form that will alow the user to create an entry
                        This form will have two options
                            A) blank


                    3) Modify Entry Flow
                        - Show all the current Entry and their Exervise logs
                        - Show  a button to modidy the entry options


                    4) Delete Entry Flow
                        - Delete the current Entry or delete the exerice log









            */}







            {/*<p>{logs}</p>*/}


            
        </>
    );
};

export default Logs;