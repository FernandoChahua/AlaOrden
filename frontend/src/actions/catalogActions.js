import {SET_QUERY, UPDATE_LIST_QUERY, SET_RESULTS, LOAD_CATEGORY_LIST, TOGGLE_LIST} from "./actions";
import axios from "axios";

export function loadCategories() {
  return (dispatch, getState) => {

    if (getState().catalog.categories.length === 0){
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
}

//TODO: implement query search
export function loadResults(params = '') {
  return (dispatch, getState) => {

    axios
      .get(`api/serv/productos${"/"+ params}`)
      .then(function (response) {
        dispatch(_loadCatalog(response.data))
      }).catch(function (error) {
      console.log(error);
    });
  }
}


export function setQuery(query, params) {
  return (dispatch) => {
    dispatch(_setQuery(query));
  }
}

export function addToList(query) {
  return (dispatch, getState) => {
    let list = getState().catalog.list;

    dispatch(_updateListQuery([...list, query]));
  }
}

export function removeFromList(index) {
  return (dispatch, getState) => {
    let list = getState().catalog.list;

    dispatch(_updateListQuery(list.splice(0,index)));
  }
}

export function searchFromList(index) {
  return (dispatch) => {

  }
}

export function toggleList() {
  return (dispatch) => {

    dispatch(_toggleList())
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