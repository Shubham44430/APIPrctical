import React, { useState } from "react";
import axios from "axios";

export default function FindProduct() {

  const [pid, setPid] = useState("");
  const [product, setProduct] = useState(null);
  const [error, setError] = useState("");

  const searchProduct = async () => {
    if (!pid) {
      setError("Please enter Product ID");
      return;
    }

    try {
      const res = await axios.get(
        `http://localhost:5000/api/product/${pid}`
      );
      setProduct(res.data);
      setError("");
    } catch (err) {
      setProduct(null);
      setError("Product not found");
    }
  };

  return (
    <div className="container mt-4">
      <h2>Find Product</h2>

      <input
        type="text" className="form-control w-25" placeholder="Enter Product ID" value={pid} onChange={(e) => setPid(e.target.value)}
      />

      <button className="btn" onClick={searchProduct}>
        Search
      </button>

      {error && <p className="text-danger mt-2">{error}</p>}

      {product && (
        <table className="table">
          <tbody>
            <tr>
              <th>Product No</th>
              <td>{product.pno}</td>
            </tr>
            <tr>
              <th>Price</th>
              <td>{product.price}</td>
            </tr>
            <tr>
              <th>Stock</th>
              <td>{product.stock}</td>
            </tr>
          </tbody>
        </table>
      )}
    </div>
  );
}
