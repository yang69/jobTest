package PayPal2017Intern;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * Created by Yang on 2017/4/13.
 * 时间限制：5秒
 * 空间限制：524288K
 * 题目描述
 * The boss of P company plays an interesting game with employees.
 * At the beginning, the boss gives a very long string with length m.
 * The boss invites n employees to reorder the string with command
 * a, s, e, where a in {0, 1} denotes the type of operation, s and e
 * are positions in the string. If a = 0, all characters from s to e
 * are ordered in non-increasing order. If a = 1, all characters from
 * s to e are ordered in non-decreasing order. After n times operation,
 * the boss wants to know the final string.
 * 输入描述:
 * The first line contains two integers m, (1 <= m <= 100000),
 * n, (0 <= n <= 50000) - the length of the string and the number
 * of operations. The next line contains a string with length m.
 * Next n lines contain operation command a, s, e, where a in {0, 1}
 * and 1 <= s <= e <= m.
 * 输出描述:
 * One line contains the final string.
 *
 * 输入例子:
 * 10 3
 * naitdocexv
 * 1 1 3
 * 0 9 10
 * 1 7 9
 *
 * 输出例子:
 * aintdocexv
 */
public class StringPuzzle {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

        int m = in.nextInt();
        int n = in.nextInt();

        in.nextLine();
        String str = in.nextLine().trim();
        Character[] chars = new Character[str.length()];
        for (int i = 0; i < str.length(); i++) {
            chars[i] = new Character(str.charAt(i));
        }

        for (int i = 0; i < n; i++) {
            int a = in.nextInt();
            int s = in.nextInt();
            int e = in.nextInt();

            if (a == 0)
                Arrays.sort(chars, s - 1, e, new Comparator<Character>() {
                    @Override
                    public int compare(Character char1, Character char2) {
                        return char2.compareTo(char1);
                    }
                });
            else
                Arrays.sort(chars, s - 1, e, new Comparator<Character>() {
                    @Override
                    public int compare(Character char1, Character char2) {
                        return char1.compareTo(char2);
                    }
                });

        }

        for (char c : chars)
            System.out.print(c);
    }
}
