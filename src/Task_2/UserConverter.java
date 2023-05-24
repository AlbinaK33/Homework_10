package Task_2;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UserConverter {

    public static void userConverter() {

        List<User> users = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader("file1.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] array = line.split(" ");
                User user = new User(array[0], Integer.parseInt(array[1]));
                users.add(user);
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

        try (Writer writer = new FileWriter("user.json")) {
            Gson gson = new GsonBuilder().create();
            gson.toJson(users, writer);
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }

    }
}
