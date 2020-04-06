package org.deep.bitsbytes.repository;

import org.deep.bitsbytes.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, String> {

}
