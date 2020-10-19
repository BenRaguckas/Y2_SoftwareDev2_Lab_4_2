import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Q3 {
    public static void main(String[] args) throws FileNotFoundException {
        int divider = 5;
        String read_name = "divider";
        String[] content = new String[divider];
        ArrayList<Integer> dist = new ArrayList<>();
        for(int i = 0; i<divider; i++) {
            content[i] = FileR.get_String(read_name + (i + 1));
            dist.add(i+1);
        }
        int rand;
        for (int i = 0; i<divider; i++){
            rand = (int)(Math.random()*dist.size());
            FileR.createNew(read_name+dist.get(rand), content[i]);
            FileR.amend(read_name+dist.get(rand),false);
            dist.remove(rand);
        }
    }
}