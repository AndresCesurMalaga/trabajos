package TwoWayComs;

import java.io.*;
import java.net.*;

public class Client {
	// initialize socket and input output streams
	private Socket socket = null;
	private DataOutputStream out = null;
	private DataInputStream in = null; //input from server
	BufferedReader input = null;// updated InputStream(System.in)

	// string to read message from input
	private String line = "";

	// constructor to put ip address and port
	public Client(String address, int port) {
		// establish a connection
		try {
			socket = new Socket(address, port);
			System.out.println("Connected");

			// takes input from terminal
			input = new BufferedReader(new InputStreamReader(System.in));

			// sends output to the socket
			out = new DataOutputStream(socket.getOutputStream());
			
			// takes input from the server socket
			in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));
			
		} catch (IOException i) {
			System.out.println(i);
		}
	}

	public void sending() { // MUST BE UPDATED
		// keep reading until "Over" is input
		while (!line.equals("Over")) {
			try {
				line = input.readLine();
				out.writeUTF(line);
			} catch (IOException i) {
				System.out.println(i);
			}
		}
	}

	public void listening() {
		// reads message from client until "Over" is sent
		while (!line.equals("Over")) {
			try {
				line = in.readUTF();
				System.out.println(line);

			} catch (IOException i) {
				System.out.println(i);
			}
		}
	}
	
	public void close() {
		// close the connection
		try {
			input.close();
			out.close();
			socket.close();
		} catch (IOException i) {
			System.out.println(i);
		}
	}
}
