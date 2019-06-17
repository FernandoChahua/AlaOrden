import React, {Component} from 'react';
import './App.css';
import Header from "./components/layout/Header";
import ShoppingList from "./components/Home/ShoppingList";
import SearchResult from "./components/Home/SearchResult";

class App extends Component {
    constructor(props) {
        super(props);
        this.state = {
            openlist: false
        }
        this.toggleList = this.toggleList.bind(this);
    }


    toggleList(){
        const { openlist } = this.state;
        this.setState({ "openlist": !openlist});
    }

    render() {
        return (
            <div className="App">
                <Header toggleList={this.toggleList}/>
                <div className="d-flex">
                    <div id="sidebar">
                        <ShoppingList openlist={this.state.openlist} toggleList={this.toggleList}/>
                    </div>
                    <div id="body" className="flex-grow-1 bg-light">
                        <SearchResult/>
                    </div>
                </div>
            </div>
        );
    }
}

export default App;
