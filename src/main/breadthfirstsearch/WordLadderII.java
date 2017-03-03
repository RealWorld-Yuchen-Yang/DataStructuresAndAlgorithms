package main.breadthfirstsearch;
import java.util.*;
import java.util.function.Predicate;
import java.util.function.Function;

/**
 * Find the shorted possible path from beginWord to endWord
 * 
 * Difficult!!
 * @author yuchenyang
 *
 */
public class WordLadderII {
    public static List<List<String>> findLadders(String beginWord, String endWord, Set<String> wordList) {
        Queue<String> q = new LinkedList<>();//used to store one step on bfs
        HashMap<String, Integer> visited = new HashMap<>(); // one snapshot of an intermediate graph  
        HashMap<String, ArrayList<String>> father = new HashMap<>(); // father: key is the current(word(node)), value is the parent path to the current node(start->currentNode's parent)
        // only used by stateExtend()
        wordList.add(beginWord);
        wordList.add(endWord);
        
        final HashMap<String, HashSet<String>> g = buildGraph(wordList);//firstly construct the graph which represents how each word in the dictionary can transfer to each other

        final Function<String, Boolean> stateIsValid = (String s) -> wordList.contains(s);
        final Function<String, Boolean> stateIsTarget = (String s) -> s.equals(endWord);
        final Function<String, List<String> > stateExtend = (String s) -> {
            List<String> result = new ArrayList<>();//result represents states(words) one step further in bfs
            final int newDepth = visited.get(s) + 1;//firstly increase the potential next step's depth 1 step further, depth implicitly represents visited
            HashSet<String> list = g.get(s);//list represents all the adjacent nodes to this node
            if (list == null) return result;

            for (String newState : list) {//newState here represents the potential next step
                if (stateIsValid.apply(newState)) {
                    if (visited.containsKey(newState)) {
                        final int depth = visited.get(newState);
                        if (depth < newDepth) {
                            // do nothing, since the previously stored result is better than the current one
                        } else if (depth == newDepth) {
                            result.add(newState);//even though the current state is visisted, we still have a potential of an alternative path
                        } else {
                            throw new IllegalStateException("not possible to get here");
                        }
                    } else {
                        result.add(newState);//first visit of the new state
                    }
                }
            }

            return result;
        };

        List<List<String>> result = new ArrayList<>();
        q.offer(beginWord);
        visited.put(beginWord, 0);
        
        while (!q.isEmpty()) {
            String state = q.poll();//get one adjacent node to the current one

            /*
             * Since we are striving for finding shortest path, 
             * if the (potential next step path)'s length is greater than found shortest path
             * there is no point of searching further
             */
            if (!result.isEmpty() && (visited.get(state) + 1) > result.get(0).size())
            {
            	break;
            }

            if (stateIsTarget.apply(state)) {
                ArrayList<String> path = new ArrayList<>();
                genPath(father, beginWord, state, path, result);
                continue;
            }
            
            //bfs: move one step further
            List<String> newStates = stateExtend.apply(state);
            for (String newState : newStates) {
                if (!visited.containsKey(newState)) {
                    q.offer(newState);
                    visited.put(newState, visited.get(state)+1);
                }
                ArrayList<String> parents = father.getOrDefault(newState, new ArrayList<>());//parents represents path: start -> currentNode's previous node
                parents.add(state);//move the currentNode's previous node one step further(by including the current node)
                father.put(newState, parents);
            }
        }
        return result;
    }
    
    private static void genPath(HashMap<String, ArrayList<String>> father,
                                String start, String state, List<String> path,
                                List<List<String>> result) {
        path.add(state);
        if (state.equals(start)) {
            if (!result.isEmpty()) {
                if (path.size() < result.get(0).size()) {
                    result.clear();
                } else if (path.size() == result.get(0).size()) {
                    // do nothing
                } else {
                    throw new IllegalStateException("not possible to get here");
                }
            }
            ArrayList<String> tmp = new ArrayList<>(path);
            Collections.reverse(tmp);
            result.add(tmp);
        } else {
            for (String f : father.get(state)) {
                genPath(father, start, f, path, result);
            }
        }
        path.remove(path.size() - 1);
    }

    private static HashMap<String, HashSet<String>> buildGraph(Set<String> dict) {
        HashMap<String, HashSet<String>> adjacency_list = new HashMap<>();
        for (String word: dict) {
            char[] array = word.toCharArray();
            for (int i = 0; i < array.length; ++i) {
                final char old = array[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    // 防止同字母替换
                    if (c == array[i]) continue;

                    array[i] = c;
                    String newWord = new String(array);

                    if (dict.contains(newWord)) {
                        HashSet<String> list = adjacency_list.getOrDefault(
                                word, new HashSet<>());
                        list.add(newWord);
                        adjacency_list.put(word, list);
                    }
                    array[i] = old; // 恢复该单词
                }
            }
        }
        return adjacency_list;
    }
    
    //test
    public static void main(String args[])
    {
    	String start = "hit";
    	String end = "cog";
    	String[] dictElements = {"hot","dot","dog","lot","log"};
    	Set<String> dict = new HashSet(Arrays.asList(dictElements));
    	List<List<String>> results = findLadders(start, end, dict);
    	for(List<String> result: results)
    	{
    		System.out.println(result);
    	}
    }
}