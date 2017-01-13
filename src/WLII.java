import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;


public class WLII {
	
	class StringWithLevel {  
		   String str;  
		   int level;  
		   public StringWithLevel(String str, int level) {  
		      this.str = str;  
		      this.level = level;  
		   }  
		}  
		public ArrayList<ArrayList<String>> findLadders(String start, String end, HashSet<String> dict) {  
		   ArrayList<ArrayList<String>> res = new ArrayList<ArrayList<String>>();  
		   HashSet<String> unvisitedSet = new HashSet<String>();  
		   unvisitedSet.addAll(dict);  
		   unvisitedSet.add(start);  
		   unvisitedSet.remove(end);  
		   Map<String, List<String>> nextMap = new HashMap<String, List<String>>();  
		   for (String e : unvisitedSet) {  
		      nextMap.put(e, new ArrayList<String>());  
		   }  
		   LinkedList<StringWithLevel> queue = new LinkedList<StringWithLevel>();  
		   queue.add(new StringWithLevel(end, 0));  
		   boolean found = false;  
		   int finalLevel = Integer.MAX_VALUE;  
		   int curLevel = 0;  
		   int preLevel = 0;  
		   HashSet<String> visitedCurLevel = new HashSet<String>();  
		   while (!queue.isEmpty()) {  
		      StringWithLevel cur = queue.poll();  
		      String curStr = cur.str;  
		      curLevel = cur.level;  
		      if(found && curLevel > finalLevel) {  
		         break;  
		      }  
		      if (curLevel > preLevel) {  
		         unvisitedSet.removeAll(visitedCurLevel);  
		      }  
		      preLevel = curLevel;  
		      char[] curStrCharArray = curStr.toCharArray();  
		      for (int i = 0; i < curStr.length(); ++i) {  
		         char originalChar = curStrCharArray[i];  
		         boolean foundCurCycle = false;  
		         for (char c = 'a'; c <= 'z'; ++c) {  
		            curStrCharArray[i] = c;  
		            String newStr = new String(curStrCharArray);  
		            if(c != originalChar && unvisitedSet.contains(newStr)) {  
		               nextMap.get(newStr).add(curStr);  
		               if(newStr.equals(start)) {  
		                  found = true;  
		                  finalLevel = curLevel;  
		                  foundCurCycle = true;  
		                  break;  
		               }  
		               if(visitedCurLevel.add(newStr)) {  
		                  queue.add(new StringWithLevel(newStr, curLevel + 1));  
		               }  
		            }  
		         }  
		         if(foundCurCycle) {  
		            break;  
		         }  
		         curStrCharArray[i] = originalChar;  
		     }  
		   }  
		   if(found) {  
		       ArrayList<String> list = new ArrayList<String>();  
		       list.add(start);  
		       getPaths(start, end, list, finalLevel + 1, nextMap, res);  
		   }  
		   return res;  
		}  
		private void getPaths(String cur, String end, ArrayList<String> list, int level, Map<String, List<String>> nextMap, ArrayList<ArrayList<String>> res) {  
		   if(cur.equals(end)){  
		      res.add(new ArrayList<String>(list));  
		   }  
		   else if(level > 0){  
		      List<String> parentsSet = nextMap.get(cur);  
		      for (String parent : parentsSet) {  
		         list.add(parent);  
		         getPaths(parent, end, list, level - 1, nextMap, res);  
		         list.remove(list.size() - 1);  
		      }  
		   }  
		}  

	public static void main(String[] args) {
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
		
		
		WLII t = new WLII();
		ArrayList<ArrayList<String>> result =  t.findLadders(start, end, dict);
		for(int i = 0; i < result.size(); i++)
		{
			for(int j = 0; j < result.get(i).size(); j++)
				System.out.print(result.get(i).get(j)+"\t");
			System.out.println();
		}

	}

}
