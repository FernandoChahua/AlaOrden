import React, {Component} from 'react';
import ProductCard from "./ProductCard";
import {connect} from "react-redux";
import {loadInitCatalog, loadResults} from "../../actions/catalogActions";

/*
local:
state: results
dispatch:
 */
class Catalog extends Component {

  constructor(props){
    super(props);
    this.state = {
      results:[]
    }
  }
  componentDidMount() {
    this.props.loadInitCatalog();
  }

  componentWillReceiveProps(nextProps) {
    if(nextProps.results){
      this.setState({results: nextProps.results})
    }
  }

  render() {
    let results = this.state.results;

    let title = results.length === 0 ?
      (<h5>No se han encontrado coincidencias a su busqueda</h5>) :
      (<h5>Mostrando: {results.length} de {"x"} </h5>);

    return (
      <div>
        {title}
        <div className="grid-container">
          {results.map((x, i) => <ProductCard key={i} index={i}/>)}
        </div>
      </div>
    );
  }
}

const mapState = state => {
  return {
    results: state.catalog.results
  }
};

const mapDispatch = {
  loadInitCatalog: loadResults
};

export default connect(mapState, mapDispatch)(Catalog);