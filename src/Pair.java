class Pair {

    private int count;
    private String name;
    private String phoneN;

    public Pair(String phoneN, String name) {
        this.phoneN = phoneN;
        this.setName(name);
    }

    public int getCount() {
        return count;
    }

    public void increaseCounter() {
        this.count += 1;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneN() {
        return phoneN;
    }

    public void setPhoneN(String phoneN) {
        this.phoneN = phoneN;
    }

    public String toString() {
        return this.name + " " + this.phoneN + " " + this.count;
    }
         /*class Sorting implements Comparator<PhoneBook.Pairs> {

            public int compare(PhoneBook.Pairs a, PhoneBook.Pairs b) {
                return a.count - b.count;

            }
            }*/


}