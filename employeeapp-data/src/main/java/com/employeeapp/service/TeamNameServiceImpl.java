package com.employeeapp.service;

import com.employeeapp.model.TeamName;
import com.employeeapp.repository.TeamNameRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class TeamNameServiceImpl implements TeamNameService {
    private final TeamNameRepository teamNameRepository;

    public TeamNameServiceImpl(TeamNameRepository teamNameRepository) {
        this.teamNameRepository = teamNameRepository;
    }

    @Override
    public List<TeamName> findAll() {
        List<TeamName> teamNames = new ArrayList<>();
        teamNameRepository.findAll().forEach(teamNames::add);
        return teamNames;
    }

    @Override
    public TeamName save(TeamName object) {
        return teamNameRepository.save(object);
    }

    @Override
    public TeamName findById(Long aLong) {
        return teamNameRepository.findById(aLong).orElse(null);
    }

    @Override
    public void delete(TeamName object) {
        teamNameRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        teamNameRepository.deleteById(aLong);
    }
}
