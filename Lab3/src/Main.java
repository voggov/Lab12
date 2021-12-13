import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {

    private static List<Character> chars = new ArrayList<>();
    public static void main(String[] args) {
        BufferedReader reader = null;
        BufferedReader reader2 = null;
        try {
            reader = new BufferedReader(new FileReader(new File("first.txt")));

            int c;
            while ((c = reader.read()) != -1) {
                chars.add((char) c);
            }

            reader.close();
            System.out.println(chars.toString());

            reader2 = new BufferedReader(new FileReader(new File("second.txt")));
            List<Character> chars2 = new ArrayList<>();
            while ((c = reader2.read()) != -1) {
                chars2.add((char) c);
            }

            reader2.close();
            System.out.println(chars2.toString());

            System.out.println(chars.equals(chars2));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


    }


    }

