import React from 'react'
import { Navbar, Nav } from 'react-bootstrap'
import "./NavBarStyle.css"
import Logotipo from '../images/logo-5marias.png'
import NavId from './texts.json'
import Login from '../Login'

function NavBarComponent() {
    return (
        <Navbar className="NavBar" bg="light" expand="lg" sticky="top"  >
            <Nav.Link href="#Home"><img src={Logotipo} alt="Logo tipo das 5 Marias" width="200px"></img></Nav.Link>
            <Navbar.Toggle aria-controls="basic-navbar-nav " />
            <Navbar.Collapse id="basic-navbar-nav">
                <Nav className="mr-auto mx-auto nb-cont">
                    <Nav.Link href="#Contato">{NavId.id.contact}</Nav.Link >
                    <Nav.Link href="#Beneficios" >{NavId.id.benefits}</Nav.Link>
                    <Nav.Link href="#Depoimentos">{NavId.id.depositions}</Nav.Link>
                    <Nav.Link href="#Duvidas">{NavId.id.duvidas}</Nav.Link>
                    <Nav.Link href="#Orcamento">{NavId.id.budget}</Nav.Link>
                </Nav>
                <Login />
            </Navbar.Collapse>
            
        </Navbar>
    )
}
export default NavBarComponent
