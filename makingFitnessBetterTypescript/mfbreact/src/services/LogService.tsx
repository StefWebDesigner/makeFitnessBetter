import Auth from "./Auth";
import axios from "axios";



class LogService {



    async getUser(username : string){
        return await axios.get("http://localhost:8080/user/getUser?username=" + username);
    }

    async getAllEntryRecords(id : number){
        return await axios.get("http://localhost:8080/entry/fetchAllExercises?id=" + id);
    }

    //About to add get all exericses
    // aysnc getAllExpercises(id : number, entryId )

    async createEntryLog(id : number, entryName : string, overallComments : string){
        return await axios.post("http://localhost:8080/entry/create?id=" + id,
            {
                entryName, overallComments
            });
    }

    async createNewExercise(entryId : number, memberId : number, exerciseName : string, sets : number, reps : number, comments : string ){
        console.log("Entry Id : " + memberId)
        return await axios.post("http://localhost:8080/exercise/create?entryId=" + entryId + "&id=" + memberId,
        {
                exerciseName, sets, reps, comments
            });
        console.log("Entry Id : " + memberId)

    }

    // async submitExerciseLog(oldExerciseName : any, oldSet : any, oldRep: any){
    //
    //     return await axios.put("http://localhost:8080/exercise/submitExerciseSet",
    //         {
    //             oldExerciseName, oldSet, oldRep
    //         });
    // }

    // static submitExerciseLog(oldExerciseName: any, oldSet: any, oldRep: any) {
    //
    // }
    async submitExerciseLog(oldExerciseName: any, oldSet: any, oldRep: any ) {
        return await axios.put("http://localhost:8080/exercise/submitExerciseSet",
            {
                oldExerciseName, oldSet, oldRep
            });
    }
}

export default LogService;