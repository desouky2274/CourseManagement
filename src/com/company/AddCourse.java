package com.company;

import com.company.gui.Connection1;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class AddCourse extends JFrame{
    public  static Connection con;
    public static Statement stat;
    public static int id;
    static {
        try {
            con = Connection1.getCon();
            stat = con.createStatement();
        } catch (SQLException ex)
        {
            JOptionPane.showMessageDialog(null,"SQL connection not found","Error",JOptionPane.ERROR_MESSAGE);
        }
    }
    private JPanel root;
    private JComboBox Courses;
    private JComboBox comboBox1;
    private JButton addCourse;

    public AddCourse(int id) throws SQLException {
        this.setPreferredSize(new Dimension(400, 300));

        this.id = id;
        try {
            String sql = "SELECT * FROM student WHERE student_ID = "+id;
            String [] courses = new String[7];
            ResultSet rs = stat.executeQuery(sql);
            rs.next();
            for (int i = 0; i < 7; i++) {
                if (rs.getString("course"+(i+1)) != null)
                    courses[i] = rs.getString("course"+(i+1));
            }
            sql = "SELECT * FROM course";
            ResultSet r = stat.executeQuery(sql);
            while (r.next()){
                boolean isHere = false;
                for (int i = 0; i < 7; i++) {
                    if (courses[i] != null){
                        if (r.getString("courseCode").equals(courses[i]))
                           isHere = true;
                    }
                }
                if (!isHere)
                Courses.addItem(r.getString("courseCode"));
                }
            } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        pack();
        setContentPane(root);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        addCourse.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    String courseCode = Courses.getSelectedItem().toString();
                    int instructorID = Integer.parseInt(comboBox1.getSelectedItem().toString());
                    String sql = "SELECT * from student WHERE student_ID = " + id;
                    ResultSet rs = stat.executeQuery(sql);
                    rs.next();
                    for (int i = 0; i < 7; i++) {
                        if (rs.getString("course"+(i+1)) == null){
                            sql = "UPDATE student SET course"+(i+1)+" = '"+courseCode+"' WHERE student_ID = "+id;
                            int r1 = stat.executeUpdate(sql);
                            sql = "INSERT INTO "+courseCode+" (studentId,instructorID) values ("+id+","+instructorID+")";
                            int r2 = stat.executeUpdate(sql);
                            if (r1 + r2 == 2){
                                JOptionPane.showMessageDialog(null,"Course Has been added successfully","Success",JOptionPane.INFORMATION_MESSAGE);
                            }
                        }
                    }
                }catch (SQLException ex){
                    ex.printStackTrace();
                }

            }
        });
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(d.width/2-this.getSize().width/2,d.height/2 - this.getSize().height/2);
        setVisible(true);
        Courses.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    ArrayList <String> ids = new ArrayList<>();
                    String courseCode = Courses.getSelectedItem().toString();
                    String sql = "Select * FROM instructor";
                    ResultSet ri = stat.executeQuery(sql);
                    while (ri.next()){
                        for (int i = 0; i < 5; i++) {
                            if (ri.getString("course"+(i+1)) != null) {
                                String c = ri.getString("course" + (i + 1));
                                if (c.equals(courseCode))
                                    ids.add( ri.getString("instructor_ID"));
                            }
                        }
                    }
                    String[] Cour = new String[ids.size()];
                    for (int i = 0; i < ids.size(); i++) {
                        Cour[i] = ids.get(i);
                    }
                    DefaultComboBoxModel mod = new DefaultComboBoxModel(Cour);
                    comboBox1.setModel(mod);
                }catch (SQLException ex){
                    ex.printStackTrace();
                }

            }
        });
    }
}
