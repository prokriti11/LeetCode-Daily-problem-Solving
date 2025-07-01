class Solution {
    public boolean checkIfCanBreak(String s1, String s2) {

        char[] arr1 = s1.toCharArray(), arr2 = s2.toCharArray();
        int lastDifference = 0;
        sortCharArray(arr1);
        sortCharArray(arr2);

        for (int i = 0; i < arr1.length; i++) {
            if ((arr1[i] - arr2[i] < 0 && lastDifference > 0) || (arr1[i] - arr2[i] > 0 && lastDifference < 0)) {
                return false;
            }

            if (arr1[i] != arr2[i]) {
                lastDifference = arr1[i] - arr2[i];
            }
        }

        return true;
    }

    private void sortCharArray(char[] arr) {

        int[] hash = new int[26];

        for (char ch : arr) {
            hash[ch - 'a']++;
        }

        for (int i = 0, index = 0; i < 26; i++) {
            while (hash[i]-- > 0) {
                arr[index++] = (char) ('a' + i);
            }
        }
    }
}