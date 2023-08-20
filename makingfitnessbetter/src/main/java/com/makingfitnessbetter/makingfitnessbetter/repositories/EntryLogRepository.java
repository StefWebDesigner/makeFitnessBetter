package com.makingfitnessbetter.makingfitnessbetter.repositories;

import com.makingfitnessbetter.makingfitnessbetter.entities.EntryLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EntryLogRepository extends JpaRepository<EntryLog, Integer> {

}
