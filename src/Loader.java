import javax.swing.*;
import java.io.IOException;

public class Loader {
    public static void main(String[] args) throws IOException {

        MyFrame myFrame = new MyFrame();
        myFrame.setUndecorated(true);
        myFrame.setSize(800, 600);
        myFrame.setLocationRelativeTo(null);
        myFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        myFrame.setVisible(true);
    }

}