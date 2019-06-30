import React from 'react';
import axios from 'axios';
import ItemList from './ItemList'
import './App.css';

class App extends React.Component {
    state = {
        showData: [],

    };

    componentDidMount() {
        this.refreshData();
    }

    refreshData = () => {
        axios.get("http://localhost:8080/api/data")
            .then(result => {
                    this.setState({showData: result.data})
                }
            );
    }

    render() {
        return (
            <div>
                <div className="container-fluid">
                    <header>
                        <h5 className="baseline">WEB SCRAPER FOR www.lrt.lt</h5>
                    </header>
                </div>
                <div className="container">

                    <div className="col-sm-12">
                        <ItemList itemsToShow={this.state.showData}/>
                    </div>
                </div>
                <div className="container-fluid">
                    <footer>
                        Copyright 2019
                    </footer>
                </div>
            </div>
        );
    }
}

export default App;
