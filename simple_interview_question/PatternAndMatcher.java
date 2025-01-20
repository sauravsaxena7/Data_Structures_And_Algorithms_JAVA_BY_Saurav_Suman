package simple_interview_question;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PatternAndMatcher {

    public static void main(String[] args){
        String str = "she sells sea shells";
        String rex = "SsS";
        String replace = "X";
        Pattern p = Pattern.compile(rex);
        Matcher m = p.matcher(str);
        String val = m.replaceAll(replace);
        System.out.println(val);

    }

}
