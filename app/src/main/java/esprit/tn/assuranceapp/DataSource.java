package esprit.tn.assuranceapp;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Created by wael on 02/10/2017.
 */

public class DataSource {

    private static HashMap<String, List<User>> usersInCountries = new HashMap<>();

    public static void setUsersInCountries() {
        List<User> users = new ArrayList<>();

        users.add(new User("Wael Mallek", "Bizerte"));
        users.add(new User("Imed Amri", "Sidi Bouzid"));
        users.add(new User("Nader Rahamn", "Sousse"));
        users.add(new User("Houssem Lassoued", "Rafraf"));
        usersInCountries.put("Tunisia", users);

        List<User> users2 = new ArrayList<>();
        users2.add(new User("Parfait Desrosiers", "Paris"));
        users2.add(new User("Benjamin Dupéré", "Croix"));
        users2.add(new User("Juliette Labossière", "Le Port"));
        usersInCountries.put("France", users2);

        List<User> users3 = new ArrayList<>();
        users3.add(new User("Angela J. Schaefer", "Florida"));
        users3.add(new User("Joel M. Brown", "LA"));
        usersInCountries.put("USA", users3);
    }

    public static List<User> getUsersByCountry(String country){
        return usersInCountries.get(country);
    }

    public static boolean checkCountryExists(String country){
        setUsersInCountries();
        return usersInCountries.containsKey(country);
    }
}
