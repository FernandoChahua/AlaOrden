import {
    ADD_LIST_QUERY,
    GET_SEARCH_RESULTS,
    DELETE_LIST_QUERY,
    ADD_FILTER,
    GET_QUERY_RESULTS,
    LOAD_INIT_CATALOG, LOAD_CATEGORY_LIST
} from "./actions";

const _loadCategories = (categories) => {
    return {
        type: LOAD_CATEGORY_LIST,
        categories
    }
};

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