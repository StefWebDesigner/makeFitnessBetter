import React, {useState} from 'react';
import {Button, Form, FormControl, FormGroup, FormLabel} from "react-bootstrap";
import logService from "../../services/LogService";
import LogService from "../../services/LogService";

const EditExerciseModal = ({oldExerciseName, oldSet, oldRep, updateExerciseName, updateSet, updateRep, handleClose } : { oldExerciseName : any, oldSet : any, oldRep : any, updateExerciseName : any,  updateSet : any, updateRep : any, handleClose : any}) => {

    let logService = new LogService();

    console.log(oldExerciseName)

    console.log("submited Exercise Name " + oldExerciseName)
    console.log("submited Exercise set " + oldSet)
    console.log("submited Exercise rep " + oldRep)


    //Problem : its fetching everything instead of only the one I'm looking at
    // const[oldExeName, setOldExeName] = useState("");



    //This isn't going to work as it is not using the id which is throwing it off
    //Goo back and make sure its pickup the id, not like in the add exercise
    // @ts-ignore
    async function submitEditExerciseLog(e : any){
        e.preventDefault();



        // await logService.submitExerciseLog(oldExerciseName, oldSet, oldRep).then(response => {
        await logService.submitExerciseLog(oldExerciseName, oldSet, oldRep).then(response => {

            if(response.data){
                updateExerciseName(response.data.response.exerciseName);
                updateSet(response.data.response.sets);
                updateRep(response.data.response.reps);
                alert("Exercise was updated")

                console.log("submited Exercise Name " + oldExerciseName)
                console.log("submited Exercise set " + oldSet)
                console.log("submited Exercise rep " + oldRep)



                handleClose();




            }
        }).catch(err => {
            console.log("update failed")
        });

    }

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
                        onChange={e => updateExerciseName(e.target.value)}
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
                        onChange={e => updateSet(e.target.value)}
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
                        onChange={e => updateRep(e.target.value)}

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