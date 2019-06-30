import React, {Component} from 'react';

class Item extends Component {

    render() {
        return (
            <div className="container">
                <div className="card my-3">
                    <h5 className="card-header">
                        <img className="card-img-top" src={"/images/" + this.props.item.channelName +".jpg"} alt="Card image cap"
                             style={{width: "70px"}}/>&nbsp;
                        {this.props.item.channelName}</h5>
                    <div className="card-body">
                        <h5 className="card-title">{this.props.item.showName}</h5>
                        <p className="card-text">{this.props.item.showTime}</p>
                    </div>
                </div>

            </div>
        );
    }
}

export default Item;