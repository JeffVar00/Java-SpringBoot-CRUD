package cr.ac.una.Proyecto1Paradigmas.aop;

import cr.ac.una.Proyecto1Paradigmas.entity.Log;
import cr.ac.una.Proyecto1Paradigmas.repository.LogRepository;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;

@Aspect
@Component
public class PersonaAOP {

    @Autowired
    private LogRepository logRepository;

    @Before("execution(* cr.ac.una.Proyecto1Paradigmas.repository.PersonaRepository.findAll(..))")
    public void logBeforeFindAll(JoinPoint joinPoint){
        logRepository.save(new Log(null,joinPoint.getSignature().getName(), new Date()));
    }
    @Before("execution(* cr.ac.una.Proyecto1Paradigmas.repository.PersonaRepository.findById(..))")
    public void logBeforeFindById(JoinPoint joinPoint){
        logRepository.save(new Log(null,joinPoint.getSignature().getName(), new Date()));
    }

    @Before("execution(* cr.ac.una.Proyecto1Paradigmas.repository.PersonaRepository.save(..))")
    public void logBeforeSave(JoinPoint joinPoint){
        logRepository.save(new Log(null,joinPoint.getSignature().getName(), new Date()));
    }

    @Before("execution(* cr.ac.una.Proyecto1Paradigmas.repository.PersonaRepository.delete(..))")
    public void logBeforeDelete(JoinPoint joinPoint){
        logRepository.save(new Log(null,joinPoint.getSignature().getName(), new Date()));
    }

}
