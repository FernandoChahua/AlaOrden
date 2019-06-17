import React from 'react';
import {Button,Table} from 'react-bootstrap';
import connect from "react-redux/es/connect/connect";
import PropTypes from "prop-types";
import {DELETE_SUBCATEGORIA} from "../../actions/actionTypes";
import {fetchSubCategoriaDelete} from "../../actions/subcategoriaAction";


class SubcategoriaList extends React.Component {

    // Le decimos al componente que va a necesitar un parametro/atributo llamado categorias que es obligatorio
    static propTypes = {
        categorias: PropTypes.array.isRequired
    };

    constructor(props) {
        super(props);
        this.state = {
            subcategorias: []
        };

        this.handleDeleteSubCategoria= this.handleDeleteSubCategoria.bind(this);

    }

    componentWillReceiveProps(nextProps) {
        if (nextProps.subcategorias) {
            this.setState({subcategorias: nextProps.subcategorias})
        }
        if(nextProps.actionType===DELETE_SUBCATEGORIA){
            this.setState(this.initialState)
        }
    }

    handleDeleteSubCategoria(event){
        this.props.fetchSubCategoriaDelete(event.target.value);
        // console.log(this.state.sub.idproducto)
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
                        <th>Categoria</th>
                        <th>Nombre</th>
                        <th>Descripción</th>
                        <th>Link de la imagen</th>
                        <th>Acción</th>
                    </tr>
                    </thead>
                    <tbody>
                    {this.state.subcategorias.map((subcategoria, index) => (
                        <tr key={index}>
                            <td>{subcategoria.idsubcategoria}</td>
                            <td>{subcategoria.categoria.nombrecategoria}</td>
                            <td>{subcategoria.nombresubcategoria}</td>
                            <td>{subcategoria.descripcionsubcategoria}</td>
                            <td>{subcategoria.linkimagensubcategoria}</td>
                            <td>

                                <Button
                                    value={subcategoria.idsubcategoria}
                                    onClick={this.handleDeleteSubCategoria}
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
    fetchSubCategoriaDelete
};

export default connect(null, mapDispatch)(SubcategoriaList);