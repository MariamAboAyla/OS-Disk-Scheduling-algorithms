import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class FCFS {
    private Queue<Integer> processesQueue;
    private int numOfProcesses;
    private int seekTime;
    private ArrayList<Integer> orderOfExcuting;
    private int initial;

    public FCFS ( int initial , int numOfProcesses , ArrayList<Integer> queue ) {
        this.initial = initial;
        //this.processesQueue = processesQueue;
        this.numOfProcesses = numOfProcesses;
        orderOfExcuting = new ArrayList<> ( numOfProcesses );
        seekTime = 0;
        processesQueue = new LinkedList<> ( queue );
    }

    public void Excute ( ) {

        if ( processesQueue.isEmpty ( ) ) {
            System.out.println ( "No Processes to be executed !" );
            return;
        }

        int process = processesQueue.poll ( );
        seekTime += (Math.abs ( initial - process ));
        orderOfExcuting.add ( process );

        while (! processesQueue.isEmpty ( )) {
            int current = processesQueue.poll ( );
            orderOfExcuting.add ( current );
            seekTime += (Math.abs ( current - process ));
            process = current;
        }


    }

    public void displayInfo ( ) {
        System.out.println (" --- FCFS 'First Come First Served' algorithm --- " );
        System.out.println ( "The number of processes is : " + numOfProcesses );
        System.out.println ( "The order of the processes is: " );
        for (int i = 1; i <= numOfProcesses; i++) {
            System.out.println ( "Process " + i + " is " + orderOfExcuting.get ( i - 1 ) );
        }
        System.out.println ("The total head movement = "+seekTime+" Cylinders" );

    }

}
