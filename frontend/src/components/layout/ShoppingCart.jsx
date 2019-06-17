import React, {Component} from 'react'
import {Button, Dropdown} from "react-bootstrap";
import DropdownToggle from "react-bootstrap/DropdownToggle";
import Badge from "react-bootstrap/Badge";
import DropdownMenu from "react-bootstrap/DropdownMenu";
import CartItem from "./CartItem"

class ShoppingCart extends Component {
    constructor(props){
        super(props);
        this.state = {
            //FIXME: hard-coded
            carrito: this.props.carrito
        };

        //Binding
        this.update = this.update.bind(this);
        this.add = this.add.bind(this);
        this.delete = this.delete.bind(this);
    }

    update(id, quantity){
        let carrito = this.state.carrito;
        let item = carrito.find(x => x.idProducto === id);
        item.cantidad = quantity;
        this.setState({
            carrito: carrito
        });
    }

    delete(id) {
        let carrito = this.state.carrito.filter(x => x.idProducto !== id);
        this.setState({
            carrito: carrito
        });
    }

    //TODO: implement add to cart
    add(id) {

    }

    render() {
        let carrito = this.state.carrito;
        let badge;
        if (carrito.length > 0){
            badge = <Badge variant="warning">{carrito.length}</Badge>
        }
        return (
            <Dropdown>
                <DropdownToggle variant="outline-warning">
                    <i className="fas fa-shopping-cart"> </i>
                    <span className="btn-desc"> Carrito </span>
                    {badge}
                </DropdownToggle>
                <DropdownMenu alignRight className="p-2" >
                    <Dropdown.Header>CARRITO</Dropdown.Header>
                    <div className="cart-menu">
                        {carrito.map((item, i) =>
                            [<Dropdown.Divider key={"divider" + item.idProducto}/>,
                                <CartItem key={"cart" + item.idProducto} details={item} updateMethod={this.update} deleteMethod={this.delete} />
                            ])}
                    </div>
                    <Dropdown.Divider/>
                    <Button type="submit" block>Procesar Pedido</Button>
                </DropdownMenu>
            </Dropdown>
        );
    }
}

export default ShoppingCart