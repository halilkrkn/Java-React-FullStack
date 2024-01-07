import React from "react";
import ProductList from "../pages/ProductList";
import { Route, Routes } from "react-router-dom";
import Category from "../pages/Category";
import Layout from "../Layout";
import ProductDetail from "../pages/ProductDetail";

function Root() {
  return (
    <Routes>
      <Route path="/" element={<ProductList />} />
      <Route path="/products">
        <Route index element={<ProductList />} />
        <Route path=":productId" element={<ProductDetail />} />
      </Route>
    </Routes>
  );
}

export default Root;
