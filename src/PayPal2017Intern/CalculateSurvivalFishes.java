package PayPal2017Intern;

import java.util.Scanner;

/**
 * Created by Yang on 2017/4/13.
 * 时间限制：1秒
 * 空间限制：32768K
 * 题目描述
 * Given two zero-indexed arrays A and B consisting of N (N >= 0) integers,
 * which represent N fishes in a river, ordered from west to east.
 * The fish are numbered from 0 to N-1, and Fish number X is represented by
 * A[X] and B[X]. Array A contains the sizes of the fishes, while array B
 * contains the directions they swim, which can be 1 (from west to east) or
 * -1 (from east to west).
 * If two fishes move in opposite directions meet each other, the larger fish
 * will eat the smaller one, and the survival will still follow its original
 * direction.
 * We assume that all fishes are in different sizes and swimming at the same
 * speed. The goal is to calculate the number of fishes that will stay alive.
 * For example:
 * A is [3, 5, 9, 1, 2]
 * B is [1, -1, 1, 1, -1]
 * Fish number 1 will eat Fish number 0, Fish number 4 will eat Fish number 3
 * and be eaten by Fish number 2. Therefore the output should be 2 (Fish number
 * 1 and Fish number 2 are still alive)
 * 输入描述:
 * Array A and B as described above
 * 输出描述:
 * The number of fishes that will stay alive
 * 输入例子:
 * 3 5 9 1 2
 * 1 -1 1 1 -1
 * 输出例子:
 * 2
 */
public class CalculateSurvivalFishes {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while(in.hasNext()) {
            String[] sizeStrings = in.nextLine().split("\\s+");
            String[] directions = in.nextLine().split("\\s+");
            int length = sizeStrings.length;
            int[] sizes = new int[length];
            for (int i = 0; i < length; i++) {
                sizes[i] = Integer.parseInt(sizeStrings[i]);
            }
            int numSurvivalFish = length;
//            int biggestSizeSwimToEast = -1;
//            int indexOfBiggestSizeSwimToEast = -1;
//            int biggestSizeSwimToWest = -1;
//            int indexOfBiggestSizeSwimToWest = -1;
            for (int i = 0; i < length; i++) {
//                if(directions[i].equals("1")) { // 向东游
//                    if(sizes[i] > biggestSizeSwimToEast) {
//                        biggestSizeSwimToEast = sizes[i];
//                        indexOfBiggestSizeSwimToEast = i;
//                    }
//                } else { // 向西游
//                    if(sizes[i] > biggestSizeSwimToWest) {
//                        biggestSizeSwimToWest = sizes[i];
//                        indexOfBiggestSizeSwimToWest = i;
//                    }
//                }
                if (directions[i].equals("1")) {
                    int sizeOfWestToEast = sizes[i];
                    for (int j = i + 1; j < length; j++)
                        if (directions[j].equals("1")) {
                            if (sizes[j] > sizeOfWestToEast)
                                sizeOfWestToEast = sizes[j];
                        } else if (sizes[j] > sizeOfWestToEast) {
                            numSurvivalFish--;
                            break;
                        }
                } else {
                    int sizeOfEastToWest = sizes[i];
                    for (int j = i - 1; j >= 0; j--)
                        if (directions[j].equals("-1")) {
                            if (sizes[j] > sizeOfEastToWest)
                                sizeOfEastToWest = sizes[j];
                        } else if (sizes[j] > sizeOfEastToWest) {
                            numSurvivalFish--;
                            break;
                        }
                }
            }
//            int numSurvivalFish = 2;
//            if(indexOfBiggestSizeSwimToEast < indexOfBiggestSizeSwimToWest) {
//                numSurvivalFish = 1;
//            }
            System.out.println(numSurvivalFish);
        }
    }
}
