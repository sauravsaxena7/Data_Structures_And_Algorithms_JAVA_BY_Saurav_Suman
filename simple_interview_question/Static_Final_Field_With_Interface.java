package simple_interview_question;


interface MouseMove{
    static int scrollUp=1,scrollDown=1;
}

interface CursorMoves extends MouseMove{
    //final int down=scrollDown++,up=scrollUp+1;
    //final int down=scrollDown=scrollDown+1,up=scrollUp+1;
    // final field scrollDown can not be changed
}

public class Static_Final_Field_With_Interface {

}
