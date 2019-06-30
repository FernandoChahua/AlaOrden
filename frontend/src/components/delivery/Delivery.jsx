import React, {Component} from 'react'
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import {Button, Form} from "react-bootstrap";
import {compose} from "redux";
import {connect} from "react-redux";
import {withRouter} from "react-router-dom";
import loadScript from "../../util/ScriptLoader";
import {loadAddress, pickAddress} from "../../actions/deliveryActions";


let apiKey = "AIzaSyDzB-76_WJJt-fAqyqnT23jyCpNwm3jqcg";
//apiKey = "";

/*
local:
state: addressList, address
dispatch:
 */
class Delivery extends Component {
  constructor(props) {
    super(props);

    this.state = {
      using: 'old',
      save: true,
      address: {},
      lat: 0,
      lng: 0,
      dir: ''
    };

    this.goToQuotation = this.goToQuotation.bind(this);
    this.handleSelect = this.handleSelect.bind(this);
  }

  handleSelect(event) {
    let state = this.state;
    this.setState(Object.assign({}, state, {address: event.target.value}));
  }

  changeGeoLoc() {

  }

  goToQuotation() {
    this.props.setAddress({
        latitude: this.state.lat,
        longitude: this.state.lng,
        description: this.state.dir
      }, this.state.save,this.props.history);
  }

  componentDidMount() {
    if (apiKey !== "")
      this.renderMap();
    this.props.loadAddress()
  };

  render() {
    return (
      <Container className="text-left">
        <Row>
          <Col className="md-8">
            <br/>
            <div>
              <h4>Direccion de Entrega</h4>
            </div>
            <hr className="mb-2"/>
            <div className="pr-5 m-4">
              <div className="input-group-append">
                <Form.Check type="radio" name="usingAddress"/>
                <h6 className="mb-3">Direccion Reciente</h6>
              </div>
              <br/>
              <h6>___ {this.state.address.description}</h6>
              <h6>LAT {this.state.lat}</h6>
              <h6>LNG {this.state.lng}</h6>
              <h6>DIR {this.state.dir}</h6>
              <Form>
                <select className="form-control" id="selDireccion"
                        value={this.state.address} onChange={this.handleSelect}>
                  <option value={{}}>Seleccione Dirección</option>
                  {this.props.addressList.map((x, i) => (<option key={i} value={x}>{x.description}</option>))}
                </select>
              </Form>
              <br/>
              <div className="d-flex justify-content-between mb-4">

                <div className="d-inline-flex">
                  <Form.Check type="radio" name="usingAddress"/>
                  <h6 className="mb-3">Direccion Nueva</h6>
                </div>

                <div className="form-check">
                  <input className="form-check-input" type="checkbox" id="chkRecordar"
                         checked={this.state.save}
                         onChange={() => this.setState({...this.state, save: !this.state.save})}/>
                  <Form.Label className="form-check-label" htmlFor="chkRecordar">Recordar</Form.Label>
                </div>
              </div>
              <Form>
                <section className="container mt-3">
                  <input id="autocomplete" className="form-control " type="text" onChange={this.changeGeoLoc}/>
                </section>
              </Form>
              <br/>
              <section id="map" className="container mt-3 mb-3">
              </section>
              <br/>
              <hr className="mb-2"/>
              <br/>
              <Row>
                <Col>
                  <Button variant="outline-primary" block onClick={this.register}>Cancelar</Button>
                </Col>
                <Col>
                  <Button block onClick={this.goToQuotation}>Siguiente</Button>
                </Col>
              </Row>
            </div>
          </Col>
        </Row>
      </Container>
    )
  }

  initMap = () => {
    let marker;
    let map;
    let geocoder;
    let infowindow;

    const me = this;
    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(function (position) {
        let pos = {
          lat: position.coords.latitude,
          lng: position.coords.longitude
        };
        geocoder = new window.google.maps.Geocoder();
        infowindow = new window.google.maps.InfoWindow();
        map = new window.google.maps.Map(document.getElementById("map"), {
          center: {
            lat: pos.lat,
            lng: pos.lng
          },
          zoom: 20
        });

        marker = new window.google.maps.Marker({
          position: pos,
          map: map,
          draggable: false,
          animation: window.google.maps.Animation.DROP
        });
        geocodeLatLng(pos);

        function addMarker(location, map) {
          marker.setMap(null);
          marker = new window.google.maps.Marker({
            position: location,
            map: map,
            draggable: false,
            animation: window.google.maps.Animation.DROP
          });
          map.setCenter(location);
          map.setZoom(18);
        }

        var autocomplete = document.getElementById('autocomplete');
        const search = new window.google.maps.places.Autocomplete(autocomplete);
        search.bindTo("bounds", map);
        search.addListener('place_changed', function () {
          var place = search.getPlace();
          if (!place.geometry.viewport) {
            window.alert("Error al mostrar el lugar");
            return;
          }
          if (place.geometry.viewport) {
            map.fitBounds(place.geometry.viewport);
            geocodeLatLng(place.geometry.location, map);
          } else {
            geocodeLatLng(place.geometry.location, map);
          }

        });

        function geocodeLatLng(longitud) {
          var latlng = longitud;
          geocoder.geocode({
            'location': latlng
          }, function (results, status) {
            if (status === 'OK') {
              if (results[0]) {
                addMarker(longitud, map);
                infowindow.setContent(results[0].formatted_address);
                infowindow.open(map, marker);
                if (document.getElementById("autocomplete")) {
                  document.getElementById("autocomplete").value = results[0].formatted_address;

                  me.setState({lat: latlng.lat, lng: latlng.lng, dir: results[0].formatted_address});
                }
              } else {
                window.alert('No results found');
              }
            } else {
              window.alert('Geocoder failed due to: ' + status);
            }
          });
        }

        window.google.maps.event.addListener(map, 'click', function (event) {
          let pos2 = {
            lat: event.latLng.lat(),
            lng: event.latLng.lng()
          };
          geocodeLatLng(pos2);
        });
      }, function () {
        handleLocationError(true, infowindow, map.getCenter());
      });
    } else {
      handleLocationError(false, infowindow, map.getCenter());
    }

    function handleLocationError(browserHasGeolocation, infoWindow, pos) {
      infoWindow.setPosition(pos);
      infoWindow.setContent(browserHasGeolocation ?
        'Error: The Geolocation service failed.' :
        'Error: Your browser doesn\'t support geolocation.');
    }
  };
  renderMap = () => {
    loadScript(`https://maps.googleapis.com/maps/api/js?key=${apiKey}&libraries=places&callback=initMap`, "google-maps-api");
    window.initMap = this.initMap;
  };
}

const mapState = state => {
  return {
    addressList: state.delivery.addressList
  }
};

const mapDispatch = {
  loadAddress: loadAddress,
  setAddress: pickAddress
};

export default compose(withRouter, connect(mapState, mapDispatch))(Delivery);