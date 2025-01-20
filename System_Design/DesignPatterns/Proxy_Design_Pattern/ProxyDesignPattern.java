package System_Design.DesignPatterns.Proxy_Design_Pattern;

public class ProxyDesignPattern {
    public static void main(String[] args){
        try{
           EmployeeDao empObjProxy = new EmployeeDaoProxy();
           empObjProxy.create("ADMIN",new EmployeeDo());
           System.out.println("Operation Successful");
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
