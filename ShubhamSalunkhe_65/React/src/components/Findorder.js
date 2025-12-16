import React, { useState } from "react";
import axios from "axios";

export default function FindOrder() {

  const [oid, setOid] = useState("");
  const [order, setOrder] = useState(null);
  const [error, setError] = useState("");

  const searchOrder = async () => {
    if (!oid) {
      setError("Please enter Order No");
      return;
    }

    try {
      const res = await axios.get(
        `http://localhost:5000/api/order/${oid}`
      );
      setOrder(res.data);
      setError("");
    } catch (err) {
      setOrder(null);
      setError("Order not found");
    }
  };

  return (
    <div className="container mt-4">
      <h2>Find Order</h2>

      <input
        type="text"
        className="form-control w-25"
        placeholder="Enter Order No"
        value={oid}
        onChange={(e) => setOid(e.target.value)}
      />
      <button className="btn" onClick={searchOrder}>
        Search
      </button>

      {error && <p className="text-danger mt-2">{error}</p>}

      {order && (
        <table className="table ">
          <tbody>
            <tr>
              <th>Order No</th>
              <td>{order.ord_no}</td>
            </tr>
            <tr>
              <th>Order Date</th>
              <td>{order.ord_date}</td>
            </tr>
            <tr>
              <th>Customer ID</th>
              <td>{order.cust_id}</td>
            </tr>
            <tr>
              <th>Product No</th>
              <td>{order.pno}</td>
            </tr>
            <tr>
              <th>Quantity</th>
              <td>{order.qty}</td>
            </tr>
          </tbody>
        </table>
      )}
    </div>
  );
}
