import React from "react";
import { MenuItem, Menu } from 'semantic-ui-react'
function Categories() {
  return (
    <div>
      <Menu inverted pointing vertical>
        <MenuItem
          name="home"
        />
        <MenuItem
          name="messages"
        />
        <MenuItem
          name="friends"
        />
      </Menu>
    </div>
  );
}

export default Categories;
