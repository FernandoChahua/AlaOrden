import {SET_QUERY, UPDATE_LIST_QUERY, SET_RESULTS, LOAD_CATEGORY_LIST, TOGGLE_LIST, LOAD_PRODUCTS} from "./actions";
import axios from "axios";

export function loadCategories() {
  return (dispatch, getState) => {

    if (getState().catalog.categories.length === 0) {
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
export function loadProducts() {
  return (dispatch, getState) => {

    axios
      .get(`api/serv/productos/`)
      .then(function (response) {
        dispatch(_loadCatalog(response.data))
      }).catch(function (error) {
      console.log(error);
    });
  }
}

export function getResults(query) {
  return (dispatch, getState) => {
    let products = getState().catalog.products;
    let results = products;
    if (query.length > 0) {
      query = query.toLowerCase();
      results = products.filter(x =>
        x.name.toLowerCase().includes(query) ||
        x.brand.name.toLowerCase().includes(query) ||
        x.packaging.toLowerCase().includes(query));
    }
    dispatch(_setResults(results));
  }
}

export function showCategories(categoryId) {
  return (dispatch, getState) => {
    let products = getState().catalog.products;
    let results = products.filter(x =>
      x.category.idCategory === categoryId);
    dispatch(_setResults(results));
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

    dispatch(_updateListQuery(list.splice(0, index)));
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


const _loadCatalog = (products) => {
  return {
    type: LOAD_PRODUCTS,
    products
  }
};

const _setResults = (results) => {
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