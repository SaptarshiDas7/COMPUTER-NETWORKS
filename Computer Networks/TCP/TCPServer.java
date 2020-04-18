import java.net.*;
import java.io.*;

class TCPServer {
	public static void main(String args[]) throws Exception{
		String sentence,input;
		String modifiedSentence;
		ServerSocket welcomeSocket = new ServerSocket(3333);
		while(true){
			Socket connectionSocket = welcomeSocket.accept();
			BufferedReader inFromClient = new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			OutputStream outToClient = connectionSocket.getOutputStream();
			sentence = inFromClient.readLine();
			System.out.println("Sentence from the Client : " + sentence);
			BufferedReader ToClient = new BufferedReader(new InputStreamReader(System.in));
			input = ToClient.readLine();
			modifiedSentence = input;
			outToClient.write((modifiedSentence+ "\n").getBytes());
			connectionSocket.close();
		}
	}
}