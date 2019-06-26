import React, {Component} from 'react';
import Layout from "../components/layout/Layout";
import Catalog from "../components/catalog/Catalog";

class Home extends Component {
  render() {
    return (
      <Layout>
        <Catalog/>
      </Layout>
    );
  }
}

export default Home;