package Task_1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidator {

    public static void isValidePhoneNumber() {
        String regex = "\\(\\d{3}\\)\\s\\d{3}-\\d{4}|\\d{3}-\\d{3}-\\d{4}";
        Pattern pattern = Pattern.compile(regex);


        try (BufferedReader reader = new BufferedReader(new FileReader("file.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.matches()) {
                    System.out.println(matcher.group());
                }

            }
        } catch (IOException e) {
            System.out.println(e.getMessage());

        }

    }
}
