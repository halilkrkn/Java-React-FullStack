import React from 'react'
import {Outlet} from "react-router-dom"
import Nav from './layout/Nav';
import { Container } from 'semantic-ui-react';


function Layout() {
  return (
    <div className="App">
    <Nav />
    <Container className="main">
    <Outlet/>
    </Container>
  </div>
  )
}

export default Layout