import { useState } from "react";
import CreateShoeForm from "./components/CreateShoeForm";
import ShoesList from "./components/ShoesList";
import { useFetchShoes } from "./hooks/useFetchShoes";

function App() {
  const { shoes, setCanGetShoesToTrue } = useFetchShoes();

  return (
    <div className="container mx-auto px-4">
      <h1 className="text-center my-4 text-3xl font-semibold">
        SportShoes App
      </h1>
      <p className="text-center">Proyecto creado con React y Spring Boot</p>

      <div className="my-4">
        <ShoesList shoes={shoes} />
      </div>
      <hr className="my-4" />
      <div className="my-4">
        <CreateShoeForm setCanGetShoesToTrue={setCanGetShoesToTrue} />
      </div>
    </div>
  );
}

export default App;
