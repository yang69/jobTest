package WorksApplications2017;

import java.util.Scanner;

/**
 * Created by Yang on 2017/5/26.
 ************************************************************************************************
 * The prison guarded by Tom has got N rooms which are numbered consecutively as 1...N. One
 * inmate is held in one room. There are M provinces and every inmate may come from one of the
 * M provinces. If an inmate came from the same province with the one who is held in the next
 * room, a prison break may happen. In how many situations will a prison break happen?
 *
 * 输入描述：
 * Input two integers M, N (1 <= M, N <= 10^9)
 * 30% small input: 1 <= M,N <= 1000
 * 40% medium input: 1 <= M,N <= 100000
 * 30% large input: 1 <= M,N <= 10^9
 *
 * 输出描述：
 * The output is an integer, stands for the number of situations in which breaks may happen. As
 * this answer might be very large, output the result of the original answer modulo 100003.
 * In such a case when M=2, N=3, the 6 possible situations are:
 * (000) (001) (011) (100) (110) (111)
 *
 * 输入例子：
 * 2 3
 *
 * 输出例子：
 * 6
 *
 * 分析：
 * 每一个牢房中的囚犯的省份有M种可能，N个牢房中各个囚犯来自的省份的可能性有M^N；
 * 相邻牢房中的囚犯都来自不同省份的可能性有M*(M-1)^(N-1)。
 *      1号牢房中的囚犯的省份有M种可能，2到N号牢房中不能与前一个牢房来自同一个省份，各有M-1种可能性
 * 所以，有相邻牢房中的囚犯来自同一省份的排列共 M^N - M*(M-1)^(N-1) 种
 ************************************************************************************************
 */
public class Jailbreak {
    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int n = in.nextInt();
        System.out.println(solve(m, n));
    }

    public static int solve(int m, int n) {
        int mod = 100003;
        int result =  (int) (power(m,n,mod) - ((m%mod)*power(m-1,n-1,mod))%mod);
        if (result < 0)
            result += mod;
        return result;
    }

    private static long power(int base, int exponent, int mod) {
        if (exponent == 0)
            return 1;
        if(exponent == 1)
            return base;
        long result = power(base, exponent >> 1, mod);
        result = (result * result) % mod;
        if((exponent & 0x1) == 1) // exponent是奇数
            result *= base;
        return result % mod;
    }
}
