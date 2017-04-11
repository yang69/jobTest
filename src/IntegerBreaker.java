import java.util.Scanner;

/**
 * Created by Yang on 2017/4/11.
 * 有一个正整数n，将n分解成若干个不同自然数之和，
 * 问如何分解能使这些数的乘积最大，输出这个乘积m
 * 输入：
 *      一个正整数，不超过50
 * 输出：
 *      一个整数
 * eg: 15 ---> 144
 */
public class IntegerBreaker {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            System.out.println(times(in.nextInt()));
        }
    }
    public static int times(int n) {
        if(n < 5) {
            return n;
        }
        int[] parts = new int[n];
        int length = 0;
        int base = 2;
        while(n >= base) {
            parts[length++] = base;
            n -= base++;
        }
        int temp = --length;
        while(n != 0 && temp >= 0) {
            parts[temp--]++;
            n--;
        }
        parts[length] += n;
        int res = 1;
        while(length >= 0) {
            res *= (parts[length--]);
        }
        return res;
    }
}
