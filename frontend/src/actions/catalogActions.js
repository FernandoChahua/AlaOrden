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
            .get("http://localhost:9090/api/serv/categorias")
            .then(function(response) {
                //console.log(response);
               categories = response.data;
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

        let productos = [
            {
                "idProduct": 1,
                "idCategory": 2,
                "category": null,
                "idBrand": 1,
                "brand": {
                    "name": "Gloria"
                },
                "name": "Leche Evaporada",
                "packaging": "paquete",
                "quantity": 4,
                "measure": 500,
                "unit": "g",
                "description": "Leche evaporada",
                "image": "1.jpg",
                "inventory": null
            },
            {
                "idProduct": 2,
                "idCategory": 2,
                "category": null,
                "idBrand": 1,
                "brand": {
                    "name": "Laive"
                },
                "name": "Leche Evaporada",
                "packaging": "paquete",
                "quantity": 4,
                "measure": 500,
                "unit": "g",
                "description": "Leche evaporada",
                "image": "2.jpg",
                "inventory": null
            },
            {
                "idProduct": 3,
                "idCategory": 2,
                "category": null,
                "idBrand": 1,
                "brand": {
                    "name": "IDEAL"
                },
                "name": "Leche Evaporada",
                "packaging": "paquete",
                "quantity": 4,
                "measure": 500,
                "unit": "g",
                "description": "Leche evaporada",
                "image": "3.jpg",
                "inventory": null
            },
            {
                "idProduct": 4,
                "idCategory": 2,
                "category": null,
                "idBrand": 1,
                "brand": {
                    "name": "Gloria"
                },
                "name": "Leche Evaporada",
                "packaging": "paquete",
                "quantity": 4,
                "measure": 500,
                "unit": "g",
                "description": "Leche evaporada",
                "image": "4.jpg",
                "inventory": null
            },
            {
                "idProduct": 5,
                "idCategory": 2,
                "category": null,
                "idBrand": 1,
                "brand": {
                    "name": "Gloria"
                },
                "name": "Leche Evaporada",
                "packaging": "paquete",
                "quantity": 4,
                "measure": 500,
                "unit": "g",
                "description": "Leche evaporada",
                "image": "5.jpg",
                "inventory": null
            },
            {
                "idProduct": 6,
                "idCategory": 2,
                "category": null,
                "idBrand": 1,
                "brand": {
                    "name": "Gloria"
                },
                "name": "Leche Evaporada",
                "packaging": "paquete",
                "quantity": 4,
                "measure": 500,
                "unit": "g",
                "description": "Leche evaporada",
                "image": "6.jpg",
                "inventory": null
            },
            {
                "idProduct": 7,
                "idCategory": 2,
                "category": null,
                "idBrand": 1,
                "brand": {
                    "name": "Gloria"
                },
                "name": "Leche Evaporada",
                "packaging": "paquete",
                "quantity": 4,
                "measure": 500,
                "unit": "g",
                "description": "Leche evaporada",
                "image": "7.jpg",
                "inventory": null
            },
            {
                "idProduct": 8,
                "idCategory": 2,
                "category": null,
                "idBrand": 1,
                "brand": {
                    "name": "Gloria"
                },
                "name": "Leche Evaporada",
                "packaging": "paquete",
                "quantity": 4,
                "measure": 500,
                "unit": "g",
                "description": "Leche evaporada",
                "image": "8.jpg",
                "inventory": null
            },{
                "idProduct": 9,
                "idCategory": 2,
                "category": null,
                "idBrand": 1,
                "brand": {
                    "name": "Gloria"
                },
                "name": "Leche Evaporada",
                "packaging": "paquete",
                "quantity": 4,
                "measure": 500,
                "unit": "g",
                "description": "Leche evaporada",
                "image": "9.jpg",
                "inventory": null
            },
        ];

        dispatch(_loadInitCatalog(productos))
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