package org.globant.mslisttask.service

import org.globant.mslisttask.model.Task
import org.globant.mslisttask.repository.TaskRepository
import org.springframework.stereotype.Service

@Service
class TaskService (
    private val taskRepository: TaskRepository
) {

    fun getListOfTasks(): List<Task> = taskRepository.findAll()

    fun getTaskById(id: Long): Task? = taskRepository.findById(id).orElse(null)

    fun createTask(task: Task): Task = taskRepository.save(task)

    fun updateTask(id: Long, task: Task): Task? {
        return taskRepository.findById(id).map {
            val taskActualizada = it.copy(
                name = task.name,
                description = task.description,
                status = task.status,
                initDate = task.initDate,
                limitDate = task.limitDate
            )
            taskRepository.save(taskActualizada)
        }.orElse(null)
    }

    fun deleteTaskById(id: Long) {
        taskRepository.deleteById(id)
    }
}