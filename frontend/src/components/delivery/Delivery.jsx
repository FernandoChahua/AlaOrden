import React, {Component} from 'react'
import Container from "react-bootstrap/Container";
import Row from "react-bootstrap/Row";
import Col from "react-bootstrap/Col";
import {Button, Dropdown, Form} from "react-bootstrap";

class Delivery extends Component {
  initMap = () => {
    var marker;
    var map;
    var geocoder;
    var infowindow;

    if (navigator.geolocation) {
      navigator.geolocation.getCurrentPosition(function (position) {
        var pos = {
          lat: position.coords.latitude,
          lng: position.coords.longitude
        };
        geocoder = new window.google.maps.Geocoder;
        infowindow = new window.google.maps.InfoWindow;
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
                if (document.getElementById("autocomplete"))
                  document.getElementById("autocomplete").value = results[0].formatted_address;
              } else {
                window.alert('No results found');
              }
            } else {
              window.alert('Geocoder failed due to: ' + status);
            }
          });
        }

        window.google.maps.event.addListener(map, 'click', function (event) {
          geocodeLatLng(event.latLng);
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
    loadScript("https://maps.googleapis.com/maps/api/js?key=AIzaSyDzB-76_WJJt-fAqyqnT23jyCpNwm3jqcg&libraries=places&callback=initMap");
    window.initMap = this.initMap;
  };

  componentDidMount() {
    this.renderMap();
  };


  render() {
    return (
        <Container className="text-left">
          <Row>
            <Col className="md-8">
              <br></br>
              <div>
                <h4>Direccion de Entrega</h4>
              </div>

              <hr className="mb-2"/>

              <div className="pr-5 m-4">




                <div className="input-group-append">
                  <h6 className="mb-3">Direccion Reciente</h6>
                </div>
                <br></br>
                <Form>

                  <select className="form-control" id="selDireccion">
                    <option>Calle xxx Nro ###</option>
                    <option>Calle yyy Nro ###</option>
                  </select>
                </Form>
                <br></br>

                <div className="d-flex justify-content-between mb-4">
                  <h6 className="mb-3">Direccion Nueva</h6>
                  <div className="form-check">
                    <input className="form-check-input" type="checkbox" id="chkRecordar"/>
                    <Form.Label className="form-check-label" for="chkRecordar">Recordar</Form.Label>
                  </div>
                </div>
                <Form>
                  <section className="container mt-3">
                    <input id="autocomplete" className="form-control " type="text"></input>
                  </section>

                </Form>
                <br></br>
                <section id="map" className="container mt-3 mb-3">
                </section>
                <br></br>
                <hr className="mb-2"></hr>
                <br></br>
                <Row>
                  <Col>
                    <Button variant="outline-primary" block onClick={this.register}>Cancelar</Button>
                  </Col>
                  <Col>
                    <Button block onClick={this.register}>Siguiente</Button>
                  </Col>
                </Row>
              </div>
            </Col>
          </Row>
        </Container>
    )
  }
}


function loadScript(url) {
  var script = window.document.createElement("script");
  var index = window.document.getElementsByTagName("script")[0];
  script.src = url;
  script.async = true;
  script.defer = true;
  index.parentNode.insertBefore(script, index);
}

export default Delivery;