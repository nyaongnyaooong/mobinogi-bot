package com.scheduler.demo.domain.scheduler.presentation.cron;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class SchedulerCron {

    // 매일 자정에 실행
    @Scheduled(cron = "0 0 0 * * ?")
    public void dailyTask() {
        log.info("일일 작업 실행");
    }

    // 매 시간마다 실행
    @Scheduled(cron = "0 0 * * * ?")
    public void hourlyTask() {
        log.info("시간별 작업 실행");
    }

    // 5분마다 실행
    @Scheduled(fixedRate = 3000)
    public void fixedRateTask() {
        log.info("3초마다 실행되는 작업");
    }
}