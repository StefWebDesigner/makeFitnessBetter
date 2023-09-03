import React, {useState} from 'react';
import MainNavigation from "../navigationComponents/MainNavigation";
import axios from "axios";

const Logs = () => {

    const [logs, setLogs] = useState([]);


    // async function getAllLogs(){
    //     let response = await axios.get('http://localhost:8080/exercise/allExercisesInLog?id=1&entryId=2');
    //     setLogs(response.data);
    // }

    return (
        <>
            <MainNavigation/>
            <h1>Logs</h1>


            <p>{logs}</p>


            
        </>
    );
};

export default Logs;