package com.vicad.repository;

import com.vicad.model.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GenderRepo extends JpaRepository<Gender, Integer> {
}
