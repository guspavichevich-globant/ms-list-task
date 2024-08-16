package com.prisma.mstasklist.repository

import com.prisma.mstasklist.model.Task
import org.springframework.data.jpa.repository.JpaRepository

interface TaskRepository : JpaRepository<Task, Long>