package educative;

import java.util.HashSet;
import java.util.Set;

public class StringSegmentation {
    public static boolean canSegmentString(String s, Set<String> dictionary) {
        //TODO: Write - Your - Code
        return canSegment(s, 0, dictionary);
      }
    
      private static boolean canSegment(String s, int start, Set<String> dictionary) {
        if (dictionary.contains(s.substring(start, s.length()))) {
          return true;
        }
        for (int i = s.length() - 1; i > start; i--) {
          if (canSegment(s, i, dictionary)) {
            return true;
          }
        }
        return false;
      }

      public static void main(String[] args) {
        Set<String> dictionary = new HashSet<>();
        dictionary.add("apple");
        dictionary.add("pie");
        canSegmentString("applepie", dictionary);
      }
}
