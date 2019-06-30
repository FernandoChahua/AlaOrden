import {applyMiddleware, createStore} from 'redux'
import { composeWithDevTools } from 'redux-devtools-extension';
import rootReducer from "../reducers/rootReducer";
import thunk from "redux-thunk";

const composeEnhancers = composeWithDevTools({ });


export default function configureStore() {
  return createStore(
    rootReducer, composeEnhancers(applyMiddleware(thunk))
  );
}
