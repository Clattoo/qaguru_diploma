package utils;

import com.github.javafaker.Faker;

public class RandomUtils {

    final Faker faker = new Faker();

    public String getRandomUserName() {
        return faker.name().username().replaceAll("[.]", "");
    }

    public String getRandomEmail() {
        return faker.internet().emailAddress();
    }

    public String getRandomPassword() {
        return faker.internet().password();
    }

    public String getProgrammingLanguage() {
        return faker.programmingLanguage().name();
    }
}
