package lesson1;

import java.util.Locale;

public class HomeWork_1 {
    public static void main(String[] args) {
        System.out.println("---------N1--------");
        task1();
        System.out.println("---------N2--------");
        task2();
        System.out.println("---------N3--------");
        task3();

        System.out.println("---------PRO N4--------");
        proTask4();
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

    public static void proTask4() {
        //Задача №4
        //В слове "Hello world!" заменить все l на r, сделать все буквы заглавными, выбрать первые 8 символов
        String word = "Hello world!";
        System.out.println(word.substring(0,7).replace('l','r').toUpperCase());
    }
}
