import { useState, useEffect } from "react";

export default function ShoesList() {
  const [shoes, setShoes] = useState([]);

  useEffect(() => {
    fetch("http://localhost:8080/shoes")
      .then((res) => res.json(res))
      .then((data) => {
        console.log(data);
        setShoes(data);
      })
      .catch((error) => {
        console.error("Error fetching products:", error);
      });
  }, []);

  return (
    <div className="container">
      <h2 className="my-4">Product List</h2>
      <ul className="list-group">
        {shoes.map((product) => (
          <li
            key={product.id}
            className="list-group-item d-flex justify-content-between align-items-center"
          >
            <div>
              <strong>{product.name}</strong> - {product.size} -{" "}
              {product.quantity}
            </div>
            <img
              src={`http://localhost:8080${product.imageUrl}`}
              alt={product.name}
              style={{ maxWidth: "100px" }}
            />
          </li>
        ))}
      </ul>
    </div>
  );
}
