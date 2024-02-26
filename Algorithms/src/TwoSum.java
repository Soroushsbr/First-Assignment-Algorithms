import java.util.HashMap;
import java.util.Map;

public class TwoSum {

    public static int[] twoSum(int[] nums, int target) {
        // Create a map to store the indices of elements
        Map<Integer, Integer> numIndices = new HashMap<>();

        // Iterate over the array
        for (int i = 0; i < nums.length; i++) {
            // Calculate the complement (target - num)
            int complement = target - nums[i];

            // Check if the complement is already in the map
            if (numIndices.containsKey(complement)) {
                // Return the indices of the two numbers
                return new int[]{numIndices.get(complement), i};
            }

            // Otherwise, add the current number and its index to the map
            numIndices.put(nums[i], i);
        }

        // If no solution is found, return an empty array
        return new int[0];
    }

    public static void main(String[] args) {
        String s = "cum";
        System.out.println(s.substring(1,2));
    }
}
