import {
  SET_QUERY,
  UPDATE_LIST_QUERY,
  SET_RESULTS,
  LOAD_CATEGORY_LIST,
  TOGGLE_LIST,
  LOAD_PRODUCTS
} from "../actions/actions";

const initial = {
  list: [],
  products: [],
  results: [],
  categories: [],
  query: ''
};

export default function catalogReducer(state = initial, action) {
  switch (action.type) {
    case LOAD_CATEGORY_LIST:
      return Object.assign({}, state,
        {categories: action.categories});
    case LOAD_PRODUCTS:
      return Object.assign({}, state,
      { products: action.products ,results: action.products});
    case SET_RESULTS:
      return Object.assign({}, state,
        { results: action.results });
    case SET_QUERY:
      return Object.assign({}, state,
        {query: action.query});
    case UPDATE_LIST_QUERY:
      return Object.assign({}, state,
        {list: action.list});
    case TOGGLE_LIST:
      return Object.assign({}, state,
        { displayShopList: !state.displayShopList});
    default:
      return state;
  }
}