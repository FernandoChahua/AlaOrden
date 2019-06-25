import React, {Component} from 'react';
import ProductCard from "../product/ProductCard";

class Catalog extends Component {
  //TODO: []results -state

  render() {
    return (
      <div className="grid-contatiner">
        {this.props.results.map((x,i) => <ProductCard key={i} product={x} />)}
      </div>
    );
  }
}

export default Catalog;