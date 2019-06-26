import React, {Component} from 'react';
import Layout from "../components/layout/Layout";
import Order from "../components/order/Order";

class PlaceOrder extends Component {
  render() {
    return (
      <Layout>
        <Order/>
      </Layout>
    );
  }
}

export default PlaceOrder;