import java.io.FileNotFoundException;

public class Q2 {
    public static void main(String[] args) throws FileNotFoundException {
        int divider = 5;
        String read_name = "Lab 3";
        String write_name = "divider";
        String[] content = new String[divider];
        String[] words = FileR.get_StringArray(read_name);
        for(int i = 0; i<divider; i++){
            content[i] = "";
        }
        for(int i = 0; i<words.length; i++){
            content[i%5] += words[i]+" ";
        }
        for(int i = 0; i<divider; i++){
            FileR.createNew(write_name+(i+1),content[i]);
        }
    }
}