import React, { useEffect, useState } from 'react';
import axios from 'axios';

export default function ShowProducts() {

  const [apidata, setApidata] = useState([]);
  const [loading, setLoading] = useState(true);
  const [error, setError] = useState("");

  useEffect(() => {
    axios.get("http://localhost:5000/api/product/")
      .then(res => {
        
        const data = Array.isArray(res.data) ? res.data : [res.data];
        setApidata(data);
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
      });
  }, []);


  return (
    <div className="container mt-4">
      <h1 className="text-center">All Products</h1>

      {apidata.length === 0 ? (
        <p className="text-center">No products found</p>
      ) : (
        <table className="table table-bordered table-striped mt-3 text-center">
          <thead className="table-dark">
            <tr>
              <th>Product No</th>
              <th>Price</th>
              <th>Stock</th>
            </tr>
          </thead>
          <tbody>
            {apidata.map(product => (
              <tr key={product.pno}>
                <td>{product.pno}</td>
                <td>{product.price}</td>
                <td>{product.stock}</td>
              </tr>
            ))}
          </tbody>
        </table>
      )}
    </div>
  );
}
