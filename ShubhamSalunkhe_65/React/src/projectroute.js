import { BrowserRouter,Route, Routes } from "react-router";

import ShowOrders from "./components/ShowOrders";
import ShowPoducts from "./components/ShowPoducts";
import AddOrder from "./components/AddOrder";
import AddProduct from "./components/AddProduct";
import Findproduct from "./components/Findproduct";
import Findorder from "./components/Findorder";
import Body from "./components/Body";

import App from "./components/App";


let projectroute=
(
    <BrowserRouter>
        <Routes>
            <Route path="" element={<App/>}>
                <Route path="" element={<Body/>}/>
                <Route path="/showorder" element={<ShowOrders/>}/>
                <Route path="/showproduct" element={<ShowPoducts/>}/>
                <Route path="/addorder" element={<AddOrder/>}/>
                <Route path="/addproduct" element={<AddProduct/>}/>
                <Route path="/findproduct" element={<Findproduct/>}/>
                <Route path="/findorder" element={<Findorder/>}/>
            </Route>
        </Routes>
    </BrowserRouter>
)

export default projectroute;