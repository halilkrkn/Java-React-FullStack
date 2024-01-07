import React from "react";
import { NavLink } from "react-router-dom";

import {
    DropdownMenu,
    DropdownItem,
    Dropdown,
    DropdownDivider,
  } from "semantic-ui-react";


function CartSummary() {
  return (
    <div className="mt-3">
      <Dropdown item text="Cart Details">
        <DropdownMenu>
          <DropdownItem>Acer Laptop</DropdownItem>
          <DropdownItem>Asus Laptop</DropdownItem>
          <DropdownItem>Dell Laptop</DropdownItem>
          <DropdownDivider/>
          <Dropdown.Item as={NavLink} to="/cart">Go to Cart</Dropdown.Item>
        </DropdownMenu>
      </Dropdown>
    </div>
  );
}

export default CartSummary;
