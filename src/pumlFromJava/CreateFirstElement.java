package pumlFromJava;

import javax.lang.model.element.*;

public class CreateFirstElement extends ElementDefault {

    private String buildUml = "";
    public CreateFirstElement(Element element) {
        super(element);
    }
    public void run(){
        for (Element element1 : super.getElementEnclosed()){
            switch (element1.getKind()) {
                case CLASS:
                    CreateClassElement newClassElement = new CreateClassElement(element1);
                    this.buildUml += newClassElement.getStringElementAll();
                    break;
                case INTERFACE:
                    CreateInterElement newInterElement = new CreateInterElement(element1);
                    this.buildUml += newInterElement.getStringElementStartEnd();
                    break;
                case ENUM:
                    CreateEnumElement newEnumElement = new CreateEnumElement(element1);
                    this.buildUml += newEnumElement.getStringElementAll();
                    break;
                case PACKAGE:
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
