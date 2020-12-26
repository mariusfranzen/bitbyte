import React, { Component } from "react";
import UserApi from "../../api/UserApi";

export class AllUsers extends Component {
    constructor(props) {
        super(props);
        this.state = {
            users: [],
        };
    }

    componentDidMount() {
        UserApi.getAllUsers().then((res) => {
            this.setState({
                users: res.data,
            });
        });
    }

    render() {
        return (
            <table>
                <thead>
                    <tr>
                        <th>Id</th>
                        <th>Username</th>
                        <th>Email</th>
                        <th>Level</th>
                        <th>Permission</th>
                        <th>Banned</th>
                        <th>Date of Creation</th>
                    </tr>
                </thead>
                <tbody>
                    {this.state.users.map((user) => (
                        <tr key={user.id}>
                            <td>{user.id}</td>
                            <td>{user.username}</td>
                            <td>{user.email}</td>
                            <td>{user.level}</td>
                            <td>{user.permission}</td>
                            <td>{user.banned.toString()}</td>
                            <td>
                                {new Intl.DateTimeFormat("en-GB", {
                                    year: "numeric",
                                    month: "long",
                                    day: "2-digit",
                                }).format(Date.parse(user.dateOfCreation))}
                            </td>
                        </tr>
                    ))}
                </tbody>
            </table>
        );
    }
}

export default AllUsers;
