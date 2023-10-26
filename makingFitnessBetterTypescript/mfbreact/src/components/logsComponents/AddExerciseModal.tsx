import React, {useState} from 'react';
import {Button, Card, Form, FormControl, FormGroup} from "react-bootstrap";
import logService from "../../services/LogService";
import LogService from "../../services/LogService";

// @ts-ignore
// const AddExerciseModal = ({onSubmit, exerciseName, setExerciseName, sets, setSets, reps, setReps, comments, setComments}) => {
// const AddExerciseModal = () => {
const AddExerciseModal = ({entryId, memberId, exerciseName, setExerciseName, sets, setSets, reps, setReps, comments, setComments, handleClose}) => {

    let logService = new LogService();
    let fetchedMemberId = memberId;
    let fetchedEntryId = entryId;

    console.log("Entry Id Outside  : " + fetchedMemberId)
    console.log("Memeber Id  : " + fetchedEntryId);

    async function submitExercise(e : any){
        e.preventDefault();

        await logService.createNewExercise(fetchedEntryId, fetchedMemberId, exerciseName, sets, reps, comments).then(response => {

            let entryIdFetched =

            console.log("Inside the function  : " + entryId)
            console.log("Inside the function : " + entryId);

            if(response.data){
                setExerciseName(response.data.response.exerciseName);
                setSets(response.data.response.sets);
                setReps(response.data.response.reps);
                setComments(response.data.response.comments);
                alert("Exercise was successfully submitted");
                handleClose();
                // getAllMyRecords(memberId);
            }
        }).catch(err=> {
            console.log("Failed")
        })
    }

    // @ts-ignore
    return (
        <>

            {/*<Form onSubmit = {*/}
            {/*    submitExercise}>*/}
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
                                onChange = {(e) => (setExerciseName(e.target.value))}
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
                                onChange = {(e) => (setSets(e.target.value))}
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
                                onChange = {(e) => (setReps(e.target.value))}
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
                                onChange = {(e) => (setComments(e.target.value))}
                            />
                        </FormGroup>
                        <div>
                            <Button
                                type = "submit"
                                onClick={submitExercise}
                            >
                               Submit Exercise
                            </Button>
                        </div>
                    </Form>
                </Card>

            </Form>
            
        </>
    );
};

export default AddExerciseModal;