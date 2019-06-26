import React, {Component} from 'react';
import Image from "react-bootstrap/Image";
import {Link} from "react-router-dom"
import logo from "../../assets/img/logoflash.ico"

/*
COMP
 */
class Brand extends Component {
  render() {
    return (
      <Link to={"/home"}>
        <Image src={logo} height={"50px"} alt="logo"/>
        <span className="overflow-hidden">A la Orden</span>
      </Link>
    );
  }
}

export default Brand;