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
            cart: this.props.cart
        };

        //Binding
        this.submitCart = this.submitCart.bind(this);
    }

    submitCart() {
        this.props.changeBody("ordering");
    }

    render() {
        let cart = this.state.cart;
        let badge;
        if (cart.length > 0){
            badge = <Badge variant="warning">{cart.length}</Badge>
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
                        {cart.map((item, i) =>
                            [<Dropdown.Divider key={"divider" + item.idProducto}/>,
                                <CartItem key={"cart" + item.idProducto} details={item} updateMethod={this.update} deleteMethod={this.delete} />
                            ])}
                    </div>
                    <Dropdown.Divider/>
                    <Button type="submit" block onClick={this.submitCart}>Procesar Pedido</Button>
                </DropdownMenu>
            </Dropdown>
        );
    }
}

export default ShoppingCart