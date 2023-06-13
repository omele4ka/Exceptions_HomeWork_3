package homeWork3.exceptions;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class MyExceptions {
    // Проверка ввода пользовательских данных
    public static boolean isFullData(String[] array) {
        if (array.length < 6) {
            System.out.println("Вы ввели не все данные");
            throw new RuntimeException("Введены не все данные");
        } else if (array.length > 6) {
            System.out.println("Вы ввели что-то лишнее");
            throw new RuntimeException("Введены лишние данные");
        }
        return true;
    }

// Проверка ввода номера телефона
    public static boolean isCorrectPhoneNumber(String phoneNumber){
        try {
            if (phoneNumber.matches("\\d{1,10}")) {
                return true;
            } else {
                throw new IllegalArgumentException("Номер телефона введен неверно. Формат ввода - 10 цифр без спецсимволов");
            }
        } catch (NullPointerException e) {
            return false;
        }
    }

    // Проверка ввода даты рождения
    public static boolean isDateOfBirthCorrect(String dateOfBirth) {
        try{
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd.MM.yyyy");
            LocalDate.parse(dateOfBirth, formatter);
            return true;
        } catch (DateTimeParseException | NullPointerException e){
            System.out.println("Дата рождения введена некорректно. Формат ввода: dd.mm.yyyy");
            return false;
        }
    }

    // Проверка ввода пола
    public static boolean isGenderCorrect(String gender){
        try {
            if (gender.equalsIgnoreCase("f") || gender.equalsIgnoreCase("m")) {
                return true;
            } else {
                throw new IllegalArgumentException("Пол введен неверно. Введите букву латиницей 'f' или 'm'.");
            }
        } catch (NullPointerException e) {
            return false;
        }
    }

}
