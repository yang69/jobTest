package PayPal2017Intern;

/**
 * Created by Yang on 2017/4/13.
 * 时间限制：4秒
 * 空间限制：65536K
 * 题目描述
 * Given two zero-indexed arrays A and B consisting of M and N (M > 0, N > 0) strings,
 * which represent M and N variables in two different models P and Q. Each variable is
 * a string, which contains letters "a-z" in lower case only. Variables in arrays A and B
 * are initially sorted by their contribution to the model, from large to small, which
 * means, A[0] has the largest contribution to model P, while A[M-1] has the smallest
 * contribution to model P. If there are X variables existing in same order in both A
 * and B, they form a "solid variable group" of which the length is X. The goal is to
 * calculate the length of the longest "solid variable group", and find out the variables
 * in the longest "solid variable group". If there are more than 1 longest "solid variable
 * groups", find out the one which has the largest contribution to model P. For example:
 * A is ['paypal', 'business', 'money', 'innovation', 'strong']
 * B is ['innovation', 'paypal', 'strong', 'inclusion']
 * The length of the longest "solid variable group" is 2, and two "solid variable groups"
 * of length 2 are ('paypal', 'strong') and ('innovation', 'strong').
 * Since 'paypal' has larger contribution to model P than 'innovation',
 * the output should be 2 and ('paypal', 'strong').
 * 输入描述:
 * Array A and B as described above
 * 输出描述:
 * The first line should be the length of the longest "solid variable group", while the
 * second line should be the longest "solid variable group" which has the largest contribution
 * to model P. If there's no longest "solid variable group" available, the second line should
 * be a blank line.
 * 输入例子:
 * paypal business money innovation strong
 * innovation paypal strong inclusion
 * 输出例子:
 * 2
 * paypal strong
 */
public class CalculateLongestSolidVariableGroup {
}
