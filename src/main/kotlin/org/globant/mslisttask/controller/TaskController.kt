package org.globant.mslisttask.controller

import org.globant.mslisttask.model.Task
import org.globant.mslisttask.service.TaskService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/task")
class TaskController (private val taskService: TaskService) {

    @GetMapping("/list")
    fun getListOfTasks(): ResponseEntity<List<Task>> =
        ResponseEntity(taskService.getListOfTasks(), HttpStatus.OK)

    @GetMapping
    fun getTaskById(
        @RequestParam taskId: Long
    ) : ResponseEntity<Task> =
        ResponseEntity(taskService.getTaskById(taskId), HttpStatus.OK)

    @PostMapping("{taskId}")
    fun updateTask(
        @PathVariable taskId: Long,
        @RequestBody task: Task
    ): ResponseEntity<Task> =
        ResponseEntity(taskService.updateTask(taskId, task), HttpStatus.OK)

    @PostMapping("/task")
    fun createTask(
        @RequestBody task: Task
    ): ResponseEntity<Task> =
        ResponseEntity(taskService.createTask(task), HttpStatus.CREATED)

    @DeleteMapping
    fun deleteTaskById(
        @RequestParam taskId: Long
    ): ResponseEntity<Void> =
        taskService.deleteTaskById(taskId)
            .let { ResponseEntity.noContent().build() }

}