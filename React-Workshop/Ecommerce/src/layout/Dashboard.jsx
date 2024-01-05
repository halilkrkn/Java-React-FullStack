import React from "react";
import { Button, Icon, Label } from "semantic-ui-react";
import Nav from "./Nav";
import Categories from "./Categories";
import ProductList from "../pages/ProductList";
import { GridRow, GridColumn, Grid, Image } from "semantic-ui-react";
function Dashboard() {
  return (
    <div>
      <Grid>
        <Grid.Row>
          <Grid.Column width={4}>
            <Categories />
          </Grid.Column>
          <Grid.Column width={12}>
            <ProductList />
          </Grid.Column>
        </Grid.Row>
      </Grid>
    </div>
  );
}

export default Dashboard;
