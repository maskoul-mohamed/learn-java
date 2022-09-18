import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import javax.swing.JFrame;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class Client extends JFrame implements Runnable {
	DataInputStream din;
	DataOutputStream dout;
	Socket s;
	String name;
	JTextField tf;
	JTextArea ta;

	public Client(String name, String host, int port) {
		super(name);

		tf = new JTextField();
		ta = new JTextArea();
		this.add(tf, BorderLayout.NORTH);
		this.add(ta,BorderLayout.CENTER);
		tf.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					dout.writeUTF(name + " said: " + tf.getText());
					tf.setText("");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
			
		});
	
	
			try {
				s = new Socket(host, port);
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				din = new DataInputStream(s.getInputStream());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			try {
				dout = new DataOutputStream(s.getOutputStream());
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

		
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setSize(200, 300);
		setVisible(true);
		new Thread(this).start();
	
	}
	
	@Override
	public void run() {
		
		while(true) {
			try {
				String msg = din.readUTF();
				ta.append(msg+"\n");
				
			} catch(Exception e) {
				System.out.println("Error in client : " + e);

			}
		}
	}

}
