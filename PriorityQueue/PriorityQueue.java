import java.util.ArrayList;

public class PriorityQueue {
    // 1: max priority
    public class NodeCls{
        int value;
        int priority;
        NodeCls() {
            
        }

        NodeCls(int value, int priority) {
            this.value = value;
            this.priority = priority;
        }

        public String toString() {
            return "[" + this.value + " , " + this.priority + "]";
        }
    }

    ArrayList<NodeCls> elements = new ArrayList<NodeCls>();
    
    void enqueue(int value, int priority) {
        NodeCls newNode = new NodeCls(value, priority);
        elements.add(newNode);
        int currIndex = elements.size()-1;
        int parentIndex = (int)Math.floor(currIndex/2.0);
        while(currIndex!=0 && elements.get(parentIndex).priority > priority) {
            elements.set(currIndex, elements.get(parentIndex));
            elements.set(parentIndex, newNode);
            currIndex = parentIndex;
            parentIndex = (int)Math.floor(currIndex/2.0);
        }
    }

    void dequeue() {
        // swap the first and last value of the array so that remains balanced
        this.elements.set(0, elements.get(elements.size()-1));
        this.elements.remove(elements.size()-1);
        NodeCls currNode = this.elements.get(0);
        int currIndex = 0;

        while(true){
            int leftIndex = 2*currIndex+1;
            int rightIndex = 2*currIndex+2;
            if(leftIndex >= elements.size() && rightIndex >= elements.size()) {
                break;
            } else if (rightIndex >= elements.size()) {
                if(elements.get(leftIndex).priority < currNode.priority) {
                    elements.set(currIndex, elements.get(leftIndex));
                    elements.set(leftIndex, currNode);
                    currIndex = leftIndex; 
                }
                break;
            }
            if(leftIndex < elements.size() && rightIndex < elements.size()) {
                if((elements.get(leftIndex).priority >= currNode.priority)&&(elements.get(rightIndex).priority >= currNode.priority)) {
                    break;
                } else if(elements.get(leftIndex).priority < elements.get(rightIndex).priority) {
                    elements.set(currIndex, elements.get(leftIndex));
                    elements.set(leftIndex, currNode);
                    currIndex = leftIndex;
                } else {
                    elements.set(currIndex, elements.get(rightIndex));
                    elements.set(rightIndex, currNode);
                    currIndex = rightIndex;
                }
            }
        }
    }
}
