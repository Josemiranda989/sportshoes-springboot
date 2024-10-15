import { useState, useEffect } from "react";

export function useFetchShoes() {
  const [shoes, setShoes] = useState([]);
  const [canGetShoes, setCanGetShoes] = useState(null);
  useEffect(() => {
    /* Consumo de Api para obtener todos los zapatos */
    if (canGetShoes == true || canGetShoes == null) {
      setCanGetShoesToFalse();
      fetch(import.meta.env.VITE_URL_API)
        .then((res) => res.json())
        .then((data) => {
          setShoes(data);
        })
        .catch((error) => {
          console.error("Error al obtener los productos:", error);
        });
    }
  }, [canGetShoes]);

  function setCanGetShoesToTrue() {
    setCanGetShoes(true);
  }

  function setCanGetShoesToFalse() {
    setCanGetShoes(false);
  }

  return { shoes, setCanGetShoesToTrue };
}
