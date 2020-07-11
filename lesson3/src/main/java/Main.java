import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        part_1();

        PhoneBook book = new PhoneBook();
        book.jobPhoneBook();

    }

    private static void part_1() {
        Scanner scan = new Scanner(System.in);
        String textToCheck = scan.nextLine();
        textToCheck = textToCheck.replaceAll("(\\p{Punct}|\\d|\\s)", " ");
        String[] words = textToCheck.split("(\\s)");
        HashMap<String, Integer> dictionary = new HashMap<>();

        for(String word : words){
            word = word.toLowerCase();
            if(!word.isEmpty()) {
                if (!dictionary.containsKey(word)) {
                    dictionary.put(word, 1);
                } else {
                    dictionary.replace(word, dictionary.get(word) + 1);
                }
            }
        }
        for(Map.Entry<String, Integer> pair : dictionary.entrySet()){
            System.out.println(pair.getKey() + " : " + pair.getValue());
        }
        scan.close();
    }
}
