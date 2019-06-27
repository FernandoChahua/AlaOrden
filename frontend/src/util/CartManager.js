export default class CartManager {

  static addToCart(cart, product, quantity) {
    if (!cart.isEmpty) {
      let item = cart.find(x => x.idProduct === product.idProduct);
      if (typeof item === 'undefined') {
        cart.push({idProduct: product.idProduct, product, quantity});
      } else {
        item.quantity += quantity;
      }
    }
    else{
      cart.push({idProduct: product.idProduct, product, quantity});
    }
    return [...cart];
  }

  static removeFromCart(cart, idProduct) {
    return cart.filter(x => x.idProduct !== idProduct);
  }

  static updateCart(cart, idProduct, quantity) {
    let item = cart.find(x => x.idProduct === idProduct);
    item.quantity = quantity;
    return JSON.parse(JSON.stringify(cart));
  }
}
/*CartManager._cart = [
    {
        "idProduct": 1,
        "producto": {
            "idProduct": 1,
            "idCategory": 2,
            "category": null,
            "idBrand": 1,
            "brand": {
                "name": "Gloria"
            },
            "name": "Leche Evaporada",
            "packaging": "paquete",
            "quantity": 4,
            "measure": 500,
            "unit": "g",
            "description": "Leche evaporada",
            "image": "2.jpg",
            "inventory": null
        },
        "quantity": 10
    },
    {
        "idProduct": 2,
        "producto": {
            "idProduct": 2,
            "idCategory": 3,
            "category": null,
            "idBrand": 1,
            "brand": {
                "name": "Laive"
            },
            "name": "Yogurt Fresa",
            "packaging": "botella",
            "quantity": 1,
            "measure": 1000,
            "unit": "ml",
            "description": "Yogurt de sabor fresa",
            "image": "3.jpg",
            "inventory": null
        },
        "quantity": 30
    }
]; */