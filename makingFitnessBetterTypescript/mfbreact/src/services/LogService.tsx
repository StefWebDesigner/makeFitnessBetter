import Auth from "./Auth";
import axios from "axios";

class LogService {

    async getUser(username : string){
        return await axios.get("http://localhost:8080/user/getUser?username=" + username);
    }

    //About to add get all exericses
    // aysnc getAllExpercises(id : number, entryId )

}

export default LogService;