import java.util.Scanner;

public class Calculator {

    public static void main(String[] args) {

        Scanner in = new Scanner(System.in);
        System.out.println("Калькулируй");
        System.out.println("Пример: (3 + 2); (X / III) и т.д.");

        String operation = in.nextLine();
        operation.trim();
        String [] elements = operation.split(" ");

        if (calculator(elements).equals("-99")){
            throw new IllegalStateException ("Калькулятор принимает целые числа от 1 до 10");
        }

        System.out.println(calculator(elements));

    }

    public static String calculator(String[] a){
        String[] arab = {"1","2","3","4","5","6","7","8","9","10"};
        String[] rome = {"I","II","III","IV","V","VI","VII","VIII","IX","X"};

        if (a.length != 3){
            throw new IllegalStateException ("Неверный ввод данных");
        }

        if (!a[1].equals("+") && !a[1].equals("-") && !a[1].equals("*") && !a[1].equals("/")){
            throw new IllegalStateException ("Неверный знак");
        }

        for (String b:arab){
            if (a[0].equals(b)){
                for (String c:arab){
                    if (a[2].equals(c)){
                        int num1 = Integer.parseInt(a[0]);
                        int num2 = Integer.parseInt(a[2]);

                        switch (a[1]) {
                            case "+":
                                num1 += num2;
                                break;
                            case "-":
                                num1 -= num2;
                                break;
                            case "*":
                                num1 *= num2;
                                break;
                            case "/":
                                num1 /= num2;
                                break;
                        }
                        return Integer.toString(num1);
                    }
                }
            }
        }

        for (String b:rome){
            if (a[0].equals(b)){
                for (String c: rome){
                    if (a[2].equals(c)){
                        int num1 =0;
                        int num2 = 0;

                        num1 = switch (a[0]) {
                            case "I" -> 1;
                            case "II" -> 2;
                            case "III" -> 3;
                            case "IV" -> 4;
                            case "V" -> 5;
                            case "VI" -> 6;
                            case "VII" -> 7;
                            case "VIII" -> 8;
                            case "IX" -> 9;
                            case "X" -> 10;
                            default -> throw new IllegalStateException("Unexpected value: " + a[0]);
                        };
                        num2 = switch (a[2]) {
                            case "I" -> 1;
                            case "II" -> 2;
                            case "III" -> 3;
                            case "IV" -> 4;
                            case "V" -> 5;
                            case "VI" -> 6;
                            case "VII" -> 7;
                            case "VIII" -> 8;
                            case "IX" -> 9;
                            case "X" -> 10;
                            default -> throw new IllegalStateException("Unexpected value: " + a[2]);
                        };

                        switch (a[1]) {
                            case "+":
                                num1 += num2;
                                break;
                            case "-":
                                num1 -= num2;
                                break;
                            case "*":
                                num1 *= num2;
                                break;
                            case "/":
                                num1 /= num2;
                                break;
                        }

                        if (num1<=0){
                            throw new IllegalStateException ("В римской системе нет 0 и отрицательных чисел");
                        }

                        String result = "";

                        if (num1>=40 && num1<50){
                            result = "XL";
                            num1 -= 40;
                        }
                        if (num1>=50 && num1<90){
                            result = "L";
                            num1 -= 50;
                        }
                        if (num1>=90 && num1<100){
                            result = "XC";
                            num1 -= 90;
                        }
                        if (num1>=100){
                            result = "C";
                            num1 -= 100;
                        }

                        while (num1>10){
                            num1 -= 10;
                            result += "X";
                        }
                        if (num1!=0){
                            result = result + rome[num1-1];
                        }
                        return result;
                    }
                }
            }
        }

        return "-99";

    }
}
