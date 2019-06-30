import React, {Component} from 'react';
import Item from "./Item";

class ItemList extends Component {

    render() {

        let itemsToShow = this.props.itemsToShow;

        return (
            <div className="container">
                {/*<h3 className="my-3 text-center">Šiuo metu Lietuvos nacionalinio radijo ir televizijos transliuotojas rodo: </h3>*/}
                <h3 className="my-3 text-center font-weight-bold">{this.props.title} </h3>
                <div>
                    {this.props.itemsToShow
                        .map(thisItem => <Item key={thisItem.id} item={thisItem}/>)}
                </div>
            </div>
        );
    }
}

export default ItemList;