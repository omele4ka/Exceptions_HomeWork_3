package homeWork3;

import static homeWork3.exceptions.MyExceptions.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

/* Напишите приложение, которое будет запрашивать у пользователя следующие данные, разделенные пробелом:
Фамилия Имя Отчество датарождения номертелефона пол

Форматы данных:
фамилия, имя, отчество - строки
датарождения - строка формата dd.mm.yyyy
номертелефона - целое беззнаковое число без форматирования
пол - символ латиницей f или m.

Приложение должно проверить введенные данные по количеству. Если количество не совпадает с требуемым, бросить исключение, обработать его и показать пользователю сообщение, что он ввел меньше и больше данных, чем требуется.

Приложение должно попытаться распарсить полученные значения и выделить из них требуемые параметры. Если форматы данных не совпадают, нужно бросить исключение, соответствующее типу проблемы. Можно использовать встроенные типы java и создать свои. Исключение должно быть корректно обработано, пользователю выведено сообщение с информацией, что именно неверно.

Если всё введено и обработано верно, должен создаться файл с названием, равным фамилии, в него в одну строку должны записаться полученные данные, вида

<Фамилия><Имя><Отчество><датарождения> <номертелефона><пол>

Однофамильцы должны записаться в один и тот же файл, в отдельные строки.

Не забудьте закрыть соединение с файлом.

При возникновении проблемы с чтением-записью в файл, исключение должно быть корректно обработано, пользователь должен увидеть стектрейс ошибки.

 */

public class Main {
    public static void main(String[] args) {

        String userInput = userInput();
        String[] userData = userInput.split(" ");

        String lastname;
        if (isFullData(userData)) {
            lastname = userData[0];
            String firstName = userData[1];
            String patronymic = userData[2];
            String dateOfBirth = userData[3];
            String phoneNumber = userData[4];
            String gender = userData[5];
            isCorrectPhoneNumber(phoneNumber);
            isDateOfBirthCorrect(dateOfBirth);
            isGenderCorrect(gender);
            createFile(lastname + ".txt", userData, existFile(lastname + ".txt"));

        }
    }

    // Ввод данных пользователем
    private static String userInput() {
        Scanner userInput =  new Scanner(System.in);
        System.out.println("Введите данные в формате: фамилия, имя, отчество - строки\n" +
                "дата рождения - строка формата dd.mm.yyyy\n" +
                "номер телефона - целое беззнаковое число без форматирования\n" +
                "пол - символ латиницей f или m.");
        return userInput.nextLine();
    }

    // Запись данных в файл
    public static void createFile(String path, String[] userData, Boolean append){
        File file = new File(path);
        try(FileWriter writer = new FileWriter(file, append)) {
            for (String s : userData) {
                writer.write(" " + s + " ");
            }
            writer.write("\n");
            writer.flush();
            System.out.println("Данные успешно сохранены!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static Boolean existFile(String path) {
        File file = new File(path);
        return file.isFile();
    }
}
