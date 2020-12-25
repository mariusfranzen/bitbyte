import React, { Component } from 'react';
import axios from 'axios';

const UserUrl = "http://localhost:8080/api/users";

export class UserApi extends Component {
    getAllUsers() {
        return axios.get(`${UserUrl}/all`);
    }

    getUserById(id) {
        return axios.get(`${UserUrl}/id?id=${id}`);
    }
}

export default new UserApi();