package com.revature.kkoders.logging;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Automatically logs certain methods of the application.
 * 
 * @author 
 *
 */
@Aspect
@Component
public class LogAspect {
	
	/**
	 * Service to log messages.
	 * 
	 */
	@Autowired
	LogService logger;
	
	/**
	 * Identifies all service methods to be logged.
	 * 
	 */
	@Pointcut(value="execution(public * com.revature.kkoders.service..*(..))") //log all service methods
	public void everyServiceMethod() {
	}
	
	/**
	 * Logs all service methods.
	 * 
	 * Normal operation is logged at the info level; exceptions are logged at the error level.
	 * 
	 * @param serviceMethod the service method
	 * @return the service method's return value, or null if void
	 * @throws Throwable
	 */
	@Around("everyServiceMethod()")
	public Object logService(ProceedingJoinPoint serviceMethod) throws Throwable {
		String message = "INFO: " + serviceMethod.getSignature(); //do info log by default; log which service method is executing.
		boolean logInfo = true; //if true, log normal operation; if false, log that exception occurred.
		
		Object returnValue = null; //to hold the return value of the service method (if there is one).
		
		try {
			returnValue = serviceMethod.proceed(); //let the service method execute; get the return value (if any).
			message += ". RETURNED: " + returnValue;
		} catch (Throwable t) { //if service method threw something...
			System.err.println("ERROR: " + t.getMessage());
			message = "ERROR: " + serviceMethod.getSignature() + ". THROW MESSAGE: " + t.getMessage(); //do error log if exception/error thrown; log which service method threw an exception.
			logInfo = false;
		}
		
		//System.out.println(logMessage); //TODO: commit to DB.
		if (logInfo) {
			//logger.info(message);
			System.out.println(message);
		}
		else {
			//logger.error(message);
			System.out.println(message);
		}
		
		return returnValue;
		
	}

}
