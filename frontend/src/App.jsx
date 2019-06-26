import React, {Component} from 'react';
import {Provider} from "react-redux";
import configureStore from "./store/configureStore";
import Paths from "./Paths";

const store = configureStore();

class App extends Component {
  render() {
    return (
      <Provider store={store}>
        <Paths />
      </Provider>
    );
  }
}

export default App;