import React, {Component} from 'react';
import Form from "react-bootstrap/Form";
import ButtonGroup from "react-bootstrap/ButtonGroup";
import Dropdown from "react-bootstrap/Dropdown";
import DropdownItem from "react-bootstrap/DropdownItem";
import {connect} from "react-redux";
import {loadCategories} from "../../actions/catalogActions";

/*
local:
state: categories
dispatch:
 */
class Categories extends Component {

    componentDidMount() {
    this.props.loadCategories();
    console.log(this.props.categories);
    }
    filterByCategory(){
        alert("aea mano");
    }
  render() {
        let categories = this.props.categories || [];

        return (
            <Form className="text-md-left bg-light">
                <ButtonGroup>
                    {categories.map((cat,i) =>
                        <Dropdown key={"ddn"+cat.categoryId}>
                            <Dropdown.Toggle key={"tgg"+cat.categoryId} variant="light">{cat.name}</Dropdown.Toggle>
                            <Dropdown.Menu key={"mnu"+cat.categoryId} rootCloseEvent="click">
                                {cat.subcategorias.map((s,i) => <DropdownItem key={"itm"+s.categoryId} onClick={this.filterByCategory.bind(this)}>{s.name}</DropdownItem>)}
                            </Dropdown.Menu>
                        </Dropdown>)}
                </ButtonGroup>
            </Form>
        );
    }
}

const mapState = (state) => {
  return {
    categories: state.catalog.categories
  }
};

const mapDispatch = {
  loadCategories:loadCategories
  //searchByCategory
};

export default connect(mapState,mapDispatch)(Categories);