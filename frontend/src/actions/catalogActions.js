import {
    ADD_LIST_QUERY,
    GET_SEARCH_RESULTS,
    DELETE_LIST_QUERY,
    ADD_FILTER,
    GET_QUERY_RESULTS,
    LOAD_INIT_CATALOG
} from "./actions";

export function loadInitCatalog(results) {
    return {
        type: LOAD_INIT_CATALOG,
        results
    }
}

export function getSearchResults(results) {
    return {
        type: GET_SEARCH_RESULTS,
        results
    }
}

export function addListQuery(query) {
    return {
        type: ADD_LIST_QUERY,
        query
    }
}

export function deleteListQuery(index) {
    return {
        type: DELETE_LIST_QUERY,
        index
    }
}

export function addFilter(filter) {
    return {
        type: ADD_FILTER,
        filter
    }

}

export function getQueryResults(results) {
    return {
        type: GET_QUERY_RESULTS,
        results
    }
}