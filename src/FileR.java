import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 * Reusable classes for LAB 4 questions. Mostly utilizing file reading and writing.
 */
public class FileR {
    /**
     * Reads specific file content and returns them as a single string
     * @param file_name name of file located in content folder
     * @return Content of the file as a string
     * @throws FileNotFoundException Fug if I know
     */
    public static String get_String(String file_name) throws FileNotFoundException {
        File file = new File(".\\content\\"+file_name+".txt");
        Scanner sc = new Scanner(file);
        String out = "";
        while (sc.hasNextLine()) {
            out += sc.nextLine();
        }
        return out;
    }

    /**
     * Reads specific file content and returns String array of each word
     * @param file_name name of file located in content folder
     * @return Content of the file as a string
     * @throws FileNotFoundException Fug if I know
     */
    public static String[] get_StringArray(String file_name) throws FileNotFoundException {
        return get_String(file_name).split(" ");
    }

    /**
     * Reads specific file and amends information to said file
     * @param file_name name of file located in content folder
     * @param pre Should amending be done in front of the content
     * @throws FileNotFoundException Fug if I know
     */
    public static void amend(String file_name, boolean pre) throws FileNotFoundException {
        String out;
        String amend_string = stats(get_String(file_name));
        if (pre) {
            out = amend_string + "\n";
            out += get_String(file_name);
        }
        else{
            out = get_String(file_name);
            out += "\n" + amend_string;
        }
        createNew(file_name,out);
    }

    /**
     * Creates a new file of specified content
     * @param file_name name to be given to the new file
     * @param content String that should be present inside the file
     * @throws FileNotFoundException Fug if I know
     */
    public static void createNew(String file_name, String content) throws FileNotFoundException {
        PrintWriter file = new PrintWriter(".\\content\\"+file_name+".txt");
        file.print(content);
        file.close();
    }

    /**
     * Counts vowels in given String
     * @param s Any String
     * @return int number of vowels
     */
    private static int countVowels(String s){
        int counter = 0;
        for(char c:s.toLowerCase().toCharArray())
            if(c=='e'||c=='u'||c=='i'||c=='o'||c=='a')
                counter++;
        return counter;
    }

    /**
     * Provides informative information about given String
     * @param s String to be analysed
     * @return String containing useful information
     */
    private static String stats(String s){
        int count_word = s.split(" ").length;
        int count_vowel = countVowels(s);
        return "String contains "+count_word+" words. It has "+count_vowel+" vowels making it an average of "+(float)count_vowel/count_word+" vowels per letter";
    }
}