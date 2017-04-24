/**
 * Created by kundan on 10/19/16.
 */

import java.sql.DriverManager;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Statement;
        import java.util.Properties;


public class Part1Assignment {
    public static void main(String[] args) {
        // Make sure Neo4j Driver is registered
        try {
            Class.forName("org.neo4j.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }


        @SuppressWarnings("unused")
        Properties properties = new Properties();
        java.sql.Connection con = null;

        try {

            //con = DriverManager.getConnection("jdbc:neo4j:http://localhost:7474/", properties);
            con = DriverManager.getConnection("jdbc:neo4j:http://localhost:7474/");

        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        // Querying

        try(Statement stmt = con.createStatement())
        {
            ResultSet rs = stmt.executeQuery("MATCH (s:Parts ) where s.color='green' with count(s.pid) as x MATCH (s:Suppliers)-[:supplies]->(p:Parts) where p.color='green' WITH s,count(p) as y,x where x=y  RETURN s.sname");
            while(rs.next()) {
                System.out.println("\n"+"------First Query Result -----");
                System.out.println(rs.getString("s.sname"));
                System.out.println("\n"+"------Second Query Result -----");


            ResultSet rss=stmt.executeQuery("MATCH (s:Suppliers)-[:supplies]->(p:Parts {color:\"green\"}) RETURN s.sname,s.sid UNION MATCH (s:Suppliers)-[:supplies]->(p:Parts {color:\"red\"}) RETURN DISTINCT s.sname,s.sid");
                while(rss.next()){
                    System.out.println(rss.getString("s.sname"));
                    System.out.println(rss.getString("s.sid"));
                }
            System.out.println("------Third Query Result-------------");

            ResultSet rsss=stmt.executeQuery("MATCH (s:Suppliers)-[:supplies]->(p:Parts {color:\"green\"}) WITH s  MATCH (s:Suppliers)-[:supplies]->(p:Parts {color:\"red\"}) RETURN DISTINCT s.sname,s.sid");
                while(rsss.next()){
                    System.out.println(rsss.getString("s.sname"));
                    System.out.println(rsss.getString("s.sid"));
                }
            System.out.println("------Fourth Query Result-------------");

            ResultSet rssss=stmt.executeQuery("MATCH (s:Suppliers)-[x:supplies]->(p:Parts )  RETURN p,max(x.cost)");
                while(rssss.next()){
                    System.out.println(rssss.getString("max(x.cost)"));
                }
            }
            con.close();
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



    }

}
