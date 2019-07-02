import React, {Component} from 'react';
import {Alert, Button, Table} from "react-bootstrap";
import {connect} from "react-redux";
import {loadUsers,saveUser,deleteUser} from "../../../actions/adminAction"
import UserDialog from "./UserDialog";

class UserTable extends Component {
  constructor(props) {
    super(props);

    this.state = {
      editing: false,
      showDialog: false,
      user: { },
    };

    this.createUser = this.createUser.bind(this);
    this.editUser = this.editUser.bind(this);
    this.removeUser = this.removeUser.bind(this);
  }

  componentDidMount() {
    this.props.loadUsers()
  }

  createUser() {
    this.setState({
      editing: false,
      showDialog: true,
      user: {
        nickname: '',
        email: '',
        hashPassword: ''
      }
    });
  }

  editUser(index) {
    this.setState({
      editing: true,
      showDialog: true,
      user: this.props.userList[index]
    });
  }

  removeUser(index){
    if (window.confirm("Desea eliminar este usuario")){
      this.props.deleteUser(this.props.userList[index].idUser);
    }
  }

  render() {
    let content = this.props.userList.length > 0 &&
      this.props.userList.map((x, i) =>
        (<tr key={"rw" + i}>
          <td key={"nk" + i}>{x.nickname}</td>
          <td key={"em" + i}>{x.email} {x.emailValidated && <i className="fas fa-check"/>}</td>
          <td key={"st" + i}>{x.state === 1? "Activo" : x.state ===2 ? "Inactivo" : "Baneado"}</td>
          <td key={"ps" + i}>{x.hashPassword}</td>
          <td key={"ct" + i}>
            <a key ={"edt"+i} href="javascript:void(0)" onClick={() => {this.editUser(i)}}>Editar</a> ||
            <a key ={"del"+i} href="javascript:void(0)" onClick={() => {this.removeUser(i)}}>Borrar</a>
          </td>
        </tr>));


    let dialogProps = {
      editing: this.state.editing,
      show: this.state.showDialog,
      user: this.state.user,
      handleChange: this.handleChange,
      onHide: () => {this.setState({...this.state, showDialog: false })},
      save: this.props.saveUser,
    };

    return (
      <div>
        <div className="d-flex justify-content-between" style={{width: "70%"}}>
          <h4>Lista de Usuarios</h4>
          <Button onClick={this.createUser.bind(this)}>Nuevo</Button>
          <UserDialog {...dialogProps} />
        </div>
        <div className="table-container">
          {this.props.userList.length === 0 && <Alert variant="secondary">No se ha encontrado ningun registro</Alert>}
          <Table responsive>
            <thead>
            <tr>
              <th>NickName</th>
              <th>Email</th>
              <th>Estado</th>
              <th>HashPassword</th>
            </tr>
            </thead>
            <tbody>
            {content}
            </tbody>
          </Table>
        </div>
      </div>
    );
  }
}

const mapState = (state) => {
  return {
    userList: state.admin.userList
  }
};
const mapDispatch = {
  loadUsers,
  saveUser,
  deleteUser,
};

export default connect(mapState, mapDispatch)(UserTable);