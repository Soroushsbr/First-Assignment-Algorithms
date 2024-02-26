import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Exercises2 {

    /*
    Given an array of integers nums and an integer target, return indices of the two numbers
    such that they add up to target.

    You may assume that each input would have exactly one solution, and you may not use the same element twice.
    You can return the answer in any order.
    */

    public static int[] twoSum(int[] nums, int target) {
        int length = nums.length;
        int[] result = new int[2];
        for(int i = 0 ; i < length - 1 ;i++){
            for(int j = i + 1 ; j < length; j++){
                if(nums[i] + nums[j] == target){
                    result[0] = i;
                    result[1] = j;
                    break;
                }
            }
        }
        return result;
    }

    /*
    Roman numerals are represented by seven different symbols: I, V, X, L, C, D and M.

    Symbol       Value
    I             1
    V             5
    X             10
    L             50
    C             100
    D             500
    M             1000

    For example, 2 is written as II in Roman numeral, just two ones added together.
    12 is written as XII, which is simply X + II.
    The number 27 is written as XXVII, which is XX + V + II.

    Roman numerals are usually written largest to smallest from left to right.
    However, the numeral for four is not IIII.
    Instead, the number four is written as IV.
    Because the one is before the five we subtract it making four.
    The same principle applies to the number nine, which is written as IX.
    There are six instances where subtraction is used:

    I can be placed before V (5) and X (10) to make 4 and 9.
    X can be placed before L (50) and C (100) to make 40 and 90.
    C can be placed before D (500) and M (1000) to make 400 and 900.

    Given a roman numeral, convert it to an integer.
    */

    public static int romanToInt(String s) {
        int sum = 0;
        char[] charArray = s.toCharArray();
        int length = s.length();
        for(int i = 0 ; i <length ; i++){
            switch (charArray[i]) {
                case 'I':
                    if (i < length - 1 && charArray[i + 1] == 'V'){
                        sum += 4;
                        i++;}
                    else if (i < length - 1 &&charArray[i + 1] == 'X'){
                        sum += 9;
                        i++;}
                    else
                        sum += 1;
                    break;
                case 'V':
                    sum += 5;
                    break;
                case 'X':
                    if (i < length - 1 &&charArray[i + 1] == 'L'){
                        sum += 40;
                        i++;}
                    else if (i < length - 1 && charArray[i + 1] == 'C'){
                        sum += 90;
                        i++;}
                    else
                        sum += 10;
                    break;
                case 'L':
                    sum += 50;
                    break;
                case 'C':
                    if (i < length - 1 &&charArray[i + 1] == 'D'){
                        sum += 400;
                        i++;}
                    else if (i < length - 1 && charArray[i + 1] == 'M'){
                        sum += 900;
                        i++;}
                    else
                        sum += 1000;
                    break;
                case 'D':
                    sum += 500;
                    break;
                case 'M':
                    sum += 1000;
                    break;
            }
            }
        return sum;
    }


    /*
    Given an array nums of distinct integers, return all the possible permutations.
    You can return the answer in any order.
    */


    public static List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        possibleWays(nums, new ArrayList<>(), result);
        return result;
    }

    private static void possibleWays(int[] nums, List<Integer> current, List<List<Integer>> result) {
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (current.contains(nums[i])) {
                continue;
            }
            current.add(nums[i]);
            possibleWays(nums, current, result);
            current.remove(current.size() - 1);
        }
    }


    public static void main(String[] args) {
        String s = "MCMXCIV";
        int[] nums = {2 , 7 , 8 , 10};
        System.out.println(romanToInt(s));
        System.out.println(twoSum(nums , 9)[0] + " " + twoSum(nums , 9)[1]);
    }
}