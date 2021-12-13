import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        String name = "test.txt";
        Path path= Paths.get(name);
        List<Character> chars = new ArrayList<>();

        BufferedReader reader = null;
        reader = new BufferedReader(new FileReader(new File(name)));
        int c;

        FileInputStream is = new FileInputStream(name);
        FileOutputStream fos = new FileOutputStream("test2.txt");
        FileChannel f = is.getChannel();
        FileChannel f2 = fos.getChannel();

        f.transferTo(0, f.size(), f2);

        f2.close();
        f.close();

        Arrays.asList(name).parallelStream().forEach((filepath) -> {
            Path source = Paths.get(filepath);
            Path target = Paths.get("text3.txt");
            try {
                System.out.println(Files.copy(source, target, StandardCopyOption.REPLACE_EXISTING));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

    }
}
