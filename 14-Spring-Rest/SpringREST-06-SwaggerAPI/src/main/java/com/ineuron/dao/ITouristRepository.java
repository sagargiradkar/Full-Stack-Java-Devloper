package com.ineuron.dao;

import com.ineuron.model.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ITouristRepository extends JpaRepository<Tourist,Integer> {
}
