import React from 'react'

export default class AddRecord extends React.Component{

    constructor(){
        super();
        this.x2 = React.createRef();
        this.x3 = React.createRef();
    }
    render(){
        return(
            <div class="container">
            <h1>New User</h1>
            <input ref={this.x2} type="text" placeholder="Enter name"/>
          <br /><br />
          <input ref={this.x3} type="text" placeholder="Enter salary" />
          <br /><br />
          <button onClick={()=>{this.myfun()}}>Register</button>
        </div>
    )}
}