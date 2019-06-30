import React from 'react';
import axios from 'axios';
import ItemList from './ItemList'
import './App.css';

class App extends React.Component {
    state = {
        showData: [],
        translations: {}
    };

    translations_lt =
        {title: 'ŽINIATINKLIO www.lrt.lt SKREPERIS', listTitle: 'Šiuo metu rodoma: '}


    translations_en =
        {title: 'WEB SCRAPER FOR www.lrt.lt', listTitle: 'Now on TV: '}


    componentDidMount() {
        this.setState({translations: this.translations_en});
        this.refreshData();
        setInterval(() => this.refreshData(), 10000);
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
                    <header className="d-flex justify-content-between">
                        <div>
                            <h5 className="baseline">{this.state.translations.title}</h5>
                        </div>

                        <div>
                            <button className="bg-dark text-white font-weight-bold mx-1"
                                    onClick={() => {this.setState({translations: this.translations_lt})
                            }}>LT
                            </button>
                            <button className="bg-dark text-white font-weight-bold mx-1"
                                    onClick={() => {this.setState({translations: this.translations_en})
                            }}>EN
                            </button>
                        </div>
                    </header>
                </div>
                <div className="container">

                    <div className="col-sm-12">
                        <ItemList itemsToShow={this.state.showData} title={this.state.translations.listTitle}/>
                    </div>
                </div>
                <div className="container-fluid">
                    <footer>
                        © 2019. All rights reserved
                    </footer>
                </div>
            </div>
        );
    }
}

export default App;
