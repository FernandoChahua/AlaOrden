import React, { Component} from 'react';
import {Form, Navbar, FormControl, Button, Image, InputGroup, Container, Nav} from 'react-bootstrap';
import ShoppingCart from './ShoppingCart'
import NotLoggedButton from "./NotLoggedButton";
import UserLoggedButton from "./UserLoggedButton";
import CategoryNav from "./CategoryNav";

function AccountButton(props) {
    if (props.user.idUsuario != null) {
        return (<UserLoggedButton user={props.user} manageUser={props.manageUser}/>);
    } else
        return (<NotLoggedButton manageUser={props.manageUser}/>);
}

class Header extends Component {
    constructor(props) {
        super(props);
        this.state = {
            query: '',
            //FIXME: hard-coded
            user: {
                idUsuario: 1,
                apodo: "Default"
            },
            //FIXME: hard-coded
            cart: [
                {
                    "idUsuario": 1,
                    "usuario": null,
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
                    "idUsuario": 1,
                    "usuario": null,
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
            ]
        };

        this.manageUser = this.manageUser.bind(this);
        this.changeQuery = this.changeQuery.bind(this);
        this.search = this.search.bind(this);
    }

    manageUser(user) {
        this.setState({
            "query": this.state.query,
            "user": user,
            "cart": this.state.cart
        });
    }

    changeQuery(event) {
        this.setState({
            "query": event.target.value,
            "user": this.state.user,
            "cart": this.state.cart
        });
    }

    search(event) {
        if ((event.type === "click" || event.key === "Enter") && this.state.query.length > 2) {
            alert(`BUSCAR: "${this.state.query}" 
            TODO: implementar búsqueda`);
            this.setState({
                "query": "",
                "user": this.state.user,
                "cart": this.state.cart
            });
        }
    }

    filter(cat) {
        alert(`FILTRAR: "${cat}" 
        TODO: implementar filtro"`);
    }

    render() {
        return (
            <div id="header">
                <Container fluid>
                    <Navbar expand={false} className="flex-column flex-sm-row">
                        {/* -- LOGO--- */}
                        <Navbar.Brand href="#home">
                            <Image src="assets/img/logo.png" height={"50px"} alt="logo"/>
                            <span className="overflow-hidden"> Placeholder</span>
                        </Navbar.Brand>

                        {/* -- BARRA DE BUSQUEDA--- */}
                        <Form inline className="flex-grow-1">
                            <InputGroup id="search-bar">
                                <InputGroup.Prepend>
                                    <Button variant="outline-secondary" onClick={this.search}><i
                                        className="fas fa-search"> </i></Button>
                                </InputGroup.Prepend>
                                <FormControl placeholder="Busca tus productos" value={this.state.query}
                                             onChange={this.changeQuery.bind(this)} onKeyUp={this.search}/>
                            </InputGroup>
                        </Form>
                        {/* -- BOTONES--- */}
                        <Nav id="buttonNav" className="flex-row justify-content-between text-md-center">
                            <div id="list-button" className="mx-1">
                                <Button variant="outline-success" onClick={this.props.toggleList}>
                                    <i className="fas fa-pen-alt"> </i>
                                    <span className="btn-desc"> Lista</span>
                                </Button>
                            </div>
                            <div className="mx-1">
                                <AccountButton user={this.state.user} manageUser={this.manageUser}/>
                            </div>
                            <div className="mx-1">
                                <ShoppingCart cart={this.state.cart} changeBody={this.props.changeBody}/>
                            </div>
                        </Nav>
                    </Navbar>
                </Container>
                <CategoryNav search={this.filter.bind(this)}/>
            </div>
        );
    }
}

export default Header;