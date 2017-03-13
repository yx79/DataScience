/*
Create an inverted index with given documents.

 Notice:Ensure that data does not include punctuation.

Corner case:
[{"id":1,"content":"This is  the content of document1"}, {"id":2,"content":"This is the       content of document3"}]

Example
Given a list of documents with id and content. (class Document)

[
  {
    "id": 1,
    "content": "This is the content of document 1 it is very short"
  },
  {
    "id": 2,
    "content": "This is the content of document 2 it is very long bilabial bilabial heheh hahaha ..."
  },
]
Return an inverted index (HashMap with key is the word and value is a list of document ids).

{
   "This": [1, 2],
   "is": [1, 2],
   ...
}
 
*/


/**
 * Definition of Document:
 * class Document {
 *     public int id;
 *     public String content;
 * }
 */
public class Solution {
    /**
     * @param docs a list of documents
     * @return an inverted index
     */
    public Map<String, List<Integer>> invertedIndex(List<Document> docs) {
        // Write your code here
        Map<String, List<Integer>> map = new HashMap<>();
        for (Document doc : docs) {
            String content = doc.content;
            String[] words = content.trim().split(" ");
            int id = doc.id;
            for (String word : words) {
                if (word.equals("")) {
                    continue;
                }
                if (map.containsKey(word)) {
                    if (!map.get(word).contains(id)) {
                        map.get(word).add(id);
                    }
                    
                } else {
                    List<Integer> list = new LinkedList<>();
                    list.add(id);
                    map.put(word, list);
                }
            }
            
        }
        return map;
    }
}
