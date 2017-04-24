/**
 * Created by kundan on 10/19/16.
 */
import java.sql.*;
        import javax.swing.*;

public class Part3Assignment
{

    public static void main(String[] args)
    {
        String dbServer = "jdbc:mysql://localhost:3306/Assignment2B";
        String userName = "root";
        String password = "root";

        Connection conn;
        Statement stmt;
        ResultSet rs;
        ResultSetMetaData rsMetaData;

        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(dbServer,userName,password);
            stmt = conn.createStatement();
            String sqlQuery = "";
            String toShow = "";

            String option = "";
            String instruction = "Enter 1: Find all Student details." + "\n" +
                    "Enter 2: Find All male_student." + "\n" +
                    "Enter 3: Find Games played by  Seth." + "\n" +
                    "Enter 4: Find Student major and name" + "\n" +
                    "Enter 5: Quit Program";

            while(true)
            {
                option = JOptionPane.showInputDialog(instruction);
                if(option.equals("1"))
                {
                    String sname = JOptionPane.showInputDialog("Enter student Name:");
                    sqlQuery = "select s.sid,s.sname,s.sage,s.sgender,s.smajor,count(s.sid) from student s join play_sport ps where s.sid=ps.sid and s.sname= '"+sname+"' group by s.sid";
                    rs = stmt.executeQuery(sqlQuery);
                    rsMetaData = rs.getMetaData();
                    System.out.println(sqlQuery);
                    toShow = "";
                    while(rs.next())
                    {
                        for(int i=0;i<rsMetaData.getColumnCount();i++)
                        {
                            toShow += rs.getString(i+1) + ", ";
                        }
                        toShow += "\n";
                    }
                    JOptionPane.showMessageDialog(null, toShow);
                }
                else if(option.equalsIgnoreCase("2"))
                {
                    sqlQuery = "SELECT student.SNAME,student.SAGE,sport.SPNAME,play_sport.LEVEL,play_sport.TOTALHOUR \n" +
                            "FROM student,play_sport,sport\n" +
                            "WHERE student.SID=play_sport.SID  and play_sport.SPID=sport.SPID and student.SGENDER='M';";
                    rs = stmt.executeQuery(sqlQuery);
                    rsMetaData = rs.getMetaData();
                    System.out.println(sqlQuery);
                    toShow = "";
                    while(rs.next())
                    {
                        for(int i=0;i<rsMetaData.getColumnCount();i++)
                        {
                            toShow += rs.getString(i+1) + ", ";
                        }
                        toShow += "\n";
                    }
                    JOptionPane.showMessageDialog(null, toShow);
                }
                else if(option.equals("3"))
                {
                    sqlQuery = "SELECT GNAME,TOTALHOUR from student ,game, play_game " +
                            "WHERE student.SNAME=\"seth\" and play_game.GID=game.GID\n" +
                            " and student.SID=play_game.SID;";
                    rs = stmt.executeQuery(sqlQuery);
                    rsMetaData = rs.getMetaData();
                    System.out.println(sqlQuery);
                    toShow = "";
                    while(rs.next())
                    {
                        for(int i=0;i<rsMetaData.getColumnCount();i++)
                        {
                            toShow += rs.getString(i+1) + ", ";
                        }
                        toShow += "\n";
                    }
                    JOptionPane.showMessageDialog(null, toShow);
                }
                else if(option.equals("4"))
                {
                    sqlQuery = "SELECT student.SNAME,student.SMAJOR from student,game,play_game WHERE\n" +
                            " student.SID=play_game.SID and gname=\"wow\" and play_game.TOTALHOUR <300 and play_game.GID=game.GID;";
                    rs = stmt.executeQuery(sqlQuery);
                    rsMetaData = rs.getMetaData();
                    System.out.println(sqlQuery);
                    toShow = "";
                    while(rs.next())
                    {
                        for(int i=0;i<rsMetaData.getColumnCount();i++)
                        {
                            toShow += rs.getString(i+1) + ", ";
                        }
                        toShow += "\n";
                    }
                    JOptionPane.showMessageDialog(null, toShow);
                }
                else
                {
                    break;
                }
            }

            stmt.close();
            conn.close();
        }
        catch(Exception e)
        {
            System.out.println("There is an error:");
            e.printStackTrace();
        }
    }

}