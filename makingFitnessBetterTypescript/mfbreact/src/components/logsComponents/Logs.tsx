import React, {useEffect, useState} from 'react';
import MainNavigation from "../navigationComponents/MainNavigation";
import axios from "axios";
import {Button, Card, CardGroup, Col, Container, Form, FormControl, FormGroup, FormLabel, Row} from "react-bootstrap";
import LogService from "../../services/LogService";
import CardHeader from "react-bootstrap/CardHeader";

const Logs = () => {

    const memberId = Number(localStorage.getItem("id"));

    let logService : LogService = new LogService();
    // const [allLogs, setAllLogs] = useState([]);
    const [allLogs, setAllLogs] = useState<any[]>([])
    const [exerciseLogMyList, setExerciseLogList] = useState<any[]>([])
    const [entryName, setEntryName] = useState("");
    const [entryComment, setEntryComment] = useState("");


    async function getAllRecords(memberId : number) {

        await  logService.getAllEntryRecords(memberId).then(response => {
            const myresult=response.data.response;
            // Used to join to list together -- could come in handy for a different senario
            const flattenedList = myresult.reduce((acc: string | any[], currentObject: {

                exerciseLogList: any; }) => {
                return acc.concat(currentObject.exerciseLogList);
            }, []);

            setExerciseLogList(flattenedList)
            setAllLogs(myresult);
        }).catch(err=>console.log(err));

        getAllRecords(memberId);

        //  const data = logService.getAllEntryRecords(memberId);
        //
        // const response = logService.getAllEntryRecords(memberId);
        //

    }




    async function submitEntryLog(e : any){
        e.preventDefault()
        await logService.createEntryLog(memberId, entryName, entryComment).then(response => {
            if(response.data){
                setEntryName(response.data.entryName);
                setEntryComment(response.data.overallComments);
            }
            console.log("Not entering")
        }).catch(err => console.log(err) );
        setEntryName("");
        setEntryComment("");
    }

    useEffect( () => {

        //async requires this and the callback of the records
        async function getAllMyRecords() {
            await getAllRecords(memberId);
        }
        getAllMyRecords()

    }, [])



    // async function getAllLogs(){
    //     let response = await axios.get('http://localhost:8080/exercise/allExercisesInLog?id=1&entryId=2');
    //     setLogs(response.data);
    // }

    return (
        <>
            <MainNavigation/>
            <h1 className="log-title">Logs</h1>

            {/* FORM FOR THE ENTRY FORM SECTION */}
            <Container>
                <Card className = "log-card">
                    <CardHeader className = "log-card-header" >Make an Entry</CardHeader>
                    <Form onSubmit={submitEntryLog}>
                        <FormGroup className="log-card-label-group">
                            <FormLabel className="log-card-label"> Entry name </FormLabel>
                            <FormControl
                                className="log-card-label"
                                type = "text"
                                name = "entryName"
                                placeholder = "Name"
                                onChange = {e => (setEntryName(e.target.value))}
                            />
                        </FormGroup>
                        <FormGroup>
                            <FormLabel className="log-card-label">
                                <p className="log-card-label">
                                    Comment
                                </p>
                            </FormLabel>
                            <FormControl
                                className="log-card-label"
                                type = "text"
                                name = "overallComments"
                                placeholder = "Optional"
                                onChange = {e => (setEntryComment(e.target.value))}
                            />
                        </FormGroup>
                        <Col></Col>
                        <div className="log-card-button-group">
                            <Button
                                className="log-entry-button"
                                type="submit"
                            >
                                Create New Entry
                            </Button>
                        </div>
                    </Form>
                </Card>

                {/* ENTRY FORMS */}

                {
                    allLogs.map(
                        mylog =>{
                            return (
                                <Card className="log-entry-exercise-card">
                                    <CardHeader className="log-entry-exercise-title">{mylog.entryName}</CardHeader>
                                    {
                                        mylog.exerciseLogList.map(
                                            (log:{exerciseName:any,sets:any,reps:any}) => {

                                                return <>  <CardGroup className = "log-entry-group">
                                                    <Row>
                                                        <Col xs={5}>

                                                            <p className="log-entry-label">Exercise Two</p>
                                                        </Col>
                                                        <Col xs={4}>
                                                            <p className="log-entry-data">  {log.exerciseName}</p>
                                                        </Col>
                                                        <Col>
                                                            <Button className="log-entry-button">Edit</Button>
                                                        </Col>
                                                    </Row>
                                                    <Row>
                                                        <Col xs={5}>
                                                            <p className="log-entry-set-label">Sets</p>
                                                        </Col>
                                                        <Col xs={4}>
                                                            <p className="log-entry-data">{log.sets}</p>
                                                        </Col>

                                                        <Col>
                                                            <Button className="log-entry-button">Edit</Button>
                                                        </Col>
                                                    </Row>
                                                    <Row>
                                                        <Col xs={5}>
                                                            <p className="log-entry-label">Reps</p>
                                                        </Col>
                                                        <Col xs={4}>
                                                            <p className="log-entry-data">{log.reps}</p>
                                                        </Col>
                                                        <Col>
                                                            <Button className="log-entry-button">Edit</Button>
                                                        </Col>
                                                    </Row>
                                                </CardGroup>

                                                    <span className="log-entry-divider"></span>
                                                </>
                                            }
                                        )
                                    }

                                    <span className="log-entry-divider"></span>

                                    <p className="log-entry-comment">OverAll Comments</p>

                                    <Button className="log-entry-button" >Add Another Exercise</Button>

                                </Card>
                            )
                        }
                    )

                }

            </Container>




        </>
    );
};

export default Logs;