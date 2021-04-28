// A Java program for a Serverside
import java.net.*;
import java.sql.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.sql.*;
public class Server extends JFrame implements ActionListener
{
private Socket socket = null;
private ServerSocket server = null;
private DataInputStream in = null;
private DataOutputStream output=null;
private Scanner sc = new Scanner(System.in);
private JFrame j= new JFrame();
private JPanel p=new JPanel();
private JButton b=new JButton("Start The Server.");
private TextArea t=new TextArea("");
private Connect c = new Connect();

public Server()

{
//initialize socket and input && output stream && Server Frame
this.setTitle("Server");
this.setSize(480,250);
this.setLocationRelativeTo(null);
this.setLayout(new BorderLayout());
p.setBackground(Color.GRAY);
this.setContentPane(p);
b.addActionListener(this);
this.getContentPane().add(t, BorderLayout.CENTER);
add(b,BorderLayout.SOUTH);
this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
this.setVisible(true);
t.setText("Waiting To Start the Server.");
}
// starts server and waits for a connection
public void actionPerformed(ActionEvent arg0)
{   
    
    
    
    try
    {
    server = new ServerSocket(5000);
    t.setText("Server started");
    t.setText(t.getText()+"\n"+"Waiting for a client ...");
    socket = server.accept();
    t.setText("Client accepted");
    in = new DataInputStream(socket.getInputStream());
    output = new DataOutputStream(socket.getOutputStream());
    

// reads message from client
    while(true)
        {
        c.link();
        c.query();
        String line = in.readUTF();
        
        if (line.equals(""))
            {
            try
            { 
            output.writeUTF(c.afficheQ());
            }
            catch(IOException i)
            {
            i.printStackTrace();
            }

            }
        else    
            {
            try 
                {
                output.writeUTF(c.afficheQ(line));
                }
            catch(IOException i)
                {
                i.printStackTrace();
                }
            }
        }
    }
    catch(Exception e)
        {
            e.printStackTrace();
        }  
      

    finally
    {
    try
    {
    in.close();
    socket.close();
    server.close();
    }
    catch(Exception w)
    {
        w.printStackTrace();
    }
    }


}
}


