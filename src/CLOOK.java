import java.util.ArrayList;
import java.util.Collections;

public class CLOOK {

    final private ArrayList<Integer> processesQueue;
    final private int numOfProcesses;
    final private ArrayList<Integer> orderOfExecuting;
    final private int initial;
    final private String direction;
    private int seekTime;

    public CLOOK(int initial, String direction, int numOfProcesses, ArrayList<Integer> queue) {
        this.initial = initial;
        this.numOfProcesses = numOfProcesses;
        orderOfExecuting = new ArrayList<>(numOfProcesses);
        this.processesQueue = queue;
        this.direction = direction;
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
        if (direction.equalsIgnoreCase("left")) {
            for (int i = index; i > 0; i--) {
                seekTime += (Math.abs(processesQueue.get(i) - processesQueue.get(i - 1)));
                orderOfExecuting.add(processesQueue.get(i - 1));
            }
            for (int i = numOfProcesses; i > index; i--) {
                seekTime += (i == numOfProcesses ? (Math.abs(processesQueue.get(i) - processesQueue.get(0))) : (Math.abs(processesQueue.get(i) - processesQueue.get(i + 1))));
                orderOfExecuting.add(processesQueue.get(i));
            }
        } else if (direction.equalsIgnoreCase("right")) {
            for (int i = index; i < numOfProcesses; i++) {
                seekTime += (Math.abs(processesQueue.get(i) - processesQueue.get(i + 1)));
                orderOfExecuting.add(processesQueue.get(i + 1));
            }
            for (int i = 0; i < index; i++) {
                seekTime += ((i == 0 ? (Math.abs(processesQueue.get(i) - processesQueue.get(numOfProcesses))) : (Math.abs(processesQueue.get(i) - processesQueue.get(i - 1)))));
                orderOfExecuting.add(processesQueue.get(i));
            }
        } else {
            System.out.println("Please choose a valid direction!");
        }
    }

    // to display the 'seek time' and sequence of executing the processes
    public void displayInfo() {
        System.out.println(" --- CLOOK algorithm --- ");
        if (numOfProcesses == 0) {
            System.out.println("The number of processes is : " + numOfProcesses);
            System.out.println("The order of the processes of " + direction + " direction " + " is 0. ");
            return;
        }

        System.out.println("The number of processes is : " + numOfProcesses);
        System.out.println("The order of the processes of direction " + direction + " is: ");
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

