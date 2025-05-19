import java.util.*;

public class Main {
    public static void main(String[] args) {
/*        HashMap<String, List<String>> dictionary = new HashMap<>();
        dictionary.put("dog",List.of("sobaka"));
        dictionary.put("brother", List.of("brat"));
        dictionary.put("mother", List.of("mama","mat"));
        dictionary.put("father", List.of("otec","papa"));
        dictionary.put("home", List.of("dom"));*/

        HashMap<String, String> dictionary = new HashMap<>();
        dictionary.put("dog", "sobaka");
        dictionary.put("brother", "brat");
        dictionary.put("mother", "mama");
        dictionary.put("father", "otec");
        dictionary.put("home", "dom");

        do {
            System.out.println("Vyberite deystvie: ");
            System.out.println("""
                    1. Sozdanie slova i perevoda
                    2. Naiti slovo i perevod
                    3. Obnovlenie znacheniya
                    4. Obnovlenie klucha
                    5. Udalenie po kluchyu
                    6. Udalenie po znacheniyu
                    """);
            Scanner scanner = new Scanner(System.in);
            int choice = scanner.nextInt();
            scanner.nextLine();
            switch (choice) {
                case 1:
                    System.out.println("*** Dobavlenie novogo slova ***");
                    System.out.println("Vvedite slovo(en)");
                    scanner = new Scanner(System.in);
                    String wordAdd = scanner.nextLine();

                    if (!dictionary.containsKey(wordAdd) && !dictionary.containsValue(wordAdd)) {
                        System.out.print("Vvedite perevod dannoqo slova(ru) : ");
                        scanner = new Scanner(System.in);
                        String newWord = scanner.nextLine();
                        newWord = newWord.toLowerCase();
                        dictionary.put(wordAdd, newWord);
                    }
                    break;
                case 2:
                    System.out.print("Vvedite slovo: ");
                    String word = scanner.nextLine();
                    word = word.toLowerCase();

                    if (dictionary.containsKey(word)) {
                        System.out.println(word + " (en) => " + dictionary.get(word) + " (ru)");
                    } else if (dictionary.containsValue(word)) {
                        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                            if (entry.getValue().equals(word)) {
                                System.out.println(entry.getKey() + " (en) => " + entry.getValue() + " (ru)");
                                break;
                            }
                        }
                    } else {
                        System.out.print("Dannoe slovo otsutsvuet,Ne xotite li vi eqo dobavit\n1 - Da\n2 - Net\n");
                        scanner = new Scanner(System.in);
                        int select = scanner.nextInt();

                        if (select == 1) {
                            System.out.print("Vvedite perevod dannoqo slova : ");
                            scanner = new Scanner(System.in);
                            String newWord = scanner.nextLine();
                            newWord = newWord.toLowerCase();
                            dictionary.put(newWord, word);
                        }
                    }
                    break;
                case 3:
                    //Возможно я неправильно понял, но сделал обновление значения по ключу.
                    System.out.println("*** Obnovlenie znacheniya: ");
                    System.out.println("Vvedite slovo(en), kotoroe nado obnovit: ");
                    String wordUpdate = scanner.nextLine();
                    if (dictionary.containsKey(wordUpdate)) {
                        System.out.println("Vvedite novoe zhachenie klucha: ");
                        scanner = new Scanner(System.in);
                        String newWord = scanner.nextLine();
                        dictionary.replace(wordUpdate, newWord);
                    }
                    break;
                case 4:
                    System.out.println("*** Obnovlenie klucha ***");
                    System.out.println("Vvedite kluch: ");
                    String wordKey = scanner.nextLine();
                    if (dictionary.containsKey(wordKey)) {
                        String oldValue = dictionary.get(wordKey);
                        dictionary.remove(wordKey);
                        String newKey = scanner.nextLine();
                        dictionary.put(newKey, oldValue);
                        System.out.println("Klyuch obnovlen");
                    } else {
                        System.out.println("Kluch ne obnaruzhen");
                    }
                    break;
                case 5:
                    System.out.println("*** Udaleniee po kluchu ***");
                    System.out.println("Vvedite kluch: ");
                    String key = scanner.nextLine();
                    if (dictionary.containsKey(key)) {
                        dictionary.remove(key);
                        System.out.println("Zapis po klyuchu udalena");
                    } else {
                        System.out.println("Kluch ne obnaruzhen");
                    }
                    break;
                case 6:
                    System.out.println("*** Udaleniee po znacheniyu ***");
                    System.out.println("Vvedite znachenie: ");
                    String value = scanner.nextLine();
                    if (dictionary.containsValue(value)) {
                        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
                            if (entry.getValue().equals(value)) {
                                dictionary.remove(entry.getKey());
                                System.out.println("Zapis udalena");
                            }
                        }
                    }
                    break;
                default:
                    System.out.println("Vveden neveriy parametr.");
                    break;
            }
        }
        while (true) ;
    }
}
