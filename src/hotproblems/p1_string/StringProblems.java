package hotproblems.p1_string;

import org.junit.Test;

import java.util.*;

public class StringProblems {

    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if (Character.toLowerCase(s.charAt(i)) != Character.toLowerCase(s.charAt(j))) return false;
            i++;
            j--;
        }
        return true;
    }

    @Test
    public void testIsPalindrome() {
        String s = "A man, a plan, a canal: Panama";
        String s2 = "race a car";
        String s3 = "";
        String s4 = ".,";
        assert isPalindrome(s);
        assert !isPalindrome(s2);
        assert isPalindrome(s3);
        assert isPalindrome(s4);
    }

    public List<List<String>> partition(String s) {
        List<List<String>> res = new ArrayList<>();
        backtrack(res, s, new ArrayList<>());
        return res;

    }

    private void backtrack(List<List<String>> res, String s, ArrayList<String> tmp) {
        if (s == null || s.length() == 0) {
            res.add(new ArrayList<>(tmp));
        }
        for (int i = 1; i <= s.length(); i++) {
            String ss = s.substring(0, i);
            if (isPalindrome(ss)) {
                tmp.add(ss);
                backtrack(res, s.substring(i), tmp);
                tmp.remove(tmp.size() - 1);
            }
        }
    }

    private boolean isPalidrome(String sb) {
        int left = 0;
        int right = sb.length() - 1;
        while (left < right) {
            if (sb.charAt(left) != sb.charAt(right)) return false;
            left++;
            right--;
        }
        return true;
    }

    @Test
    public void testPartitiion() {
        String s = "aab";
        System.out.println(partition(s));
    }

    private boolean flag = false;

    public boolean wordBreak(String s, List<String> wordDict) {
        return wordBreak(s, new HashSet<String>(wordDict), 0, new Boolean[s.length()]);
    }

    private boolean wordBreak(String s, HashSet<String> wordDict, int start, Boolean[] cache) {
        if (start == s.length()) {
            return true;
        }
        if (cache[start] != null) {
            return cache[start];
        }
        for (int end = start + 1; end <= s.length(); end++) {
            if (wordDict.contains(s.substring(start, end)) && wordBreak(s, wordDict, end, cache)) {
//                System.out.println(s.substring(start, end));
                return cache[start] = true;
            }
        }
        return cache[start] = false;
    }

    private void backtrackWord(Map<String, Object> wordDict, String s) {
        if (flag) {
            return;
        }
        if (s.length() == 0) {
            flag = true;
        }
        for (int i = 1; i <= s.length(); i++) {
            String ss = s.substring(0, i);
            if (wordDict.containsKey(ss)) {
                backtrackWord(wordDict, s.substring(i));
            }
        }
    }

    @Test
    public void testWordBreak() {
        String s = "leetcode";
        List<String> wordDict = Arrays.asList("leet", "code");
        assert wordBreak(s, wordDict);

        String s2 = "applepenapple";
        List<String> wordDict2 = Arrays.asList("apple", "pen");
        assert wordBreak(s2, wordDict2);

        String s3 = "catsandog";
        List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        assert !wordBreak(s3, wordDict3);

        String s4 = "acaaaaabbbdbcccdcdaadcdccacbcccabbbbcdaaaaaadb";
        List<String> wordDict4 = Arrays.asList("abbcbda", "cbdaaa", "b", "dadaaad", "dccbbbc", "dccadd", "ccbdbc", "bbca", "bacbcdd", "a", "bacb", "cbc", "adc", "c", "cbdbcad", "cdbab", "db", "abbcdbd", "bcb", "bbdab", "aa", "bcadb", "bacbcb", "ca", "dbdabdb", "ccd", "acbb", "bdc", "acbccd", "d", "cccdcda", "dcbd", "cbccacd", "ac", "cca", "aaddc", "dccac", "ccdc", "bbbbcda", "ba", "adbcadb", "dca", "abd", "bdbb", "ddadbad", "badb", "ab", "aaaaa", "acba", "abbb");
        assert wordBreak(s4, wordDict4);
    }

    public List<String> wordBreak2(String s, List<String> wordDict) {
        List<String> res = new ArrayList<>();
        Map<Integer, List<String>> cache = new HashMap<Integer, List<String>>();
        wordBreak2(res, cache, s, 1, new HashSet<>(wordDict), new ArrayList<>());
        return res;
    }

    public void wordBreak2(List<String> res, Map<Integer, List<String>> cache, String s, int start, Set<String> wordDict, List<String> tmp) {
        if (s.length() == 0) {
            res.add(listToString(tmp));
        }
        for (int i = start; i <= s.length(); i++) {
            String ss = s.substring(0, i);
            if (wordDict.contains(ss)) {
                if (cache.containsKey(i)) {
                    List<String> next = cache.get(i);
                    tmp.addAll(next);
                    res.add(listToString(tmp));
                } else {
                    tmp.add(ss);
                    wordBreak2(res, cache, s, i, wordDict, tmp);
                    cache.put(i, new ArrayList<>(tmp));
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
    }

    private String listToString(List<String> tmp) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < tmp.size(); i++) {
            sb.append(tmp.get(i));
            if (i != tmp.size() - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    @Test
    public void testWordBreak2() {
        String s = "catsanddog";
        List<String> wordDict = Arrays.asList("cat", "cats", "and", "sand", "dog");
        System.out.println(wordBreak2(s, wordDict));

        String s2 = "pineapplepenapple";
        List<String> wordDict2 = Arrays.asList("apple", "pen", "applepen", "pine", "pineapple");
        System.out.println(wordBreak2(s2, wordDict2));

        String s3 = "catsandog";
        List<String> wordDict3 = Arrays.asList("cats", "dog", "sand", "and", "cat");
        System.out.println(wordBreak2(s3, wordDict3));

//        String s4 = "acaaaaabbbdbcccdcdaadcdccacbcccabbbbcdaaaaaadb";
//        List<String> wordDict4 = Arrays.asList("abbcbda", "cbdaaa", "b", "dadaaad", "dccbbbc", "dccadd", "ccbdbc", "bbca", "bacbcdd", "a", "bacb", "cbc", "adc", "c", "cbdbcad", "cdbab", "db", "abbcdbd", "bcb", "bbdab", "aa", "bcadb", "bacbcb", "ca", "dbdabdb", "ccd", "acbb", "bdc", "acbccd", "d", "cccdcda", "dcbd", "cbccacd", "ac", "cca", "aaddc", "dccac", "ccdc", "bbbbcda", "ba", "adbcadb", "dca", "abd", "bdbb", "ddadbad", "badb", "ab", "aaaaa", "acba", "abbb");
//        System.out.println(wordBreak2(s4, wordDict4));
    }
}
