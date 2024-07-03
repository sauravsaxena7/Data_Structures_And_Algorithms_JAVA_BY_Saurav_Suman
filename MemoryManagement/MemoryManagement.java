package MemoryManagement;

class Person{
    protected void profession(){
        System.out.println("I am Person");
    }
}

public class MemoryManagement{
    public static void main(String args[]){
        int primitiveVariable1 = 10;
        Person personObj = new Person();
        String stringLiterals = "24";
        MemoryManagement memObj = new MemoryManagement();
        memObj.memoryManagementTest(personObj);
    }
    private void memoryManagementTest(Person person){
        Person testPersonObj=person;
        String stringLiterals2 = "24";
        String str = new String("24");
    }
}