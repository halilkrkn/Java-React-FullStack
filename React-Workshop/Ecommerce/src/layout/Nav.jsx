import React, { useState } from "react";
import CartSummary from "./CartSummary";
import { MenuMenu, MenuItem, Menu, Container } from "semantic-ui-react";
import SignOut from "./SignOut";
import SignIn from "./SignIn";
import { Link, NavLink } from "react-router-dom";

function Nav() {
  const [isAuthenticated, SetIsAuthenticated] = useState(true);


  const handleSignOut = () => {
    SetIsAuthenticated(false);
  };

  const handleSignIn = () => {
    SetIsAuthenticated(true);
  };

  return (
    <div className="mTop">
      <Menu inverted fixed="top">
        <Container>
          <MenuItem as={NavLink} to="/" name="home"/>
          <MenuItem name="messages" />
          <MenuMenu position="right">
            <CartSummary />
            {isAuthenticated ? (
              <SignIn signOut={handleSignOut} />
            ) : (
              <SignOut signIn={handleSignIn} />
            )}
          </MenuMenu>
        </Container>
      </Menu>
    </div>
  );
}

export default Nav;
