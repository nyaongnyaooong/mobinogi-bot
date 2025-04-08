package com.mobinogi.bot.config

import net.dv8tion.jda.api.JDA
import net.dv8tion.jda.api.JDABuilder
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class DiscordConfig(
    @Value("\${discord.token}")
    private val token: String
) {
    @Bean
    fun jda(): JDA = JDABuilder.createDefault(token)
        .build()
        .awaitReady()
} 