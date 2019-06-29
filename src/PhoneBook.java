import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;


public class PhoneBook {
    private static final String PREFIX_PLUS_359 = "+359";
    private static final String PREFIX_00359 = "00359";
    private static final String PREFIX_ZERO = "0";
    private static final String PREFIX_08 = "08";
    private List<Pair> pairs = new ArrayList<Pair>();


    public void readFromFile(File file) {
        try {
            Scanner sc = new Scanner(file);


            while (sc.hasNextLine()) {
                String line = sc.nextLine();
                String[] details = line.split(" ");
                String name = details[0];
                String phoneN = details[1];
                if (isValidNumbers(phoneN)) {
                    String convertedPhoneNumber = convertInNormalPhoneNumbers(phoneN);
                    Pair pair = new Pair(convertedPhoneNumber, name);
                    pairs.add(pair);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    public void addPair() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the name of the pair:");
        String name = scanner.nextLine();
        System.out.println("Enter phone number:");
        String phoneN = scanner.nextLine();
        if (isValidNumbers(phoneN)) {
            phoneN = convertInNormalPhoneNumbers(phoneN);

            Pair pair = new Pair(phoneN, name);
            pairs.add(pair);
        }

    }

    public void deletePairByName() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name :");
        String nameToDelete = scanner.nextLine();
        pairs.removeIf(pairs1 -> pairs1.getName().equals(nameToDelete));
    }

    public void accessToPhoneNumber() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name :");
        String name = scanner.nextLine();
        pairs.forEach(pairs1 -> {
            if (pairs1.getName().equals(name)) {
                pairs1.increaseCounter();
            }
        });
    }

    public void printFivePairsWithBiggestAccess() {
        sortPairsByOutgoingCalls();

        if (pairs.size() <= 5) {
            System.out.println(pairs);
        } else {
            System.out.println(pairs.subList(0, 5));
        }
    }

    public List<Pair> getPairs() {
        return pairs;
    }

    private void sortPairsByOutgoingCalls() {
        pairs.sort(new Sorting());
    }

    private boolean isValidNumbers(String phoneN) {
        if (!phoneN.startsWith(PREFIX_PLUS_359) && !phoneN.startsWith(PREFIX_00359) && !phoneN.startsWith(PREFIX_08)) {
            return false;
        }

        String subnumber;
        if (phoneN.startsWith(PREFIX_00359)) {
            subnumber = phoneN.substring(5);

        } else if (phoneN.startsWith(PREFIX_ZERO)) {
            subnumber = phoneN.substring(1);
        } else {
            subnumber = phoneN.substring(4);
        }

        if (!subnumber.startsWith("88") && !subnumber.startsWith("87") && !subnumber.startsWith("89")) {
            return false;
        }

        subnumber = subnumber.substring(2);

        if (2 > Integer.parseInt(subnumber.substring(0, 1)) || Integer.parseInt(subnumber.substring(0, 1)) > 9) {
            return false;
        }
        subnumber = subnumber.substring(1);

        if (subnumber.length() != 6) {
            return false;
        }

        for (int i = 0; i < subnumber.length(); i++) {
            int currentNumber = subnumber.charAt(i) - '0';
            if (currentNumber > 9 || currentNumber < 0) {
                return false;
            }
        }

        return true;

    }

    private String convertInNormalPhoneNumbers(String phoneN) {
        if (phoneN.startsWith(PREFIX_PLUS_359)) {
            return phoneN.replace(PREFIX_PLUS_359, PREFIX_ZERO);
        }

        if (phoneN.startsWith(PREFIX_00359)) {
            return phoneN.replace(PREFIX_00359, PREFIX_ZERO);
        }

        return phoneN;
    }
}



