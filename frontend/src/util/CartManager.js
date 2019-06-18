export default class CartManager {
    constructor(userId){
        this.userId = userId;
        if (this._cart === "undefined"){
            this._cart = [];
        }
    }
    static getCart(){
        return this._cart;
    }
    static addToCart(producto, cantidad){
        let idProducto= producto.idProducto;
        let item = this._cart.find(x => x.idProducto === idProducto);
        if (typeof item === 'undefined') {
            this._cart.push({idProducto, producto, cantidad});
        }
        else {
            item.cantidad += cantidad;
        }
    }
    static removeFromCart(idProducto) {
        console.log((idProducto));
        let index = this._cart
        this._cart = this._cart.filter(x => x.producto.idProducto !== idProducto);
    }
    static updateCart(idProducto, cantidad) {
        let item = this._cart.find(x => x.idProducto === idProducto);
        item.cantidad = cantidad;
    }
}
CartManager._cart = [
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
];