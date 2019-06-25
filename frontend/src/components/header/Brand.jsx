import React, {Component} from 'react';
import Image from "react-bootstrap/Image";
import {Link} from "react-router-dom"

class Brand extends Component {
  render() {
    return (
      <Link to={"/home"}>
        <Image src="assets/img/logoflash.ico" height={"50px"} alt="logo"/>
        <span className="overflow-hidden">A la Orden</span>
      </Link>
    );
  }
}

export default Brand;