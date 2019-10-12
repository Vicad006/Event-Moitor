package com.vicad.repository;

import com.vicad.model.MaritalStatus;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MaritalStatusRepo extends JpaRepository<MaritalStatus, Integer> {
}
