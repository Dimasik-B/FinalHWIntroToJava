public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Ivanov", 6556268);
        phoneBook.add("Petrov", 6775311);
        phoneBook.add("Ivanov", 6556269);
        phoneBook.add("Petrov", 6775312);
        phoneBook.add("Petrov", 6775313);
        phoneBook.add("Baranova", 6451155);
        phoneBook.add("Kalinin", 6139966);
        phoneBook.add("Kalinin", 6139967);
        phoneBook.add("Fedorova", 6237175);
        System.out.println(phoneBook.getPhoneBook());
        System.out.println(phoneBook.findByName("Petrov"));
        System.out.println(phoneBook.findByPhoneNumber(6556268));
        System.out.println(phoneBook.findByName("Petrosv"));
        System.out.println(phoneBook.findByPhoneNumber(13691369));
        System.out.println(phoneBook.removeByName("Petrov"));
        System.out.println(phoneBook.removeByName("Smirnov"));
        System.out.println(phoneBook.removeByNumber(6451155));
        System.out.println(phoneBook.removeByNumber(1111111));
        System.out.println(phoneBook.removeNumber(222222));
        System.out.println(phoneBook.removeNumber(6139967));
        System.out.println(phoneBook.getPhoneBook());
    }
}