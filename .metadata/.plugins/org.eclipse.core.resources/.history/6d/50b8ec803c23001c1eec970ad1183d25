import java.util.ArrayList;

public class Heap {
	ArrayList<Integer> heap = new ArrayList<>();

	public void add(int val) {
		heap.add(val);
		upheapify(heap.size());
	}

	private void upheapify(int size) {
		// TODO Auto-generated method stub
		if (size < 0) {
			return;
		}
		int parent = (size - 1 / 2);
		if (parent > 0 && heap[parent] > heap[size]) {
//			switch
			upheapify(parent);
		}
		return;

	}

	private void downHeapify(int index) {
		int lc = heap.get((2 * index) + 1);
		int rc = heap.get((2 * index) + 2);
		int p = heap.get(index);
		if (lc < p && lc < rc) {
		} else if (rc < p && rc < lc) {
		}
	}
}
