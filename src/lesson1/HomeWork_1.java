package lesson1;

import java.util.Arrays;
import java.util.Scanner;

public class HomeWork_1 {
    public static void main(String[] args) {
        System.out.println("---------N1--------");
        task1();
        System.out.println("---------N2--------");
        task2();
        System.out.println("---------N3--------");
        task3();
        System.out.println("---------PRO N1--------");
        proTask1();
        System.out.println("---------PRO N2--------");
        proTask2();
        System.out.println("---------PRO N3--------");
        proTask3();
        System.out.println("---------PRO N4--------");
        proTask4();
        System.out.println("---------Expert N1--------");
        ExpertTask1();

    }
    public static void task1() {
        //Задача №1
        //Дано (их менять нельзя)
        String hi = "                Hello ";
        String world = " WoRld!";
        char newLine = '\n';
        //Создать из трех переменных единую строку,
        //Привести к правильному виду (Ниже)
        //затроить (Можно вызвать тольку одну команду System.out.print())
        //
        //Результат вывода на экран:
        //Hello world!
        //Hello world!
        //Hello world!
        String result = hi.trim() + world.toLowerCase() + newLine;
        System.out.print(result.repeat(3));
    }

    public static void task2() {
        //Задача №2
        //Создать переменные с ростом, весом.
        //Произвести расчет индекса массы тела (вес) / (рост * рост) используя переменные, вывести на экран
        //Пример результата вывода на экран:
        //21.0
        float height = 1.75F;
        float weight = 75.5F;
        float imt = (float) (weight / Math.pow(height,2));
        System.out.println(String.format("%.1f", imt));
    }

    public static void task3() {
        //Задача №3
        //Создать из массива букв a,b,c,d,e, строку,вывести на экран , поменять в массиве 4 букву по счету на h,
        //и снова создать строку, вывести на экран
        char[] lettersArray = new char[] {'a','b','c','d','e'};
        String stringFromArray = String.valueOf(lettersArray);
        System.out.println(stringFromArray);
        lettersArray[3] = 'h';
        stringFromArray = String.valueOf(lettersArray);
        System.out.println(stringFromArray);
    }
    public static void proTask1() {
        //Задача №1
        //Произвести преобразование "234" в число типа int и прибавить к этому числу длину строки "some_text"
        String number = "234";
        String text = "some_text";
        int result = Integer.parseInt(number) + text.length();
        System.out.println(result);
    }
    public static void proTask2() {
        //Задача №2
        //Посчитать (a+b)^2 = ?, при a=3, b=5
        int a = 3;
        int b = 5;
        System.out.println(Math.pow(a+b,2));
    }
    public static void proTask3() {
        //Задача №3
        //Создать два массив чисел:
        // 1,2,5,7,10
        // 2,3,2,17,15
        // Создать массив чисел, в котором будут: все числа из этих двух массивов,
        // и результат умножения чисел с одинаковым порядковым номером
        //
        //Ожидаемый результат:
        //1,2,5,7,10,2,3,2,17,15,2,6,10,119,150
        //(первый массив - 1,2,5,7,10), (второй массив - 2,3,2,17,15),
        //(результат перемножения - (1*2), (2*3), (5*2), (7*17), (10*15)
        int[] firstArray = new int[]{1, 2, 5, 7, 10};
        int[] secondArray = new int[]{2, 3, 2, 17, 15};
        int[] multiplicationArray = new int[firstArray.length];
        int[] finalArray = new int[firstArray.length * 3];

        for (int i = 0; i < multiplicationArray.length; i++) {
            multiplicationArray[i] = firstArray[i] * secondArray[i];
        }
        System.arraycopy(firstArray,0,finalArray,0,firstArray.length);
        System.arraycopy(secondArray,0,finalArray,firstArray.length,secondArray.length);
        System.arraycopy(multiplicationArray,0,finalArray,firstArray.length+secondArray.length,multiplicationArray.length);
        System.out.println(Arrays.toString(finalArray));
    }
    public static void proTask4() {
        //Задача №4
        //В слове "Hello world!" заменить все l на r, сделать все буквы заглавными, выбрать первые 8 символов
        String word = "Hello world!";
        System.out.println(word.substring(0,7).replace('l','r').toUpperCase());
    }

    public static void ExpertTask1() {
        //Экспертный уровень
        //Задача №1
        //Создать метод маскирования персональных данных, который:
        //Телефон (до/после маскирования): 79991113344 / 7999***3344
        //Email (до/после маскирования): test@yandex.ru / tes*@******.ru, my_mail@gmail.com / my_mai*@*****.com
        //Фио (до/после маскирования): Иванов Иван Иванович / И****в Иван И.
        //
        //Входящие параметры: String text
        //Возвращаемый результат: String
        //
        //Примеры возможного текста:
        //<client>(Какие то данные)<data>79991113344;test@yandex.ru;Иванов Иван Иванович</data></client> - "<client>(Какие то данные)<data>7999***3344;tes*@******.ru;И****в Иван И.</data></client>"
        //<client>(Какие то данные)<data></data></client> - вернет тоже (никаких ошибок)
        //<client>(Какие то данные)<data>Иванов Иван Иванович;79991113344</data></client> - "<client>(Какие то данные)<data>И****в Иван И.;7999***3344</data></client>"

        //Используемые технологии: String.find, String.replaceAll, String.split, String.join, String.contains, String.substring
        //Регулярные выражения, класс StringBuilder
        String mask = "*";
        System.out.println("Введите ваши данные");
        //Scanner scanner = new Scanner(System.in);
        //String inputText = scanner.nextLine();
        String inputText = "<client>(Какие то данные)<data>79991113344;test@yandex.ru;Иванов Иван Иванович</data></client>";
        //scanner.close();
        // вытаскиваем данные из тега дата
        String dataString = inputText.substring(inputText.indexOf("<data>")+6,inputText.indexOf("</data>"));
        if (dataString.isEmpty())  {
            System.out.println(inputText);
            return;
        }
        String[] userData = dataString.split(";");
        StringBuilder temporaryString = new StringBuilder();
        String resultString = "";
        for (int i = 0; i < userData.length; i++) {

            if (userData[i].contains("@")) { // значит электронка
                temporaryString = temporaryString.append(userData[i]);
                userData[i] = temporaryString.replace(userData[i].indexOf("@")-2,userData[i].indexOf("@")-1,mask).toString();
                userData[i] = temporaryString.replace(userData[i].indexOf("@")+1,userData[i].indexOf(".")-1,mask).toString();
                //userData[i] = userData[i].substring(0,userData[i].indexOf('@'));
                //userData[i] = userData[i].
            }
            if (userData[i].matches("[0-9]+")) { // значит телефон
                //System.out.println(userData[i].length());
                temporaryString = temporaryString.append(userData[i]);
                userData[i] = temporaryString.replace(4, userData[i].length() -4, mask.repeat(userData[i].length()-8)).toString();
                //userData[i] = temporaryString.toString();
                System.out.println(userData[i]);
            }
            resultString += userData[i]+"  ";
        }
        System.out.println(inputText);
        System.out.println(dataString);
        System.out.println(resultString);

    }
}
