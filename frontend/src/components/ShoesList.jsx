import { useState, useEffect } from "react";

export default function ShoesList({shoes}) {
 

  return (
    <div className="container mx-auto px-4">
      <h2 className="my-4 text-2xl font-semibold">Shoes List</h2>
      <ul className="divide-y divide-gray-200">
        {shoes.length === 0 ? (
          <p className="py-4">No shoes available</p>
        ) : (
          shoes.map((shoe) => (
            <li
              key={shoe.id}
              className="flex justify-between items-center py-4"
            >
              <div className="text-primary">
                <strong>{shoe.name}</strong> - {shoe.size} - {shoe.quantity}
              </div>
              <img
                src={`${shoe.imageUrl}`}
                alt={shoe.name}
                className="max-w-full h-auto"
                style={{ maxWidth: "100px" }}
              />
            </li>
          ))
        )}
      </ul>
    </div>
  );
}
