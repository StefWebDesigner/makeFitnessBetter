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

}

export default LogService;