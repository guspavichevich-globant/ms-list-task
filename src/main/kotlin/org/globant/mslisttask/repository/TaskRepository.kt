package org.globant.mslisttask.repository

import org.globant.mslisttask.model.Task
import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository : JpaRepository<Task, Long>