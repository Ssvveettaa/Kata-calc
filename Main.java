import java.util.Scanner;
import java.util.Arrays;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.println("Input:");
        String str = scan.nextLine();
        System.out.println("Output:");
        System.out.println(Main.calc(str));
    }
    public static String calc(String input) {
        String output = new String("");   // String output;   // String output = new String();
        String exception = "throws Exception";
        String[] inputArabic = {"1","2","3","4","5","6","7","8","9","10"};
        String[] inputRoman = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};
        String[] outputRoman = {"C","XC","L","XL","X","IX","V","IV","I"};
        int[] outputArabic = {100,90,50,40,10,9,5,4,1};
        int numberOne = 0;
        int numberTwo = 0;
        int result = 0;
        String[] inputMassiv = input.split(" ");
        if(inputMassiv.length != 3){
            return exception;
        }                               // Продолжаем, если 3 элемента:
        if(!inputMassiv[1].equals("+") && !inputMassiv[1].equals("-")  && !inputMassiv[1].equals("*")  && !inputMassiv[1].equals("/")){
            return exception;
        }                               // Продолжаем, если 2-й элемент "+" или "-" или "*" или "/":
        for(int i = 0; i < inputArabic.length; i++) {   // Проверяем есть ли Арабские, если есть - записываем:
            if(inputMassiv[0].equals(inputArabic[i])){
                numberOne = i+1;
            }
            if(inputMassiv[2].equals(inputArabic[i])){
                numberTwo = i+1;
            }
        }
        if (numberOne != 0 && numberTwo != 0){          // Если оба числа Арабские - считаем выражение:
            result = Main.calculation(numberOne, inputMassiv[1], numberTwo);
            return output = Integer.toString(result);   // Возвращаем результат в виде строки.
        }   else if (numberOne != 0 || numberTwo != 0){
            return exception;                           // Если только одно число Арабское - выходим.
        }                                               // Продолжаем, если оба числа не Арабские:
        for(int i = 0; i < inputRoman.length; i++) {    // Проверяем есть ли Римские, если есть - записываем:
            if(inputMassiv[0].equals(inputRoman[i])){
                numberOne = i+1;
            }
            if(inputMassiv[2].equals(inputRoman[i])){
                numberTwo = i+1;
            }
        }
        if (numberOne != 0 && numberTwo != 0){          // Если оба числа Римские - считаем выражение:
            result = Main.calculation(numberOne, inputMassiv[1], numberTwo);
            if(result<1){
                return exception;
            }                                           // Продолжаем, если результат больше 0:
            int l = 0;                                  // Переводим в Римские:
            for (int i = 0; i < outputRoman.length; i++) {
                l = result / outputArabic[i];
                while (l>0) {
                    output = output.concat(outputRoman[i]);
                    l--;
                }
                result = result % outputArabic[i];
            }
            return output;                              // Возвращаем строку (ответ Римскими).
        }
        return exception;               // Операнды не Арабские и один точно не Римский =) или оба не Римские.
    }
    public static int calculation(int a, String arithmetic, int b){
        int x = 0;
        switch(arithmetic){
            case "+" -> x = a + b;
            case "-" -> x = a - b;
            case "*" -> x = a * b;
            case "/" -> x = a / b;
        }
        return x;
    }
}