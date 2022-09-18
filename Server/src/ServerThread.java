import java.io.DataInputStream;
import java.io.IOException;
import java.net.Socket;

public class ServerThread extends Thread {
	private Socket s;
	private Server srv;
	private DataInputStream din;
	
	
	public ServerThread(Socket s, Server srv) {
		this.s = s;
		this.srv = srv;
	}
	
	  public void run() {
		try {
			din = new DataInputStream(s.getInputStream());
			while(true) {
				String msg = din.readUTF();
				System.out.println("Get message of " + msg + "from client " + s);
				srv.sendToAll(msg);
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			srv.deleteConnection(s);
		}
	}
}
