import React from "react";
import { Link, NavLink } from "react-router-dom";
import { Dropdown, Menu, Image } from "semantic-ui-react";

function SignIn({signOut}) {
  return (
    <div>
      <Menu.Item>
        <Image
          avatar
          spaced="right"
          src="https://avatars.githubusercontent.com/u/42476890?v=4"
        />
        <Dropdown pointing="top right" text="Halilkrkn">
          <Dropdown.Menu>
            <Dropdown.Item as={NavLink} to="/myInfo" text="My Info" icon="info">
            </Dropdown.Item>
            <Dropdown.Item as={NavLink} to="/signOut" onClick={signOut} text="Log Out" icon="sign-out" />
          </Dropdown.Menu>
        </Dropdown>
      </Menu.Item>
    </div>
  );
}

export default SignIn;
