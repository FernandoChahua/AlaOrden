import React, {Component} from 'react';
import Card from "react-bootstrap/Card";
import Image from "react-bootstrap/Image";
import Badge from "react-bootstrap/Badge";
import Collapse from "react-bootstrap/Collapse";
import ProFormaDetails from "./ProFormaDetails";
import ListGroupItem from "react-bootstrap/ListGroupItem";
import Table from "react-bootstrap/Table";
import {Button} from "react-bootstrap";
import {connect} from "react-redux";
import {pickOption} from "../../actions/quotationActions";
import ConfirmAddress from "../modal/ConfirmAddress";
import Col from "react-bootstrap/Col";
import ConfirmLocation from "../modal/ConfirmLocation";

/*
local:
state: proformaList[i]
dispatch:
 */
class ProForma extends Component {
  constructor(props) {
    super(props);
    this.state = {
      show: false,
      showModal: false
    };
    this.pickOrder = this.pickOrder.bind(this);
  }


  toggleConfirmation() {
    this.setState({...this.state, showModal: !this.state.showModal})
  }

  pickOrder(){
    this.props.pickOption(this.props.proforma,this.props.history)
  }
  render() {
    const franchise = this.props.proforma.location.franchise;

    return (
      <div className="m-4">
        <div className="d-flex justify-content-between mb-2">
          <h6 className="align-self-end">{franchise.name}</h6>
          <div className="form-check">
            <Button block onClick={() => {this.setState({...this.state,showModal: true})}}>Seleccionar</Button>
            <ConfirmLocation show={this.state.showModal}
                            toggle={this.toggleConfirmation.bind(this)}
                            confirm={this.pickOrder}
                             object={this.props.proforma}/>
          </div>
        </div>
        <Card>
          <Card.Header onClick={() => {this.setState({show: !this.state.show})}}
                       className="d-inline-flex justify-content-between">
            <Image src={process.env.PUBLIC_URL + "/img/franchises/" + franchise.logo} alt="logo" className="" height="40px"/>
            <div>
              <b>TOTAL: </b>
              <Badge pill variant="light">S/. {Math.round(this.props.proforma.subTotal*100)/100}</Badge>
            </div>
          </Card.Header>
          <Collapse in={this.state.show}>
            <ListGroupItem variant="flush">
              <Table responsive className="proforma-table">
                <thead>
                <tr>
                  <th>producto</th>
                  <th>precio</th>
                  <th>cantidad</th>
                  <th>subtotal</th>
                </tr>
                </thead>
                <tbody>
                {this.props.proforma.orderDetails.map((x,i) => (<ProFormaDetails key={i} details={x}/>))}
                </tbody>
              </Table>
            </ListGroupItem>
          </Collapse>
        </Card>
      </div>
      );
  }
}

const mapState = (state, ownProps) => {
  return {
    proforma: state.quotation.proformaList[ownProps.index]
  }
};

const mapDispatch = {
  pickOption: pickOption
};

export default connect(mapState,mapDispatch)(ProForma);