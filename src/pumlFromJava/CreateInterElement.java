package pumlFromJava;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import java.util.ArrayList;

public class CreateInterElement extends ElementDefault{
    private ArrayList<CreateMethodElement> methods;
    private CreateImpleElement impleElement;

    public CreateInterElement(Element element){
        super(element);
        this.impleElement = new CreateImpleElement(element);
    }
    public String getStringElementStart(){
        return "interface " + super.getNameAndEnclosing() + " <<interface>> {\n";
    }
    public String getStringElementEnd(){
        return "}\n\n" ;
    }
    public String getStringElementStartEnd(){
        return this.getStringElementStart() + this.getStringElementEnd();
    }
    public String getStringElementAllPlus(){
        return this.getStringElementStart() + this.getStringMethods() + this.getStringElementEnd() /* + this.impleElement.getStringExtendsInterface() +"\n" */;
    }
    //Methods definitive
    public String getStringElementFromBool(boolean val){
        if(val){
            return this.getStringElementDCA();
        }
        else {
            return this.getStringElementDCC();
        }
    }
    public String getStringElementDCC(){
        return this.getStringElementAllPlus();
    }
    public String getStringElementDCA(){
        return this.getStringElementStart()  + "}\n";
    }
    public ArrayList<CreateMethodElement> getMethods(){
        if(this.methods == null){
            this.methods = new ArrayList<>();
            for (Element element1: super.getElementEnclosed()) {
                if(element1.getKind() == ElementKind.METHOD){
                    CreateMethodElement newMethodElement = new CreateMethodElement(element1);
                    this.methods.add(newMethodElement);
                }
            }
        }
        return this.methods;
    }
    public String getStringMethods(){
        String temp = "";
        for (CreateMethodElement methodElement: this.getMethods()) {
            temp += methodElement.getMethod();
        }
        return temp;
    }
}
