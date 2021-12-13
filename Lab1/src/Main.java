import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Locale;

public class Main {
    public static void main(String[] args) {
        String name = "test.txt";
        var find = search(new File("D:\\"), name);
         var findC = search(new File("C:\\"), name);
        if (find != "File not found") {
            System.out.println(find);
        } else if (findC != "File not found") {

         if (findC != null)
           System.out.println(findC);
        }
        else {
            System.out.println("File not found!!!!");
        }


    }

    public static String search(File file, String name) {
        if (file.isDirectory()) {
            File[] dirArr = file.listFiles();
            if (dirArr != null) {
                for (var i : dirArr) {
                    if (i.isDirectory()) {

                           var namecpy1 = search(i, name);
                        if (!name.equals(namecpy1))
                            return namecpy1;
                    } else if (i.getName().toLowerCase(Locale.ROOT).endsWith(name)) {
                        var temp = i.getParent() +"/"+ name;
                        name = temp;
                        return name;
                    }
                }
            }
        }
        return "File no found";
    }
}
