import java.util.ArrayList;

public class Person {
    private ArrayList<String> numbers = new ArrayList<>();
    private String eMail;

    public Person(String phoneNumber, String eMail) {
        numbers.add(phoneNumber);
        this.eMail = eMail;
    }

    public ArrayList<String> getNumbers() {
        return numbers;
    }

    public String getMail() {
        return eMail;
    }
    public void addPhoneNumber(String number){
        numbers.add(number);
    }
}
