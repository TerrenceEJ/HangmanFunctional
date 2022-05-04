import java.io.*;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Score extends Player{
    File file = new File("stats.txt");
    FileReader fileReader = new FileReader("stats.txt");
    BufferedReader read = new BufferedReader(fileReader);
    Map<String, Integer> SB = new HashMap<>();
    private String scoreR = "";
    int fScore = 0;
    String highscore = "";
    int has = 0;

    public Score() throws IOException {
        if(!file.exists()){
            file.createNewFile();
            System.out.println("created scoreboard");
        }else{
            System.out.println("pulling up scoreboard");
        }
        scoreR = read.lines().collect(Collectors.joining());
        Arrays.stream(scoreR.split(",")).filter(l-> l.contains("-")).forEach(
                l-> {
                    String[] pair = l.split("-");
                    String key = pair[0];
                    String value = pair[1];
                    SB.put(key, Integer.valueOf(value));
                }
        );

        has = SB.entrySet().stream().max(Map.Entry.comparingByValue()).get().getValue();
        highscore = SB.entrySet().stream().max(Map.Entry.comparingByValue()).get().getKey();

        read.close();
    }

    public int getHighest(){
        return this.has;
    }

    public String getHighscore(){
        return this.highscore;
    }

    public void writeScore() throws IOException {
        FileWriter fileWriter = new FileWriter("stats.txt");
        fileWriter.write(scoreR+"Player Name: " + getName() +
                            "-" + getfScore() + ","
        );
        fileWriter.close();
    }


    public String getScoreR() {
        return scoreR;
    }

    public void setScoreR(String scoreR) {
        this.scoreR = scoreR;
    }

    public int getfScore() {
        return fScore;
    }

    public void setfScore(int fScore) {
        this.fScore = fScore;
    }
}
