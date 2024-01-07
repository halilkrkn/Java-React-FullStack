import { createSlice } from "@reduxjs/toolkit";
import { ADD_TO_CART, REMOVE_TO_CART } from "../actions/cartActions";
import { cartItems } from "../initialStates/cartItems";



// payload, verileri oluşturduğumuz type'lara gönderdiğimiz yapı
// action, payloadları alıp örneğin ürünü ekleme silme güncelleme işlemlerini yapan yapıdır.
// state, redux yapısında bulunan ve herhangi bir işlem yapılmadan önceki verileri tutan yapıdır.
// state, redux store'da verileri tuttuğumuz verilerdir.
// state, uygulamamızın genel state'lerini tutan yapıdır.
// reducer, actiondaki type'a göre state'i güncelleyen yapıdır.
// reducer, state'leri yönettiğimiz yapıdır.
// reducer, action'larımızı dinleyen ve state'leri güncelleyen yapıdır.
// reducer, global state'lerin yöneten yapıdır.
const initialState = {
  cartItems: cartItems,
};


// export const cartSlice = createSlice({
//     name: "carts",
//     initialState,
//     reducers: {
//         addToCart: (state, action) => {
//         let product = state.cartItems.find(
//             (c) => c.product.id === action.payload.id
//         );
//         if (product) {
//             product.quantity++;
//         } else {
//             state.cartItems.push({ quantity: 1, product: action.payload });
//         }
//         },
//         removeFromCart: (state, action) => {
//         state.cartItems = state.cartItems.filter(
//             (c) => c.product.id !== action.payload.id
//         );
//         },
//     },
//     });

// export const { addToCart, removeFromCart } = cartSlice.actions;
// export default cartSlice.reducer;

export default function cartReducer(
  state = initialState,
  action = { type, payload }
) {
  switch (action.type) {
    case ADD_TO_CART:
      let product = state.cartItems.find(
        (c) => c.product.id === action.payload.id
      );
      if (product) {
        product.quantity++;
        return {
          ...state,
        };
      } else {
        return {
          ...state,
          cartItems: [
            ...state.cartItems,
            { quantity: 1, product: action.payload },
          ],
        };
      }

    case REMOVE_TO_CART:
      // return state.filter((cartItem) => cartItem.id !== action.payload.id);
      return {
        ...state,
        cartItems: state.cartItems.filter(
          (c) => c.product.id !== action.payload.id
        ),
      };
    default:
      return state;
  }
}
