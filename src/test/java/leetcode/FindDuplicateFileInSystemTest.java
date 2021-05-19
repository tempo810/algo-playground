package leetcode;

import org.junit.jupiter.api.Test;

/**
 * @author Tempo
 */
class FindDuplicateFileInSystemTest {
    private final FindDuplicateFileInSystem solution = new FindDuplicateFileInSystem();

    @Test
    void findDuplicate() {
        System.out.println(solution.findDuplicate(new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)", "root 4.txt(efgh)"}));

    }
}
