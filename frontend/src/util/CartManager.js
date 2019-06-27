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
        "productId": 1,
        "producto": {
            "productId": 1,
            "categoryId": 2,
            "category": null,
            "brandId": 1,
            "brand": {
                "name": "Gloria"
            },
            "name": "Leche Evaporada",
            "packaging": "paquete",
            "packageUnit": 4,
            "measure": 500,
            "unit": "g",
            "description": "Leche evaporada",
            "image": "2.jpg",
            "inventory": null
        },
        "packageUnit": 10
    },
    {
        "productId": 2,
        "producto": {
            "productId": 2,
            "categoryId": 3,
            "category": null,
            "brandId": 1,
            "brand": {
                "name": "Laive"
            },
            "name": "Yogurt Fresa",
            "packaging": "botella",
            "packageUnit": 1,
            "measure": 1000,
            "unit": "ml",
            "description": "Yogurt de sabor fresa",
            "image": "3.jpg",
            "inventory": null
        },
        "packageUnit": 30
    }
]; */