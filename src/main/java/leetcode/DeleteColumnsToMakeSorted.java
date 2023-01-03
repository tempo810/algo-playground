package leetcode;

/**
 * @author tempo
 */
public class DeleteColumnsToMakeSorted {

    public int minDeletionSize(String[] strs) {
        int totalDelete = 0;
        for (int i = 0; i < strs[0].length(); i++) {
            int currentChar = 'a';
            for (String str : strs) {
                char c = str.charAt(i);
                if (c < currentChar) {
                    totalDelete++;
                    break;
                }
                currentChar = c;
            }
        }
        return totalDelete;
    }
}
