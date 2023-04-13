package webapp_java.aop.aspect;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.context.annotation.Configuration;

@Configuration
@Aspect
public class LoggingAspect {
    @Around("execution(* webapp_java.hibernate.dao.*.*(..))")
    public Object aroundAllRepositoryMethodsAdvice (ProceedingJoinPoint joinPoint) throws Throwable {
        Signature signature = joinPoint.getSignature();
        String methodName = signature.getName();
        System.out.println("Begin of " + methodName);
        Object proceed = joinPoint.proceed();
        System.out.println("End of " + methodName);
        return proceed;
    }
}
