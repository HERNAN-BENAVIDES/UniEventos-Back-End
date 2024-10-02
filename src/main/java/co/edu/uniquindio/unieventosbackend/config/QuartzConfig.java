package co.edu.uniquindio.unieventosbackend.config;

import co.edu.uniquindio.unieventosbackend.utils.EmailReminderJob;
import org.quartz.JobBuilder;
import org.quartz.JobDetail;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.CronScheduleBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class QuartzConfig {

     @Bean
     public JobDetail emailReminderJobDetail() {
          return JobBuilder.newJob(EmailReminderJob.class)
                  .withIdentity("emailReminderJob")
                  .storeDurably()
                  .build();
     }

     @Bean
     public Trigger emailReminderJobTrigger() {
          return TriggerBuilder.newTrigger()
                  .forJob(emailReminderJobDetail())
                  .withIdentity("emailReminderTrigger")
                  .withSchedule(CronScheduleBuilder.cronSchedule("0 0 10 ? * MON")) // Cada lunes a las 10 AM
                  .build();
     }
}
