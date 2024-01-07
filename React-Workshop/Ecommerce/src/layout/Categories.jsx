import React from "react";
import { Link, NavLink, Outlet } from "react-router-dom";
import { MenuItem, Menu } from 'semantic-ui-react'
function Categories() {
  return (
    <div>
      <Menu inverted pointing vertical>
        <MenuItem
          as={Link}
          to ="/"
          name="Home"
        />
        <MenuItem
          as={Link}
          to={"categories"}
          name="Categories"
        />
        <MenuItem
          as={Link}
          to = "products"
          name="Products"
        />
      </Menu>
    </div>
  );
}

export default Categories;
