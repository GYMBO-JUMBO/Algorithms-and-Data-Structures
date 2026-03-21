import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
public class Assignment1 {
    public static void main(String[] args){
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("--- Task 1 ---");
            int a = scanner.nextInt();
            PrintDigit(a);
            System.out.println("--- Task 2 ---");
            int b = scanner.nextInt();
            List<Integer> list1 = new ArrayList<>();
            for(int i = 0; i < b; i++){
                int dummy = scanner.nextInt();
                list1.add(dummy);
            }
            int totalsum = AverageOfElements(list1, 0);
            double task2Avg = (double) totalsum / b;
            System.out.println(task2Avg);
            System.out.println("--- Task 3 ---");
            int c = scanner.nextInt();
            if (c < 2) {
                System.out.println("Composite");
            } else {
                System.out.println(PrimeNumberCheck(c, 2));
            }
            System.out.println("--- Task 4 ---");
            int d = scanner.nextInt();
            System.out.println(Factorial(d));
            System.out.println("--- Task 5 ---");
            int e = scanner.nextInt();
            System.out.println(FibonacciNumber(e));
            System.out.println("--- Task 6 ---");
            int f = scanner.nextInt();
            int g = scanner.nextInt();
            System.out.println(PowerOf(f, g));
            System.out.println("--- Task 7 ---");
            int h = scanner.nextInt();
            List<Integer> list2 = new ArrayList<>();
            for(int i = 0; i < h; i++){
                int some = scanner.nextInt();
                list2.add(some);
            }
            int index2 = list2.size() - 1;
            ReverseOutput(index2, list2);
            System.out.println("--- Task 8 ---");
            String line1 = scanner.nextLine();
            if(CheckDigits(line1, 0)){
                System.out.println("YES");
            }
            else{
                System.out.println("NO");
            }
            System.out.println("--- Task 9 ---");
            String line2 = scanner.nextLine();
            System.out.println(CheckDigits(0, line2));
            System.out.println("--- Task 10 ---");
            int x = scanner.nextInt();
            int y = scanner.nextInt();
            System.out.println(GCD(x, y));
        }
    }
    public static void PrintDigit(int a){
        if(a < 10){
            System.out.println(a);
            return;
        }
        PrintDigit(a/10);
        PrintDigit(a%10);
    }
    public static int AverageOfElements(List<Integer> list1, int index){
        if(index == list1.size()){
            return 0;
        }
        return list1.get(index) + AverageOfElements(list1, index + 1);
    }
    public static String PrimeNumberCheck(int c, int index){
        if(index > Math.sqrt(c)){
            return "Prime";
        }
        if(c % index == 0){
            return "Composite";
        }
        return PrimeNumberCheck(c, index + 1);
    }
    public static long Factorial(int d){
        if(d <= 1){
            return 1;
        }
        return d * Factorial(d - 1);
    }
    public static int FibonacciNumber(int e){
        if (e == 0) {
        return 0;
        }
        if (e == 1) {
            return 1;
        }
        return FibonacciNumber(e - 1) + FibonacciNumber(e - 2);
    }
    public static int PowerOf(int f, int g){
        if(g == 0){
            return 1;
        }
        return f * PowerOf(f, g - 1);
    }
    public static void ReverseOutput(int index, List<Integer> list2){
        if(index < 0){
            return;
        }
        System.out.println(list2.get(index));
        ReverseOutput(index - 1, list2);
    }
    public static boolean CheckDigits(String line, int index){
        if(index == line.length()){
            return true;
        }
        if(!Character.isDigit(line.charAt(index))){
            return false;
        }
        return CheckDigits(line, index + 1);
    }
    public static int CheckDigits(int index, String str){
        if(str.length() == index){
            return 0;
        }
        return 1 + CheckDigits(index + 1, str);
    }
    public static int GCD(int a, int b){
        if(b == 0){
            return a;
        }
        return GCD(b, a % b);
    }
}
