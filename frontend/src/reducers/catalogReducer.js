import {
  ADD_FILTER,
  UPDATE_LIST_QUERY,
  DELETE_LIST_QUERY,
  GET_SEARCH_RESULTS,
  GET_QUERY_RESULTS,
  SET_RESULTS, LOAD_CATEGORY_LIST, TOGGLE_LIST
} from "../actions/actions";


export default function catalogReducer(state = {list: [], results: []}, action) {
  switch (action.type) {
    case LOAD_CATEGORY_LIST:
      return Object.assign({}, state,
        {categories: action.categories});
    case SET_RESULTS:
      return Object.assign({}, state,
        {results: action.results});
    case GET_SEARCH_RESULTS:
      return Object.assign({}, state,
        {results: action.results, query: ''});
    case UPDATE_LIST_QUERY:
      return Object.assign({}, state,
        {list: state.list.concat([action.query])});
    case DELETE_LIST_QUERY:
      return Object.assign({}, state,
        {list: state.list.splice(0, action.index)});
    case GET_QUERY_RESULTS:
      return Object.assign({}, state,
        {results: action.results});
    case ADD_FILTER:
      return Object.assign({}, state,
        {query: state.query.concat(action.filter)});
    case TOGGLE_LIST:
      return Object.assign({}, state,
        { displayShopList: !state.displayShopList});
    default:
      return state;
  }
}