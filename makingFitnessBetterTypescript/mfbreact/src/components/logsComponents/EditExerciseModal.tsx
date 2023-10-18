import React, {useState} from 'react';
import {Button, Form, FormControl, FormGroup, FormLabel} from "react-bootstrap";

const EditExerciseModal = ({newExerciseName, newSetExerciseName} : { newExerciseName : any, newSetExerciseName : any}) => {

    console.log(newExerciseName)
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
                        placeholder = {newExerciseName}
                    />
                </FormGroup>
                <FormGroup>
                    <FormLabel>
                        Set
                    </FormLabel>
                    <FormControl
                        type= "number"
                        name = "newSet"
                        placeholder = 'Going to pick up the older state'
                    />
                </FormGroup>
                <FormGroup>
                    <FormLabel>
                        Reps
                    </FormLabel>
                    <FormControl
                        type= "number"
                        name = "newRep"
                        placeholder = 'Going to pick up the older state'
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