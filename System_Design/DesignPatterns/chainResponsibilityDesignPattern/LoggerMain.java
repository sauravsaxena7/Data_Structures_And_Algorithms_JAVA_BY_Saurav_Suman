package System_Design.DesignPatterns.chainResponsibilityDesignPattern;

public class LoggerMain {

   public static void main(String[] args){
       LogProcessor logProcessor = new InfoLogProcessor( new DebugLogProcessor( new ErrorLogProcessor(null)) );

       logProcessor.log(LogProcessor.ERROR,"Exceptions Happened");
       logProcessor.log(LogProcessor.DEBUG,"DEBUGGING");
       logProcessor.log(LogProcessor.INFO,"INFO ABOUT COOL");
   }


}
