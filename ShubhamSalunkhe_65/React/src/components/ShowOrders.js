import React, { useEffect, useState } from 'react';
import axios from 'axios';

export default function ShowOrders() {
  const [apidata, setApidata] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState(null);

  useEffect(() => {
    axios.get("http://localhost:5000/api/orders/")
      .then(res => {
        setApidata(res.data);
        setLoading(false);
      })
      .catch(err => {
        setLoading(false);
        if (err.response) {
          setError(err.response.data || err.response.statusText);
        } else if (err.request) {
          setError("No response from server. Check if API is running.");
        } else {
          setError(err.message);
        }
        console.error(err);
      });
  }, []);

  return (
    <div className="container mt-4">
      <h1>Order API Data</h1>

        <table className="table table-bordered table-striped mt-3">
          <thead className="thead-dark">
            <tr>
              <th>Order No</th>
              <th>Date</th>
              <th>Product no</th>
              <th>Quantity</th>
            </tr>
          </thead>
          <tbody>
            {apidata.map((ord, index) => (
              <tr key={index}>
                <td>{ord.ordNo}</td>
                <td>{ord.ordDate}</td>
                <td>{ord.pno}</td>
                <td>{ord.qty}</td>
              </tr>
            ))}
          </tbody>
        </table>
      

      {!loading && !error && apidata.length === 0 && (
        <p>No employee data found.</p>
      )}
    </div>
  );
}
