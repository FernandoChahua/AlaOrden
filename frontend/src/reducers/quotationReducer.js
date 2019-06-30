import {LOAD_OPTIONS} from "../actions/actions";

const initial = {
    proformaList: [
        {
            "idOrders": null,
            "user": {
                "idUser": 2,
                "nickname": null,
                "hashPassword": null,
                "salt": null,
                "email": null,
                "emailValidated": false,
                "state": null,
                "addresses": null,
                "cart": null
            },
            "location": {
                "idLocation": 1,
                "address": "Av. Universitaria 3, Pueblo Libre 15084",
                "franchise": {
                    "idFranchise": 1,
                    "name": "Wong",
                    "webUrl": "www.wong.com",
                    "apiUrl": "api/WongProducto",
                    "logo": "wong.png",
                    "locations": null
                },
                "longitude": -77.08,
                "latitude": -12.08
            },
            "state": "Procesando",
            "date": "2019-06-30T09:10:19.74",
            "address": "Av. Julio César Tello 471, Carmen de La Legua - Reynoso 07006, Peru",
            "transaction": null,
            "subTotal": 71.95,
            "priceDelivery": 5.22,
            "discount": 0,
            "orderDetails": [
                {
                    "pk": {
                        "idOrders": null,
                        "idProduct": 1
                    },
                    "orders": null,
                    "product": {
                        "idProduct": 1,
                        "category": {
                            "idCategory": 5,
                            "name": "Refrescos gaseosos",
                            "parent": null,
                            "products": null,
                            "subCategories": null
                        },
                        "brand": {
                            "idBrand": 1,
                            "name": "Coca Cola"
                        },
                        "name": "Sprite",
                        "packaging": "botella",
                        "quantity": 1,
                        "measure": 625,
                        "unit": "ml",
                        "description": "Gaseosa blanca sabor a limón",
                        "image": "sprite.png",
                        "inventory": null
                    },
                    "price": 11.99,
                    "quantity": 1
                },
                {
                    "pk": {
                        "idOrders": null,
                        "idProduct": 4
                    },
                    "orders": null,
                    "product": {
                        "idProduct": 4,
                        "category": {
                            "idCategory": 10,
                            "name": "Galletas",
                            "parent": null,
                            "products": null,
                            "subCategories": null
                        },
                        "brand": {
                            "idBrand": 2,
                            "name": "Nabisco"
                        },
                        "name": "Oreo Fresa",
                        "packaging": "paquete",
                        "quantity": 6,
                        "measure": 18,
                        "unit": "g",
                        "description": "Six pack de galleta de chocolote con relleno",
                        "image": "sixoreofresa.png",
                        "inventory": null
                    },
                    "price": 14.99,
                    "quantity": 4
                }
            ]
        },
        {
            "idOrders": null,
            "user": {
                "idUser": 2,
                "nickname": null,
                "hashPassword": null,
                "salt": null,
                "email": null,
                "emailValidated": false,
                "state": null,
                "addresses": null,
                "cart": null
            },
            "location": {
                "idLocation": 3,
                "address": "Av. de la Marina 2500, San Miguel 15088",
                "franchise": {
                    "idFranchise": 2,
                    "name": "Metro",
                    "webUrl": "www.metro.com",
                    "apiUrl": "api/MetroProducto",
                    "logo": "metro.png",
                    "locations": null
                },
                "longitude": -77.09,
                "latitude": -12.08
            },
            "state": "Procesando",
            "date": "2019-06-30T09:10:19.74",
            "address": "Av. Julio César Tello 471, Carmen de La Legua - Reynoso 07006, Peru",
            "transaction": null,
            "subTotal": 73.95,
            "priceDelivery": 5.21,
            "discount": 0,
            "orderDetails": [
                {
                    "pk": {
                        "idOrders": null,
                        "idProduct": 1
                    },
                    "orders": null,
                    "product": {
                        "idProduct": 1,
                        "category": {
                            "idCategory": 5,
                            "name": "Refrescos gaseosos",
                            "parent": null,
                            "products": null,
                            "subCategories": null
                        },
                        "brand": {
                            "idBrand": 1,
                            "name": "Coca Cola"
                        },
                        "name": "Sprite",
                        "packaging": "botella",
                        "quantity": 1,
                        "measure": 625,
                        "unit": "ml",
                        "description": "Gaseosa blanca sabor a limón",
                        "image": "sprite.png",
                        "inventory": null
                    },
                    "price": 9.99,
                    "quantity": 1
                },
                {
                    "pk": {
                        "idOrders": null,
                        "idProduct": 4
                    },
                    "orders": null,
                    "product": {
                        "idProduct": 4,
                        "category": {
                            "idCategory": 10,
                            "name": "Galletas",
                            "parent": null,
                            "products": null,
                            "subCategories": null
                        },
                        "brand": {
                            "idBrand": 2,
                            "name": "Nabisco"
                        },
                        "name": "Oreo Fresa",
                        "packaging": "paquete",
                        "quantity": 6,
                        "measure": 18,
                        "unit": "g",
                        "description": "Six pack de galleta de chocolote con relleno",
                        "image": "sixoreofresa.png",
                        "inventory": null
                    },
                    "price": 15.99,
                    "quantity": 4
                }
            ]
        },
        {
            "idOrders": null,
            "user": {
                "idUser": 2,
                "nickname": null,
                "hashPassword": null,
                "salt": null,
                "email": null,
                "emailValidated": false,
                "state": null,
                "addresses": null,
                "cart": null
            },
            "location": {
                "idLocation": 5,
                "address": "Av. Arequipa 2250, Lince 15046",
                "franchise": {
                    "idFranchise": 3,
                    "name": "plazavea.png",
                    "webUrl": "www.plazavea.com",
                    "apiUrl": "api/PlazaVea",
                    "logo": "Plaza Vea",
                    "locations": null
                },
                "longitude": -77.03,
                "latitude": -12.09
            },
            "state": "Procesando",
            "date": "2019-06-30T09:10:19.74",
            "address": "Av. Julio César Tello 471, Carmen de La Legua - Reynoso 07006, Peru",
            "transaction": null,
            "subTotal": 73.95,
            "priceDelivery": 5.43,
            "discount": 0,
            "orderDetails": [
                {
                    "pk": {
                        "idOrders": null,
                        "idProduct": 1
                    },
                    "orders": null,
                    "product": {
                        "idProduct": 1,
                        "category": {
                            "idCategory": 5,
                            "name": "Refrescos gaseosos",
                            "parent": null,
                            "products": null,
                            "subCategories": null
                        },
                        "brand": {
                            "idBrand": 1,
                            "name": "Coca Cola"
                        },
                        "name": "Sprite",
                        "packaging": "botella",
                        "quantity": 1,
                        "measure": 625,
                        "unit": "ml",
                        "description": "Gaseosa blanca sabor a limón",
                        "image": "sprite.png",
                        "inventory": null
                    },
                    "price": 9.99,
                    "quantity": 1
                },
                {
                    "pk": {
                        "idOrders": null,
                        "idProduct": 4
                    },
                    "orders": null,
                    "product": {
                        "idProduct": 4,
                        "category": {
                            "idCategory": 10,
                            "name": "Galletas",
                            "parent": null,
                            "products": null,
                            "subCategories": null
                        },
                        "brand": {
                            "idBrand": 2,
                            "name": "Nabisco"
                        },
                        "name": "Oreo Fresa",
                        "packaging": "paquete",
                        "quantity": 6,
                        "measure": 18,
                        "unit": "g",
                        "description": "Six pack de galleta de chocolote con relleno",
                        "image": "sixoreofresa.png",
                        "inventory": null
                    },
                    "price": 15.99,
                    "quantity": 4
                }
            ]
        },
        {
            "idOrders": null,
            "user": {
                "idUser": 2,
                "nickname": null,
                "hashPassword": null,
                "salt": null,
                "email": null,
                "emailValidated": false,
                "state": null,
                "addresses": null,
                "cart": null
            },
            "location": {
                "idLocation": 7,
                "address": "San Miguel 15087",
                "franchise": {
                    "idFranchise": 4,
                    "name": "Tottus",
                    "webUrl": "www.tottus.com",
                    "apiUrl": "api/TottusProducto",
                    "logo": "tottus.png",
                    "locations": null
                },
                "longitude": -77.09,
                "latitude": -12.08
            },
            "state": "Procesando",
            "date": "2019-06-30T09:10:19.74",
            "address": "Av. Julio César Tello 471, Carmen de La Legua - Reynoso 07006, Peru",
            "transaction": null,
            "subTotal": 78.55,
            "priceDelivery": 5.21,
            "discount": 0,
            "orderDetails": [
                {
                    "pk": {
                        "idOrders": null,
                        "idProduct": 1
                    },
                    "orders": null,
                    "product": {
                        "idProduct": 1,
                        "category": {
                            "idCategory": 5,
                            "name": "Refrescos gaseosos",
                            "parent": null,
                            "products": null,
                            "subCategories": null
                        },
                        "brand": {
                            "idBrand": 1,
                            "name": "Coca Cola"
                        },
                        "name": "Sprite",
                        "packaging": "botella",
                        "quantity": 1,
                        "measure": 625,
                        "unit": "ml",
                        "description": "Gaseosa blanca sabor a limón",
                        "image": "sprite.png",
                        "inventory": null
                    },
                    "price": 10.59,
                    "quantity": 1
                },
                {
                    "pk": {
                        "idOrders": null,
                        "idProduct": 4
                    },
                    "orders": null,
                    "product": {
                        "idProduct": 4,
                        "category": {
                            "idCategory": 10,
                            "name": "Galletas",
                            "parent": null,
                            "products": null,
                            "subCategories": null
                        },
                        "brand": {
                            "idBrand": 2,
                            "name": "Nabisco"
                        },
                        "name": "Oreo Fresa",
                        "packaging": "paquete",
                        "quantity": 6,
                        "measure": 18,
                        "unit": "g",
                        "description": "Six pack de galleta de chocolote con relleno",
                        "image": "sixoreofresa.png",
                        "inventory": null
                    },
                    "price": 16.99,
                    "quantity": 4
                }
            ]
        }
    ],
};

export default function quotationReducer(state = initial, action) {
    switch (action.type) {
        case LOAD_OPTIONS:
            return Object.assign({}, state,
                { proformaList: action.proformaList });
        default:
            return state;
    }
}