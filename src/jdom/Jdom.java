/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jdom;


import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.jdom2.Element;
import org.jdom2.Document;
import org.jdom2.output.XMLOutputter;
import java.util.Scanner;
/**
 *
 * @author camilo.posadaa
 */
public class Jdom {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Element root;
        Element atributo;
        ArrayList<Element> atributos = new ArrayList<>();
        int numAtributos;
        String nombreAtributo;
        String text;
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el nombre del elemento raiz: ");
        String raiz = sc.next();
        root = new Element(raiz);
        System.out.println("Numero de atributos a crear en su archivo XML: ");
        numAtributos = sc.nextInt();
        
        for(int i = 0; i<numAtributos; i++){
            System.out.println("Nombre del atributo #" + i + ":");
            nombreAtributo = sc.next();
            atributo = new Element(nombreAtributo);
            atributos.add(atributo);
        }
        
        for (Element atributo1 : atributos) {
            atributo = (Element) atributo1;
            System.out.println("Ingrese el contenido de " + atributo.getName() + ":");
            text = sc.next();
            atributo.setText(text);
            root.addContent(atributo);
        }
        
        Document doc = new Document(root);
        System.out.println(root.getContent());
        /**
         * Serializar
         */
        
        try (FileOutputStream out = new FileOutputStream("test.xml")) {
            XMLOutputter serializer = new XMLOutputter();
            serializer.output(doc, out);
            out.flush();
            System.out.println("El documento se guardo con exito");
        }
        catch(IOException e){
            System.err.println(e);
        }
        
   
    }
    
}
