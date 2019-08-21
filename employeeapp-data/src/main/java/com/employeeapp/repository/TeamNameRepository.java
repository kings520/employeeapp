package com.employeeapp.repository;

import com.employeeapp.model.TeamName;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeamNameRepository extends JpaRepository<TeamName,Long> {
}
