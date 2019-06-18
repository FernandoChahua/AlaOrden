import React from 'react';
import {FormGroup, ControlLabel, FormControl, Form, Button, Col} from 'react-bootstrap';
import {fetchProductoSave} from "../../actions/productoActions";
import connect from "react-redux/es/connect/connect";
import {SAVE_ORDEN} from "../../actions/actionTypes";
import PropTypes from "prop-types";


class ProductoForm extends React.Component {

    initialState = {

        subcategorias: [],
        producto: {
            codigoproducto: "",
            nombreproducto: "",
            precioproducto: "",
            descripcionproducto: "",
            stock: "",
            linkimagenproducto: "",
            subCategoria: {
                idsubcategoria: 1
            }
        }

    };

    static propTypes = {
        subcategorias: PropTypes.array.isRequired,
        afterSubmit: PropTypes.func
    };

    constructor(props) {
        super(props);
        this.state = this.initialState;
        this.handleSubmit = this.handleSubmit.bind(this);
    }

    handleTextChange(event) {
        let fieldName = event.target.name;
        let fieldValue = event.target.value;
        this.setState({producto: {...this.state.producto,[fieldName]: fieldValue}})
    }

    handleSelectChange(event) {
        let fieldValue = event.target.value;
        this.setState({producto:{...this.state.producto, subCategoria: {idsubcategoria: fieldValue}}})
    }


    componentWillReceiveProps(nextProps) {
        if (nextProps.subcategorias) {
            this.setState({subcategorias: nextProps.subcategorias})
        }

        if(nextProps.actionType===SAVE_ORDEN){
            this.setState(this.initialState);
            this.props.afterSubmit();
        }
    }


    handleSubmit(){
        this.props.fetchProductoSave(this.state.producto);
    }

    render() {
        return (
            <div>
                <h4>Registro de productos: </h4>
                <Form horizontal>
                    <FormGroup controlId="nombresubcategoria">
                        <Col componentClass={ControlLabel} sm={2}>
                            Sub-Categoria
                        </Col>
                        <Col sm={8}>
                            <FormControl onChange={this.handleSelectChange.bind(this)} componentClass="select" placeholder="select">
                                {this.state.subcategorias.map((subCategoria, index)=>(
                                    <option key={index} value={subCategoria.idsubcategoria}>{subCategoria.nombresubcategoria}</option>
                                ))}


                            </FormControl>
                        </Col>
                    </FormGroup>
                    <FormGroup controlId="nombreproducto">
                        <Col componentClass={ControlLabel} sm={2}>
                            Nombre
                        </Col>
                        <Col sm={8}>
                            <FormControl name="nombreproducto"
                                         type="text" value={this.state.producto.nombreproducto}
                                         onChange={this.handleTextChange.bind(this)}/>
                        </Col>
                    </FormGroup>

                    <FormGroup controlId="codigoproducto">
                        <Col componentClass={ControlLabel} sm={2}>
                            Codigo
                        </Col>
                        <Col sm={8}>
                            <FormControl name="codigoproducto"
                                         type="text" value={this.state.producto.codigoproducto}
                                         onChange={this.handleTextChange.bind(this)}/>
                        </Col>
                    </FormGroup>
                    <FormGroup controlId="precioproducto">
                        <Col componentClass={ControlLabel} sm={2}>
                            Precio
                        </Col>
                        <Col sm={8}>
                            <FormControl name="precioproducto"
                                         type="text" value={this.state.producto.precioproducto}
                                         onChange={this.handleTextChange.bind(this)}/>
                        </Col>
                    </FormGroup>
                    <FormGroup controlId="descripcionproducto">
                        <Col componentClass={ControlLabel} sm={2}>
                            Descripcion
                        </Col>
                        <Col sm={8}>
                            <FormControl name="descripcionproducto"
                                         type="text" value={this.state.producto.descripcionproducto}
                                         onChange={this.handleTextChange.bind(this)}/>
                        </Col>
                    </FormGroup>
                    <FormGroup controlId="stock">
                        <Col componentClass={ControlLabel} sm={2}>
                            Stock
                        </Col>
                        <Col sm={8}>
                            <FormControl name="stock"
                                         type="text" value={this.state.producto.stock}
                                         onChange={this.handleTextChange.bind(this)}/>
                        </Col>
                    </FormGroup>
                      <FormGroup controlId="linkimagenproducto">
                        <Col componentClass={ControlLabel} sm={2}>
                            Link de imagen
                        </Col>
                        <Col sm={8}>
                            <FormControl name="linkimagenproducto"
                                         type="text" value={this.state.producto.linkimagenproducto}
                                         onChange={this.handleTextChange.bind(this)}/>
                        </Col>
                    </FormGroup>
                    <FormGroup>
                        <Col smOffset={2} sm={8}>
                            <Button onClick={this.handleSubmit}>Guardar</Button>
                        </Col>
                    </FormGroup>
                </Form>
            </div>
        );
    }

}

const mapState = state => {
    return {
        result: state.producto.result || {},
        actionType: state.producto.actionType
    }
};

const mapDispatch = {
    fetchProductoSave
};

export default connect(mapState, mapDispatch)(ProductoForm);