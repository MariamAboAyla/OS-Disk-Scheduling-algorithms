import java.util.ArrayList;
import java.util.Collections;

public class Optimized {
    final private ArrayList<Integer> processesQueue;
    final private int numOfProcesses;
    final private ArrayList<Integer> orderOfExecuting;
    private int seekTime;

    public Optimized(int numOfProcesses, ArrayList<Integer> queue) {
        this.numOfProcesses = numOfProcesses;
        orderOfExecuting = new ArrayList<>(numOfProcesses);
        this.processesQueue = queue;
        seekTime = 0;
    }

    public void Execute() {
        if (processesQueue.isEmpty()) {
            System.out.println("No Processes to be executed !");
            return;
        }
        Collections.sort(processesQueue);
        int pre_process = 0;
        for (int process : processesQueue) {
            seekTime += (seekTime == 0 ? process : process - pre_process);
            orderOfExecuting.add(process);
            pre_process = process;
        }
    }

    public void displayInfo() {
        System.out.println(" --- Optimized algorithm --- ");
        System.out.println("The number of processes is : " + numOfProcesses);
        System.out.println("The order of the processes is : ");
        for (int i = 1; i <= orderOfExecuting.size(); i++) {
            System.out.println("Process " + i + " is " + orderOfExecuting.get(i - 1));
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


}
