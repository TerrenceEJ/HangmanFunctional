import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Locale;
import java.util.Scanner;

import static java.lang.System.exit;

public class Main extends Application {
    static Player player = new Player();

    @Override
    public void start(Stage stage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("mainGame.fxml"));
        Scene scene = new Scene(root);
        scene.setRoot(root);
        stage.setScene(scene);
        stage.setTitle("Hangman");
        stage.show();
        scene.getRoot().requestFocus();
    }

    public static void main(String[] args) throws IOException {
        Controller controller = new Controller();

        System.out.println("Hello, what is your name?");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        player.setName(name);
        System.out.println("Hello, " + player.getName() + " would you like to play a game? (y/n)");
        if(scanner.nextLine().toLowerCase(Locale.ROOT).charAt(0) == 'y') {
            launch(args);
        }else{
            exit(0);
        }

    }

    public Player getPlayer(){
        return this.player;
    }
}
