package simple_interview_question.inheritanceBasedQuestion;


import java.io.IOException;

class Degree{
    public void selectDegree(){//LINE A
        /*
        *
        *   */
    }
}
class Stream extends Degree{
//    public void selectDegree() throws IOException {//LINE B
//        super.selectDegree();
//        throw new IOException();
//    }

   // Compilation ERROR OCCURED At Line B
}


public class StreamExtendsDegreeThrowNewException {
}
