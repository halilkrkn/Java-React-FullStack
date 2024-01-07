import { combineReducers } from "@reduxjs/toolkit";
import cartReducer from "./reducers/cartReducer";

const rootReducer = combineReducers({
  cartReducer: cartReducer,
});

export default rootReducer;

