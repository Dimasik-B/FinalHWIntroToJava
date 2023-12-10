import java.util.*;

public class PhoneBook {
    private static HashMap<String, ArrayList<Integer>> phoneBook = new HashMap<>();

    public void add(String name, Integer phoneNum) {
        ArrayList<Integer> list = new ArrayList<>();
        if (phoneBook.containsKey(name)){
            phoneBook.get(name).add(phoneNum);
        } else {
            phoneBook.put(name, list);
            list.add(phoneNum);
        }

    }

    public String findByName(String name) {
        StringBuilder stringBuilder = new StringBuilder();
        if(phoneBook.containsKey(name))
            return stringBuilder.append(name)
                    .append(" : ")
                    .append(phoneBook.get(name))
                    .append("\n").toString();
        else
            return stringBuilder.append("Такого имени нет: ")
                    .append(name)
                    .append("\n").toString();
    }

    public String findByPhoneNumber(Integer phoneNum){
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry entry:
             phoneBook.entrySet()) {
                for (Integer number:
                     phoneBook.get(entry.getKey())) {
                    if (number.equals(phoneNum)) {
                        stringBuilder.append(entry.getKey())
                                .append(" : ")
                                .append(entry.getValue())
                                .append("\n");
                    }
                }
             }
        if (stringBuilder.isEmpty())
            stringBuilder.append("Такого телефона нет: ")
                .append(phoneNum)
                .append("\n");
        return stringBuilder.toString();
    }

    public String removeByName(String name){
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry entry:
                phoneBook.entrySet()) {
            if(entry.getKey().toString().equals(name)){
                stringBuilder.append("Данные удалены: ")
                        .append(name)
                        .append(" - ")
                        .append(phoneBook.get(name))
                        .append("\n");
            }
        }
        if (stringBuilder.isEmpty())
            stringBuilder.append("Такого имени нет: ")
                .append(name)
                .append("\n");
        else phoneBook.remove(name);
        return stringBuilder.toString();
    }

    public String removeByNumber(Integer phoneNum){
        String key = "";
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry entry:
                phoneBook.entrySet()) {
            for (Integer number :
                    phoneBook.get(entry.getKey())) {
                if (number.equals(phoneNum)) {
                    key = entry.getKey().toString();
                    stringBuilder.append("Данные удалены: ")
                            .append(key)
                            .append(" - ")
                            .append(phoneBook.get(key))
                            .append("\n");
                }
            }
        }
        if (stringBuilder.isEmpty())
            stringBuilder.append("Такого телефона нет: ")
                    .append(phoneNum)
                    .append("\n");
        else phoneBook.remove(key);
        return stringBuilder.toString();
    }

    public String removeNumber(Integer phoneNum){
        String key = "";
        int index = 0;
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry entry:
                phoneBook.entrySet()) {
            for (Integer number :
                    phoneBook.get(entry.getKey())) {
                if (number.equals(phoneNum)) {
                    key = entry.getKey().toString();
                    stringBuilder.append("Номер удалён: ")
                            .append(phoneNum)
                            .append(" - ")
                            .append("Абонент: ")
                            .append(key)
                            .append("\n");
                    index = phoneBook.get(key).indexOf(phoneNum);
                }
            }
        }
        if (stringBuilder.isEmpty())
            stringBuilder.append("Такого телефона нет: ")
                    .append(phoneNum)
                    .append("\n");
        else phoneBook.get(key).remove(index);
        return stringBuilder.toString();
    }

    public String getPhoneBook() {
        List <Integer> numsCounts = new ArrayList<Integer>();
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry entry:
                phoneBook.entrySet()) {
            if(!numsCounts.contains(phoneBook.get(entry.getKey()).size()))
                numsCounts.add(phoneBook.get(entry.getKey()).size());
        }

        Collections.sort(numsCounts, Collections.reverseOrder());

        for (int i = 0; i < numsCounts.size(); i++) {
            for (Map.Entry entry :
                    phoneBook.entrySet()) {
                if(phoneBook.get(entry.getKey()).size() == numsCounts.get(i)) {
                    stringBuilder.append(entry.getKey())
                            .append(" : ")
                            .append(entry.getValue())
                            .append("\n");
                }
            }
        }
        return stringBuilder.toString();
    }
}
