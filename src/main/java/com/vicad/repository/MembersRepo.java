package com.vicad.repository;

import com.vicad.model.Members;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MembersRepo extends JpaRepository<Members, Integer> {

}
