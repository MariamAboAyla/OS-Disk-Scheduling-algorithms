import java.util.ArrayList;
import java.util.Collections;

public class LOOK {

    private ArrayList<Integer> processesQueue;
    private int numOfProcesses;
    private int seekTime;
    private ArrayList<Integer> orderOfExcuting;
    private int initial;
    private String direction;
    private int sectorsNumber;


    public LOOK ( int initial , String direction , int sectorsNumber  , int numOfProcesses , ArrayList<Integer> queue ) {
        this.initial = initial;
        this.numOfProcesses = numOfProcesses;
        orderOfExcuting = new ArrayList<> ( numOfProcesses );
        this.processesQueue = queue;
        this.direction = direction;
        this.sectorsNumber = sectorsNumber - 1;
        seekTime = 0;

    }

    // to get the first index from "right" direction to the current head
    private int findStartIndexToRight ( ) {

        for (int i = 0; i < numOfProcesses; i++) {
            if ( processesQueue.get ( i ) >= initial ) {
                return i;
            }
        }
        return numOfProcesses - 1;

    }

    // to get the first index from "left" direction to the current head
    private int findStartIndexToLeft ( ) {
        for (int i = numOfProcesses - 1; i >= 0; i--) {
            if ( processesQueue.get ( i ) <= initial ) {
                return i;
            }
        }
        return 0;
    }

    public void Excute ( ) {

        Collections.sort ( processesQueue );

        if ( direction.equalsIgnoreCase ( "left" ) ) {

            int index = findStartIndexToLeft ( );

            for (int i = index; i >= 0; i--) {
                orderOfExcuting.add ( processesQueue.get ( i ) );
                seekTime += Math.abs ( initial - processesQueue.get ( i ) );
                initial = processesQueue.get ( i );
            }


            for (int i = index + 1; i < numOfProcesses; i++) {
                orderOfExcuting.add ( processesQueue.get ( i ) );
                seekTime += Math.abs ( initial - processesQueue.get ( i ) );
                initial = processesQueue.get ( i );
            }


        } else if ( direction.equalsIgnoreCase ( "right" ) ) {

            int index = findStartIndexToRight ( );

            // to add all processes to the right
            for (int i = index; i < numOfProcesses; i++) {
                orderOfExcuting.add ( processesQueue.get ( i ) );
                seekTime += Math.abs ( initial - processesQueue.get ( i ) );
                initial = processesQueue.get ( i );
            }


            // to reverse to get the first process on the opposite direction
            for (int i = index - 1; i >= 0; i--) {
                orderOfExcuting.add ( processesQueue.get ( i ) );
                seekTime += Math.abs ( initial - processesQueue.get ( i ) );
                initial = processesQueue.get ( i );

            }

        } else {
            System.out.println ( "Please choose a valid direction!" );
        }

    }

    // to display the 'seek time' and sequence of executing the processes
    public void displayInfo ( ) {
        System.out.println ( " --- LOOK algorithm --- " );
        if ( numOfProcesses == 0 ) {
            System.out.println ( "The number of processes is : " + numOfProcesses );
            System.out.println ( "The order of the processes of " + direction + " direction " + " is 0. " );
            return;
        }

        System.out.println ( "The number of processes is : " + numOfProcesses );
        System.out.println ( "The order of the processes of direction " + direction + " is: " );
        for (int i = 1; i <= orderOfExcuting.size (); i++) {
            System.out.println ( "Process " + i + " is " + orderOfExcuting.get ( i - 1 ) );
        }
        System.out.println ( "The total head movement = " + seekTime + " Cylinders" );

    }




}
