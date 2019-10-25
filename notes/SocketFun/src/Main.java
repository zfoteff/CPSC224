import java.io.*;
import java.net.Socket;

public class Main
{
    //  Professor Sprint IP address:
    public static void main(String[] args)
    {
        String myName = "Zac F.";
        String ipAddress = "192.168.1.100";
        int portNum = 8080;

        try {
            Socket clientSocket = new Socket(ipAddress, portNum);
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true); // creates output object
            // that sends user input to socket
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream())); // creates
            // object that recieves input from server
            BufferedReader stdIn = new BufferedReader(new InputStreamReader(System.in)); // like scanner


            boolean go = true;
            while(go)
            {
                out.println(myName);

                //  read from stdIn and send whatever the user types to the server
                if (stdIn.ready())  //  if the input stream has info to be sent
                {
                    String userInput = stdIn.readLine();
                    out.println(userInput);
                }


                if(in.ready())
                {
                    String serverMessage = in.readLine();
                    System.out.println(serverMessage);
                    if (serverMessage.equals("closing"))
                        go = false;
                }
            }


        } catch (IOException e) {
            e.printStackTrace();
        }
        //  if this passes, that means the connection has been accepted


    }
}
