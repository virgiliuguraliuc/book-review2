package org.fasttrackit.bookreview.persistance;

import org.fasttrackit.bookreview.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {
}