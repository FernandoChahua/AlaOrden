import React, {Component} from 'react';
import Form from "react-bootstrap/Form";
import {FormControl, InputGroup} from "react-bootstrap"
import Button from "react-bootstrap/Button";

class SearchBar extends Component {
  //TODO: query -local-, search() -state-

  render() {
    return (
      <Form inline className="flex-grow-1">
        <InputGroup id="search-bar">
          <InputGroup.Prepend>
            <Button variant="outline-secondary" onClick={this.search}><i
              className="fas fa-search"> </i></Button>
          </InputGroup.Prepend>
          <FormControl placeholder="Busca tus productos" value={this.state.query}
                       onChange={this.changeQuery.bind(this)} onKeyUp={this.search}/>
        </InputGroup>
      </Form>
    );
  }
}

export default SearchBar;