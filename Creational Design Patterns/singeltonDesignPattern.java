//this verison is for only single thread enviroment//
// class Logger{
//     private static Logger logger=null;
//     private Logger(){}

//     public static Logger getLogger(){
//         if(logger==null){
//             logger=new Logger();
//         }
//         return logger;   
//     }
//     public void log(String msg){
//         System.err.println(msg);
//     }
// }

//when mutiple threads sun at same time we can use getSInatce() with syncronaiztion //
// class Logger{
//     private static Logger instance=null;
//     private Logger(){
//         System.err.println("Logger is created");
//     }

//     public static synchronized Logger getInstance(){
//         if(instance==null){
//             instance=new Logger();
//         }
//         return instance;   
//     }
//     public void log(String msg){
//         System.err.println(msg);
//     }
// }

//double check-lock technique//
class Logger{
    private static volatile Logger instance=null;
    private Logger(){
        System.err.println("Logger is created");
    }

    public static Logger getInstance(){
        if(instance==null){
        synchronized(Logger.class){
            if(instance==null){
            instance=new Logger();
            }
            }
        }
        return instance;   
    }
    public void log(String msg){
        System.err.println(msg);
    }
}


public  class singeltonDesignPattern{
    public static void main(String[] args) {
          Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Application started...");
        logger2.log("Logger is working fine!");

        // Verify both are same instance
        System.out.println("Are both loggers same? " + (logger1 == logger2));
        
    }
}