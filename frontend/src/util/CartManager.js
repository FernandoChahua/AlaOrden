class CartManager {
    constructor(userId){
        this.userId = userId;
        if (this.cart === "undefined"){
            this.cart = [];
        }
    }
    static getCart(){
        return this.cart;
    }
    static addToCart(producto, cantidad){
        this.cart.push({});
    }
    static removeFromCart(idProducto) {
        this.cart = this.cart.filter(x => x.producto.idProducto === idProducto);
    }
    static updateCart(idProducto, cantidad) {
        let item = this.cart.find(x => x.idProducto === idProducto);
        item.cantidad = cantidad;
    }
}
CartManager.cart = [];