import java.io.FileNotFoundException;

public class Q1 {
    public static void main(String[] args) throws FileNotFoundException {
        String[] words = FileR.get_StringArray("Lab 3");
        for(int i = 0; i < words.length; i++)
            if(i%5 == 0)
                System.out.print(words[i]+" ");
    }
}