import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class WordLadderII {
	
	public boolean isAdjacent(String s1, String s2)
	{
		boolean hasOneDifferentChar = false;
		for(int i = 0; i < s1.length(); i++)
		{
			if(s1.charAt(i) != s2.charAt(i))
			{
				if(!hasOneDifferentChar)
					hasOneDifferentChar = true;
				else
					return false;
			}
		}
		return true;
	}
	
	public HashMap<String, ArrayList<String>> deepCopyMap(HashMap<String, ArrayList<String>> map)
	{
		HashMap<String, ArrayList<String>> result = new HashMap<String, ArrayList<String>>();
		
		Iterator it = map.keySet().iterator();
		while(it.hasNext())
		{
			String s = (String) it.next();
			ArrayList<String> org = map.get(s);
			ArrayList<String> copyArray = new ArrayList<String>(org);
			result.put(s, copyArray);
			
		}
		return result;
		
	}
	
	public ArrayList<String> deepCopyArrayList(ArrayList<String> list)
	{
		ArrayList<String> result = new ArrayList<String>();
		for(int i = 0; i < list.size(); i++)
			result.add(list.get(i));
		return result;
		
	}
	
	public void showMapContent(HashMap<String, ArrayList<String>> map)
	{
		Iterator it = map.keySet().iterator();
		while(it.hasNext())
		{
			String s = (String) it.next();
			System.out.print(s+": \t");
			ArrayList<String> org = map.get(s);
			for(int i = 0; i < org.size();i++)
				System.out.print(org.get(i)+",");
				
			System.out.println();
			
			
		}
		
		System.out.println("--------");
	}

	public List<List<String>> findLadders(String start, String end,
			Set<String> dict) {
		List<List<String>> result = new ArrayList<List<String>>();
		if(dict.size() == 0)
		{
			if(isAdjacent(start,end))
			{
				ArrayList<String> temp = new ArrayList<String>();
				temp.add(start);
				temp.add(end);
				result.add(temp);
			}
			return result;
		}
		
		HashMap<String, ArrayList<String>> forwardMap = new HashMap<String, ArrayList<String>>();
		HashMap<String, ArrayList<String>> forwardMapTemp = new HashMap<String, ArrayList<String>>();
//		Set<String> dict1 = new HashSet<String>();
		HashMap<String, ArrayList<String>> backwardMap = new HashMap<String, ArrayList<String>>();
		HashMap<String, ArrayList<String>> backwardMapTemp = new HashMap<String, ArrayList<String>>();
		Set<String> dict2 = new HashSet<String>();
		
		Iterator it = dict.iterator();
		while(it.hasNext())
		{
			dict2.add(new String((String)it.next()));
		}
		
		boolean meet = false;
		forwardMap.put(start, new ArrayList<String>());
		forwardMapTemp.put(start, new ArrayList<String>());
		backwardMap.put(end, new ArrayList<String>());
		backwardMapTemp.put(end, new ArrayList<String>());
		HashSet<String> meetInMiddleSet = new HashSet<String>();
		
		while(!(dict.size() == 0 && dict2.size() == 0))
		{
			//forward 1 step
			if(meet)
				break;
			
			forwardMap.clear();
			Iterator it1 = forwardMapTemp.keySet().iterator();
			boolean foundNewAdjacent = false;
			while(it1.hasNext())
			{
				String s = (String) it1.next();
				Iterator itD1 = dict.iterator();
				System.out.println("forwardMapTemp");
				showMapContent(forwardMapTemp);
				
				while(itD1.hasNext())
				{
					String temp  = (String) itD1.next(); 
					if(isAdjacent(s,temp))
					{
						foundNewAdjacent = true;
//						System.out.println(s+" forward "+temp);
						forwardMap.put(temp, deepCopyArrayList(forwardMapTemp.get(s)));
						forwardMap.get(temp).add(s);
						if(backwardMap.containsKey(temp))
						{
							meetInMiddleSet.add(temp);
							meet = true;
						}
							
					}
					
				}
				
				
				
			}
			
			System.out.println("forwardMap");
			showMapContent(forwardMap);
			forwardMapTemp = deepCopyMap(forwardMap);
			
			Iterator itRemove1 = forwardMap.keySet().iterator();
			while(itRemove1.hasNext())
			{
				dict.remove(itRemove1.next());
			}
			
			//backward 1 step
			if(meet)
				break;
			if(!foundNewAdjacent)
				break;
			
			
			backwardMap.clear();
			Iterator it2 = backwardMapTemp.keySet().iterator();
			foundNewAdjacent = false;
			while(it2.hasNext())
			{
				String s = (String) it2.next();
				Iterator itD2 = dict2.iterator();
				System.out.println("backwardMapTemp");
				showMapContent(backwardMapTemp);
				while(itD2.hasNext())
				{
					String temp  = (String) itD2.next(); 
					if(isAdjacent(s,temp))
					{
						foundNewAdjacent = true;
//						System.out.println(s+" back "+temp);
						backwardMap.put(temp, deepCopyArrayList(backwardMapTemp.get(s)));
//						System.out.println(backwardMapTemp.get(s) == null);
						backwardMap.get(temp).add(s);
						if(forwardMap.containsKey(temp))
						{
							meetInMiddleSet.add(temp);
							meet = true;
						}
					}
					
				}
				
				
				
			}
			
			System.out.println("backwardMap");
			showMapContent(backwardMap);
			backwardMapTemp = deepCopyMap(backwardMap);
			
			
			Iterator itRemove2 = backwardMap.keySet().iterator();
			while(itRemove2.hasNext())
			{
				dict2.remove(itRemove2.next());
			}
			
			if(meet)
				break;
			if(!foundNewAdjacent)
				break;
		}
		
		
		
		
		if(meet)
		{
			
			Iterator itMeet = meetInMiddleSet.iterator();
			
			while(itMeet.hasNext())
			{
				
				String s = (String) itMeet.next();
				ArrayList<String> temp1 = forwardMap.get(s);
				ArrayList<String> temp2 = backwardMap.get(s);
				temp1.add(s);
				for(int i = temp2.size()-1; i >=0; i--)
				{
					
					temp1.add(temp2.get(i));
				}
				result.add(temp1);
			}
			
		}
		
		
		return result;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
	
		
		String start = "nape";
		String end = "mild";
		String[] array = new String[]{"dose","ends","dine","jars","prow","soap","guns","hops","cray","hove","ella","hour","lens","jive","wiry","earl","mara","part","flue","putt","rory","bull","york","ruts","lily","vamp","bask","peer","boat","dens","lyre","jets","wide","rile","boos","down","path","onyx","mows","toke","soto","dork","nape","mans","loin","jots","male","sits","minn","sale","pets","hugo","woke","suds","rugs","vole","warp","mite","pews","lips","pals","nigh","sulk","vice","clod","iowa","gibe","shad","carl","huns","coot","sera","mils","rose","orly","ford","void","time","eloy","risk","veep","reps","dolt","hens","tray","melt","rung","rich","saga","lust","yews","rode","many","cods","rape","last","tile","nosy","take","nope","toni","bank","jock","jody","diss","nips","bake","lima","wore","kins","cult","hart","wuss","tale","sing","lake","bogy","wigs","kari","magi","bass","pent","tost","fops","bags","duns","will","tart","drug","gale","mold","disk","spay","hows","naps","puss","gina","kara","zorn","boll","cams","boas","rave","sets","lego","hays","judy","chap","live","bahs","ohio","nibs","cuts","pups","data","kate","rump","hews","mary","stow","fang","bolt","rues","mesh","mice","rise","rant","dune","jell","laws","jove","bode","sung","nils","vila","mode","hued","cell","fies","swat","wags","nate","wist","honk","goth","told","oise","wail","tels","sore","hunk","mate","luke","tore","bond","bast","vows","ripe","fond","benz","firs","zeds","wary","baas","wins","pair","tags","cost","woes","buns","lend","bops","code","eddy","siva","oops","toed","bale","hutu","jolt","rife","darn","tape","bold","cope","cake","wisp","vats","wave","hems","bill","cord","pert","type","kroc","ucla","albs","yoko","silt","pock","drub","puny","fads","mull","pray","mole","talc","east","slay","jamb","mill","dung","jack","lynx","nome","leos","lade","sana","tike","cali","toge","pled","mile","mass","leon","sloe","lube","kans","cory","burs","race","toss","mild","tops","maze","city","sadr","bays","poet","volt","laze","gold","zuni","shea","gags","fist","ping","pope","cora","yaks","cosy","foci","plan","colo","hume","yowl","craw","pied","toga","lobs","love","lode","duds","bled","juts","gabs","fink","rock","pant","wipe","pele","suez","nina","ring","okra","warm","lyle","gape","bead","lead","jane","oink","ware","zibo","inns","mope","hang","made","fobs","gamy","fort","peak","gill","dino","dina","tier"};
		
		HashSet<String>	dict = new HashSet<String>(Arrays.asList(array));
//		dict.add("hot");
//		dict.add("dot");
//		dict.add("dog");
//		dict.add("lot");
//		dict.add("log");
//		
//		dict.add("dof");
//		dict.add("mit");
//		dict.add("sit");
//		dict.add("set");
//		dict.add("mog");
//		
//		dict.add("mig");
//		dict.add("seg");
//		dict.add("nax");
//		dict.add("max");
		
		
		WordLadderII t = new WordLadderII();
		
		ArrayList<List<String>> result = (ArrayList<List<String>>) t.findLadders(start, end, dict);
		for(int i = 0; i < result.size(); i++)
		{
			for(int j = 0; j < result.get(i).size(); j++)
				System.out.print(result.get(i).get(j)+"\t");
			System.out.println();
		}
	}

}
