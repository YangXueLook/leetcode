import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class CloneGraph {

	public UndirectedGraphNode assistant(UndirectedGraphNode node,
			HashMap<UndirectedGraphNode, UndirectedGraphNode> orgAndClonedMap) {
		System.out.println("///////////");
		System.out.println(node.label + " is lable");
		Iterator<UndirectedGraphNode> ii = orgAndClonedMap.keySet().iterator();
		while (ii.hasNext()) {
			UndirectedGraphNode ug = ii.next();
			System.out.println(ug.label + " and "
					+ orgAndClonedMap.get(ug).label);
		}
		System.out.println("----------");
		if (orgAndClonedMap.containsKey(node))
			return orgAndClonedMap.get(node);

		UndirectedGraphNode result = new UndirectedGraphNode(node.label);

		orgAndClonedMap.put(node, result);

		for (int i = 0; i < node.neighbors.size(); i++) {
//			if (node.neighbors.get(i).equals(node)) {
//				result.neighbors.add(result);
//			}

			UndirectedGraphNode temp = assistant(node.neighbors.get(i),
					orgAndClonedMap);
			if (temp != null) {
				result.neighbors.add(temp);

				// orgAndClonedMap.get(node).neighbors.add(temp);
			}
		}

		return result;
	}

	public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {

		if (node == null)
			return null;

		
		HashMap<UndirectedGraphNode, UndirectedGraphNode> orgAndClonedMap = new HashMap<UndirectedGraphNode, UndirectedGraphNode>();

		return assistant(node, orgAndClonedMap);

	}

	public static void main(String[] args) {
		UndirectedGraphNode n1 = new UndirectedGraphNode(1);
		UndirectedGraphNode n2 = new UndirectedGraphNode(2);
		UndirectedGraphNode n3 = new UndirectedGraphNode(3);
		n1.neighbors.add(n2);
		n1.neighbors.add(n3);
		n2.neighbors.add(n1);
		n3.neighbors.add(n1);
		n3.neighbors.add(n3);

		CloneGraph t = new CloneGraph();
		UndirectedGraphNode result = t.cloneGraph(n1);
		for (int i = 0; i < result.neighbors.size(); i++)
			System.out.println(result.neighbors.get(i).label);
		System.out.println("-------");

		UndirectedGraphNode r2 = result.neighbors.get(0);
		for (int i = 0; i < r2.neighbors.size(); i++)
			System.out.println(r2.neighbors.get(i).label);
		System.out.println("-------");

		UndirectedGraphNode r3 = result.neighbors.get(1);
		for (int i = 0; i < r3.neighbors.size(); i++)
			System.out.println(r3.neighbors.get(i).label);
		System.out.println("-------");

	}

}

class UndirectedGraphNode {
	int label;
	List<UndirectedGraphNode> neighbors;

	UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
};