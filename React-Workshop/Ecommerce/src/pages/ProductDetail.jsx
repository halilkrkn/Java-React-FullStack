import React, { useEffect, useState } from "react";
import { useParams } from "react-router-dom";
import {
  CardMeta,
  CardHeader,
  CardGroup,
  CardDescription,
  CardContent,
  Button,
  Card,
  Image,
} from "semantic-ui-react";
import ProductService from "../services/productService";

function ProductDetail() {
  const [product, setProduct] = useState({});
  const { productId } = useParams();

  useEffect(() => {
    let productService = new ProductService();
    productService
      .getByProductId(productId)
      .then((result) => setProduct(result.data));
  }, []);

  return (
    <div>
      <CardGroup>
        <Card fluid>
          <CardContent>
            <Image
              floated="right"
              size="large"
              src= {product.thumbnail}
            />
            <CardHeader>{product.title}</CardHeader>
            <CardMeta>{product.description}</CardMeta>
            <CardMeta className="text-3xl">{product.price}</CardMeta>
            <CardMeta>{product.stock}</CardMeta>

            <CardDescription>
              Steve wants to add you to the group <strong>best friends</strong>
            </CardDescription>
          </CardContent>
          <CardContent extra>
            <div className="ui two buttons">
              <Button basic color="green">
                Approve
              </Button>
              <Button basic color="red">
                Decline
              </Button>
            </div>
          </CardContent>
        </Card>
      </CardGroup>
    </div>
  );
}

export default ProductDetail;
