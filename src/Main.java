import java.io.File;

public class Main extends PhoneBook {
    public static void main(String[] args) {
        File file = new File("src\\phonebook.txt");
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.readFromFile(file);
        System.out.println(phoneBook.getPairs());

        phoneBook.deletePairByName();
        System.out.println(phoneBook.getPairs());

        phoneBook.addPair();
        System.out.println(phoneBook.getPairs());

        phoneBook.accessToPhoneNumber();
        phoneBook.accessToPhoneNumber();
        phoneBook.accessToPhoneNumber();
        phoneBook.accessToPhoneNumber();
        phoneBook.accessToPhoneNumber();

        phoneBook.printFivePairsWithBiggestAccess();
    }

}
