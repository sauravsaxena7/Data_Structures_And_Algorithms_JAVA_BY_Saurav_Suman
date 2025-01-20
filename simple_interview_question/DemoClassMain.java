package simple_interview_question;

public class DemoClassMain {
    public static void main(String[] strings){
        for (int dx = -1; dx <= 1; dx++) {
            for (int dy = -1; dy <= 1; dy++) {
                if (dx != 0 || dy != 0) {
                    System.out.println("nx,ny: "+dx+" , "+dy);
                }
            }
        }
    }
}
