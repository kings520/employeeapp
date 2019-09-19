package com.employeeapp.service;

import com.employeeapp.model.SubTask;
import com.employeeapp.repository.SubTaskRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SubTaskServiceImpl implements SubTaskService {
    private final SubTaskRepository taskRepository;

    public SubTaskServiceImpl(SubTaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<SubTask> findAll() {
        List<SubTask> tasks = new ArrayList<>();
        taskRepository.findAll().forEach(tasks::add);
        return tasks;
    }

    @Override
    public SubTask save(SubTask object) {
        return taskRepository.save(object);
    }

    @Override
    public SubTask findById(Long aLong) {
        return taskRepository.findById(aLong).orElse(null);
    }

    @Override
    public void delete(SubTask object) {
        taskRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        taskRepository.deleteById(aLong);
    }

}
