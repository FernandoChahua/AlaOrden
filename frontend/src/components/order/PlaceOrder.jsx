import React, {Component} from 'react'
import Tab from 'react-bootstrap/Tab'
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import Nav from "react-bootstrap/Nav";
import Location from "./Location";
import Quotation from "./Quotation/Quotation";
import Payment from "./Payment";
import Receipt from "./Receipt";
import Stepper from 'react-stepper-horizontal'

class PlaceOrder extends Component {
    constructor(props) {
        super(props);
        this.state = {
            activeStep: 1
        };
        this.setStep = this.setStep.bind(this);
    }

    setStep(step) {
        if (this.state.step < step){
            this.setState({activeStep:step});
        }
    }

    render() {

        let activeStep = this.state.activeStep;
        let steps =  [
            {title: 'Dirección', href: ''},
            {title: 'Cotización', href: ''},
            {title: 'Pago', href: ''},
            {title: 'Confirmación', href: ''}
        ];

        return (
            <div id="stepper" >
                <Stepper steps={steps} activeStep={activeStep} />
                <Tab.Container id="steps" defaultActiveKey="1">
                    <Row>
                        <Col>
                            <Nav fill variant="pills" className="flex-row">
                                <Nav.Item>
                                    <Nav.Link eventKey="1">Direccion</Nav.Link>
                                </Nav.Item>
                                <Nav.Item>
                                    <Nav.Link eventKey="2">Cotizacion</Nav.Link>
                                </Nav.Item>
                                <Nav.Item>
                                    <Nav.Link eventKey="3">Pago</Nav.Link>
                                </Nav.Item>
                                <Nav.Item>
                                    <Nav.Link eventKey="4">Recibo</Nav.Link>
                                </Nav.Item>
                            </Nav>
                        </Col>
                    </Row>
                    <Row>
                        <Col>
                            <Tab.Content>
                                <Tab.Pane eventKey="1">
                                    <Location/>
                                </Tab.Pane>
                                <Tab.Pane eventKey="2">
                                    <Quotation/>
                                </Tab.Pane>
                                <Tab.Pane eventKey="3">
                                    <Payment/>
                                </Tab.Pane>
                                <Tab.Pane eventKey="4">
                                    <Receipt/>
                                </Tab.Pane>
                            </Tab.Content>
                        </Col>
                    </Row>
                </Tab.Container>
            </div>
        );
    }
}

export default PlaceOrder;