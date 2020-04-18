import java.net.*;
import java.io.*;

public class UDPServer {
    public static void main(String args[]) throws Exception{
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        DatagramSocket serverSocket = new DatagramSocket(3333);
         while(true){
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData()); 
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();
            String modifiedSentence = sentence.toUpperCase(); 
            sendData = modifiedSentence.getBytes();
            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length, IPAddress,port); serverSocket.send(sendPacket);
        }
    }
}