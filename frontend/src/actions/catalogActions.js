import {
    ADD_LIST_QUERY,
    GET_SEARCH_RESULTS,
    DELETE_LIST_QUERY,
    ADD_FILTER,
    GET_QUERY_RESULTS,
    LOAD_INIT_CATALOG, LOAD_CATEGORY_LIST, TOGGLE_LIST
} from "./actions";
import axios from "axios";


export function loadCategories() {
    return (dispatch) => {
        let categories;
        axios
            .get("http://localhost:9090/api/categorias")
            .then(function(response) {
                //console.log(response);
               categories = response.data._embedded.categorias;
               console.log(categories);
               dispatch(_loadCategories(categories))
            })
            .catch(function(error) {
                console.log(error);
            });


    }
}

export function loadInitCatalog() {
    return (dispatch) => {

        dispatch(_loadInitCatalog())
    }
}

export function getSearchResults() {
    return (dispatch) => {

        dispatch(_getSearchResults())
    }
}
export function addListQuery() {
    return (dispatch) => {

        dispatch(_addListQuery())
    }
}

export function deleteListQuery() {
    return (dispatch) => {

        dispatch(_deleteListQuery())
    }
}

export function addFilter() {
    return (dispatch) => {

        dispatch(_addFilter())
    }
}

export function toggleList() {
    return (dispatch) => {

        dispatch(_toggleList())
    }
}

const _loadCategories = (categories) => {
    return {
        type: LOAD_CATEGORY_LIST,
        categories
    }
};

export function getQueryResults() {
    return (dispatch) => {

        dispatch(_getQueryResults())
    }
}

const _loadInitCatalog = (results) => {
    return {
        type: LOAD_INIT_CATALOG,
        results
    }
};

const _getSearchResults = (results) => {
    return {
        type: GET_SEARCH_RESULTS,
        results
    }
};

const _addListQuery = (query) => {
    return {
        type: ADD_LIST_QUERY,
        query
    }
};

const _deleteListQuery = (index) => {
    return {
        type: DELETE_LIST_QUERY,
        index
    }
};

const _addFilter = (filter) => {
    return {
        type: ADD_FILTER,
        filter
    }
};

const _getQueryResults = (results) => {
    return {
        type: GET_QUERY_RESULTS,
        results
    }
};

const _toggleList = () => {
    return {
        type: TOGGLE_LIST
    }
}