import React, {Component} from 'react';
import Jumbotron from "react-bootstrap/Jumbotron";
import Button from "react-bootstrap/Button";

class Forbidden extends Component {
  render() {
    return (
      <div className="d-flex justify-content-center">
        <Jumbotron style={{width: "50%", marginTop: "40px"}}>
          <h1>Acceso restringido</h1>
          <p>
            Inicie sesión para continuar
          </p>
          <p>
            <Button variant="primary">Learn more</Button>
          </p>
        </Jumbotron>
      </div>
    );
  }
}

export default Forbidden;