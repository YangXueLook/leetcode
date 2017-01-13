import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class SubstringsWithConcatenationOfAllWords {

	public static List<Integer> findSubstring(String S, String[] L) {
		ArrayList<Integer> result = new ArrayList<Integer>();

//		HashMap<String, Integer> wordAndCountMap = new HashMap<String, Integer>();
//		for (int i = 0; i < L.length; i++) {
//			if (wordAndCountMap.containsKey(L[i]))
//				wordAndCountMap.put(L[i], wordAndCountMap.get(L[i]) - 1);
//			else
//				wordAndCountMap.put(L[i], -1);
//		}
//		int numberOfZeros = 0;
//		int wordLength = L[0].length();
//		int preIndex = 0;
//		int postIndex = 0;
//		String currentWord;
//		for (preIndex = 0; preIndex < S.length() - wordLength; preIndex++) {
////			System.out.println(postIndex + " " + preIndex);
//			
//			currentWord = S.substring(preIndex, preIndex + wordLength);
//			if (wordAndCountMap.containsKey(currentWord)) {
//				wordAndCountMap.put(currentWord,
//						wordAndCountMap.get(currentWord) + 1);
//				if (wordAndCountMap.get(currentWord) == 0) {
//					numberOfZeros++;
//					if (numberOfZeros == wordAndCountMap.size()) {
//						result.add(postIndex);
//						// postIndex = preIndex + wordLength;
//
//						
//
//						wordAndCountMap.put(S.substring(postIndex, postIndex
//								+ wordLength), wordAndCountMap.get(S.substring(
//								postIndex, postIndex + wordLength)) - 1);
//						postIndex = postIndex + wordLength;
//						numberOfZeros--;
//					}
//				}
//				if (wordAndCountMap.get(currentWord) > 0) {
//					while (!S.substring(postIndex, postIndex + wordLength)
//							.equals(currentWord)) {
//						wordAndCountMap.put(S.substring(postIndex, postIndex
//								+ wordLength), wordAndCountMap.get(S.substring(
//								postIndex, postIndex + wordLength)) - 1);
//						postIndex = postIndex + wordLength;
//					}
//					wordAndCountMap.put(S.substring(postIndex, postIndex
//							+ wordLength), wordAndCountMap.get(S.substring(
//							postIndex, postIndex + wordLength)) - 1);
//					postIndex = postIndex + wordLength;
//				}
//			} else {
//				while (!S.substring(postIndex, postIndex + wordLength).equals(
//						currentWord)) {
//					if(wordAndCountMap.get(S.substring(
//							postIndex, postIndex + wordLength)) == 0)
//						numberOfZeros--;
//					
//					wordAndCountMap.put(S.substring(postIndex, postIndex
//							+ wordLength), wordAndCountMap.get(S.substring(
//							postIndex, postIndex + wordLength)) - 1);
//					postIndex = postIndex + wordLength;
//				}
//
//				postIndex = postIndex + wordLength;
//			}
//			
//			
//		}
		
		int numberOfZeros = 0;
		int wordLength = L[0].length();
		int preIndex = 0;
		int postIndex = 0;
		
		
		HashMap<String, Integer> wordAndCountMap = new HashMap<String, Integer>();
		for (int i = 0; i < L.length; i++) {
			if (wordAndCountMap.containsKey(L[i]))
				wordAndCountMap.put(L[i], wordAndCountMap.get(L[i]) - 1);
			else
				wordAndCountMap.put(L[i], -1);
		}
		
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String S = "barfoothefoobarman";
		String[] L = new String[] { "foo", "bar" };

		ArrayList<Integer> result = (ArrayList<Integer>) findSubstring(S, L);

		for (int i = 0; i < result.size(); i++)
			System.out.print(result.get(i) + " ");
	}

}
