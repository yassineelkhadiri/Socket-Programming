import java.net.*;
import java.io.*;
public class Client

{
    // initialize socket and input output streams
    public Socket socket = null;
    public DataInputStream in = null;
    public DataOutputStream output = null;
    

// establish a connection
public Client()
{
try
{
socket = new Socket("localhost", 5000);
in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
output = new DataOutputStream(socket.getOutputStream());
}

catch(IOException i)
{
i.printStackTrace();
}
}
//communication with the server 
public String get() throws IOException

{   
    return(in.readUTF());
}
public void give(String s) throws IOException 
{
    output.writeUTF(s);
}


//close the connection
public void close()
{
try{
in.close();
output.close();
socket.close();
}
catch(IOException n)
{
    n.printStackTrace();
}
}


}


