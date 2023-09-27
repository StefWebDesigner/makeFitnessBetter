import React, {useState} from 'react';
import {Card, Form, FormControl, FormGroup} from "react-bootstrap";

// @ts-ignore
// const AddExerciseModal = ({onSubmit, exerciseName, setExerciseName, sets, setSets, reps, setReps, comments, setComments}) => {
const AddExerciseModal = () => {

    // @ts-ignore
    return (
        <>

            {/*<Form onSubmit = {onSubmit}>*/}
            <Form>
            <Card>
                    <Card.Header>
                        Add An Exercise
                    </Card.Header>
                    <Form >
                        <FormGroup>
                            <Form.Label>Exercise Name</Form.Label>
                            <FormControl
                                type = "text"
                                name = "exerciseName"
                                placeholder = "8"
                                // value={exerciseName}
                                // onChange = {(e) => (setExerciseName(e.target.value))}
                                required
                            />
                        </FormGroup>
                        <FormGroup>
                            <Form.Label>Sets</Form.Label>
                            <FormControl
                                type = "number"
                                name = "sets"
                                placeholder = "2"
                                // value={sets}
                                // onChange = {(e) => (setSets(e.target.value))}
                                required
                            />
                        </FormGroup>
                        <FormGroup>
                            <Form.Label>Reps</Form.Label>
                            <FormControl
                                type = "number"
                                name = "reps"
                                placeholder = "8"
                                // value = {reps}
                                // onChange = {(e) => (setReps(e.target.value))}
                                required
                            />
                        </FormGroup>
                        <FormGroup>
                            <Form.Label>Comments</Form.Label>
                            <FormControl
                                type = "text"
                                name = "comments"
                                placeholder = "optional"
                                // value = {comments}
                                // onChange = {(e) => (setComments(e.target.value))}
                            />
                        </FormGroup>
                    </Form>
                </Card>

            </Form>
            
        </>
    );
};

export default AddExerciseModal;