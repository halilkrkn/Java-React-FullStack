import { createStore } from "@reduxjs/toolkit";
import rootReducer from "./rootReducer";

export function configureStore() {
    return createStore(rootReducer)
}