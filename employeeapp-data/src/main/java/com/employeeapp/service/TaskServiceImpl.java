package com.employeeapp.service;

import com.employeeapp.model.Task;
import com.employeeapp.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> findAll() {
        List<Task> tasks = new ArrayList<>();
        taskRepository.findAll().forEach(tasks::add);
        return tasks;
    }

    @Override
    public Task save(Task object) {
        return taskRepository.save(object);
    }

    @Override
    public Task findById(Long aLong) {
        return taskRepository.findById(aLong).orElse(null);
    }

    @Override
    public void delete(Task object) {
        taskRepository.delete(object);
    }

    @Override
    public void deleteById(Long aLong) {
        taskRepository.deleteById(aLong);
    }
}
