import React from 'react';
import Login from "../authenticationComponents/Login";
import MainNavigation from "../navigationComponents/MainNavigation";

const HomepageComponent = () => {
    return (
        <>
            <MainNavigation/>
            <Login/>

            <h1>Homepage</h1>


        </>
    );
};

export default HomepageComponent;