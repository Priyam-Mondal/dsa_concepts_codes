// Approach 1:

// Using Queues:
// You store characters of both strings in two queues.
// Then, you cyclically rotate one queue (in this case, q2) and compare it with the other queue (q1) to check for equality.
// If q1 and q2 become equal after rotation, it means that the original string q is a cyclic rotation of string p.
// Time Complexity: O(n^2) where n is the length of the strings.
// Space Complexity: O(n) for storing characters in the queues.



// Approach 2:

// Concatenation and Substring:
// You create a temporary string by concatenating str1 with itself (str1 + str1).
// Then, you check if str2 is a substring of this temporary string.
// If str2 is found in the concatenated string, it means str1 and str2 are rotations of each other.
// Time Complexity: O(n^2) where n is the length of the strings. (Though the contains operation might be optimized internally)
// Space Complexity: O(n) for storing the concatenated string.


public static int isCyclicRotation(String p, String q) {
    // Check if lengths of strings p and q are different
    if (p.length() != q.length()) {
        return 0; //Return 0 if lengths are different (they cannot be cyclic rotations of each other)
    }

    // Concatenate q with itself
    String concatenated = q + q;

    // Check if p is a substring of concatenated
    if (concatenated.contains(p)) {
        return 1; // Return 1 if p is a cyclic rotation of q
    }

    return 0; // Return 0 if no cyclic rotation of q matches p
}
