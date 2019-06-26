import React, {Component} from 'react';
import ProductCard from "./ProductCard";
import {connect} from "react-redux";

/*
local:
state: results
dispatch:
 */
class Catalog extends Component {

  render() {
    let results = this.props.results || [];

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
  //loadInitialCatalog()
};

export default connect(mapState, mapDispatch)(Catalog);