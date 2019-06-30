import React, {Component} from 'react';


class Item extends Component {
    //
    // deleteHandler = (event) => {
    //     this.props.deleteHandler(this.props.item.isbn)
    // }
    //
    // editHandler = (event) => {
    //     this.props.editHandler(this.props.item)
    // }

    render() {
        return (
            <div className="container">

            {/*<div className="card float-left" style={{width: '200px', margin: '10px'}}>*/}
                {/*/!*<img className="card-img-top" src={"https://picsum.photos/200/?image=" + Math.floor((Math.random() * 20) + 1)} alt="Card image cap"/>*!/*/}
                {/*<img className="card-img-top" src={this.props.item.image} alt="Card image cap"/>*/}
                {/*<div className="card-body">*/}
                    {/*<h5 className="card-title">{this.props.item.showTime}</h5>*/}
                    {/*<h6 className="card-text">{this.props.item.showName}</h6>*/}
                    {/*/!*<h6 className="card-text">({this.props.item.channelName}</h6>*!/*/}
                {/*</div>*/}
                {/*/!*<div className="card-footer">*!/*/}
                    {/*/!*<button onClick={this.editHandler} type="button" className="btn btn-success">Edit</button>&nbsp;*!/*/}
                    {/*/!*<button onClick={this.deleteHandler} type="button" className="btn btn-success">Delete</button>*!/*/}
                {/*/!*</div>*!/*/}
            {/*</div>*/}


                <div className="card my-3">
                    <h5 className="card-header">{this.props.item.channelName}</h5>
                    <div className="card-body">
                        <h5 className="card-title">{this.props.item.showName}</h5>
                        <p className="card-text">{this.props.item.showTime}</p>
                        {/*<a href="#" className="btn btn-primary">Go somewhere</a>*/}
                    </div>
                </div>

            </div>
        );
    }
}

export default Item;