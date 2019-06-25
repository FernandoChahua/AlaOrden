import React, {Component} from 'react';
import Stepper from "react-stepper-horizontal/lib/Stepper"

class Order extends Component {
  //TODO: maxStep -state-, activeStep -local-
  render() {
    let activeStep = this.state.activeStep;
    let steps =  [
      {title: 'Dirección',},
      {title: 'Cotización',},
      {title: 'Pago',},
    ];
    return (
      <Stepper steps={steps} activeStep={activeStep} />
    );
  }
}

export default Order;