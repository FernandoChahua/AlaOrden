import React, {Component} from 'react';
import './App.css';
import Header from "./components/layout/Header";
import ShoppingList from "./components/home/ShoppingList";
import MainBody from "./components/home/MainBody";
import CartManager from "./util/CartManager";

class Layout extends Component {
    constructor(props) {
        super(props);
        let cart = CartManager.getCart();
        this.state = {
            ordering: false,
            body: "search",
            cart: cart
        };
        this.toggleList = this.toggleList.bind(this);
        this.changeBody = this.changeBody.bind(this);
        this.updateCart = this.updateCart.bind(this);
    }

    updateCart() {
        let cart = CartManager.getCart();
        this.setState({
            ordering: this.state.ordering,
            body: this.state.body,
            cart: cart
        });
    }

    toggleList(){
        const { openlist, body } = this.state;
        this.setState({ "openlist": !openlist, "body": body });
    }
    changeBody(body, params = {}){
        const { openlist } = this.state;
        this.setState({"openlist": openlist, "body": body});
    }



    render() {
        return (
            <div className="App">
                <Header cart={this.state.cart} toggleList={this.toggleList} changeBody={this.changeBody} updateCart={this.updateCart}/>
                <div className="d-flex">
                    <div id="sidebar">
                        <ShoppingList openlist={this.state.openlist} toggleList={this.toggleList} changeBody={this.changeBody} updateCart={this.updateCart}/>
                    </div>
                    <div id="body" className="flex-grow-1">
                        <div id="content">
                            <MainBody body={this.state.body} changeBody={this.changeBody} updateCart={this.updateCart}/>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default Layout;
