import axios from 'axios';

class ProductService {
    getProducts() {
        return axios.get('https://dummyjson.com/products')
    }

    getByProductId(id) {
        return axios.get(`https://dummyjson.com/products/${id}`)
    }
}
 
export default ProductService;