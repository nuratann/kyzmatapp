package kg.kyzmatapp.freelancerservice.utils;

import java.security.SecureRandom;

public class RandomStringGenerator {

    private static final String CHARACTERS = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz";
    private static final SecureRandom RANDOM = new SecureRandom();

    public static String generateRandomString(int length, boolean number) {
        StringBuilder stringBuilder = new StringBuilder(length);
        int len = number? 10 : CHARACTERS.length();
        for (int i = 0; i < length; i++) {
            int index = RANDOM.nextInt(len);
            stringBuilder.append(CHARACTERS.charAt(index));
        }
        return stringBuilder.toString();
    }

    public static String generateRandomString(int length) {
        return generateRandomString(length, false);
    }

    public static String generateRandomEmail() {
        return generateRandomString(8)+"@"+generateRandomString(4)+".com";
    }

    public static String generateRandomPhone(int length) {
        return "+"+generateRandomString(length, true);
    }
}
