package com.scheduler.demo.domain.scheduler.application;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ScheduledFuture;

import org.springframework.scheduling.TaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class SchedulerService {

    private final TaskScheduler taskScheduler;
    private final Map<String, ScheduledFuture<?>> scheduledTasks = new ConcurrentHashMap<>();

    public void addScheduleTask(String taskName, String cronExpression, Runnable task) {
        ScheduledFuture<?> scheduledTask = taskScheduler.schedule(task, new CronTrigger(cronExpression));
        scheduledTasks.put(taskName, scheduledTask);
        log.info("Task added: {}", taskName);
    }

    public void removeScheduleTask(String taskName) {
        ScheduledFuture<?> scheduledTask = scheduledTasks.get(taskName);
        if (scheduledTask != null) {
            scheduledTask.cancel(true);
            scheduledTasks.remove(taskName);
            log.info("Task removed: {}", taskName);
        }
    }

    public void updateScheduleTask(String taskName, String newCronExpression, Runnable task) {
        removeScheduleTask(taskName);
        addScheduleTask(taskName, newCronExpression, task);
        log.info("Task updated: {}", taskName);
    }
}
