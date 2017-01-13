import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordSearchII {
	public List<String> findWords(char[][] board, String[] words) {
		HashSet<String> list = new HashSet();
		Trie trie = new Trie();
		for (String word : words)
			trie.insert(word);
		boolean[][] visited = new boolean[board.length][board[0].length];
		for (int i = 0; i < board.length; i++)
			for (int j = 0; j < board[0].length; j++)
				dfs(list, board, visited, "", i, j, trie);
		return new ArrayList(list);
	}

	public void dfs(Set<String> list, char[][] board, boolean[][] visited,
			String str, int x, int y, Trie trie) {
		if (x < 0 || x >= board.length || y < 0 || y >= board[0].length)
			return;
		if (visited[x][y])
			return;
		str += board[x][y];
		if (!trie.startsWith(str))
			return;
		if (trie.search(str))
			list.add(str);
		visited[x][y] = true;
		dfs(list, board, visited, str, x - 1, y, trie);
		dfs(list, board, visited, str, x + 1, y, trie);
		dfs(list, board, visited, str, x, y - 1, trie);
		dfs(list, board, visited, str, x, y + 1, trie);
		visited[x][y] = false;
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}

class TrieNode {
	// Initialize your data structure here.
	int num;// 有多少单词通过这个节点,即节点字符出现的次数
	TrieNode[] son;// 所有的儿子节点
	boolean isEnd;// 是不是最后一个节点
	char val;// 节点的值

	TrieNode() {
		this.num = 1;
		this.son = new TrieNode[26];
		this.isEnd = false;
	}
}

class Trie {
	protected TrieNode root;

	public Trie() {
		root = new TrieNode();
	}

	public void insert(String word) {
		if (word == null || word.length() == 0)
			return;
		TrieNode node = this.root;
		char[] letters = word.toCharArray();
		for (int i = 0; i < word.length(); i++) {
			int pos = letters[i] - 'a';
			if (node.son[pos] == null) {
				node.son[pos] = new TrieNode();
				node.son[pos].val = letters[i];
			} else {
				node.son[pos].num++;
			}
			node = node.son[pos];
		}
		node.isEnd = true;
	}

	// Returns if the word is in the trie.
	public boolean search(String word) {
		if (word == null || word.length() == 0) {
			return false;
		}
		TrieNode node = root;
		char[] letters = word.toCharArray();
		for (int i = 0; i < word.length(); i++) {
			int pos = letters[i] - 'a';
			if (node.son[pos] != null) {
				node = node.son[pos];
			} else {
				return false;
			}
		}
		return node.isEnd;
	}

	// Returns if there is any word in the trie
	// that starts with the given prefix.
	public boolean startsWith(String prefix) {
		if (prefix == null || prefix.length() == 0) {
			return false;
		}
		TrieNode node = root;
		char[] letters = prefix.toCharArray();
		for (int i = 0; i < prefix.length(); i++) {
			int pos = letters[i] - 'a';
			if (node.son[pos] != null) {
				node = node.son[pos];
			} else {
				return false;
			}
		}
		return true;
	}

	

}
