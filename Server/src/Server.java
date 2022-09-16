import java.io.DataOutputStream;
import java.io.IOException;
import java.net.*;
import java.util.Enumeration;
import java.util.Hashtable;
public class Server {

	Hashtable<Socket, DataOutputStream> clients = new Hashtable<>();
	
	public Server(int port) {
		listen(port);
	}
	
	public void listen(int port) {
		try {
			ServerSocket ss = new ServerSocket(port);
			System.out.println("Listening on : " + ss);
			while(true) {
				Socket s =  ss.accept();
				System.out.println("Connection of : " + s);
				DataOutputStream dout = new DataOutputStream(s.getOutputStream());
				clients.put(s, dout);
				new ServerThread(s, this).start();
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void sendToAll(String msg) {
		try {
			synchronized(clients) {
				for(Enumeration e = clients.elements() ; e.hasMoreElements();) {
					DataOutputStream dout = (DataOutputStream) e.nextElement();
					dout.writeUTF(msg);
					System.out.println("msg : " + msg);
				}
			}
			
		} catch(Exception e) {
			System.out.println("Error sending in sendToAll\n" + e);
		}
	}
	
	public void deleteConnection(Socket s) {
		try {
			synchronized(clients) {
				System.out.println("Disconnected to : "+ s);
				clients.remove(s);
			}
		} catch(Exception e) {
			System.out.println("Error in deleteConnection\n" + e);
		}
	}
	   public static void main(String[] args) {
		   new Server(9999);
		   
}
}
