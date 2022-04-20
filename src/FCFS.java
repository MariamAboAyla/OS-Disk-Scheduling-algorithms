import java.util.ArrayList;

public class FCFS {
    final private ArrayList<Integer> processesQueue;
    final private int numOfProcesses;
    final private ArrayList<Integer> orderOfExecuting;
    private int seekTime;
    private int initial;

    public FCFS(int initial, int numOfProcesses, ArrayList<Integer> queue) {
        this.initial = initial;
        this.numOfProcesses = numOfProcesses;
        orderOfExecuting = new ArrayList<>(numOfProcesses);
        seekTime = 0;
        processesQueue = new ArrayList<>(queue);
    }

    public void Execute() {
        if (processesQueue.isEmpty()) {
            System.out.println("No Processes to be executed !");
            return;
        }
        for (int process : processesQueue) {
            seekTime += (Math.abs(initial - process));
            orderOfExecuting.add(process);
            initial = process;
        }
    }

    public void displayInfo() {
        System.out.println(" --- FCFS 'First Come First Served' algorithm --- ");
        System.out.println("The number of processes is : " + numOfProcesses);
        System.out.println("The order of the processes is: ");
        for (int i = 1; i <= numOfProcesses; i++) {
            System.out.println("Process " + i + " is " + orderOfExecuting.get(i - 1));
        }
        System.out.println("The total head movement = " + seekTime + " Cylinders.");
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
