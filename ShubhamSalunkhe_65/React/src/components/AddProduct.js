import axios from 'axios'
import React, { useRef } from 'react'


export default function AddOrder() {

  let x1=useRef();
  let x2=useRef();
  let x3=useRef();

function myfun() {
  console.log(x1.current.value);
  console.log(x2.current.value);
  console.log(x3.current.value);

  axios.
  post("http://localhost:5000/api/order/{id}" ,{
    id:x1.current.value,
    price:x2.current.value,
    stock:x3.current.value
  })
  
}

  return (
    <div class="container">
        <h1>New Product</h1>        
        <input ref={x1} type="text" placeholder="Enter ID"/>
      <br /><br />
        <input ref={x2} type="text" placeholder="Enter price"/>
      <br /><br />
      <input ref={x3} type="text" placeholder="Enter Stock" />
      <br /><br />
      <button onClick={myfun}>Register</button>
    </div>
  )
}
