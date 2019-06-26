import React, {Component} from 'react';
import Form from "react-bootstrap/Form";
import {FormControl, InputGroup} from "react-bootstrap"
import Button from "react-bootstrap/Button";

/*
local:
state:
dispatch:
 */
class SearchBar extends Component {
  constructor(props) {
    super(props);
    this.state = {
      query: ''
    };
    this.changeQuery = this.changeQuery.bind(this);
    this.search = this.search.bind(this);
  }

  changeQuery(event) {
    this.setState({
      query: event.target.value,
    });
  }

  search(event) {
    if ((event.type === "click" || event.key === "Enter") && this.state.query.length > 2) {
      alert(`BUSCAR: "${this.state.query}" 
            TODO: implementar búsqueda`);
      this.setState({
        "query": ""
      });
    }
  }

  render() {
    return (
      <Form inline className="flex-grow-1">
        <InputGroup id="search-bar">
          <InputGroup.Prepend>
            <Button variant="outline-secondary" onClick={this.search}><i
              className="fas fa-search"> </i></Button>
          </InputGroup.Prepend>
          <FormControl placeholder="Busca tus productos"
                       onChange={this.changeQuery.bind(this)} onKeyUp={this.search}/>
        </InputGroup>
      </Form>
    );
  }
}

export default SearchBar;