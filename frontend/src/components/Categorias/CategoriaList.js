import React from 'react';
import {Button, Table} from 'react-bootstrap';
import connect from "react-redux/es/connect/connect";
import PropTypes from "prop-types";
import {DELETE_CATEGORIA} from "../../actions/actionTypes";
import {fetchCategoriaDelete} from "../../actions/categoriaAction";


class CategoriaList extends React.Component {

    // Le decimos al componente que va a necesitar un parametro/atributo llamado categorias que es obligatorio
    static propTypes = {
        categorias: PropTypes.array.isRequired
    };

    constructor(props) {
        super(props);
        this.state = {
            categorias: []
        };
        this.handleDeleteCategoria= this.handleDeleteCategoria.bind(this);
    }

    componentWillReceiveProps(nextProps) {
        if (nextProps.categorias) {
            this.setState({categorias: nextProps.categorias})
        }
        if (nextProps.actionType===DELETE_CATEGORIA) {
            this.setState(this.initialState)
        }


    }

    handleDeleteCategoria(event){
        this.props.fetchCategoriaDelete(event.target.value);
        console.log(event.target.value);

    }

    render() {
        return (
            <div>
                <h4>Listado de categorias: </h4>
                <Table responsive hover>
                    <thead>
                    <tr>
                        <th>ID</th>
                        <th>Nombre</th>
                        <th>Descripción</th>
                        <th>Acción</th>
                    </tr>
                    </thead>
                    <tbody>
                    {this.state.categorias.map((categoria, index) => (
                        <tr key={index}>
                            <td>{categoria.idcategoria}</td>
                            <td>{categoria.nombrecategoria}</td>
                            <td>{categoria.descripcioncategoria}</td>
                            <td>

                                <Button
                                    value={categoria.idcategoria}
                                    onClick={this.handleDeleteCategoria}
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
    fetchCategoriaDelete
};

export default connect(null, mapDispatch)(CategoriaList);