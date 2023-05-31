package pumlFromJava;

import jdk.javadoc.doclet.DocletEnvironment;

import javax.lang.model.element.Element;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class PumlDiagram {

    private static FileWriter file = null;

    //Crée le fichier pour le diagramme
    private static void createFile(String name_file , String dir_file){
        if(file == null){
            try{
            File file_loc = new File(dir_file+"/"+name_file);
            if (file_loc.createNewFile()) {
                System.out.println("File created: " + file_loc.getName());
            } else {
                System.out.println("File already exists.");
                System.out.println("The .puml file will be overwritten.");
            }
            file = new FileWriter(file_loc);
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
    }

    //Ajoute les premières lignes
    public static void genereStart(String name_file , String dir_file) throws IOException {
        createFile(name_file,dir_file);
        if(file != null) {
            file.write("@startuml\n'https://plantuml.com/class-diagram\nskinparam classAttributeIconSize 0\n" +
                    "skinparam classFontStyle Bold\n" +
                    "skinparam style strictuml\n" +
                    "hide empty members\n\n");
        }
        /*
        @startuml
        'https://plantuml.com/class-diagram
         */
    }

    //Ajoute les résultats du JavaDoc
    public static void generePrincipal(String element_string) throws IOException {
        if(file != null) {
            file.append(element_string);
        }
    }

    //Conclue le document
    public  static void genereEnd() throws IOException {
        if(file != null) {
            file.append("\n@enduml\n");
            file.close();
        }
        /*
        @enduml
         */
    }
}
