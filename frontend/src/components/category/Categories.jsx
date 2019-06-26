import React, {Component} from 'react';
import Form from "react-bootstrap/Form";
import ButtonGroup from "react-bootstrap/ButtonGroup";
import Dropdown from "react-bootstrap/Dropdown";
import DropdownItem from "react-bootstrap/DropdownItem";

//catogories -state-
class Categories extends Component {

    render() {
        let categories = this.props.categories;

        return (
            <Form className="text-md-left bg-light">
                <ButtonGroup>
                    {categories.map((cat,i) =>
                        <Dropdown key={"ddn"+cat.idCategoria}>
                            <Dropdown.Toggle key={"tgg"+cat.idCategoria} variant="light">{cat.name}</Dropdown.Toggle>
                            <Dropdown.Menu key={"mnu"+cat.idCategoria} rootCloseEvent="click">
                                {cat.subcategories.map((s,i) => <DropdownItem key={"itm"+s.idCategoria} onClick={this.filterByCategory}>{s.name}</DropdownItem>)}
                            </Dropdown.Menu>
                        </Dropdown>)}
                </ButtonGroup>
            </Form>
        );
    }
}

export default Categories;