package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class KeysAndRooms {
	public static void main(String[] args) {
     List<List<Integer>> list=new ArrayList<List<Integer>>();
//     List<Integer> l=new ArrayList<Integer>();
//     l.add(1);
//     
//     list.add(l);
	}
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
    	int v=rooms.size();
    	boolean visited[]=new boolean[v];
    	Queue<Integer> q=new LinkedList<>();
    	q.add(0);
    	visited[0]=true;
    	while(!q.isEmpty()) {
    		int t=q.poll();
        	for(int i:rooms.get(t)) {
        		if(!visited[i]) {
        			q.add(i);
        	    	visited[i]=true;
        		}
        	}
    		
    	}
    	for(boolean b:visited) {
    		if(!b) {
    			return false;
    		}
    	}
		return true;      
    }
}
