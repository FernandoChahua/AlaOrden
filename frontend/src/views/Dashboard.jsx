import React, {Component} from 'react';
import Layout from "../components/layout/Layout";
import Crud from "../components/crud/Crud";

class Dashboard extends Component {
  render() {
    return (
      <Layout>
        <Crud/>
      </Layout>
    );
  }
}

export default Dashboard;