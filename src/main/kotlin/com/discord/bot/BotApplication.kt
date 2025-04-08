package com.mobinogi.bot

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.scheduling.annotation.EnableScheduling

@SpringBootApplication
@EnableScheduling
class BotApplication

fun main(args: Array<String>) {
    runApplication<BotApplication>(*args)
} 