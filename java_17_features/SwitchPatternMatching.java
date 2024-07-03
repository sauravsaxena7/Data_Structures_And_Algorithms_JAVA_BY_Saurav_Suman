package java_17_features;
/*
what: Offers a more concise and expressive way to handle
different cases in a switch statement using patterns
instead of traditional case labels

WHY: Improve code readability, reduce boilerplate,
and enable complex data structures processing.

HOW IT WORKS:
Use switch with pattern matching expressions like instanceOf,
== , or custom patterns.
Each case can bind the matched value to a variable for further
processing

*
* */

//improve in code readeability
public class SwitchPatternMatching {
    public static void main(String[] args){

        traditionalInstanceOf();


    }

    static void traditionalInstanceOf(){
        System.out.println("....TRADITIONAL INSTANCE OF....");
        Object value = "SAURAVSUMAN";
        if (value instanceof String){
            String str = (String) value;
            System.out.println("given value is: "+str);
        }

    }

    static void patternMatchingInstanceOf(){
        System.out.println("....PATTERN MATCHING INSTANCE OF....");
        Object value = "SAURAVSUMAN";
        if (value instanceof String str) System.out.println("given value is: " + str);

    }

    static void traditionalIfStatements(){
        System.out.println("....TRADITIONAL IF STATEMENTS....");
        Object obj = "SAURAVSUMAN";
        if (obj instanceof String) {
            System.out.println("type string....");
        }
        else if (obj instanceof Integer) {
            System.out.println("type interger....");
        }

    }

    static void switchStatementColonExamples(Object obj){
        System.out.println("....SWITCH STATEMENT COLON EXAMPLE....");

        switch (obj){
            case String str:{
                System.out.println("type string...."+ str);
                break;
            }case Integer i:{
                System.out.println("type Integer...."+ i);
                break;
            }
            default:
                System.out.println("Not Matching");
        }
    }
    static void switchStatementWithArrowStatement(Object obj){
        System.out.println("....SWITCH STATEMENT WITH ARROW STATEMENT....");

        switch (obj){
            case String str->System.out.println("type string...."+ str);

            case Integer i->System.out.println("type Integer...."+ i);
            default->{
                System.out.println("Not Matching");
            }
        }
    }
    static int switchExpressionColonSyntax(int i){
        System.out.println("....SWITCH Expression With colon Syntax....");

        return switch (i){
            case 10,11: yield 100;
            case 20: yield 200;
            default: yield 1;
        };
    }
}
