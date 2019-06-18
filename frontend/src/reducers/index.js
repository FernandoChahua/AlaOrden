import {combineReducers} from 'redux';
import task from './task';
import account from './account';
import categoria from './categoria';
import subcategoria from './subcategoria';
import producto from './producto';
import pedido from './pedido';
import detallePedido from './detallePedido';
import cupon from './cupon';

export default combineReducers({
    account, task, categoria,subcategoria,producto,pedido,detallePedido,cupon
});
