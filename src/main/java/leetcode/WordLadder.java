package leetcode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @author Tempo
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> remainingWords = new HashSet<>(wordList);
        if (!wordList.remove(endWord)) {
            return 0;
        }
        Set<String> head = new HashSet<>();
        head.add(beginWord);
        Set<String> tail = new HashSet<>();
        tail.add(endWord);

        return countTransform(head, tail, remainingWords);
    }

    private int countTransform(Set<String> head, Set<String> tail, Set<String> remainingWords) {
        Set<String> transformedWords = new HashSet<>();
        for (String word : head) {
            char[] wordArray = word.toCharArray();
            for (int i = 0; i < wordArray.length; i++) {
                char currentChar = wordArray[i];
                for (char j = 'a'; j <= 'z'; j++) {
                    if (j != currentChar) {
                        wordArray[i] = j;
                        String transformedWord = new String(wordArray);
                        if (tail.contains(transformedWord)) return 2;
                        else if (!head.contains(transformedWord) && remainingWords.remove(transformedWord)) {
                            transformedWords.add(transformedWord);
                        }
                        wordArray[i] = currentChar;
                    }
                }
            }
        }
        if (transformedWords.size() == 0) {
            return 0;
        }
        int result = transformedWords.size() > tail.size() ? countTransform(tail, transformedWords, remainingWords) : countTransform(transformedWords, tail, remainingWords);
        return result == 0 ? 0 : 1 + result;
    }
}
