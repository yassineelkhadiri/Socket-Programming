import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.awt.event.*;
import java.sql.*;
import java.net.*;


public class NewFrame extends JFrame implements ActionListener
{

    private JFrame f =new JFrame();
    private JPanel p=new JPanel();
    private JButton b=new JButton("Connect To Server");
    private JButton b1=new JButton("Show All");
    private JButton b2=new JButton("Search For Id");
    private Client c;
    private JTextField jt;
    private TextArea t=new TextArea("");
    public NewFrame(){    
    
    p.setLayout( new FlowLayout());
    this.setTitle("Client");
    this.setSize(500,250);
    this.setLocationRelativeTo(null);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setLayout(new BorderLayout());
    p.setBackground(Color.GRAY);
    
    this.setContentPane(p);
    b.addActionListener(this);
    b1.addActionListener(this);
    b2.addActionListener(this);
    this.getContentPane().add(b, BorderLayout.CENTER);        
    add(t,BorderLayout.SOUTH);

    
    this.setVisible(true);
    }
    public void actionPerformed(ActionEvent evt)
    {   
        try 
        {
        
        t.setText("Insert ID.");
        JFrame nf= new JFrame();
        JPanel np = new JPanel();
        if (evt.getSource().equals(b))
        {
        c=new Client();
        while(!(c.socket.isConnected()))
        {
            t.setText("Server Is Not Connected"); 
        }
        jt= new JTextField(8);
        jt.setSize(120,80);
        nf.setSize(400,100);
        nf.getContentPane().add(b1, BorderLayout.WEST);
        nf.getContentPane().add(b1, BorderLayout.EAST); 
        np.setLayout(new FlowLayout());
        np.add(jt);
        np.add(b1);
        np.add(b2);
        nf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        nf.add(np);
        nf.setTitle("Affichage");
        nf.setVisible(true); 
        t.setText("Client Connected.");
        }
        else if(evt.getSource().equals(b1))
        {   
    
            c.give("");
            t.setText(t.getText()+"\n"+"Executing");
            String g=c.get();
            t.setText(g);
            nf.setVisible(false);
            nf.dispose();
            
        }
        else 
        {   
            if(jt.getText().equals("")==false)
            {
            try
            { 
            c.give(jt.getText());
            t.setText(t.getText()+"\n"+"Executing");
            String g=c.get();
            t.setText(g);
            nf.setVisible(false);
            nf.dispose();
            }
            catch(Exception e)
            {
                e.printStackTrace();
            }
            
        }
        }
        }
            
        catch(Exception e)
        {
            t.setText("Server Is Not Connected.");
        }
        
        
    }
}