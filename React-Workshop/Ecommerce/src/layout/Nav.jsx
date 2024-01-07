import React, { useState } from "react";
import CartSummary from "./CartSummary";
import { MenuMenu, MenuItem, Menu, Container, Grid } from "semantic-ui-react";
import SignOut from "./SignOut";
import SignIn from "./SignIn";
import { Link, NavLink, Outlet } from "react-router-dom";
import Categories from "./Categories";
import { useSelector } from "react-redux";

function Nav() {
  const [isAuthenticated, SetIsAuthenticated] = useState(true);
  const { cartItems } = useSelector((state) => state.cartReducer);

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
          <MenuItem as={NavLink} to="/" name="home" />
          <MenuItem name="messages" />
          <MenuMenu position="right">
            {cartItems.length>0 &&<CartSummary />}
            {isAuthenticated ? (
              <SignIn signOut={handleSignOut} />
            ) : (
              <SignOut signIn={handleSignIn} />
            )}
          </MenuMenu>
        </Container>
      </Menu>
      <div>
        <Container className="main">
          <Grid>
            <Grid.Row>
              <Grid.Column width={2}>
                <Categories />
              </Grid.Column>
            </Grid.Row>
            <Grid.Row>
              <Grid.Column width={14}>
                <Outlet />
              </Grid.Column>
            </Grid.Row>
          </Grid>
        </Container>
      </div>
    </div>
  );
}

export default Nav;
