import java.util.ArrayList;
import java.util.Arrays;
import java.util.Queue;

public class SSTF {

    private ArrayList<Integer> processesQueue, newQueue;
    private int numOfProcesses;
    private int seekTime;
    private ArrayList<Integer> orderOfExcuting;
    private int initial;

    public SSTF ( int initial , int numOfProcesses , ArrayList<Integer> queue ) {
        this.initial = initial;
        this.numOfProcesses = numOfProcesses;
        orderOfExcuting = new ArrayList<> ( numOfProcesses );
        newQueue = queue;
        processesQueue = queue;
        seekTime = 0;

    }

    private int findClosestProcess(int current){

        int closestProcess = 500; // as default scetor is of 0:199, so 500 is an impossible to get number as if marked false
        int index = -1;

        // get the nearest one then send it (could send it by index)
        for (int i = 0; i< numOfProcesses; i++) {
            if ( newQueue.get ( i ) == current  )
                continue;
            int difference = Math.abs ( newQueue.get ( i) - current );
            if(difference < closestProcess){
                closestProcess =  difference;
                index = processesQueue.indexOf ( newQueue.get(i) );
            }

        }

        return index;

    }

    public void Excute(){


        for(int i=0; i<numOfProcesses; i++){
            // search for the closest process to be executed
            int processIndex = findClosestProcess(initial);
            if(processIndex == -1){
                System.out.println ("not found!" );
                break;
            }
            if(newQueue.contains ( initial )) {
                int index = newQueue.indexOf ( initial );
                newQueue.set ( index, 500 );
            }
            Integer process = processesQueue.get ( processIndex );
            orderOfExcuting.add ( process );
            seekTime += Math.abs ( initial - process );
            initial =  process;

        }

    }

    public void displayInfo ( ) {
        System.out.println (" --- SSTF 'Shortest Seek Time First' algorithm --- " );
        System.out.println ( "The number of processes is : " + numOfProcesses );
        System.out.println ( "The order of the processes is: " );
        // make conidiiton till 'numOfProcesses' /////////

        for (int i = 0; i < orderOfExcuting.size (); i++) {
            System.out.println ( "Process " + (i+1) + " is " + orderOfExcuting.get ( i ) );
        }
        System.out.println ("The total head movement = "+seekTime+" Cylinders" );

    }


}
