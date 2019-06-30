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

    constructor(props){
        super(props);
        this.filterByCategory = this.filterByCategory.bind(this);
    }
    componentDidMount() {
    this.props.loadCategories();

    }
    filterByCategory(idCategory){

    }
  render() {
        let categories = this.props.categories || [];

        return (
            <Form className="text-md-left bg-light">
                <ButtonGroup>
                    {categories.map((cat,i) =>
                        <Dropdown key={"ddn"+cat.idCategory}>
                            <Dropdown.Toggle key={"tgg"+cat.idCategory} variant="light">{cat.name}</Dropdown.Toggle>
                            <Dropdown.Menu key={"mnu"+cat.idCategory} rootCloseEvent="click">
                                {cat.subCategories.map((s,i) => <DropdownItem key={"itm"+s.idCategory} onClick={this.filterByCategory}>{s.name}</DropdownItem>)}
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