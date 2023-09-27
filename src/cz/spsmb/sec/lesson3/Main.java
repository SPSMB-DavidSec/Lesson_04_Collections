package cz.spsmb.sec.lesson3;

import cz.spsmb.sec.lesson3.exceptions.YouCanNotPassException;

import java.util.*;

public class Main {


    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Jan");
        names.add("David");
        names.add("Tomáš");
        names.add("Jan");
        names.add("Jana");
        names.add("Karel");
        names.get(0);

        printNames(names);
        System.out.println("----------------");

        Set<String> namesSet = new HashSet<>(names);
        namesSet.add("Pavel");

        printNames(namesSet);

        List<Person> personsList = new ArrayList<>();
        personsList.add(new Person("David Šec", "sec@spsmb.cz"));
        personsList.add(new Person("Bohata Jan", "bohata@spsmb.cz"));
        personsList.add(new Person("David Šec", "sec@spsmb.cz"));

        Set<Person> personsSet = new HashSet<>();
        personsSet.addAll(personsList);


        Map<String, Person> personsMap = new HashMap<>();
        personsMap.put("učitel", new Person("David Šec", "sec@spsmb.cz"));
        personsMap.put("ředitel", new Person("Bohata Jan", "bohata@spsmb.cz"));
        personsMap.put("učitel", new Person("Minařík Jan", "minarik@spsmb.cz"));


        printPersons(personsMap);


        //printPersons(personsList);
        //System.out.println("----------------");
        //printPersons(personsSet);

        ///Najdi osobu se jménem Tomáš
        try {
            String foundName = findByName("admin", names);
            foundName = foundName.toUpperCase();
            System.out.println(foundName);
        } catch (NullPointerException e) {
            System.out.println("Item not found! " + e.getMessage());
        }
        catch (YouCanNotPassException ex) {
            System.out.println("Item not found! " + ex.getMessage());
        }
    }

    private static String findByName(String name, List<String> names) throws NullPointerException {
        for (String item : names) {
            if (item.equals(name)) {
                return item;
            } else if (name.equals("admin")) {
                throw new YouCanNotPassException("Hey, what are you trying for???");
            }
        }
        throw new NullPointerException("Item " + name + " was not found in the list.");
    }

    public static void printNames(Collection<String> names) {
        names.forEach(name -> System.out.println(name));
    }

    public static void printPersons(Collection<Person> persons) {
        persons.forEach(name -> System.out.println(name));
    }

    public static void printPersons(Map<String, Person> persons) {
        for (Person person : persons.values()) {
            System.out.println(person);
        }
    }

}
