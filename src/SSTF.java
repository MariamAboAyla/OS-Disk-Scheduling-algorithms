import java.util.ArrayList;
import java.util.Collections;

public class SSTF {

    final private ArrayList<Integer> processesQueue;
    final private int numOfProcesses;
    final private ArrayList<Integer> orderOfExecuting;
    final private ArrayList<Integer> orderOfExecuting_Gui;
    final private int initial;
    private int seekTime;

    public SSTF(int initial, int numOfProcesses, ArrayList<Integer> queue) {
        this.initial = initial;
        this.numOfProcesses = numOfProcesses;
        orderOfExecuting = new ArrayList<>(numOfProcesses);
        orderOfExecuting_Gui = new ArrayList<>(numOfProcesses);
        processesQueue = queue;
        seekTime = 0;
    }

    public void Execute() {
        if (processesQueue.isEmpty()) {
            System.out.println("No Processes to be executed !");
            return;
        }
        processesQueue.add(initial);
        Collections.sort(processesQueue);
        int index = 0;
        for (int i = 0; i < processesQueue.size(); i++) {
            if (processesQueue.get(i) == initial) {
                index = i;
                break;
            }
        }
        orderOfExecuting_Gui.add(initial);
        int ptr1 = index - 1;
        int ptr2 = index + 1;
        while (ptr1 != -1 || ptr2 != (numOfProcesses + 1)) {
            if (ptr1 == -1) {
                orderOfExecuting.add(processesQueue.get(ptr2));
                orderOfExecuting_Gui.add(processesQueue.get(ptr2));
                seekTime += (Math.abs(processesQueue.get(index) - processesQueue.get(ptr2)));
                index = ptr2;
                ptr2 = index + 1;
            } else if (ptr2 == (numOfProcesses + 1)) {
                orderOfExecuting.add(processesQueue.get(ptr1));
                orderOfExecuting_Gui.add(processesQueue.get(ptr1));
                seekTime += (Math.abs(processesQueue.get(index) - processesQueue.get(ptr1)));
                index = ptr1;
                ptr1 = index - 1;
            } else {
                int ans1 = (Math.abs(processesQueue.get(index) - processesQueue.get(ptr1)));
                int ans2 = (Math.abs(processesQueue.get(index) - processesQueue.get(ptr2)));
                if (ans1 < ans2) {
                    seekTime += ans1;
                    orderOfExecuting.add(processesQueue.get(ptr1));
                    orderOfExecuting_Gui.add(processesQueue.get(ptr1));
                    index = ptr1;
                    ptr1 = index - 1;
                } else {
                    seekTime += ans2;
                    orderOfExecuting.add(processesQueue.get(ptr2));
                    orderOfExecuting_Gui.add(processesQueue.get(ptr2));
                    index = ptr2;
                    ptr2 = index + 1;
                }
            }
        }
    }

    public void displayInfo() {
        System.out.println(" --- SSTF 'Shortest Seek Time First' algorithm --- ");
        System.out.println("The number of processes is : " + numOfProcesses);
        System.out.println("The order of the processes is: ");

        for (int i = 0; i < orderOfExecuting.size(); i++) {
            System.out.println("Process " + (i + 1) + " is " + orderOfExecuting.get(i));
        }
        System.out.println("The total head movement = " + seekTime + " Cylinders");
    }

    public int getSeekTime() {
        return seekTime;
    }

    public void setSeekTime(int seekTime) {
        this.seekTime = seekTime;
    }

    public ArrayList<Integer> getOrderOfExecuting() {
        return orderOfExecuting;
    }

    public ArrayList<Integer> getOrderOfExecuting_Gui() {
        return orderOfExecuting_Gui;
    }


}
