import com.gluonhq.charm.glisten.control.TextField;
import javafx.fxml.FXML;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.text.Text;

import java.io.IOException;

public class Controller extends FileR{
    Board board = new Board();
    Main main = new Main();
    Player player = main.getPlayer();
    Score score = new Score();

    @FXML
    private ImageView imgView;

    @FXML
    private Text mainMsg;

    @FXML
    private Text blank;

    @FXML
    private TextField input;

    @FXML
    private Text scoreInfo;

    @FXML
    private Text yourInfo;

    public Controller() throws IOException {
    }

    public void initialize() {
        mainMsg.setText("I am thinking of a word "+ player.getName() +"... guess a letter!");
        String setup = board.getCompare().toString();
        blank.setText(board.clean(setup));
        Image imageNew = new Image(getFile().toURI().toString());
        imgView.setImage(imageNew);
        scoreInfo.setText("Current High-Score: " + score.getHighscore() + " \nWith " + score.getHighest() + " points!");
        yourInfo.setText("Your Current Score:\n" + player.getScore());
    }

    @FXML
    public void Guess(KeyEvent event) throws IOException {
        if(event.getCode()== KeyCode.ENTER) {//check if word contains input
            char g = input.getText().charAt(0);
            if(board.getWord().contains(g) && !board.getLetterBank().contains(g)){
                mainMsg.setText("Correct!");
                board.setLetterBank(board.getLetterBank(), g);
                String updated = board.convert(g);
                blank.setText(updated);
                player.setScore(player.getScore() + 10);

                if(!updated.contains("_")){
                    mainMsg.setText("Congratulations, you've won!");
                    Score score = new Score();
                    score.setName(player.getName());
                    score.setfScore(player.getScore());
                    score.writeScore();
                }
            }
            else if(board.getLetterBank().contains(g)){
                mainMsg.setText("You have already tried this letter. Try again.");
            }
            else{
                board.setLetterBank(board.getLetterBank(), g);
                mainMsg.setText("Wrong guess. Try again.");
                player.setFail(player.getFail()+1);
                setFile(player.getFail());
                player.setScore(player.getScore()-5);
                Image imageN = new Image(getFile().toURI().toString());
                imgView.setImage(imageN);
                if(imgView.getImage().getUrl().contains("state7")){
                    mainMsg.setText("Out of tries. Game over. \n Score: " + player.getScore());
                }
            }
            yourInfo.setText("Your Current Score:\n" + player.getScore());
            input.setText("");
        }
    }
}