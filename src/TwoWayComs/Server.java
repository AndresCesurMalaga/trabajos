package TwoWayComs;

import java.io.*;
import java.net.*;

public class Server {
	// initialize socket and input stream
	private Socket socket = null;
	private ServerSocket server = null;
	private DataInputStream in = null;
	private DataOutputStream out = null;

	// string to read message from input
	private String line = "";

	// constructor with port
	public Server(int port) {
		// starts server and waits for a connection
		try {
			server = new ServerSocket(port);
			System.out.println("Server started");

			System.out.println("Waiting for a client ...");

			socket = server.accept();
			System.out.println("Client accepted");

			// takes input from the client socket
			in = new DataInputStream(new BufferedInputStream(socket.getInputStream()));

			// sends output to the socket
			out = new DataOutputStream(socket.getOutputStream());

		} catch (IOException i) {
			System.out.println(i);
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
			System.out.println("Closing connection");

			in.close();
			out.close();
			socket.close();
		} catch (IOException i) {
			System.out.println(i);
		}
	}
}
