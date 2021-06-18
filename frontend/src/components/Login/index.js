import React from 'react'
import { Nav } from 'react-bootstrap'
import { Link } from 'react-router-dom'
import IconUser from '../images/icon_person.png'

function Login() {
    return (
       <>
        <Link to="/login"><img alt="userIcone" className="imgIcons" src={IconUser}></img>Login</Link>
       </>
    )
}
export default Login