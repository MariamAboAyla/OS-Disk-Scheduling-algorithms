import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Gui extends JFrame {
    private final int sectorNum = 200;
    private final String direction = "right";
    private JTextField processesTextField;
    private JTextField startPosition;
    private JButton simulateButton;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField5;
    private JTextField textField6;
    private JButton chartFCFS;
    private JButton chartSSTF;
    private JButton chartScan;
    private JButton chartCSCAN;
    private JButton chartLOOK;
    private JButton chartCLOOK;
    private JButton chartOptimized;
    private JTextField textField7;
    private JTextField textField8;
    private JTextField textField9;
    private JTextField textField10;
    private JTextField textField11;
    private JTextField textField12;
    private JTextField textField13;
    private JTextField textField14;
    private JTextField textField15;
    private JTextField textField16;
    private JPanel mainPanel;

    public Gui() {
        super("Scheduler Simulator");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setContentPane(mainPanel);
        this.pack();

        simulateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int init = Integer.parseInt(startPosition.getText());
                if (init < 0 || init > 199) {
                    JOptionPane.showMessageDialog(null, "Start position must be between 0 and 199");
                } else {
                    ArrayList<Integer> result;
                    Utility utility1 = new Utility();

                    result=utility1.Simulator(processesTextField.getText().trim(), init);
                    //FCFS
                    FCFS fcfs = new FCFS(init,result.size(),result);
                    fcfs.Execute();
                    textField3.setText(fcfs.getOrderOfExecuting_Gui().toString());
                    textField4.setText(String.valueOf(fcfs.getSeekTime()));

                    Utility utility2 = new Utility();
                    result = utility2.Simulator(processesTextField.getText().trim(), init);
                    //SSTF
                    SSTF sstf = new SSTF(init,result.size(),result);
                    sstf.Execute();
                    textField5.setText(sstf.getOrderOfExecuting_Gui().toString());
                    textField6.setText(String.valueOf(sstf.getSeekTime()));


                    Utility utility6 = new Utility();
                    result = utility6.Simulator(processesTextField.getText().trim(), init);
                    //SCAN
                    SCAN scan = new SCAN(init,direction,sectorNum,result.size(),result);
                    scan.Execute();
                    textField7.setText(scan.getOrderOfExecuting_Gui().toString());
                    textField8.setText(String.valueOf(scan.getSeekTime()));

                    Utility utility4 = new Utility();
                    result = utility4.Simulator(processesTextField.getText().trim(), init);
                    //CSCAN
                    CSCAN cscan = new CSCAN(init,direction,sectorNum,result.size(),result);
                    cscan.Execute();
                    textField9.setText(cscan.getOrderOfExecuting_Gui().toString());
                    textField10.setText(String.valueOf(cscan.getSeekTime()));


                    Utility utility5 = new Utility();
                    result = utility5.Simulator(processesTextField.getText().trim(), init);
                    //LOOK
                    LOOK look = new LOOK(init,direction,result.size(),result);
                    look.Execute();
                    textField11.setText(look.getOrderOfExecuting_Gui().toString());
                    textField12.setText(String.valueOf(look.getSeekTime()));

                    Utility utility3 = new Utility();
                    result = utility3.Simulator(processesTextField.getText().trim(), init);
                    //CLOOK
                    CLOOK clook = new CLOOK(init,direction,result.size(),result);
                    clook.Execute();
                    textField13.setText(clook.getOrderOfExecuting_Gui().toString());
                    textField14.setText(String.valueOf(clook.getSeekTime()));


                    Utility utility7 = new Utility();
                    result = utility7.Simulator(processesTextField.getText().trim(), init);
                    //Optimized
                    Optimized opt = new Optimized(result.size(),result);
                    opt.Execute();
                    textField15.setText(opt.getOrderOfExecuting_Gui().toString());
                    textField16.setText(String.valueOf(opt.getSeekTime()));




                }
            }
        });
        chartFCFS.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int init = Integer.parseInt(startPosition.getText());
                Runnable r = new Runnable() {
                    public void run() {
                        Utility utility1 = new Utility();
                        ArrayList<Integer> result;
                        result = utility1.Simulator(processesTextField.getText().trim(), init);
                        // FCFS
                        FCFS fcfs = new FCFS(init, result.size(), result);
                        fcfs.Execute();
                        Graph lineComponent = new Graph(fcfs.getOrderOfExecuting_Gui(), "FCFS");
                        JOptionPane.showMessageDialog(null, lineComponent);
                    }
                };
                SwingUtilities.invokeLater(r);
            }
        });
        chartSSTF.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int init = Integer.parseInt(startPosition.getText());
                Runnable r = new Runnable() {
                    public void run() {
                        Utility utility1 = new Utility();
                        ArrayList<Integer> result;
                        result = utility1.Simulator(processesTextField.getText().trim(), init);
                        SSTF sstf = new SSTF(init, result.size(), result);
                        sstf.Execute();
                        Graph lineComponent = new Graph(sstf.getOrderOfExecuting_Gui(), "SJF");
                        JOptionPane.showMessageDialog(null, lineComponent);
                    }
                };
                SwingUtilities.invokeLater(r);
            }
        });
        chartScan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int init = Integer.parseInt(startPosition.getText());
                Runnable r = new Runnable() {
                    public void run() {
                        Utility utility1 = new Utility();
                        ArrayList<Integer> result;
                        result = utility1.Simulator(processesTextField.getText().trim(), init);
                        SCAN scan = new SCAN(init, direction, sectorNum, result.size(), result);
                        scan.Execute();
                        Graph lineComponent = new Graph(scan.getOrderOfExecuting_Gui(), "SCAN");
                        JOptionPane.showMessageDialog(null, lineComponent);
                    }
                };
                SwingUtilities.invokeLater(r);
            }
        });
        chartCSCAN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int init = Integer.parseInt(startPosition.getText());
                Runnable r = new Runnable() {
                    public void run() {
                        Utility utility1 = new Utility();
                        ArrayList<Integer> result;
                        result = utility1.Simulator(processesTextField.getText().trim(), init);
                        CSCAN cscan = new CSCAN(init, direction, sectorNum, result.size(), result);
                        cscan.Execute();
                        Graph lineComponent = new Graph(cscan.getOrderOfExecuting_Gui(), "CSCAN");
                        JOptionPane.showMessageDialog(null, lineComponent);
                    }
                };
                SwingUtilities.invokeLater(r);
            }
        });
        chartLOOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int init = Integer.parseInt(startPosition.getText());
                Runnable r = new Runnable() {
                    public void run() {
                        Utility utility1 = new Utility();
                        ArrayList<Integer> result;
                        result = utility1.Simulator(processesTextField.getText().trim(), init);
                        LOOK look = new LOOK(init, direction, result.size(), result);
                        look.Execute();
                        Graph lineComponent = new Graph(look.getOrderOfExecuting_Gui(), "LOOK");
                        JOptionPane.showMessageDialog(null, lineComponent);
                    }
                };
                SwingUtilities.invokeLater(r);
            }
        });
        chartCLOOK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int init = Integer.parseInt(startPosition.getText());
                Runnable r = new Runnable() {
                    public void run() {
                        Utility utility1 = new Utility();
                        ArrayList<Integer> result;
                        result = utility1.Simulator(processesTextField.getText().trim(), init);
                        CLOOK clook = new CLOOK(init, direction, result.size(), result);
                        clook.Execute();
                        Graph lineComponent = new Graph(clook.getOrderOfExecuting_Gui(), "CLOOK");
                        JOptionPane.showMessageDialog(null, lineComponent);
                    }
                };
                SwingUtilities.invokeLater(r);
            }
        });
        chartOptimized.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                Runnable r = new Runnable() {
                    public void run() {
                        Utility utility1 = new Utility();
                        ArrayList<Integer> result;
                        result = utility1.Simulator(processesTextField.getText().trim(), 0);
                        Optimized optimized = new Optimized(result.size(), result);
                        optimized.Execute();
                        Graph lineComponent = new Graph(optimized.getOrderOfExecuting_Gui(), "Optimized");
                        JOptionPane.showMessageDialog(null, lineComponent);
                    }
                };
                SwingUtilities.invokeLater(r);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new Gui();
        frame.setVisible(true);
    }


}

