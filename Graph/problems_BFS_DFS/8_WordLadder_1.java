/*Given two distinct words startWord and targetWord, and a list denoting wordList of unique words of equal lengths. 
Find the length of the shortest transformation sequence from startWord to targetWord.
Keep the following conditions in mind:

A word can only consist of lowercase characters.
Only one letter can be changed in each transformation.
Each transformed word must exist in the wordList including the targetWord.
startWord may or may not be part of the wordList
The second part of this problem can be found here.

Note: If no possible way to transform sequence from startWord to targetWord return 0


Example 1:

Input:
wordList = {"des","der","dfr","dgt","dfs"}
startWord = "der", targetWord= "dfs",
Output:
3
Explanation:
The length of the smallest transformation
sequence from "der" to "dfs" is 3
i,e "der" -> "dfr" -> "dfs".
Example 2:

Input:
wordList = {"geek", "gefk"}
startWord = "gedk", targetWord= "geek", 
Output:
2
Explanation:
gedk -> geek */



class Pair {
    String first;
    int second;
    Pair(String _first, int _second) {
        this.first = _first;
        this.second = _second;
    }
}

class Solution
{
    public int wordLadderLength(String startWord, String targetWord, String[] wordList)
    {
        // Creating a queue ds of type {word,transitions to reach ‘word’}.
        Queue < Pair > q = new LinkedList < > ();
 
        // BFS traversal with pushing values in queue 
        // when after a transformation, a word is found in wordList.
        q.add(new Pair(startWord, 1));
        
        // Push all values of wordList into a set
        // to make deletion from it easier and in less time complexity.
        Set < String > st = new HashSet < String > ();
        int len = wordList.length;
        for (int i = 0; i < len; i++) {
            st.add(wordList[i]);
        }
        
        st.remove(startWord);
        
        while (!q.isEmpty()) {
            String word = q.peek().first;
            int steps = q.peek().second;
            q.remove();
      
            // we return the steps as soon as
            // the first occurence of targetWord is found.
            if (word.equals(targetWord) == true) return steps;

            // Now, replace each character of ‘word’ with char
            // from a-z then check if ‘word’ exists in wordList.
            for (int i = 0; i < word.length(); i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char replacedCharArray[] = word.toCharArray();
                    replacedCharArray[i] = ch;
                    String replacedWord = new String(replacedCharArray);

                    // check if it exists in the set and push it in the queue.
                    if (st.contains(replacedWord) == true) {
                        st.remove(replacedWord);
                        q.add(new Pair(replacedWord, steps + 1));
                    }
                }

            }
        }
        // If there is no transformation sequence possible
        return 0;
    }
}