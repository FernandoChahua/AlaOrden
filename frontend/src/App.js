import React, {Component} from 'react';
import './App.css';
import Header from "./components/layout/Header";
import ShoppingList from "./components/home/ShoppingList";
import MainBody from "./components/home/MainBody";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            ordering: false,
            body: "search"
        };
        this.toggleList = this.toggleList.bind(this);
        this.changeBody = this.changeBody.bind(this);

        this.header = React.createRef();
    }


    toggleList(){
        const { openlist, body } = this.state;
        this.setState({ "openlist": !openlist, "body": body });
    }

    changeBody(body, params = {}){
        const { openlist } = this.state;
        this.setState({"openlist": openlist, "body": body});
    }



    render() {
        return (
            <div className="App">
                <Header ref={this.header} toggleList={this.toggleList} changeBody={this.changeBody}/>
                <div className="d-flex">
                    <div id="sidebar">
                        <ShoppingList openlist={this.state.openlist} toggleList={this.toggleList} changeBody={this.changeBody}/>
                    </div>
                    <div id="body" className="flex-grow-1">
                        <div id="content">
                            <MainBody body={this.state.body} changeBody={this.changeBody}/>
                        </div>
                    </div>
                </div>
            </div>
        );
    }
}

export default App;
