package Pubmatic;

import java.util.Queue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.LinkedBlockingQueue;

class Test extends Object{
	int x;
	int y;
	
//	@Override
//	public String toString() {
//		return "Test [x=" + x + ", y=" + y + "]";
//	}
	
}

public class JavaStudy {
	public static void main(String[] args) {
      Test t=new Test();
//      System.out.println(t.t);
      Test obj=t;
      obj.x=10;
      System.out.println(t);
      BlockingQueue<Integer> q=new LinkedBlockingQueue();
	}
}
