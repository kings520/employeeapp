package com.employeeapp.service;

import com.employeeapp.model.Team;
import com.employeeapp.repository.TeamRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class TeamServiceImpl implements TeamService {
    private final TeamRepository teamNameRepository;

    public TeamServiceImpl(TeamRepository teamNameRepository) {
        this.teamNameRepository = teamNameRepository;
    }

    @Override
    public List<Team> findAll() {
        List<Team> teamNames = new ArrayList<>();
        teamNameRepository.findAll().forEach(teamNames::add);
        return teamNames;
    }

    @Override
    public Team save(Team object) {
        return teamNameRepository.save(object);
    }

    @Override
    public Team findById(Long aLong) {
        return teamNameRepository.findById(aLong).orElse(null);
    }

    @Override
    public void delete(Team object) {
        teamNameRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        teamNameRepository.deleteById(aLong);
    }
}
