package com.employeeapp.service;

import com.employeeapp.model.TeamLead;
import com.employeeapp.repository.TeamLeadRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TeamLeadServiceImpl implements TeamLeadService {
    private final TeamLeadRepository teamLeadRepository;

    public TeamLeadServiceImpl(TeamLeadRepository teamLeadRepository) {
        this.teamLeadRepository = teamLeadRepository;
    }

    @Override
    public List<TeamLead> findAll() {
        List<TeamLead> teamLead = new ArrayList<>();
        teamLeadRepository.findAll().forEach(teamLead::add);
        return teamLead;
    }

    @Override
    public TeamLead save(TeamLead object) {
        return teamLeadRepository.save(object);
    }

    @Override
    public TeamLead findById(Long aLong) {
        return teamLeadRepository.findById(aLong).orElse(null);
    }

    @Override
    public void delete(TeamLead object) {
        teamLeadRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        teamLeadRepository.deleteById(aLong);
    }
}
