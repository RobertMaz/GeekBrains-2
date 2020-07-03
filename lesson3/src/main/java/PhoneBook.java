import java.util.*;

public class PhoneBook {
    private HashMap<String, Person> book = new HashMap<>();


    public ArrayList<String> getPhoneNumbers(String name){
            return book.get(name).getNumbers();
    }
    public String getEmailAdders(String name){
        return book.get(name).getMail();
    }


    public void jobPhoneBook(){
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to PhoneBook");
        while(true){
            printTask();
            int enterNumber;
            while (true) {
                try {
                    enterNumber = Integer.parseInt(scan.nextLine());
                    if (enterNumber > -1 && enterNumber < 5) break;
                } catch (InputMismatchException e){
                    System.out.println("Introduced illegal symbol. Please try again");
                    scan.nextLine();
                }
            }

            if (enterNumber == 0) break;
            if (enterNumber == 4) printPeople();
            try {
                if (enterNumber == 3) {
                    System.out.println("Please enter person name");
                    System.out.println(getPhoneNumbers(scan.nextLine()) + "\n");
                    continue;
                }

                if (enterNumber == 2) {
                    System.out.println("Please enter person name");
                    System.out.println(getEmailAdders(scan.nextLine()) + "\n");
                    continue;
                }
            } catch (NullPointerException e) {
                System.out.println("This name is not found\n");
            }

            if (enterNumber == 1){
                System.out.println("Please enter name");
                String name = scan.nextLine();
                System.out.println("Please enter phone number");
                String number = scan.nextLine();
                System.out.println("Please enter email address");
                String email = scan.nextLine();
                addPersonForPhoneBook(name, number, email);
            }
        }
        scan.close();
    }

    public void addPersonForPhoneBook(String name, String number, String email){
        if (book.containsKey(name)){
            book.get(name).addPhoneNumber(number);
        } else {
            book.put(name, new Person(number, email));
        }
    }

    public void printPeople(){
        for(Map.Entry<String, Person> pair : book.entrySet()){
            System.out.println(String.format("%s %s %s\n",pair.getKey(), pair.getValue().getNumbers(), pair.getValue().getMail()));
        }
    }


    public void printTask() {
        System.out.println("\nPlease enter number" +
                "\n1 for add Person to PhoneBook" +
                "\n2 for get email address by name" +
                "\n3 for get phone numbers by name" +
                "\n4 print list people in PhoneBook" +
                "\n0 end");
    }

}
