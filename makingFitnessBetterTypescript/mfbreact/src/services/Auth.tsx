import axios from "axios";
import {useContext} from "react";

class Auth {

    async login(username : string, password : string){
        return await axios.post("http://localhost:8080/login",
            {
                username,
                password
            });
    }

    logout():void{
        localStorage.removeItem("token");
        localStorage.removeItem("id");
        localStorage.removeItem("role");
        localStorage.removeItem("remember-me");
    }

    isLoggedIn():boolean{
        return localStorage.getItem("token")!=undefined;
    }

}

export default Auth;