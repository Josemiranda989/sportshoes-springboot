import { useState } from "react";

export default function CreateShoeForm() {
  const [name, setName] = useState("");
  const [size, setSize] = useState("");
  const [quantity, setQuantity] = useState("");
  const [image, setImage] = useState(null);

  const handleSubmit = async (e) => {
    e.preventDefault();

    const formData = new FormData();
    formData.append("name", name);
    formData.append("size", size);
    formData.append("quantity", quantity);
    formData.append("image", image);

    fetch("http://localhost:8080/shoes", {
      method: "POST",
      body: formData,
      // No necesitas establecer el encabezado Content-Type
    })
      .then((response) => {
        if (response.ok) {
          console.log("Shoe created successfully");
          //hacer un reload luego de 3 segundos
          setTimeout(() => {
            window.location.reload();
          }, 2000);
        } else {
          console.error("Failed to create shoe");
        }
      })
      .catch((error) => {
        console.error("Error creating shoe:", error);
      });
  };

  return (
    <div className="container mx-auto px-4">
      <h2 className="my-4 text-2xl font-semibold">New Shoe</h2>
      <form onSubmit={handleSubmit}>
        <div className="mb-4">
          <label className="block mb-2">Name:</label>
          <input
            type="text"
            className="w-full py-2 px-3 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
        </div>
        <div className="mb-4">
          <label className="block mb-2">Size:</label>
          <input
            type="text"
            className="w-full py-2 px-3 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
            value={size}
            onChange={(e) => setSize(e.target.value)}
          />
        </div>
        <div className="mb-4">
          <label className="block mb-2">Quantity:</label>
          <input
            type="number"
            className="w-full py-2 px-3 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
            value={quantity}
            onChange={(e) => setQuantity(e.target.value)}
          />
        </div>
        <div className="mb-4">
          <label className="block mb-2">Image:</label>
          <input
            type="file"
            className="w-full py-2 px-3 border rounded-md focus:outline-none focus:ring-2 focus:ring-blue-500"
            onChange={(e) => setImage(e.target.files[0])}
          />
        </div>
        <button
          type="submit"
          className="bg-blue-500 text-white py-2 px-4 rounded-md hover:bg-blue-600 focus:outline-none focus:ring-2 focus:ring-blue-500"
        >
          Create Shoe
        </button>
      </form>
    </div>
  );
}
