// GUI and main program for the Training Record

import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.lang.Number;
import java.util.ArrayList;

public class TrainingRecordGUI extends JFrame implements ActionListener {
    private JTextField name = new JTextField(30);               //super
    private JTextField day = new JTextField(2);                 //super
    private JTextField month = new JTextField(2);
    private JTextField year = new JTextField(4);                //super
    private JTextField hours = new JTextField(2);               
    private JTextField mins = new JTextField(2);
    private JTextField secs = new JTextField(2);
    private JTextField dist = new JTextField(4);
    private JTextField terrain = new JTextField(10);            //cycle
    private JTextField numberOfSprints = new JTextField(2);     //sprint
    private JTextField recoveryTime = new JTextField(2);        //sprint
    private String[] locations = {"indoors", "outdoors"};
    private JComboBox<String> locationDropDown = new JComboBox<>(locations);
    private JLabel labn = new JLabel(" Name:");
    private JLabel labd = new JLabel(" Day:");
    private JLabel labm = new JLabel(" Month:");
    private JLabel laby = new JLabel(" Year:");
    private JLabel labh = new JLabel(" Hours:");
    private JLabel labmm = new JLabel(" Mins:");
    private JLabel labs = new JLabel(" Secs:");
    private JLabel labdist = new JLabel(" Distance (km)");
    private JLabel labTerrain = new JLabel("Terrain (cycle training)");
    private JLabel labNumberOfSprints = new JLabel("Number of sprints (sprint training)");
    private JLabel labRecovery = new JLabel("Recovery time (sprint training)");
    private JLabel labLocation = new JLabel("Swim location (swim training)");
    private JButton addR = new JButton("Add as run");
    private JButton addSp = new JButton("Add as sprint");
    private JButton addC = new JButton("Add as cycle");
    private JButton addSw = new JButton("Add as swim");
    private JButton lookup = new JButton("Look Up");
    private JButton date = new JButton("Find All by Date");
    private JButton clear = new JButton("Clear");
    private JButton remove = new JButton("Remove");
    private TrainingRecord myAthletes = new TrainingRecord();
    private JTextArea outputArea = new JTextArea(5,50);
    
    public static void main(String[] args) {
        TrainingRecordGUI applic = new TrainingRecordGUI();
        applic.setVisible(true);
    } // main
 
   // set up the GUI 
     public TrainingRecordGUI() {
        super("Training Record");
        setLayout(new FlowLayout()); 
        add(labn);
        add(name);
        name.setEditable(true);
        add(labd);
        add(day);
        day.setEditable(true);
        add(labm);
        add(month);
        month.setEditable(true);
        add(laby);
        add(year);
        year.setEditable(true);
        add(labh);
        add(hours);
        hours.setEditable(true);
        add(labmm);
        add(mins);
        mins.setEditable(true);
        add(labs);
        add(secs);
        secs.setEditable(true);
        add(labdist);
        add(dist);
        dist.setEditable(true);
        add(labTerrain);
        add(terrain);
        terrain.setEditable(true);
        add(labNumberOfSprints);
        add(numberOfSprints);
        numberOfSprints.setEditable(true);
        add(labRecovery);
        add(recoveryTime);
        recoveryTime.setEditable(true);
        add(labLocation);
        add(locationDropDown);
        locationDropDown.addActionListener(this);
        add(addR);
        addR.addActionListener(this);
        add(addSp);
        addSp.addActionListener(this);
        add(addC);
        addC.addActionListener(this);
        add(addSw);
        addSw.addActionListener(this);
        add(lookup);
        lookup.addActionListener(this);
        lookup.setEnabled(false);
        add(date);
        date.addActionListener(this);
        date.setEnabled(false);
        add(clear);
        clear.addActionListener(this);
        add(remove);
        remove.addActionListener(this);
        remove.setEnabled(false);
        add(outputArea);
        outputArea.setEditable(false); 
        setSize(720,400);
        setVisible(true); 
        blankDisplay();
        
        // To save typing in new entries while testing, uncomment
        // the following lines (or add your own test cases)
        Entry a = new Entry("Alice", 1, 2, 2003, 0, 16, 7, 3);
        Entry b = new Entry("Bob", 1, 2, 2003, 0, 14, 15, 3);
        Entry c1 = new Entry("Claire",7,3,2010, 0, 26, 20, 7);        
        Entry c2 = new Entry("Claire",11,3,2010, 0, 24, 55, 7);        
        myAthletes.addEntry(a);
        myAthletes.addEntry(b);
        myAthletes.addEntry(c1);        
        myAthletes.addEntry(c2);        
     } // constructor
  
   // listen for and respond to GUI events 
     public void actionPerformed(ActionEvent event) {    
        if (event.getSource() == addR) {
          if (name.getText().equals("") || month.getText().equals("") || day.getText().equals("") || year.getText().equals("") || dist.getText().equals("")
           || hours.getText().equals("") || mins.getText().equals("") || secs.getText().equals("")) 
          {
                outputArea.setText("One of the fields is empty");
          }else{
           String n = name.getText();
           int m = Integer.parseInt(month.getText());   
           int d = Integer.parseInt(day.getText()); 
           int y = Integer.parseInt(year.getText());
           float km = java.lang.Float.parseFloat(dist.getText());
           int h = Integer.parseInt(hours.getText());
           int mm = Integer.parseInt(mins.getText());
           int s = Integer.parseInt(secs.getText());
           Run r = new Run(n, d, m, y, h, mm, s, km);
           myAthletes.addEntry(r);
           String output = "Run";
           outputArea.setText(output + " added\n");
           blankDisplay();
           lookup.setEnabled(true);
           date.setEnabled(true);
           remove.setEnabled(true);
          }
        }
        
        if (event.getSource() == addSp) {
          if (name.getText().equals("") || month.getText().equals("") || day.getText().equals("") || year.getText().equals("") || dist.getText().equals("")
           || hours.getText().equals("") || mins.getText().equals("") || secs.getText().equals("") || recoveryTime.getText().equals("") || 
           numberOfSprints.getText().equals("") || year.getText().length() != 4 || day.getText().length() > 2 || month.getText().length() > 2)            
          {
              outputArea.setText("One of the fields is empty");
          }else{
           String n = name.getText();
           int m = Integer.parseInt(month.getText()); 
           int d = Integer.parseInt(day.getText()); 
           int y = Integer.parseInt(year.getText());
           float km = java.lang.Float.parseFloat(dist.getText());
           int h = Integer.parseInt(hours.getText());
           int mm = Integer.parseInt(mins.getText());
           int s = Integer.parseInt(secs.getText());
           int r = Integer.parseInt(recoveryTime.getText());
           int nOs = Integer.parseInt(numberOfSprints.getText());
           Sprint sp = new Sprint(n, d, m, y, h, mm, s, km, r, nOs);
           myAthletes.addEntry(sp);
           String output = "Sprint";
           outputArea.setText(output + " added\n");
           blankDisplay(); 
           lookup.setEnabled(true);
           date.setEnabled(true);
           remove.setEnabled(true);
          }
        }
        
        if (event.getSource() == addC) {
           if (name.getText().equals("") || month.getText().equals("") || day.getText().equals("") || year.getText().equals("") || dist.getText().equals("")
           || hours.getText().equals("") || mins.getText().equals("") || secs.getText().equals("") || terrain.getText().equals("")) 
           {
                outputArea.setText("One of the fields is empty");
          }else{
           String n = name.getText();
           int m = Integer.parseInt(month.getText());
           int d = Integer.parseInt(day.getText()); 
           int y = Integer.parseInt(year.getText());
           float km = java.lang.Float.parseFloat(dist.getText());
           int h = Integer.parseInt(hours.getText());
           int mm = Integer.parseInt(mins.getText());
           int s = Integer.parseInt(secs.getText());
           String terrain2 = terrain.getText();
           Cycle c = new Cycle(n, d, m, y, h, mm, s, km, terrain2);
           myAthletes.addEntry(c);
           String output = "Cycle";
           outputArea.setText(output + " added\n");
           blankDisplay();
           lookup.setEnabled(true);
           date.setEnabled(true);
           remove.setEnabled(true);
        }
        }
        
        if (event.getSource() == addSw) {
          if (name.getText().equals("") || month.getText().equals("") || day.getText().equals("") || year.getText().equals("") || dist.getText().equals("")
           || hours.getText().equals("") || mins.getText().equals("") || secs.getText().equals("")) 
          {
                outputArea.setText("One of the fields is empty");
          }else{
            String n = name.getText();
            int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText()); 
            int y = Integer.parseInt(year.getText());
            float km = java.lang.Float.parseFloat(dist.getText());
            int h = Integer.parseInt(hours.getText());
            int mm = Integer.parseInt(mins.getText());
            int s = Integer.parseInt(secs.getText());
            String location = (String)locationDropDown.getSelectedItem();
            Swim sw = new Swim(n, d, m, y, h, mm, s, km, location);
            myAthletes.addEntry(sw);
            String output = "Swim";
            outputArea.setText(output + " added\n");
            blankDisplay();
            lookup.setEnabled(true);
            date.setEnabled(true);
            remove.setEnabled(true);
          }
        }
         
        if (event.getSource() == lookup) {
             if (month.getText().equals("") || day.getText().equals("") || year.getText().equals("")) {
                 outputArea.setText("One of the fields is empty");
             }else{
             int m = Integer.parseInt(month.getText());
             int d = Integer.parseInt(day.getText()); 
             int y = Integer.parseInt(year.getText()); 
             outputArea.setText("looking up record ...");
             String result = myAthletes.lookupEntry(d, m, y);
             outputArea.setText(result);
          }
        }
        
        if (event.getSource() == date) {
           if (month.getText().equals("") || day.getText().equals("") || year.getText().equals("")) {
                 outputArea.setText("One of the fields is empty");
           }else{
            int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            outputArea.setText("looking up record...");
            String result = myAthletes.lookupAll(d, m, y);
            outputArea.setText(result);
           }
        }        
        
        if (event.getSource() == clear) {
           outputArea.setText(null);
           blankDisplay();
        } // actionPerformed
        
        if (event.getSource() == remove) {
            if (name.getText().equals("") || month.getText().equals("") || day.getText().equals("") || year.getText().equals("")) {
                outputArea.setText("One of the fields is empty");
            }else{
            String removeName = name.getText();
            int m = Integer.parseInt(month.getText());
            int d = Integer.parseInt(day.getText());
            int y = Integer.parseInt(year.getText());
            float km = 0.0f;
            int h = 0;
            int mm = 0;
            int s = 0;
            Entry e = new Entry(removeName, d, m, y, h, mm, s, km);
            String result = myAthletes.removeEntry(e);
            outputArea.setText(result + " has been removed");
           }
        }
        
     }
       
     public void blankDisplay(){
        name.setText("");
        day.setText("");
        month.setText("");
        year.setText("");
        hours.setText("");
        mins.setText("");
        secs.setText("");
        dist.setText("");  
        terrain.setText("");
        numberOfSprints.setText("");
        recoveryTime.setText("");
     }// blankDisplay    
} // TrainingRecordGUI