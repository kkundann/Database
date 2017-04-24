/**
 * Created by kundan on 10/18/16.
 */
import org.hibernate.*;
import org.hibernate.boot.*;
import java.util.List;
import java.util.Set;
import java.util.Iterator;
import javax.swing.*;

public class HibernateTester 
{

	public static void main(String[] args) 
	{
		HibernateSession hibernateSession = new HibernateSession();
		SessionFactory sessionFactory;
		Session session;
		String option = "";
		String instruction = "Enter 1: Enter Student_name" + "\n" +
		                     "Enter 2: View All male_student" + "\n" +
		                     "Enter 3: View  Seth_Games" + "\n" +
				             "Enter 4: View major_name_Student" + "\n" +
				             "Enter 5: Quit Program";
		try
		{
			while(true)
			{
				option = JOptionPane.showInputDialog(instruction);
				
				hibernateSession.setUp();
				sessionFactory = hibernateSession.getSessionFactory();
				session = sessionFactory.openSession();
				session.beginTransaction();
				
				if(option.equals("1"))
				{
					String Studentname = JOptionPane.showInputDialog("Enter student Name:");
					String allStudentString = "SID" + "....." + "SNAME" +"......"+"SAGE"+"....."+"SGENDER"+"....."+"SMAJOR"+"..."+
							"TOTAL_NO_SPORTS"+"\n";
					List allStudent = session.createQuery("from Student").list();
					for(int i=0;i<allStudent.size();i++) {

						Student theStudent = (Student) allStudent.get(i);
						if (theStudent.getSname().equals(Studentname)) {
							allStudentString += theStudent.getSid() + "....." + theStudent.getSname() + "....." +
									theStudent.getSage() +
									"....." + theStudent.getSgender() + "....." + theStudent.getSmajor() + "....." +
									theStudent.getPlaysportSet().size() + "\n";
						}
					}
					JOptionPane.showMessageDialog(null, allStudentString);
				}
				else if(option.equals("2"))
				{

					String allStudentString = "SNAME" +"......"+"SAGE"+"....."+"SPORTNAME"+"....."+"SKILL_LEVEL"+"..."+
							"HOUR_SPEND_ON_SPORTS"+"\n";
					List allStudent = session.createQuery("from Student").list();
					for(int i=0;i<allStudent.size();i++) {

						Student theStudent = (Student) allStudent.get(i);
						if (theStudent.getSgender().equals("M")) {
							for(Playsport s:theStudent.getPlaysportSet()) {
								allStudentString += theStudent.getSname() +"....."+
										"....." + theStudent.getSage()
										+
										"....."   + s.getPrimaryKey().getSport().getSpname() +"...." +
										s.getLevel() + "......" + s.getTotalhour()  + "\n";
							}	}
					}
					JOptionPane.showMessageDialog(null, allStudentString);
				}

				else if(option.equals("3"))
				{

					String allStudentString = "Seth_Played_with" +"......"+"Total_Hour_Played"+"\n";
					List allStudent = session.createQuery("from Student").list();
					for(int i=0;i<allStudent.size();i++) {

						Student theStudent = (Student) allStudent.get(i);
						if (theStudent.getSname().equals("Seth")) {
							for(Playgame g:theStudent.getPlaygameSet()) {
								allStudentString += g.getPrimaryKey().getGame().getGname() + "......."
										+ g.getTotalhour() + "......" + "\n";
							}	}
					}
					JOptionPane.showMessageDialog(null, allStudentString);
				}
				else if(option.equals("4"))
				{

					String allStudentString = "SNAME" +"......"+"SMAJOR"+"\n";
					List allStudent = session.createQuery("from Student").list();
					for(int i=0;i<allStudent.size();i++) {

						Student theStudent = (Student) allStudent.get(i);
							for(Playgame g : theStudent.getPlaygameSet())
							{
								if(g.getGame().getGname().equals("WOW") && Integer.parseInt(g.getTotalhour()) < 300) {
									allStudentString += theStudent.getSname() + "....."
											+ theStudent.getSmajor()
											+ "\n";
								}
							}
					}
					JOptionPane.showMessageDialog(null, allStudentString);
				}
				else
				{
					break;
				}



			}
			session.getTransaction().commit();
			session.close();
			JOptionPane.showMessageDialog(null, "Bye Bye");
		}
		catch(Exception e)
		{
			System.out.println("There is an error:");
			System.out.println(e.toString());
		}
	}

}
