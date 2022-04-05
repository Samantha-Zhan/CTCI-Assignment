public class Runner {
    public static void main(String[] args) {
/*         Heaps h = new Heaps();
        
        h.insert(44);
        h.insert(33);
        h.insert(22);
        h.insert(11);
        h.insert(12);
        h.insert(55);
        System.out.println(h.maxHeap);
        System.out.println("---------------");
        h.remove();
        System.out.println(h.maxHeap); */
        

        PriorityQueue pq = new PriorityQueue();
        pq.enqueue(3, 2);
        pq.enqueue(5, 3);
        pq.enqueue(9, 0);
        pq.enqueue(2, 1);
        System.out.println(pq.elements);
        pq.dequeue();
        System.out.println(pq.elements);
    }
}
