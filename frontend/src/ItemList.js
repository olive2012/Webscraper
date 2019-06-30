import React, {Component} from 'react';
import Item from "./Item";

class ItemList extends Component {

    render() {
        return (
            <div className="container">
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