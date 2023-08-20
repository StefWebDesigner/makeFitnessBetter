package com.makingfitnessbetter.makingfitnessbetter.repositories;

import com.makingfitnessbetter.makingfitnessbetter.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {


}
