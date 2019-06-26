import {
    ADD_FILTER,
    ADD_LIST_QUERY,
    DELETE_LIST_QUERY,
    GET_SEARCH_RESULTS,
    GET_QUERY_RESULTS,
    LOAD_INIT_CATALOG
} from "../actions/actions";


export default function catalogReducer(state = {list:[]}, action) {
    switch (action.type) {
        case LOAD_INIT_CATALOG:
            return Object.assign({},state,
                {results: action.results});
        case GET_SEARCH_RESULTS:
            return Object.assign({},state,
                {results:action.results, query:''});
        case ADD_LIST_QUERY:
            return Object.assign({},state,
                {list: state.list.concat([action.query])});
        case DELETE_LIST_QUERY:
            return Object.assign({},state,
                {list: state.list.splice(0,action.index)});
        case GET_QUERY_RESULTS:
            return Object.assign({},state,
                {results:action.results});
        case ADD_FILTER:
            return Object.assign({},state,
                {query: state.query.concat(action.filter)})
        default:
            return state;
    }
}