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
        "description": 'Mercedes Gallagher de Parks #342'
      },
      "subtotal": 31.00,
      "precioEnvio": 10.00,
      "descuento": 0.00,
      "detallePedido":[
        {
          "producto":{
            "name":'Sprite',
            "packaging":'botella',
            "description":"Bebida gasificada sabor limón",
            "unit":'ml',
            "measure":625,
            "brand":{
              "name":'Coca Cola'
            },
            "packageUnit":1,
            "category":{
              "name":'Gaseosa'
            }
          },
          "precio":2.00,
          "packageUnit":10
        },
        {
          "producto":{
            "name":'San Luis',
            "packaging":'botella',
            "description":"six pack de agua mineral de manantial",
            "unit":'ml',
            "measure":625,
            "brand":{
              "name":'Coca Cola'
            },
            "packageUnit":6,
            "category":{
              "name":'Agua'
            }
          },
          "precio":8.00,
          "packageUnit":1
        },
        {
          "producto":{
            "name":'Oreo',
            "packaging":'paquete de 4 unidades',
            "description":"Galleta de chocolote con relleno",
            "unit":'g',
            "measure":18,
            "brand":{
              "name":'Nabisco'
            },
            "packageUnit":1,
            "category":{
              "name":'Galletas'
            }
          },
          "precio":0.5,
          "packageUnit":6
        }
      ]
    }
    let cont=0;
    const descripciones=aux.detallePedido.map(
      d=>
        <tr>
          <td>{++cont}</td>
          <td className="text-left">{`${d.packageUnit} de: ${d.producto.category.name} ${d.producto.name} 
                    ${d.producto.measure} ${d.producto.unit}, ${d.producto.description}, ${d.producto.packageUnit} unidad(es)`}</td>
          <td>S/.{(d.precio * d.packageUnit).toFixed(2)}</td>
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