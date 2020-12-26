import React, { Component } from 'react'

export class Navbar extends Component {
    render() {
        return (
            <nav>
                <ul>
                    <li><a href="/">Home</a></li>
                    <li><a href="/users">Users</a></li>
                    <li><a href="/blog">Blog</a></li>
                </ul>
            </nav>
        )
    }
}

export default Navbar
