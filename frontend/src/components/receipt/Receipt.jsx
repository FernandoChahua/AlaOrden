import React, {Component} from 'react';
import Table from "react-bootstrap/Table";

/*
local:
state: order
dispatch:
 */
class Receipt extends Component {
  render() {

    let aux = {
      "idPedido": 1,
      "usuario": {
        "apodo": 'Sick',
        "email": 'sick@hotmail.com'
      },
      "transaccion": {
        "idTransaccion": 1231212341
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
            "cantidad":1,
            "categoria":{
              "nombre":'Gaseosa'
            }
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
            "cantidad":6,
            "categoria":{
              "nombre":'Agua'
            }
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
            "cantidad":1,
            "categoria":{
              "nombre":'Galletas'
            }
          },
          "precio":0.5,
          "cantidad":6
        }
      ]
    }
    let cont=0;
    const descripciones=aux.detallePedido.map(
      d=>
        <tr>
          <td>{++cont}</td>
          <td className="text-left">{`${d.cantidad} de: ${d.producto.categoria.nombre} ${d.producto.nombre} 
                    ${d.producto.magnitud} ${d.producto.unidad}, ${d.producto.descripcion}, ${d.producto.cantidad} unidad(es)`}</td>
          <td>S/.{(d.precio * d.cantidad).toFixed(2)}</td>
        </tr>
    );



    return (
      <div>
        <h2 style={{color:"orange"}}>Detalles del pedido # {aux.idPedido}</h2>
        <container className="text-left">
          <p > <strong>Pedido realizado: </strong>{aux.fechaRealizacion.toString()}</p>
          <p > <strong>Id Transaccion: </strong> #{aux.transaccion.idTransaccion}</p>
          <p > <strong>Total del pedido: </strong>
            S/.{(aux.subtotal+aux.precioEnvio-aux.descuento).toFixed(2)}</p>
        </container>


        <Table responsive  size="sm" style={{fontSize:18}}>

          <thead>
          <tr>
            <th>#</th>
            <th>Producto</th>
            <th>Precio</th>
          </tr>
          </thead>

          <tbody>

          {descripciones}

          <tr>
            <td></td>
            <th className="text-right">Subtotal</th>
            <td>S/.{aux.subtotal.toFixed(2)}</td>
          </tr>
          <tr>
            <td></td>
            <th className="text-right">Precio envio</th>
            <td>S/.{aux.precioEnvio.toFixed(2)}</td>
          </tr>
          <tr>
            <td></td>
            <th className="text-right">Descuento</th>
            <td>S/.{aux.descuento.toFixed(2)}</td>
          </tr>
          <tr>
            <td></td>
            <th className="text-right">Total</th>
            <td>S/.{(aux.subtotal+aux.precioEnvio-aux.descuento).toFixed(2)}</td>
          </tr>
          </tbody>
        </Table>
      </div>
    );
  }
}

export default Receipt;