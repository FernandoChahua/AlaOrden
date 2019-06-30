import React, {Component} from 'react';
import Form from "react-bootstrap/Form";
import {FormControl, InputGroup} from "react-bootstrap"
import Button from "react-bootstrap/Button";
import {getSearchResults, setQuery} from "../../actions/catalogActions";
import {connect} from "react-redux";

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
    event.preventDefault();
    if ((event.type === "click" || event.key === "Enter") && this.state.query.length > 2) {

      this.props.setQuery(this.state.query);

    }
  }

  render() {
    return (
      <div className="flex-grow-1">
        <InputGroup id="search-bar">

          <FormControl placeholder="Busca tus productos"
                       onChange={this.changeQuery} onKeyUp={this.search}/>
          <InputGroup.Append>
            <Button variant="outline-secondary" onClick={this.search}>
              <i className="fas fa-search"/>
            </Button>
          </InputGroup.Append>
        </InputGroup>
      </div>
    );
  }
}

const mapState = state => {
  return {

  }
};

const mapDispatch = {
  setQuery: setQuery
};

export default connect(mapState,mapDispatch)(SearchBar);