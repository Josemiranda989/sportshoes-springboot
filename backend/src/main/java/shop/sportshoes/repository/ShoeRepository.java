package shop.sportshoes.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import shop.sportshoes.model.Shoe;

public interface ShoeRepository extends JpaRepository<Shoe, Long> {
}
