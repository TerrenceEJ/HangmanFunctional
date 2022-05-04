import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Board extends FileR{
    private List<Character> word;
    private List<Character> compare;
    private String chosenW;
    private List<Character>letterBank = new ArrayList<>();
    private String past = " ";


    Board(){
        String[] wordBank = {"bird", "programming", "human", "soda", "salsa", "oregano", "computer", "firefly", "strength", "agility"};
        int random = ThreadLocalRandom.current().nextInt(0, wordBank.length);
        this.chosenW = wordBank[random];
        this.word = chosenW.chars().mapToObj(a-> (char) a).collect(Collectors.toList());
        this.compare = Collections.nCopies(word.size(), '_').stream().collect(Collectors.toList());
    }

    public String clean(String w){
        w = w.replace("[", "");
        w = w.replace("]", "");
        w = w.replaceAll(",", "");
        return w;
    }

    public void setLetterBank(List<Character> letterBank, char c) {
        letterBank.add(c);
        this.letterBank = letterBank;
    }

    public List<Character> getLetterBank() {
        return letterBank;
    }

    public String convert(char c){
        String finish = chosenW;
        String progress = getCompare().toString();

        if(word.contains(c)){
            past += c;
            System.out.println(past);
            progress = finish.replaceAll("[^"+past+"]", "_ ");
        }

        progress = clean(progress);
        this.compare = progress.chars().mapToObj(a-> (char) a).collect(Collectors.toList());
        return progress;
    }


    public List<Character> getWord() {
        return word;
    }

    public List<Character> getCompare() {
        return compare;
    }

    public void setCompare(List<Character> compare) {
        this.compare = compare;
    }

    public void setWord(List<Character> word) {
        this.word = word;
    }
}
