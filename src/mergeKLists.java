import java.util.ArrayList;
import java.util.List;

public class mergeKLists {

	public ListNode mergeKLists(List<ListNode> lists) {
		if (lists == null || lists.size() == 0)
			return null;

		for (int i = lists.size() - 1; i >= 0; i--) {
			if (lists.get(i) == null)
				lists.remove(i);
		}

		if (lists.size() == 0)
			return null;

		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		ListNode movingIndex = dummy;
		int currentMinListIndex = 0;
		ListNode currentMinNode;
		ListNode tempIndex;
		ArrayList<ListNode> headIndexList = new ArrayList<ListNode>();
		for (int i = 0; i < lists.size(); i++) {
			headIndexList.add(lists.get(i));
		}

		while (lists.size() != 0) {
			currentMinNode = lists.get(0);
			currentMinListIndex = 0;
			for (int i = 0; i < lists.size(); i++) {
				if (lists.get(i).val < currentMinNode.val) {
					currentMinNode = lists.get(i);
					currentMinListIndex = i;

				}
			}

			movingIndex.next = currentMinNode;
			movingIndex = movingIndex.next;

			if (currentMinNode.next == null)
				lists.remove(currentMinListIndex);
			else
				lists.set(currentMinListIndex, currentMinNode.next);

		}

		return dummy.next;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		mergeKLists t = new mergeKLists();
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(21);
		ListNode l3 = new ListNode(3);
		ListNode l4 = new ListNode(4);
		ListNode l5 = new ListNode(5);
		ListNode l6 = new ListNode(6);

		l1.next = l2;
		l3.next = l4;
		l5.next = l6;

		ArrayList<ListNode> lists = new ArrayList<ListNode>();

		lists.add(l1);
		lists.add(l3);
		lists.add(l5);
		ListNode result = t.mergeKLists(lists);

		while (result != null) {
			System.out.println(result.val);
			result = result.next;
		}

	}

}
