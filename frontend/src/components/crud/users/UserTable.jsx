import React, {Component} from 'react';
import {Table} from "react-bootstrap";
import {connect} from "react-redux";
import {loadUsers} from "../../../actions/adminAction"
class UserTable extends Component {

  componentDidMount() {
    this.props.loadUsers()
  }

  render() {
    let cells = this.props.userList.map((x,i) =>
      (<tr key={"rw" + i}>
        <td key={"nk" + i}>{x.nickname}</td>
        <td key={"em"+i}>{x.email} {x.emailValidated && <i className="fas fa-check-circle"/>}</td>
        <td key={"ps"+i}>{x.hashPassword}</td>
      </tr>)
    );

    return (
      <Table responsive>
        <thead>
        <tr>
          <th>NickName</th>
          <th>Email</th>
          <th>HashPassword</th>
        </tr>
        </thead>
        <tbody>
        {cells}
        </tbody>
      </Table>
    );
  }
}

const mapState = (state) => {
  return {
    userList: state.admin.userList
  }
};
const mapDispatch = {
  loadUsers
};

export default connect(mapState,mapDispatch)(UserTable);