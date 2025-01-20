package simple_interview_question.fileHandling;

import java.io.*;

public class ReadingAndInFile {
    public static void main(String[] args) throws Exception{
//        File result = new File("Test.txt");
//        FileWriter fileWriter = new FileWriter(new BufferedWriter(result));
//        fileWriter.write("Math-Magical",0,5);
//        fileWriter.flush();
//        fileWriter.close();
//        System.out.println(new BufferedReader( new FileReader(result)).readLine());


//        The code you provided has some issues that will cause it to throw errors. Here are the problems and their solutions:
//
//        Incorrect Use of FileWriter Constructor: You are passing a BufferedWriter object to the FileWriter constructor, which is incorrect. FileWriter accepts a File or String (file path) as an argument, but not a BufferedWriter. To wrap FileWriter with BufferedWriter, you need to create a FileWriter first and then pass it to BufferedWriter.
//
//        Misuse of write Method Parameters: In fileWriter.write("Math-Magical", 0, 5);, you are trying to specify an offset and length. The write method expects a char[] as the first argument if you're specifying an offset and length. Here, write(String str) is sufficient since you're writing the whole string or part of it as a substring.
//
//        Here’s the corrected version:


        // Create the file and write to it using BufferedWriter
        File result = new File("Test.txt");
        FileWriter fileWriter = new FileWriter(result);
        BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

        // Writing only the first 5 characters
        bufferedWriter.write("Maths-Magical", 0, 5);
        bufferedWriter.flush();
        bufferedWriter.close();

        // Reading the content of the file
        BufferedReader bufferedReader = new BufferedReader(new FileReader(result));
        System.out.println(bufferedReader.readLine());
        bufferedReader.close();

//        Explanation of Changes
//        BufferedWriter is now created by passing fileWriter as an argument, ensuring data is buffered for efficient writing.
//        write Method: bufferedWriter.write("Math-Magical", 0, 5); now correctly writes only the first five characters ("Math-").
//                Resource Management: Ensures both BufferedWriter and BufferedReader are properly closed.
    }
}
