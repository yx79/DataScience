/*

Use map reduce to build inverted index for given documents.
[{"id":1,"content":"This is the content of document1"}, {"id":2,"content":"This is the content of document2"}]

*/

/**
 * Definition of OutputCollector:
 * class OutputCollector<K, V> {
 *     public void collect(K key, V value);
 *         // Adds a key/value pair to the output buffer
 * }
 * Definition of Document:
 * class Document {
 *     public int id;
 *     public String content;
 * }
 */
public class InvertedIndex {

    public static class Map {
        public void map(String _, Document value,
                        OutputCollector<String, Integer> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, int value);
            String[] words = value.content.trim().split(" ");
            for (String word : words) {
                if (word.equals("")) {
                    continue;
                }
                output.collect(word, value.id);
            }
        }
    }

    public static class Reduce {
        public void reduce(String key, Iterator<Integer> values,
                           OutputCollector<String, List<Integer>> output) {
            // Write your code here
            // Output the results into output buffer.
            // Ps. output.collect(String key, List<Integer> value);
            String[] words = value.content.trim().split(" ");
            for (String word : words) {
                if (word.equals("")) {
                    continue;
                }
                output.collect(word, value.id);
            }
        }
    }
}
