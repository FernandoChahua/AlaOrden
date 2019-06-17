import React from 'react';
import CategoriaForm from "./CategoriaForm";
import CategoriaList from "./CategoriaList";
import {connect} from "react-redux";
import {fetchCategoriaList} from "../../actions/categoriaAction";
import {VIEW_CATEGORIA_LIST} from "../../actions/actionTypes";

class Categorias extends React.Component {

    componentDidMount() {
        this.props.fetchCategoriaList();
    }

    componentWillReceiveProps(nextProps) {
        if (nextProps.actionType === VIEW_CATEGORIA_LIST) {
            this.setState({"categorias" : nextProps.categoriaList});
        }
    }

    constructor(props) {
        super(props);
        this.state = {
            categorias: []
        }
    }

    render() {
        return (
            <div>
                <CategoriaForm afterSubmit={this.props.fetchCategoriaList} />
                <CategoriaList categorias={this.state.categorias} />
            </div>
        )
    }
}

const mapState = state => {
    return {
        categoriaList: state.categoria.categoriaList,
        actionType: state.categoria.actionType
    }
};

const mapDispatch = {
    fetchCategoriaList
};

export default connect(mapState, mapDispatch)(Categorias);