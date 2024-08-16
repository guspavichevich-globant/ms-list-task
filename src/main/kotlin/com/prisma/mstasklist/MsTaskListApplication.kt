package com.prisma.mstasklist

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class MsTaskListApplication

fun main(args: Array<String>) {
    runApplication<MsTaskListApplication>(*args)
}