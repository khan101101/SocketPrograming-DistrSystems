/** Represents the CientSide in Sever-Socket Programming
 * @author Nasim AHMAD, Martriculation Nr: 1185555
 * @version 7
 * @since 1.0
*/
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;
public class FileDemoClient {
	public static void main(String[] args) {
		/** Creates instances of all variables needed for socket communication
		*/
	
		Scanner scanner = new Scanner(System.in);
		Socket s;
		OutputStream os;
		PrintWriter pw;
		String userInput;
		String serverResponse;
		ObjectInputStream ois;
		

		try {
			 /** Instantiating the streams, serversocket and socket based on port 1117
	       	  * 
	       	
	       	 */
			s = new Socket("127.0.0.1", 1117);
			os = s.getOutputStream();
			pw = new PrintWriter(os);
		
			
			
			while (true) {
				
				pw.println(userInput = scanner.nextLine());
				pw.flush();
				
				if(userInput.startsWith("directoryListing;")) {
					/** listing the files of a directory sent from the serverside
					 
					*/
					ois = new ObjectInputStream(s.getInputStream());
					File[] fileList = (File[]) ois.readObject();
					for(int i = 0; i < fileList.length; i++) {
						System.out.println(fileList[i].getName());
						
						os.close();
					}
				}
				
				
				
			
			}
		}			
					catch (UnknownHostException e) {
						
						e.printStackTrace();
					} catch (IOException e) {
					
						e.printStackTrace();
					} catch (ClassNotFoundException e) {
					
						e.printStackTrace();
					}
		}
	}  
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
