package org.fasttrackit.bookreview.persistance;

import org.fasttrackit.bookreview.domain.Cart;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CartRepository extends JpaRepository<Cart, Long> {
}
