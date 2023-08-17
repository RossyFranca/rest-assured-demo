package com.franca.restassureddemo.schedulers;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTaskOne {


    @Scheduled(fixedRate = 5000)
    public void runTask(){
        System.out.println("Tarefa executada a cada 5 segundos");
    }

    @Scheduled(cron = "0 30 13 * * MON-FRI")
    public void runSemanalTask(){
        System.out.println("tarefa executada todos os dias de semana ás 13:30");
    }

}
