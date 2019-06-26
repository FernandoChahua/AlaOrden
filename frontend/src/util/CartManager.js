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
        "idProducto": 1,
        "producto": {
            "idProducto": 1,
            "idCategoria": 2,
            "categoria": null,
            "idMarca": 1,
            "marca": {
                "nombre": "Gloria"
            },
            "nombre": "Leche Evaporada",
            "presentacion": "paquete",
            "cantidad": 4,
            "magnitud": 500,
            "unidad": "g",
            "descripcion": "Leche evaporada",
            "imagen": "2.jpg",
            "productoFranquicias": null
        },
        "cantidad": 10
    },
    {
        "idProducto": 2,
        "producto": {
            "idProducto": 2,
            "idCategoria": 3,
            "categoria": null,
            "idMarca": 1,
            "marca": {
                "nombre": "Laive"
            },
            "nombre": "Yogurt Fresa",
            "presentacion": "botella",
            "cantidad": 1,
            "magnitud": 1000,
            "unidad": "ml",
            "descripcion": "Yogurt de sabor fresa",
            "imagen": "3.jpg",
            "productoFranquicias": null
        },
        "cantidad": 30
    }
]; */