import React from "react";
import { NavLink } from "react-router-dom";
import { Button } from "semantic-ui-react";

function SignOut(prop) {
  return (
    <div className="mt-3">
      <Button as={NavLink} to="/" onClick={prop.signIn} primary>
        Log In
      </Button>
      <Button as={NavLink} to="/register" color="orange">Register</Button>
    </div>
  );
}

export default SignOut;
