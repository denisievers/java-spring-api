package com.userDepart.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.userDepart.entities.User;

/**
 *
 * @author Dênis Ronan Sievers
 */
public interface UserRepository extends JpaRepository<User, Long>{
    
}
