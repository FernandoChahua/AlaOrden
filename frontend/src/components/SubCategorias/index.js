import React from 'react';
import SubcategoriaForm from "./SubcategoriaForm";
import SubcategoriaList from "./SubcategoriaList";
import {connect} from "react-redux";
import {fetchSubcategoriaList} from "../../actions/subcategoriaAction";
import {fetchCategoriaList} from "../../actions/categoriaAction";
import {VIEW_SUBCATEGORIA_LIST} from "../../actions/actionTypes";

class SubCategorias extends React.Component {

    constructor(props) {
        super(props);
        this.state = {
            subcategorias: [],
            categorias: []
        }
    }

    componentDidMount() {
        this.props.fetchSubcategoriaList();
        this.props.fetchCategoriaList();
    }

    componentWillReceiveProps(nextProps) {

        if (nextProps.actionType === VIEW_SUBCATEGORIA_LIST) {
            this.setState({"subcategorias" : nextProps.subcategoriaList, "categorias" : nextProps.categoriaList});
        }
    }

    render() {
        return (
            <div>
                <SubcategoriaForm afterSubmit={this.props.fetchSubcategoriaList} categorias={this.state.categorias} />
                <SubcategoriaList subcategorias={this.state.subcategorias} />
            </div>
        );
    }

}


const mapState = state => {
    return {
        subcategoriaList: state.subcategoria.subcategoriaList,
        categoriaList: state.categoria.categoriaList,
        actionType: state.subcategoria.actionType
    }
};

const mapDispatch = {
    fetchSubcategoriaList, fetchCategoriaList
};

export default connect(mapState, mapDispatch)(SubCategorias);