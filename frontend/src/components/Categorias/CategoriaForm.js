import React from 'react';
import {FormGroup, ControlLabel, FormControl, Form, Button, Col} from 'react-bootstrap';
import connect from "react-redux/es/connect/connect";
import {SAVE_CATEGORIA} from "../../actions/actionTypes";
import PropTypes from "prop-types"
import {fetchCategoriaSave} from "../../actions/categoriaAction";

class CategoriaForm extends React.Component{

    initialState = {
        categoria: {
            nombrecategoria: "",
            descripcioncategoria: "",
            linkimagencategoria: ""
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
        this.setState({categoria: {...this.state.categoria,[fieldName]: fieldValue}})
    }


    componentWillReceiveProps(nextProps) {

        if(nextProps.actionType===SAVE_CATEGORIA){
            this.setState(this.initialState);
            this.props.afterSubmit();
        }
    }

    handleSubmit(){
        this.props.fetchCategoriaSave(this.state.categoria);
    }


    render() {
        return (
            <div>
                <h4>Registro de Categorias: </h4>
                <Form horizontal>

                    <FormGroup controlId="nombrecategoria">
                        <Col componentClass={ControlLabel} sm={2}>
                            Nombre
                        </Col>
                        <Col sm={8}>
                            <FormControl name="nombrecategoria"
                                         type="text" value={this.state.nombrecategoria}
                                         onChange={this.handleTextChange.bind(this)}/>
                        </Col>
                    </FormGroup>

                    <FormGroup controlId="descripcioncategoria">
                        <Col componentClass={ControlLabel} sm={2}>
                            Descripcion
                        </Col>
                        <Col sm={8}>
                            <FormControl name="descripcioncategoria"
                                         type="text" value={this.state.descripcioncategoria}
                                         onChange={this.handleTextChange.bind(this)}/>
                        </Col>
                    </FormGroup>

                    <FormGroup controlId="linkimagencategoria">
                        <Col componentClass={ControlLabel} sm={2}>
                            Link de la imagen
                        </Col>
                        <Col sm={8}>
                            <FormControl name="linkimagencategoria"
                                         type="text" value={this.state.linkimagencategoria}
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
        result: state.categoria.result || {},
        actionType: state.categoria.actionType
    }
};

const mapDispatch = {
    fetchCategoriaSave
};



export default connect(mapState, mapDispatch)(CategoriaForm);