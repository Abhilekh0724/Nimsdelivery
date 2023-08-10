package com.backend.projectname.Repository;

import com.backend.projectname.pojo.Users;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.data.repository.CrudRepository;

public interface UsersRepository  extends CrudRepository<Users, Integer> {
   Users findByEmail(String email);

}
