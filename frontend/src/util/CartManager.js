export default class CartManager {

    static addToCart(cart, productId, quantity){
        let item = cart.find(x => x.productId === productId);
        if (typeof item === 'undefined') {
            cart.push({productId, quantity});
        }
        else {
            item.quantity += quantity;
        }
        return cart;
    }
    static removeFromCart(cart, productId) {
        return cart.filter(x => x.productId !== productId);
    }

    static updateCart(cart, productId, quantity) {
        let item = cart.find(x => x.productId === productId);
        item.quantity = quantity;
    }
}
/*CartManager._cart = [
    {
        "idProduct": 1,
        "product": {
            "idProduct": 1,
            "idCategory": 2,
            "category": null,
            "idBrand": 1,
            "brand": {
                "name": "Gloria"
            },
            "name": "Leche Evaporada",
            "presentation": "paquete",
            "quantity": 4,
            "magnitude": 500,
            "unity": "g",
            "description": "Leche evaporada",
            "image": "2.jpg",
            "productoFranquicias": null
        },
        "quantity": 10
    },
    {
        "idProduct": 2,
        "product": {
            "idProduct": 2,
            "idCategory": 3,
            "category": null,
            "idBrand": 1,
            "brand": {
                "name": "Laive"
            },
            "name": "Yogurt Fresa",
            "presentation": "botella",
            "quantity": 1,
            "magnitude": 1000,
            "unity": "ml",
            "description": "Yogurt de sabor fresa",
            "image": "3.jpg",
            "productoFranquicias": null
        },
        "quantity": 30
    }
]; */