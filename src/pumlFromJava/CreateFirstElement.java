package pumlFromJava;

import javax.lang.model.element.*;

public class CreateFirstElement extends ElementDefault {

    private String buildUml = "";
    public CreateFirstElement(Element element) {
        super(element);
    }

    // run() définit le type de l'élément et crée une instance appropriée.
    public void run(){
        for (Element element1 : super.getElementEnclosed()){
            switch (element1.getKind()) {
                case CLASS:
                    //Crée une instance de classe
                    //builduml = l'entiereté de l'élément
                    CreateClassElement newClassElement = new CreateClassElement(element1);
                    this.buildUml += newClassElement.getStringElementAll();
                    break;
                case INTERFACE:
                    //Crée une instance d'interface
                    //builduml = juste les lignes de début et de fin de l'élément
                    CreateInterElement newInterElement = new CreateInterElement(element1);
                    this.buildUml += newInterElement.getStringElementStartEnd();
                    break;
                case ENUM:
                    //Crée une instance d'enum
                    //builduml = l'entiereté de l'élément
                    CreateEnumElement newEnumElement = new CreateEnumElement(element1);
                    this.buildUml += newEnumElement.getStringElementAll();
                    break;
                case PACKAGE:
                    //Crée un nouvel élément puis le fait passer par la fonction chaque élément du package
                    CreateFirstElement newFirstElement = new CreateFirstElement(element1);
                    newFirstElement.run();
                    break;
                default:
                    System.out.println("NAME : " + element1.getSimpleName());
                    break;
            }
        }
    }
    public String getBuildUml(){
        if(this.buildUml == ""){
            this.run();
        }
        return this.buildUml;
    }
}
