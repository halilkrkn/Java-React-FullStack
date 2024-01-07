import React from "react";
import { Outlet } from "react-router-dom";
import Nav from "./layout/Nav";
import { Container } from "semantic-ui-react";
import { ToastContainer } from "react-toastify";

function Layout() {
  return (
    <div className="App">
      <Container className="main">
        <ToastContainer position="bottom-right"/>
        <Nav />
      </Container>
    </div>
  );
}

export default Layout;
