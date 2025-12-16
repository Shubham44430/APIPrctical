import React from "react";   //node_Modules folder
import ReactDOM from "react-dom/client";  //node_Modules folder

import projectroute from "./projectroute";

console.log(React);
console.log(ReactDOM);

const app = ReactDOM.createRoot(document.getElementById("root"));

app.render(projectroute);