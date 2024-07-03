package java_17_features;


import java.util.Objects;
import java.util.Scanner;

class Alean{

    private final int id;
    private final String name;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Alean(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Alean{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Alean alean = (Alean) o;
        return id == alean.id && Objects.equals(name, alean.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}

//canonical constructor
//Data Carrier class
record  AlienRecord(int id,String name) implements Cloneable{

    static int num;
    //nstance field is not allowed in record
    //int numr;

    //Non-canonical record constructor must delegate to another constructor
    public AlienRecord(){
        this(0,"");
    }

    //compact canonical constructor

    public AlienRecord{
        if(id==0) throw  new IllegalArgumentException("Id Cannot Be zero");
    }

};


public class RecordClassesEmaple {

    public static void main(String[] args){
        Alean a1  = new Alean(1,"saurav");
        Alean a2  = new Alean(1,"saurav");


//        AlienRecord ar1  = new AlienRecord(1,"saurav");
//        AlienRecord ar2  = new AlienRecord(1,"saurav");
//
//        AlienRecord ar3 = new AlienRecord();
//
//        System.out.println(ar3.name());
//
//        System.out.println(a1.equals(a2));
//        System.out.println(ar1.equals(ar2));
//        System.out.println(ar2);
//
        Scanner s = new Scanner(System.in); // do not change this
        String inputLine = s.nextLine();

        int[] count = new int[26];
        int[] count2 = new int[27];
        boolean flag=true;

        for(int i=1;i<=26;i++){
            count2[i]=0;
        }

        for (int i = 0; i < inputLine.length(); i++) {

            // storing the frequency of the character.
            count[inputLine.charAt(i) - 'a']++;
        }

        for (int i = 0; i < inputLine.length(); i++) {

            // storing the frequency of the character.
            count2[inputLine.charAt(i) - 'a']=1;
        }

        for (int i = 0; i < inputLine.length(); i++) {
            // checking if the character is non-repeating or not.
            if (count[inputLine.charAt(i) - 'a'] == 1) {
                System.out.println(inputLine.charAt(i));
                break;
            }
        }

        for (int i = 1; i <=26; i++) {

            if (count2[i] != 1) {
                flag=false;
                break;
            }
        }

        System.out.println(flag);
    }
}
