package shop.sportshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.sportshoes.model.Shoe;

/**
 * ShoeRepository es una interfaz que extiende JpaRepository.
 * JpaRepository es una extensión específica de JPA de Repository que actúa como un DAO (Data Access Object),
 * proporcionando métodos útiles para operaciones CRUD y paginación.
 *
 * La interfaz está parametrizada con el tipo de dominio (Shoe) y el tipo de ID (Long).
 * Esto significa que se puede utilizar para realizar operaciones CRUD en entidades Shoe.
 */
public interface ShoeRepository extends JpaRepository<Shoe, Long> {
}