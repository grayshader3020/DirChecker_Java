
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.*;
//import java.net.MalformedURLException;
import java.sql.SQLOutput;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class dirbScanner {
    // ANSI color codes for console output
    public static final String RESET = "\u001B[0m";
    public static final String GREEN = "\u001B[32m";
    public static final String RED = "\u001B[31m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String CYAN = "\u001B[36m";
    public static void main(String[] args) throws FileNotFoundException {
        // variable decalaration
        String baseUrl = null;    //  user input url: http://testphp.vulnweb.com
        HttpURLConnection con =null;   // building a connection with con
        String wordlist="commondirs.txt";  // defining a wordlist

        // Reading file content with buffer object br
        try( BufferedReader br = new BufferedReader(new FileReader(wordlist))){
            System.out.println("[+] Wordlist read. Starting the dirb process...[*]\n");
            String line;


            try{
                // taking user input with dialog box
                baseUrl = JOptionPane.showInputDialog("Enter the host you want to scan( with protocol - ex.https://www.google.com)  : ");
            }catch (Exception ex){
                // exception for baseUrl not set
                System.out.println("Could not set the URL variable");
            }

            // LOOP FOR ITERATING EACH LINE IN THE WORDLIST FILE UNTIL ITS NULL
            while ((line = br.readLine())!= null){
                // System.out.println(line);  //PRINTING LINE  FOR e.g robots.txt
                // 1. The trim() method in Java removes leading and trailing whitespace from a string.
                // 2. This includes spaces, tabs (\t), and newline characters (\n, \r).
                line = line.trim();
                String fullUrl = baseUrl+"/"+line;
                //          baseUrl        + /+ line
                //   https://www.google.com / robots.txt
                System.out.println("Scanning: "+fullUrl);

                try{
                    // building URLs dynamically (baseUrl + "/" + line).
                    // If the combined URL has formatting issues, URI will catch it early.
                    // After confirming it's valid, toURL() converts it for use in HttpURLConnection:
                    try {
                        URI uri = new URI(fullUrl);
                        URL urlObj = uri.toURL();
                        con = (HttpURLConnection) urlObj.openConnection();
                        con.setRequestMethod("GET");
                    }catch (URISyntaxException ex){
                        System.out.println("Invalid URL syntax for : "+fullUrl+" - "+ex.getMessage());
                    }catch (IOException ex){
                        System.out.println("Connection error for : "+ fullUrl+" - "+ ex.getMessage());
                    }

                    int responseCode = con.getResponseCode();
                    if (responseCode == 200) {
                        System.out.println(GREEN + "[200 OK] Found: " + line + RESET);
                    } else if (responseCode == 404) {
                        System.out.println(RED + "[404 Not Found] Dir Not available: " + line + RESET);
                    } else if (responseCode == 401) {
                        System.out.println(YELLOW + "[401 Unauthorized] Access denied: " + line + RESET);
                    } else if (responseCode == 500) {
                        System.out.println(BLUE + "[500 Internal Server Error] Error at: " + line + RESET);
                    } else {
                        System.out.println(CYAN + "[Response " + responseCode + "] for: " + line + RESET);
                    }

                }catch (IOException ex){
                    Logger.getLogger(dirbScanner.class.getName()).log(Level.SEVERE,null,ex);
                }
            }
        }catch (IOException ex){
            Logger.getLogger(dirbScanner.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
}
