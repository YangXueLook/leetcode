import java.util.HashMap;


public class AddSearchWord {
	
	// Your WordDictionary object will be instantiated and called as such:
	// WordDictionary wordDictionary = new WordDictionary();
	// wordDictionary.addWord("word");
	// wordDictionary.search("pattern");
	
	 // Adds a word into the data structure.
	private Node root = new Node('$');
	
    public void addWord(String word) {
    	Node current = root;
    	for(int i = 0; i < word.length(); i++)
    	{
    		if(current.childrenMap.containsKey(word.charAt(i)))
    		{
    			current = current.childrenMap.get(word.charAt(i));
    		}
    		else
    		{
    			Node newNode = new Node(word.charAt(i));
    			current.childrenMap.put(word.charAt(i), newNode);
    			current = newNode;
    			
    		}
    	}
    	current.childrenMap.put('$', null);
        
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
    	return searchFrom(word, root);
    	
    }

	private boolean searchFrom(String word, Node currentRoot) {
		
		if(currentRoot == null)
			return false;
		
		if(word.length() == 0)
		{
			if(currentRoot.childrenMap.containsKey('$'))
				return true;
			else
				return false;
		}
		if(word.charAt(0) != '.')
		{
			if(!currentRoot.childrenMap.containsKey(word.charAt(0)))
				return false;
			if(currentRoot.childrenMap.containsKey(word.charAt(0)))
			{
				currentRoot = currentRoot.childrenMap.get(word.charAt(0));
				return searchFrom(word.substring(1), currentRoot);
			}
		}
		else
		{
			if(currentRoot.childrenMap.size() == 0)
				return false;
			
			Object[] array = currentRoot.childrenMap.keySet().toArray();
			word = word.substring(1);
			for(int i = 0; i < array.length; i++)
			{
				if(searchFrom(word, currentRoot.childrenMap.get(array[i])))
					return true;
			}

			return false;
		}
		return false;
	}

	public static void main(String[] args) {
		AddSearchWord t = new AddSearchWord();
		

		t.addWord("bad");
		t.addWord("dad");
		t.addWord("mad");
		System.out.println(t.search("pad"));
		System.out.println(t.search("bad"));
		System.out.println(t.search(".ad"));
		System.out.println(t.search("ba"));
		
	}

}

class Node
{
	char val;
	HashMap<Character, Node> childrenMap = new HashMap<Character, Node>();
	Node(char c)
	{
		this.val = c;
	}
}







