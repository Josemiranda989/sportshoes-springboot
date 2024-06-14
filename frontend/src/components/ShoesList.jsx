import { useState, useEffect } from "react";

export default function ShoesList() {
  const [shoes, setShoes] = useState([]);

  useEffect(() => {
    /* Consumo de Api para obtener todos los zapatos */
    fetch("http://localhost:8080/shoes")
      .then((res) => res.json(res))
      .then((data) => {
        // console.log(data);
        setShoes(data);
      })
      .catch((error) => {
        console.error("Error al obtener los productos:", error);
      });
  }, []);

  return (
    <div className="container">
      <h2 className="my-4">Shoes List</h2>
      <ul className="list-group">
        {shoes.length === 0 ? (
          <p>No shoes available</p>
        ) : (
          shoes.map((shoe) => (
            <li
              key={shoe.id}
              className="list-group-item d-flex justify-content-between align-items-center"
            >
              <div className="text-primary">
                <strong>{shoe.name}</strong> - {shoe.size} - {shoe.quantity}
              </div>
              <img
                src={`http://localhost:8080${shoe.imageUrl}`}
                alt={shoe.name}
                style={{ maxWidth: "100px" }}
              />
            </li>
          ))
        )}
      </ul>
    </div>
  );
}
