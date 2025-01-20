package simple_interview_question;


class VoterList{
    static private int voters=0;
    int totalVoters;
    private static synchronized int Counter(){
        return ++voters;
    }
    public void totalVotersCount(){
        totalVoters=Counter();
    }
}

public class VotersListStaticMethod {
    static int i=0;
    int size=20;
    public static void main(String[] args){
        System.out.println(new VoterList().totalVoters);

        //int arr = new int[size]; // give compile time error "the static reference to the non-static field size is not valid"
        int arr[] = new int[20];
        for(int i=0;i<20;i++){
            System.out.print(arr[i]+" ");
        }

    }
}
