import React, {Component} from 'react'
import {ButtonGroup, Dropdown, DropdownItem, Form} from "react-bootstrap";

class CategoryNav extends Component {
    constructor(props) {
        super(props);

        this.filterByCategory = this.filterByCategory.bind(this);
    }

    filterByCategory(event) {
        this.props.search(event.target.innerText)
    }
    render() {
        //FIXME: hard-coded
        let categories = [
            {
                idCategoria: 1,
                name: "Lacteos",
                subcategories: [
                    {
                        idCategoria: 2,
                        name: "Yogurt"
                    },
                    {
                        idCategoria: 3,
                        name: "Quesos"
                    }
                ]
            },
            {
                idCategoria: 4,
                name: "Carnes",
                subcategories: [
                    {
                        idCategoria: 5,
                        name: "Pescado" },
                    {
                        idCategoria: 6,
                        name: "Embutidos"
                    }
                ]
            }
        ];

        return(
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

export default CategoryNav;