import React, { Component } from 'react'

class Receipt extends Component {
    constructor(props){
        super(props);
        this.state={
            pedido: props.pedido
        };    }
    render() {
        let aux = {
            "idPedido": 1,
            "usuario": {
                "apodo": 'Sick',
                "email": 'sick@hotmail.com'
            },
            "transaccion": {
                "idTransaccion": 1
            },
            "estado": 'Entregado',
            "fechaRealizacion": "2019-03-30T00:00:00",
            "direccion": {
                "descripcion": 'Mercedes Gallagher de Parks #342'
            },
            "subtotal": 31.00,
            "precioEnvio": 10.00,
            "descuento": 0.00,
            "detallePedido":[
                {
                    "producto":{
                        "nombre":'Sprite',
                        "presentacion":'botella',
                        "descripcion":"Bebida gasificada sabor limón",
                        "unidad":'ml',
                        "magnitud":625,
                        "marca":{
                            "nombre":'Coca Cola'
                        },
                        "cantidad":1
                    },
                    "precio":2.00,
                    "cantidad":10
                },
                {
                    "producto":{
                        "nombre":'San Luis',
                        "presentacion":'botella',
                        "descripcion":"six pack de agua mineral de manantial",
                        "unidad":'ml',
                        "magnitud":625,
                        "marca":{
                            "nombre":'Coca Cola'
                        },
                        "cantidad":6
                    },
                    "precio":8.00,
                    "cantidad":1
                },
                {
                    "producto":{
                        "nombre":'Oreo',
                        "presentacion":'paquete de 4 unidades',
                        "descripcion":"Galleta de chocolote con relleno",
                        "unidad":'g',
                        "magnitud":18,
                        "marca":{
                            "nombre":'Nabisco'
                        },
                        "cantidad":1
                    },
                    "precio":0.5,
                    "cantidad":6
                }
            ]
        }


        return (
            <div>
                <h2 style={{color:"orange"}}>Detalles del pedido # {aux.idPedido}</h2>
                <container>
                    <p > <strong>Pedido realizado:</strong> {aux.fechaRealizacion.toString()}</p>
                    <p > <strong>Total del pedido:</strong> S/.{aux.subtotal+aux.precioEnvio-aux.descuento}</p>
                    
                </container>
            </div>
        );
    }
}

export default Receipt;