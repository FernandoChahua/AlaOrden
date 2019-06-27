import React, {Component} from 'react';
import {Route} from "react-router-dom"
import Layout from "../components/layout/Layout";
import Order from "../components/order/Order";
import Delivery from "../components/delivery/Delivery";
import Quotation from "../components/quotation/Quotation";
import Payment from "../components/payment/Payment";

class PlaceOrder extends Component {
  render() {
    return (
      <Layout>
        <Order {...this.props}>

        </Order>
      </Layout>
    );
  }
}

export default PlaceOrder;