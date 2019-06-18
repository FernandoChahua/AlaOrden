import React from 'react';
import {Table} from 'react-bootstrap';
import connect from "react-redux/es/connect/connect";
import { Button} from 'react-bootstrap';
import PropTypes from "prop-types";
import {DELETE_PRODUCTO} from "../../actions/actionTypes";
import {fetchProductoDelete} from "../../actions/productoActions";



class ProductoList extends React.Component {

    static propTypes = {
        subcategorias: PropTypes.array.isRequired
    };

    constructor(props) {
        super(props);
        this.state = {
            productos: []
        };
        this.handleDeleteClick= this.handleDeleteClick.bind(this);

    }

    componentWillReceiveProps(nextProps) {
        if (nextProps.productos) {
            this.setState({productos: nextProps.productos})
        }
        if(nextProps.actionType===DELETE_PRODUCTO){
            this.setState(this.initialState)
        }
    }

    handleDeleteClick(event){
        this.props.fetchProductoDelete(event.target.value);
        // console.log(this.state.producto.idproducto)
        console.log(event.target.value);
    }


    render() {
        return (
            <div>
                <h4>Listado de Productos: </h4>
                <Table responsive hover>
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Sub-Categoria</th>
                        <th>Nombre</th>
                        <th>Descripción</th>
                        <th>Link de la imagen</th>
                        <th>Acción</th>
                    </tr>
                    </thead>
                    <tbody>
                    {this.state.productos.map((producto, index) => (
                        <tr key={index}>
                            <td>{producto.idproducto}</td>
                            <td>{producto.subCategoria.nombresubcategoria}</td>
                            <td>{producto.nombreproducto}</td>
                            <td>{producto.descripcionproducto}</td>
                            <td>{producto.linkimagenproducto}</td>
                            <td>

                                <Button
                                    value={producto.idproducto}
                                    onClick={this.handleDeleteClick}
                                    className="btn btn-default">
                                    Delete
                                </Button>
                            </td>

                        </tr>
                    ))}
                    </tbody>
                </Table>
            </div>
        )
    }

}

const mapDispatch = {
    fetchProductoDelete
};

export default connect(null, mapDispatch)(ProductoList);