import java.net.*;
import java.io.*;
 
public class TCPClient {
        public static void main(String args[]) throws Exception{
        String sentence;
        String modifiedSentence;
        while(true){
                Socket clientSocket = new Socket("172.16.4.144",3333);
                BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));
                sentence = inFromUser.readLine();
                OutputStream outToServer = clientSocket.getOutputStream();
                BufferedReader inFromServer = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
                outToServer.write((sentence+"\n").getBytes());
                modifiedSentence = inFromServer.readLine();
                System.out.println("FROM SERVER : "+modifiedSentence);
        }
        }
}