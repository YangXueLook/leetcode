import java.util.ArrayList;
import java.util.List;

public class TextJustification {

	public static List<String> fullJustify(String[] words, int L) {
		List<String> result = new ArrayList<String>();
		ArrayList<String> currentLineWords = new ArrayList<String>();
		int currentLength = 0;

		for (int i = 0; i < words.length; i++) {
			if (words[i].length() + currentLength <= L) {
				currentLineWords.add(words[i]);
				currentLength = currentLength + words[i].length() + 1;
			} else {
				int currentLineWordNumbers = currentLineWords.size();
				int totalWordLength = 0;
				for (int j = 0; j < currentLineWordNumbers; j++)
					totalWordLength = totalWordLength
							+ currentLineWords.get(j).length();
				int totalSpaceLength = L - totalWordLength;

				if (currentLineWordNumbers > 1) {
					int minSpaceIntervalLength = totalSpaceLength
							/ (currentLineWordNumbers - 1);
					int numberOfLongerSpaceIntervalLength = totalSpaceLength
							% (currentLineWordNumbers - 1);

					StringBuffer currentLine = new StringBuffer();
					for (int j = 0; j < currentLineWordNumbers-1; j++) {
						currentLine.append(currentLineWords.get(j));
						for (int k = 0; k < minSpaceIntervalLength; k++)
							currentLine.append(" ");
						if (numberOfLongerSpaceIntervalLength > 0) {
							currentLine.append(" ");
							numberOfLongerSpaceIntervalLength--;
						}

					}
					currentLine.append(currentLineWords.get(currentLineWords.size()-1));
					
					result.add(currentLine.toString());
				} else {
					StringBuffer currentLine = new StringBuffer();
					currentLine.append(currentLineWords.get(0));
					for (int j = 0; j < L - currentLineWords.get(0).length(); j++)
						currentLine.append(" ");
					result.add(currentLine.toString());

				}

				currentLineWords.clear();
				currentLineWords.add(words[i]);
				currentLength = words[i].length() + 1;
			}
		}
		if (currentLineWords.size() > 0) {
			int numberOfSpacesLeft = L;
			StringBuffer currentLine = new StringBuffer();
			for (int i = 0; i < currentLineWords.size() - 1; i++) {
				currentLine.append(currentLineWords.get(i));
				currentLine.append(" ");
				numberOfSpacesLeft = numberOfSpacesLeft - 1
						- currentLineWords.get(i).length();
			}
			currentLine
					.append(currentLineWords.get(currentLineWords.size() - 1));
			numberOfSpacesLeft = numberOfSpacesLeft
					- currentLineWords.get(currentLineWords.size() - 1)
							.length();
			for (int i = 0; i < numberOfSpacesLeft; i++)
				currentLine.append(" ");
			result.add(currentLine.toString());
		}

		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] words = new String[] { "This", "is", "an", "exampleeeeee",
				"of", "text", "justification." };
		List<String> result = fullJustify(words, 16);
		for (int i = 0; i < result.size(); i++)
			System.out.println(result.get(i));

	}

}
