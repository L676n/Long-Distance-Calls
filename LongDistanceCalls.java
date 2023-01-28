


import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;

    
    public class LongDistanceCalls extends JFrame{
        
        
    private JRadioButton DayTime;
    private JRadioButton evening;
    private JRadioButton offPeak;
    private ButtonGroup BG;
    private JTextField minutesTextField;
    private JLabel messageLabel;
    private JButton calcButton;
    private JButton exitButton;
    
    private JPanel panel1;
    private JPanel panel2;
    private JPanel panel3;
    private JPanel panel4;
    private JPanel panel5;
    
    private final int WINDOW_WIDTH = 350;
    private final int WINDOW_HEIGHT = 500;
    private final double DAY_TIME = 0.07;
    private final double EVENING = 0.12;
    private final double OFF_PEAK = 0.05;
    
    public LongDistanceCalls (){
      
        setTitle("Tempreture Converter");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(4,1));
        
        
        buildPanel();
        add(panel1);
        add(panel2);
        add(panel5);
        setVisible(true);
    }

    private void buildPanel(){
        
        DayTime = new JRadioButton("Daytime (6:00 a.m. through 5:59 p.m.)");
        evening = new JRadioButton("Evening (6:00 p.m. through 11:59 p.m.) ");
        offPeak = new JRadioButton("Off-Peak (12:00 a.m. through 5:59 a.m.)");
        
        BG=new ButtonGroup();
        BG.add(DayTime);
        BG.add(evening);
        BG.add(offPeak);
        
        panel1=new JPanel();
        panel1.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel1.setBorder(BorderFactory.createTitledBorder("Select a Rate Category"));
        panel1.add(DayTime);
        panel1.add(evening);
        panel1.add(offPeak);
        
        
        messageLabel = new JLabel("Minutes:");
        minutesTextField = new JTextField(10);
        panel2 = new JPanel();
        
        panel2.setBorder(BorderFactory.createTitledBorder("Time of Call"));
        panel2.setLayout(new GridLayout(1,2));
        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout(FlowLayout.LEFT));
        panel3.add(messageLabel);
        panel4 = new JPanel();
        panel4.setLayout(new FlowLayout(FlowLayout.RIGHT));
        panel4.add(minutesTextField);
        panel2.add(panel3);
        panel2.add(panel4);
        
        calcButton = new JButton("Calculate Charges");
        exitButton = new JButton("Exit");
        panel5 = new JPanel();
        calcButton.addActionListener(new CalcButtonListener());
        exitButton.addActionListener(new ExitButtonListener());
        
        panel5.add(calcButton);
        panel5.add(exitButton);   
    }
    
        private class CalcButtonListener implements ActionListener{
        public void actionPerformed(ActionEvent e) {
           
            int minutes=Integer.parseInt(minutesTextField.getText());
            double charge=0;
            
            if(DayTime.isSelected()){
                charge=minutes*DAY_TIME;
            }
            else if(evening.isSelected()){
                charge=minutes*EVENING;
            }
            else if(offPeak.isSelected()){
                charge=minutes*OFF_PEAK;
            }
     
            JOptionPane.showMessageDialog(null,String.format("Total Charge "
                    + "is: $%.2f", charge));
         } 
    }
    private class ExitButtonListener implements ActionListener{

        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }
    
    public static void main(String[] args){
      LongDistanceCalls LDC = new LongDistanceCalls();
    }   
 }

