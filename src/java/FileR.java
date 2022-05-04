import javafx.scene.image.Image;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class FileR {
    private File file = new File("src/java/state/base.png");
    public ArrayList<File> img = new ArrayList<>(8);
    private String rotation = "";

    FileR(){
        if(file.exists()) {
            img.add(new File("src/java/state/base.png"));
            img.add(new File("src/java/state/state1.png"));
            img.add(new File("src/java/state/state2.png"));
            img.add(new File("src/java/state/state3.png"));
            img.add(new File("src/java/state/state4.png"));
            img.add(new File("src/java/state/state5.png"));
            img.add(new File("src/java/state/state6.png"));
            img.add(new File("src/java/state/state7.png"));
        }
        else {
            System.out.println("File doesn't exist");
        }

    }

    public void showImg() throws IOException {

    }

    public File getFile() {
        return file;
    }

    public void setFile(int i) {
        file = img.get(i);
    }
}
