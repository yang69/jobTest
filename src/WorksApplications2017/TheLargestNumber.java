package WorksApplications2017;

import java.util.Scanner;

/**
 * Created by Yang on 2017/5/26.
 ************************************************************************************************
 * Programmer Tom working in Works Applications received a new requirement. To implement this
 * requirement, he needs to maintain a sequence and support two kinds of operations as follows:
 * 1. Query. Syntax: Q L.
 * Function: Search for the largest number of the last L numbers in this sequence and output this
 * number. L should not be larger than the length of this sequence.
 * 2. Insert. Syntax: I N.
 * Function: Append number [(N + t) % mod] it to the sequence. t is the result of last query
 * operation (if no query operation has been performed, t = 0). N is a 32-bit non-negative integer.
 *
 * 输入描述：
 * The first line of the input consists of two integers, M and mod (1 <= M <= 200000), mod is in
 * the range of 32-bit integers. The following M lines, consists of M query operations or insert
 * operations.
 * 30% small input: 1 <= M <= 200
 * 40% medium input: 1 <= M <= 2000
 * 30% large input: 1 <= M <= 200000
 *
 * 输出描述：
 * For each query operation, output one line. There's just one number in the line, which is the
 * largest number of the last Lth number.
 *
 * 输入例子：
 * 5 100
 * I 96
 * Q 1
 * I 97
 * Q 1
 * Q 2
 *
 * 输出例子：
 * 96
 * 93
 * 96
 ************************************************************************************************
 */
public class TheLargestNumber {
    static int[] nums = new int[200000];
    static int[] maxs = new int[200000]; // maxs[i]表示最后i个数字中的最大值
    static int n = 0; // 保存的数据的总数
    static int m = 0; // 已缓存的最大值个数

    public static void add(int x) {
        nums[n++] = x;
        m = 0; //每次添加新的数据之后，maxs数组就可能改变。故放弃之前的缓存
    }

    public static int query(int x) {
        // 如果已有缓存，直接读取
        if (x < m) {
            return maxs[x-1];
        }
        // 否则，计算最后m+1,m+2,……,x个数字的最大值，并缓存下来，m更新为x
        if (m == 0) {
            maxs[0] = nums[n-1];
            m++;
        }
        int temp = maxs[m-1];
        for (int i = m; i < x; i++) {
            temp = temp > nums[n-1-i] ? temp : nums[n-1-i];
            maxs[i] = temp;
        }
        m = x;
        return maxs[x-1];
    }

    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int m = in.nextInt();
        int mod = in.nextInt();
        int t = 0;
        while(m-- > 0){
            String ch = in.next();
            int x = in.nextInt();

            if(ch.equals("I")){
                add((x + t)%mod);
            } else {
                t = query(x);
                System.out.println(t);
            }
        }
    }
}
