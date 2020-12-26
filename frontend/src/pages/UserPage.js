import React, { Component } from "react";
import AddUser from "../components/UserPageComponents/AddUser";
import AllUsers from "../components/UserPageComponents/AllUsers";

export class UserPage extends Component {
    render() {
        return (
            <div className="row">
                <div className="grid-1-2 left">
                    <h1>Add user:</h1>
                    <AddUser />
                </div>
                <div className="grid-1-2 right">
                    <h1>All users:</h1>
                    <AllUsers />
                </div>
            </div>
        );
    }
}

export default UserPage;
