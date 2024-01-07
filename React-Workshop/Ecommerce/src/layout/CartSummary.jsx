import React from "react";
import { useSelector } from "react-redux";
import { NavLink } from "react-router-dom";

import {
  DropdownMenu,
  DropdownItem,
  Dropdown,
  DropdownDivider,
  Label,
  MenuItem,
  Icon,
  LabelDetail,
} from "semantic-ui-react";

function CartSummary() {
  const { cartItems } = useSelector((state) => state.cartReducer);

  return (
    <div className="mt-3">
      <Dropdown item text="Cart Details">
        <DropdownMenu>
          {cartItems.map((cartItem) => (
             <Label className="mt-7" key={cartItem.product.id}>
              <Icon name='cart' />
             {cartItem.product.title}
             <LabelDetail>{cartItem.quantity}</LabelDetail>
           </Label>
          ))}
          <DropdownDivider />
          <Dropdown.Item as={NavLink} to="/cart">
            Go to Cart
          </Dropdown.Item>
        </DropdownMenu>
      </Dropdown>
    </div>
  );
}

export default CartSummary;
