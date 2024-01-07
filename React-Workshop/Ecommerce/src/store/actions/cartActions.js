export const ADD_TO_CART = "ADD_TO_CART"
export const REMOVE_TO_CART = "REMOVE_TO_CART"


// payload, verileri oluşturduğumuz type'lara gönderdiğimiz yapı
// action, payloadları alıp örneğin ürünü ekleme,silme, güncelleme işlemlerini yapan yapıdır.
export function addToCart(product) {
    return {
        type: ADD_TO_CART,
        payload: product
    }
}


export function removeToCart(product) {
    return {
        type: REMOVE_TO_CART,
        payload: product
    }
}