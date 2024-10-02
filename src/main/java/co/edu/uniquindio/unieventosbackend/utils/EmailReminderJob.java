package co.edu.uniquindio.unieventosbackend.utils;

import co.edu.uniquindio.unieventosbackend.exceptions.EmailSenderException;
import co.edu.uniquindio.unieventosbackend.exceptions.UsuarioNotFoundException;
import co.edu.uniquindio.unieventosbackend.services.EmailService;
import lombok.SneakyThrows;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class EmailReminderJob implements Job {

     @Autowired
     private EmailService emailService;

     @SneakyThrows
     @Override
     public void execute(JobExecutionContext context) throws JobExecutionException {
          try {
               emailService.enviarCorreoMasivo();
          } catch (Exception | UsuarioNotFoundException e) {
               throw new EmailSenderException(e);
          }
     }
}
