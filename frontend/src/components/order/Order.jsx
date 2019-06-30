import React, {Component} from 'react';
import {Route} from "react-router-dom"
import Stepper from "react-stepper-horizontal/lib/Stepper"
import Delivery from "../delivery/Delivery";
import Payment from "../payment/Payment";
import Quotation from "../quotation/Quotation";
import {connect} from "react-redux";

/*
local:
state: orderStep, maxStep
dispatch:
 */
class Order extends Component {


  render() {
    let steps =  [
      {title: 'Dirección', onClick: () => { this.props.history.push("/order/delivery")  }},
      {title: 'Cotización',onClick: () => { this.props.history.push("/order/quotation") }},
      {title: 'Pago', onClick: () => { this.props.history.push("/order/payment") }}
    ];

    return (
      <div id="order-steps">
        <Stepper steps={steps} activeStep={this.props.activeStep} />
        <Route path={`${this.props.match.path}/delivery`} component={Delivery}/>
        <Route path={`${this.props.match.path}/quotation`} component={Quotation}/>
        <Route path={`${this.props.match.path}/payment`} component={Payment} />
      </div>
    );
  }
}

const mapState = state => {
  return {
    activeStep: state.order.activeStep,
    maxStep: state.order.maxStep,
    allowCheckout: state.cart.allowCheckout
  }
};

const mapDispatch = {
};

export default connect(mapState,mapDispatch)(Order);