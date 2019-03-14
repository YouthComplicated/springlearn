package com.lanmo.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

/**
 * @author NJ
 * @date 2019/3/13 8:38
 */
@Aspect
public class LogRecordAspects {


    public void logStart(){
    }

    public void logEnd(){
    }

    public void logReturn(){
    }

    public void logException(){
    }


    /**
     * 	@AfterReturning("execution(* com.greattimes.ev..*.*(..)) && @annotation(ol)")
            public void afterReturn(JoinPoint joinPoint ,OperateLog ol) throws Throwable {
            records( joinPoint, ol,null);
        }

         @AfterThrowing(pointcut="execution(* com.greattimes.ev..*.*(..)) && @annotation(ol)",throwing="e")
             public void afterThrow(JoinPoint joinPoint ,OperateLog ol,Exception e) throws Throwable {
             records( joinPoint, ol,e);
         }


         private void records(JoinPoint joinPoint,OperateLog ol,Exception e){
             HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
             HttpSession session = request.getSession();
             User user = JSON.parseObject(session.getAttribute("member").toString(), User.class);
             String ip = request.getRemoteAddr();
             log.info("----------operate info start!--------------");
             log.info("user:【{}{}】",user.getId(),user.getName());
             log.info("IP:【{}】",ip);
             log.info("action:{}",ol.desc());
             log.info("actionType:{}",ol.type());
             if(e!=null){
                 log.error("操作异常：",e.toString());
                 log.error("operate error!");
             }else{
                 log.info("operate success!");
             }
             log.info("----------operate info end!--------------");
         }
     */

}
