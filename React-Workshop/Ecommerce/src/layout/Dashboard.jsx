import React from "react";
import { Button, Container, Icon, Label } from "semantic-ui-react";
import Nav from "./Nav";
import Categories from "./Categories";
import ProductList from "../pages/ProductList";
import { GridRow, GridColumn, Grid, Image } from "semantic-ui-react";
import { Link, Outlet } from "react-router-dom";
function Dashboard() {
  return (
   <div className="text-3xl bg-orange-400">Dashboard</div>
  );
}

export default Dashboard;
