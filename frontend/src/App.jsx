import CreateShoeForm from "./components/CreateShoeForm";
import ShoesList from "./components/ShoesList";

function App() {
  return (
    <>
      <div className="container">
        <h1 className="text-center my-4">SportShoes App</h1>
        <p className="text-center">Proyecto creado con React y Spring Boot</p>

        <div className="my-4">
          <ShoesList />
        </div>
        <hr />
        <div className="my-4">
          <CreateShoeForm />
        </div>
      </div>
    </>
  );
}

export default App;
