import {SET_QUERY, UPDATE_LIST_QUERY, SET_RESULTS, LOAD_CATEGORY_LIST, TOGGLE_LIST} from "./actions";
import axios from "axios";

export function loadCategories() {
  return (dispatch) => {
    axios
      .get("api/serv/categorias")
      .then(function (response) {
        //console.log(response);
        dispatch(_loadCategories(response.data))
      })
      .catch(function (error) {
        console.log(error);
      });
  }
}

export function loadResults() {
  return (dispatch, getState) => {

    axios
      .get("api/serv/productos")
      .then(function (response) {
        //console.log(response);
        dispatch(_loadCatalog(response.data))
      }).catch(function (error) {
        console.log(error);
      });


  }
}

export function addListQuery() {
  return (dispatch) => {

    dispatch(_updateListQuery())
  }
}

export function toggleList() {
  return (dispatch) => {

    dispatch(_toggleList())
  }
}

export function setQuery(query, params) {
  return (dispatch) => {

    dispatch(_setQuery(query));
  }
}

const _setQuery = (query) => {
  return {
    type: SET_QUERY,
    query
  }
};

const _loadCategories = (categories) => {
  return {
    type: LOAD_CATEGORY_LIST,
    categories
  }
};


const _loadCatalog = (results) => {
  return {
    type: SET_RESULTS,
    results
  }
};

const _updateListQuery = (list) => {
  return {
    type: UPDATE_LIST_QUERY,
    list
  }
};


const _toggleList = () => {
  return {
    type: TOGGLE_LIST
  }
};