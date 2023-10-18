import React, {useState} from 'react';
import {Button, Form, FormControl, FormGroup, FormLabel} from "react-bootstrap";

const EditExerciseModal = ({oldExerciseName, oldSet, oldRep} : { oldExerciseName : any, oldSet : any, oldRep : any}) => {

    console.log(oldExerciseName)
    //Problem : its fetching everything instead of only the one I'm looking at
    // const[oldExeName, setOldExeName] = useState("");



    return (
        <>
            <Form>
                <FormGroup>
                    <FormLabel>
                        Exercise Name
                    </FormLabel>
                    <FormControl
                        type= "text"
                        name = "newExercise"
                        placeholder = {oldExerciseName}
                    />
                </FormGroup>
                <FormGroup>
                    <FormLabel>
                        Set
                    </FormLabel>
                    <FormControl
                        type= "number"
                        name = "newSet"
                        placeholder = {oldSet}
                    />
                </FormGroup>
                <FormGroup>
                    <FormLabel>
                        Reps
                    </FormLabel>
                    <FormControl
                        type= "number"
                        name = "newRep"
                        placeholder = {oldRep}
                    />
                </FormGroup>
                <div className="">
                    <Button
                        type= "submit"
                    >
                        Submit
                    </Button>
                </div>


            </Form>

        </>
    );
};

export default EditExerciseModal;