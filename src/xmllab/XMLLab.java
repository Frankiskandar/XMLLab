/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package xmllab;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.net.URLConnection;
import java.util.Scanner;

/**
 *
 * @author tug37915
 */
public class XMLLab {

    /**
     * @param args the command line arguments
     */
    
    public static String id;
    
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.print( "Enter the id number: " );
        Scanner scanner = new Scanner(System.in);
        id = scanner.nextLine();
        try {
            new XMLLab().sendGet();
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    private Document XMLparser(InputStream stream) throws Exception {
        DocumentBuilderFactory objDocumentBuilderFactory = null;
        DocumentBuilder objDocumentBuilder = null;
        Document doc = null;
        try
        {
            objDocumentBuilderFactory = DocumentBuilderFactory.newInstance();
            objDocumentBuilder = objDocumentBuilderFactory.newDocumentBuilder();

            doc = objDocumentBuilder.parse(stream);
        }
        catch(Exception ex)
        {
            throw ex;
        }       
        return doc;
    }// end parsexml
    
    private void sendGet() throws Exception {
        URL url = new URL("http://129.32.92.49/xml/grade.php?id="+id);
        URLConnection con = url.openConnection();
        Document doc = XMLparser(con.getInputStream());
        NodeList name = doc.getElementsByTagName("name");
        NodeList grade = doc.getElementsByTagName("grade");
        //print name and grade
        System.out.println(name.item(0).getTextContent());
        System.out.println(grade.item(0).getTextContent());
        
    }//end start
    
}
