import java.util.*;
public class heap{
// Min-Heap Initialization
static class MinHeap{
private PriorityQueue<Integer> heap = new PriorityQueue<>();
public void insert(int value){
heap.add(value);
}
public Integer getMin(){
return heap.peek();
}
public Integer extractMin(){
return heap.poll();
}
}
public static void main(String[] args){
// Min-Heap Test
MinHeap heap = new MinHeap();
heap.insert(30);
heap.insert(26);
heap.insert(15);
System.out.println("Min-Heap Extract Min: " + heap.extractMin());
}
}
