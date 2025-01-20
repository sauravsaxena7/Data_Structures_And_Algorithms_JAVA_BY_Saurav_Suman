package simple_interview_question;

public class Validate_Ip_Address {

    public static  void main(String[] args){
        String str = "0.0.0.0";
        str.replaceAll(".","-");
        String[] r = str.split("-");
        System.out.println(r);
    }
}
