package algos.sorting;

import java.util.ArrayList;
import java.util.List;

public class MergeSort implements ISort {

	@Override
	public final void sort(final List<Integer> list) {
		this.devide(list, 0, list.size()-1);
	}
	
	private void devide(List<Integer> list, int start, int end) {
		if (start < end) {
			int mid = (start+end)/2;
			devide(list, start, mid);
			devide(list, mid+1, end);
			
			this.merge(list, start, end, mid);
			
		}
	}
	
	private void merge(List<Integer> list, int start, int end, int mid) {
		List<Integer> rightList = new ArrayList<>();
		List<Integer> leftList = new ArrayList<>();
		
		for(int i=0; i<mid-start+1; i++) {
			leftList.add(list.get(start+i));
		}
		
		for(int i=0; i<end-mid; i++) {
			rightList.add(list.get(mid+i+1));
		}
		
		int i = 0, j = 0, k = start;
		while (i < leftList.size() && j < rightList.size()) {
			list.remove(k);
			if(leftList.get(i) < rightList.get(j)) {
				list.add(k++, leftList.get(i++));
			} else if(leftList.get(i) > rightList.get(j)){
				list.add(k++, rightList.get(j++));
			}
		}
		
		while(i<leftList.size()) {
			list.remove(k);
			list.add(k++, leftList.get(i++));
		}
		
		while(j<rightList.size()) {
			list.remove(k);
			list.add(k++, rightList.get(j++));
		}
	}
	
	public static void main(String[] args) {
		List<Integer> list = new ArrayList<>();
		list.add(5);
		list.add(4);
		list.add(3);
		list.add(2);
		list.add(1);
		ISort sortingAlgo = new MergeSort();
		sortingAlgo.sort(list);
		printList(list);
	}
	
	private static final void printList(List<Integer> list) {
		for(Integer i : list)
			System.out.println(i);
	}
}
