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
    <div className="container">
      <h2 className="my-4">New Shoe</h2>
      <form onSubmit={handleSubmit}>
        <div className="mb-3">
          <label className="form-label">Name:</label>
          <input
            type="text"
            className="form-control"
            value={name}
            onChange={(e) => setName(e.target.value)}
          />
        </div>
        <div className="mb-3">
          <label className="form-label">Size:</label>
          <input
            type="text"
            className="form-control"
            value={size}
            onChange={(e) => setSize(e.target.value)}
          />
        </div>
        <div className="mb-3">
          <label className="form-label">Quantity:</label>
          <input
            type="number"
            className="form-control"
            value={quantity}
            onChange={(e) => setQuantity(e.target.value)}
          />
        </div>
        <div className="mb-3">
          <label className="form-label">Image:</label>
          <input
            type="file"
            className="form-control"
            onChange={(e) => setImage(e.target.files[0])}
          />
        </div>
        <button type="submit" className="btn btn-primary">
          Create Shoe
        </button>
      </form>
    </div>
  );
}
