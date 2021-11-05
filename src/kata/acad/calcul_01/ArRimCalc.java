package kata.acad.calcul_01;


// загрузка(вызов) класса Scanner из пакета утилит Java
import java.util.Scanner;
// загрузка(вызов) класса InputMismatchException из пакета утилит Java
import java.util.InputMismatchException;



// Создание класса ArRimCalc
public class ArRimCalc {

/* Создание объекта класса Scanner для чтения введенных данных при помощи System.in
   и привязка его модификатором static к классу ArRimCalc */
    static Scanner scanner = new Scanner(System.in);

// Создание переменных типа int и переменной типа char. Привязка их модификатором static к классу ArRimCalc

    static int Число1;
    static int Число2;
    static int Результат;
    static char Действие;

// Создание метода Main
    public static void main(String[] args) {

// Вывод на монитор запроса на введение арифметического выражения
        System.out.println("_______________________________________________________________");
        System.out.println("Введите арифметическое выражение вида | 2+2 | 2-2 | 2*2 | 2/2 |\n латинскими или римскими цифрами и нажмите Enter. ");
        System.out.println("---------------------------------------------------------------");

// Считывание строки "ВведенныеДанные", введенную пользователем с переходом на следующую строку.
        String ВведенныеДанные = scanner.nextLine();

//  Создание заполняемого символьного массива типа char длиной 18 символов: "МассивСимволов".
        char[] МассивСимволов = new char[18];


/* Цикл заполнения символьного массива "МассивСимволов" данными. Длина строки определена методом length.
 Длина равна числу 16-разрядных символов Юникода в строке. */
        for (int i = 0; i < ВведенныеДанные.length(); i++) {

// Выбираем из введенных данных символ\значение i методом сharAt
            МассивСимволов[i] = ВведенныеДанные.charAt(i);

// Определение и присвоение символам реального арифметического действия.
            if (МассивСимволов[i] == '+') {
                Действие = '+';
            }
            if (МассивСимволов[i] == '-') {
                Действие = '-';
            }
            if (МассивСимволов[i] == '*') {
                Действие = '*';
            }
            if (МассивСимволов[i] == '/') {
                Действие = '/';
            }

        }
// Преобразуем и присваиваем в тип данных
        String МассивСимволовString = String.valueOf(МассивСимволов);

/* Присвоение/объявление параметров для строки типа "String", содержащей массив-"[]"),
 и разделение строки "МассивСимволовString" на подстроки методом split по параметру (regex) "[+-/*]" */
        String[] blacks = МассивСимволовString.split("[+-/*]");

// ????????????
        String stable00 = blacks[0];
        String stable01 = blacks[1];

// Возвращаем параметр строки с массивом black[1] без пробелов методом trim
        String string03 = stable01.trim();

// Присвоение\замена арабских цифр на латинские
        Число1 = РимЦифра(stable00);
        Число2 = РимЦифра(string03);

// Задание алгоритма на сравнение\определение значения переменных Число1 и Число2. (меньше нуля - false. Результат=0).

// (Оператор if и логический оператор &&)
        if (Число1 < 0 && Число2 < 0) {
            Результат = 0;

// Если обе части выражения не меньше 0, то вычисляется.
        } else {
            Результат = calculated(Число1, Число2, Действие);
            System.out.println("---Результат для римских цифр----");

// Выводится вычисленный результат конвертации.
            String результатРим = convertРимЦифра(Результат);
            System.out.println(stable00 + " " + Действие + " " + string03 + " = " + результатРим);
        }
// Вызываю статический метод parseInt из класса Integer. (???? Возвращаем араб. значение Числу1 и Числу2.)
        Число1 = Integer.parseInt(stable00);
        Число2 = Integer.parseInt(string03);

//Вычисляю и вывожу после заставки результат для араб.цифр.
        Результат = calculated(Число1, Число2, Действие);
        System.out.println("--Результат для арабских цифр--");
        System.out.println(Число1 + " " + Действие + " " + Число2 + " = " + Результат);

    }

// Строчный массив римских чисел\цифр для конвертации в арабские.
    private static String convertРимЦифра (int numArabian) {
        String[] roman = {"O", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII",
                "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI",
                "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII",
                "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX",
                "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII",
                "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV",
                "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV",
                "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI",
                "XCVII", "XCVIII", "XCIX", "C"
        };

// Объявление строки s константой.
        final String s = roman[numArabian];
// Остановка выполнения метода.
        return s;
    }

/* Отслеживание исключений в операторах блока try
  Сравнение, определене, присвоение и завершение метода после определения.
  Передача исключений в блок catch  */

    private static int РимЦифра (String roman) {
        try {
            if (roman.equals("I")) {
                return 1;
            } else if (roman.equals("II")) {
                return 2;
            } else if (roman.equals("III")) {
                return 3;
            } else if (roman.equals("IV")) {
                return 4;
            } else if (roman.equals("V")) {
                return 5;
            } else if (roman.equals("VI")) {
                return 6;
            } else if (roman.equals("VII")) {
                return 7;
            } else if (roman.equals("VIII")) {
                return 8;
            } else if (roman.equals("IX")) {
                return 9;
            } else if (roman.equals("X")) {
                return 10;
            }

// Блок catch задействует библиотеку утилит java InputMismatchException для отработки ошибок.
        } catch (InputMismatchException e) {

// Создание объекта класса InputMismatchException для "ручной" передачи ошибок на отработку.
            throw new InputMismatchException("Неверный формат данных");
        }
// ???
        return -1;
    }

// Создаем метод calculated c операторами int Число1, int Число2, char Действие, int Результат.

    public static int calculated (int Число1, int Число2, char Действие) {
        int Результат = 0;

// Оператор switch сравнивает полученное Действие со значением (по поряду)
// При совпадении условий выполняется код после двоеточия.
// Консструкция break передает значение для обработки за пределы блока switch.
// .
        switch (Действие) {
            case '+':
                Результат = Число1 + Число2;
                break;
            case '-':
                Результат = Число1 - Число2;
                break;
            case '*':
                Результат = Число1 * Число2;
                break;
            case '/':
                try {
                    Результат = Число1 / Число2;
                } catch (ArithmeticException | InputMismatchException e) {
                    System.out.println("Ошибка : " + e);
                    System.out.println("Допускаются только целочисленные и ненулевые параметры");

                    break;
                }
                break;
            default:
                throw new IllegalArgumentException("Не верный знак операции");
        }
        return Результат;
}
}


