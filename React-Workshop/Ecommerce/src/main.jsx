import React from "react";
import ReactDOM from "react-dom/client";
import App from "./App.jsx";
import "./index.css";
import "semantic-ui-css/semantic.min.css";
import {
  createBrowserRouter,
  createRoutesFromElements,
  Route,
  RouterProvider,
} from "react-router-dom";
import SignOut from "./layout/SignOut.jsx";
import SignIn from "./layout/SignIn.jsx";
import Dashboard from "./layout/Dashboard.jsx";
import MyInfo from "./layout/MyInfo.jsx";
import ProductList from "./pages/ProductList.jsx";
import Layout from "./Layout.jsx";
import Register from "./pages/Register.jsx";
import LogOut from "./pages/LogOut.jsx";
import Category from "./pages/Category.jsx";
import ProductDetail from "./pages/ProductDetail.jsx";
import CartDetail from "./pages/CartDetail.jsx";

const router = createBrowserRouter(
  createRoutesFromElements(
    <Route path="/" element={<Layout />}>
      <Route index element={<Dashboard />}/>
      <Route path="myInfo" element={<MyInfo />} />
      <Route path="signOut" element={<LogOut />} />
      <Route path="signIn" element={<SignIn />} />
      <Route path="register" element={<Register />} />
      <Route path="cart" element={<CartDetail/>}/>
      <Route path="/categories" element={<Category />} />
      <Route path="products">
        <Route index element={<ProductList />} />
        <Route path=":productId" element={<ProductDetail />} />
      </Route>
    </Route>
  )
);

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
    <RouterProvider router={router} />
  </React.StrictMode>
);
