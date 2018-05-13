
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.ObjectOutputStream;
/** Represents the ServerSide in Sever-Socket Programming
 * @author Nasim AHMAD, Martriculation Nr: 1185555
 * @version 7
 * @since 1.0
*/
public class FileDemo {
	

	
/**
 * ich bn die mainlasdf
 * @param args ueber
 */
	public static void main(String[] args) {

		/** Creates instances of all variables needed for socket communication
		*/
		ServerSocket ss;
		Socket socket;
		InputStream is;
		InputStreamReader isr;
		BufferedReader br;
		String tmp;
		ObjectOutputStream obs = null;
		
		
		
		try {
			 /** Instantiating the streams, serversocket and socket based on port 1117
       	  * 
       	 */
       	
			ss = new ServerSocket(1117);
			socket = ss.accept();
			
			is = socket.getInputStream();
			isr = new InputStreamReader(is);
			br = new BufferedReader(isr);
			
		
			
			
			while((tmp = br.readLine()) != null){
				
				String[] array = tmp.split(";");
				

				if(array[0].startsWith("directoryListing")) {
					/** listing the files of a directory and sending them to the client
					 * @param A string from the client side
					
					*/
					obs = new ObjectOutputStream(socket.getOutputStream());
					File currentDir = new File("C:\\Users\\khan101\\eclipse-workspace\\JavaRoadToProgress\\src\\" + array[1]);
					File[] fileList = currentDir.listFiles();
					obs.writeObject(fileList);
					obs.flush();
					
				
				}
	             else if(array[0].startsWith("deleteDirectory")) {
	            	 /** Delete a directory specified by the client
	            	  * @param String from client
	            
	            	 */
	            	 obs = new ObjectOutputStream(socket.getOutputStream());
	            	 File f= new File("C:\\Users\\khan101\\eclipse-workspace\\JavaRoadToProgress\\src\\" + array[1]);
	            
	            	 if (f.isDirectory()) 
	            		 f.delete();
	            	 System.out.println("Directory deleted");
	            		obs.flush();
	            		obs.close();
				}
				
	             else if(array[0].startsWith("addDirectory")) {
	            	 /** Adds a new directory in the working directory of eclipse
	            	  * @param String from the client
	            
	            	 */
	            	 Path path = FileSystems.getDefault().getPath("C:\\Users\\khan101\\eclipse-workspace\\JavaRoadToProgress\\src\\" + array[1]);
	            	 Files.createDirectory(path);
	            	 System.out.println("File created");
	            
	            	
				}
				
	             else if(array[0].startsWith("addFile")) {
	            	 /** Adds a file in the working directory of eclipse
	            	  * @param File name as a string from client
	            	  * 
	            	 */
	            	 File f= new File("C:\\Users\\khan101\\eclipse-workspace\\JavaRoadToProgress\\src\\" + array[1]);
	            	
	            	 f.createNewFile();
	            
	            	  BufferedWriter writer = new BufferedWriter(new FileWriter(f));
	            	    writer.write(array[2]);
	            	    System.out.println("File created");
	            	    writer.close();
	            	
				}
				
	             else if(array[0].startsWith("getFile")) {
	            	 /** Get the content of file present on the serverside and sends it to the client
	            	  * @param File name as a string from client
	            	
	            	 */
	            	
	            	
	            	 
	            	 File f= new File("C:\\Users\\khan101\\eclipse-workspace\\JavaRoadToProgress\\src\\" + array[1]);
	            	 BufferedReader br2 = new BufferedReader(new FileReader(f));
	            	 
	            	  String st;
	            	  OutputStream os = socket.getOutputStream();
	            	  PrintWriter pw = new PrintWriter(os);
	                  StringWriter output;
	                  PrintWriter outgoingMessage;
	                  output = new StringWriter();
	                  outgoingMessage = new PrintWriter(output);
	                  
	            	  while ((st = br2.readLine()) != null) {
	            	      System.out.println(st);
	            		
	            		  outgoingMessage.print(st);
	            	    
	            	  }
	           
	                }
				
	             else if(array[0].startsWith("deleteFile")) {
	            	 /** Delete a file present on the serverside 
	            	  * @param File name as a string from client
	            	
	            	 */
	            	
	            	 
	            	 File f= new File("C:\\Users\\khan101\\eclipse-workspace\\JavaRoadToProgress\\src\\" + array[1]);
	            	
	            	 f.delete();
	            	 System.out.println("File is deleted!");
	    	
	            	
				}
	             else if(array[0].startsWith("closeProgram")) {
	            	System.out.println("Socket closing...");
	            	 socket.close();
	            
	            	
	            	
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
	            	
				}
	      			
			}		
		 
		
		catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();}

	
	}
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	