package simple_interview_question.inheritanceBasedQuestion;

class Order{
    String orderId;
    Order(){
        orderId="0000A";
        System.out.println(orderId);
    }
    Order(String od){
        orderId=od;
        System.out.println(orderId);
    }
}

class RaisedTicket extends Order{
    String orderId;
    RaisedTicket(){
        orderId="xxxb";
        System.out.println(orderId);
    }
    RaisedTicket(String od){
        orderId=od;
        System.out.println(orderId);
    }
}

public class RaisedTicketExtendsOrder {

    public static void main(String[] args){
        RaisedTicket b = new RaisedTicket("1908A3");
    }

}
