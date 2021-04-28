import java.sql.*;

public class Connect
{
    static final String URL_BD ="jdbc:mysql://remotemysql.com:3306/gXy6SedWD6?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC&allowPublicKeyRetrieval=true&useSSL=false" ;
    Connection c =null;
    ResultSet r =null;

    public Connect()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver"); 
        }
        catch(ClassNotFoundException p)
        {
            p.printStackTrace();
        }
    }
    
    
    public  void link() throws SQLException
    {
        try 
        {
            c = DriverManager.getConnection(URL_BD,"gXy6SedWD6","itIC3EPG1X");
        }
        catch(SQLException e)
        {
            System.out.println("Could not connect.");
        }

    }
    
    public  void query() throws SQLException
    {
        try
        {
            Statement s = c.createStatement();
            r=s.executeQuery("Select * from Etudiant ");
        }
        catch(SQLException xk)
        {
            System.out.println("Could not execute query.");
        }
    }

    public String afficheQ() throws Exception
    {   
        String s="";
        try 
        {
                while(r.next())
                {
                    Etudiant e=new Etudiant(r.getInt("Cin"),r.getInt("NumInscri"),r.getInt("Age"),r.getString("Nom"),r.getString("Prenom"),r.getString("Email"));
                    s=s+"\n"+e.toString();
                }
                return(s);
        }
        catch(Exception se)
        {
            return("Could not retrieve student.");
        }


    }
    
    public  String afficheQ(String p ) throws Exception
    {   
        try 
        {       
                
                Statement m = c.createStatement();
                ResultSet rSet=m.executeQuery("Select * from Etudiant where Cin = "+p);
                Etudiant e=null;
                
                    while(rSet.next())
                    {
                     e=new Etudiant(rSet.getInt("Cin"),rSet.getInt("NumInscri"),rSet.getInt("Age"),rSet.getString("Nom"),rSet.getString("Prenom"),rSet.getString("Email"));
                    }
                    return(e.toString());
                
        }
        catch(Exception se)
        {
            return("Could not retrieve student.");
        }


    }
    
    
   


}