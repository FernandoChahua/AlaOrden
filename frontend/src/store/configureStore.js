import {applyMiddleware, createStore} from 'redux'
import rootReducer from "../reducers/rootReducer";
import thunk from "redux-thunk";

const configureStore = () => {
  createStore(rootReducer, applyMiddleware(thunk));
};

export default configureStore;

// export default function configureStore() {
//   return createStore(
//       rootReducer,
//       window.__REDUX_DEVTOOLS_EXTENSION__ && window.__REDUX_DEVTOOLS_EXTENSION__(),
//       applyMiddleware(thunk)
//   );
// }