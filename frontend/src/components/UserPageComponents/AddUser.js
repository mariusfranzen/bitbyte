import React, { Component } from 'react';
import UserApi from "../../api/UserApi";

export class AddUser extends Component {
    constructor(props) {
        super(props);

        this.state = {
            newUser: {
                username: "",
                email: "",
                password: ""
            }
        }
    }

    usernameChanged(event) {
        let user = this.state.newUser;
        user.username = event.target.value;

        this.setState({newUser: user})
    }

    emailChanged(event) {
        let user = this.state.newUser;
        user.email = event.target.value;

        this.setState({newUser: user})
    }

    passwordChanged(event) {
        let user = this.state.newUser;
        user.password = event.target.value;

        this.setState({newUser: user})
    }

    submitUser(event) {
        event.preventDefault();
        UserApi.postUser(this.state.newUser).then((res) => {
            console.log(res.data.error);
        })
    }

    render() {
        return (
            <form onSubmit={this.submitUser.bind(this)}>
                <label className="formLabel">Username:</label>
                <input type="text" value={this.state.newUser.username} onChange={this.usernameChanged.bind(this)} />
                <label className="formLabel">Email:</label>
                <input type="email" value={this.state.newUser.email} onChange={this.emailChanged.bind(this)} />
                <label className="formLabel">Password:</label>
                <input type="password" value={this.state.newUser.password} onChange={this.passwordChanged.bind(this)} />
                <input type="submit" value="Submit" />
            </form>
        )
    }
}

export default AddUser
