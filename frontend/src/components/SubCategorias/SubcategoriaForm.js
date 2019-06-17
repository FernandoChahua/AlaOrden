import React from 'react';
import {FormGroup, ControlLabel, FormControl, Form, Button, Col} from 'react-bootstrap';
import {fetchSubcategoriaSave} from "../../actions/subcategoriaAction";
import connect from "react-redux/es/connect/connect";
import {SAVE_SUBCATEGORIA} from "../../actions/actionTypes";
import PropTypes from "prop-types";


class SubcategoriaForm extends React.Component {

     initialState = {
        categorias: [],
        subcategoria: {
            nombresubcategoria: "",
            descripcionsubcategoria: "",
            linkimagensubcategoria: "",
            categoria: {
                idcategoria: 1
            }
        }
    };

    static propTypes = {
        categorias: PropTypes.array.isRequired,
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
        this.setState({subcategoria: {...this.state.subcategoria,[fieldName]: fieldValue}})
    }

    handleSelectChange(event) {
        let fieldValue = event.target.value;
        this.setState({subcategoria:{...this.state.subcategoria, categoria: {idcategoria: fieldValue}}})
    }

    componentWillReceiveProps(nextProps) {
        if (nextProps.categorias) {
            this.setState({categorias: nextProps.categorias})
        }

        if(nextProps.actionType===SAVE_SUBCATEGORIA){
            this.setState(this.initialState);
            this.props.afterSubmit();
        }
    }

    handleSubmit(){
        this.props.fetchSubcategoriaSave(this.state.subcategoria);
    }

        render() {
            return (
                <div>
                    <h4>Registro de Sub-categorias: </h4>
                    <Form horizontal>
                        <FormGroup controlId="nombrecategoria">
                            <Col componentClass={ControlLabel} sm={2}>
                                Categoria
                            </Col>
                            <Col sm={8}>
                                <FormControl onChange={this.handleSelectChange.bind(this)} componentClass="select" placeholder="select">
                                    {this.state.categorias.map((categoria, index)=>(
                                        <option key={index} value={categoria.idcategoria}>{categoria.nombrecategoria}</option>
                                    ))}


                                </FormControl>
                            </Col>
                        </FormGroup>
                        <FormGroup controlId="nombresubcategoria">
                            <Col componentClass={ControlLabel} sm={2}>
                                Nombre
                            </Col>
                            <Col sm={8}>
                                <FormControl name="nombresubcategoria"
                                             type="text" value={this.state.subcategoria.nombresubcategoria}
                                             onChange={this.handleTextChange.bind(this)}/>
                            </Col>
                        </FormGroup>

                        <FormGroup controlId="descripcionsubcategoria">
                            <Col componentClass={ControlLabel} sm={2}>
                                Descripcion
                            </Col>
                            <Col sm={8}>
                                <FormControl name="descripcionsubcategoria"
                                             type="text"  value={this.state.subcategoria.descripcionsubcategoria}
                                             onChange={this.handleTextChange.bind(this)}/>
                            </Col>
                        </FormGroup>
                        <FormGroup controlId="linkimagensubcategoria">
                            <Col componentClass={ControlLabel} sm={2}>
                                Link de imagen
                            </Col>
                            <Col sm={8}>
                                <FormControl name="linkimagensubcategoria"
                                             type="text"  value={this.state.subcategoria.linkimagensubcategoria}
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
        result: state.subcategoria.result || {},
        actionType: state.subcategoria.actionType
    }
};

const mapDispatch = {
    fetchSubcategoriaSave
};

export default connect(mapState, mapDispatch)(SubcategoriaForm);