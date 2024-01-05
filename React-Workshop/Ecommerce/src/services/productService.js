import axios from 'axios';

class ProductService {
    getProducts() {
        return axios.get('https://dummyjson.com/products')
    }
}
 
export default ProductService;