package pumlFromJava;

import javax.lang.model.element.Element;
import java.util.ArrayList;

public class CreateInterElement extends ElementDefault{

    private CreateExtendsElement extendsElement;

    public CreateInterElement(Element element){
        super(element);
        this.extendsElement = new CreateExtendsElement(element);
    }

    public String getStringElementStart(){
        return "interface " + super.getNameAndEnclosing() + " <<interface>> {\n";
    }
    public String getStringElementStartPlus(){
        return "interface " + super.getNameAndEnclosing() + " " + this.extendsElement.getStringExtends() +" <<interface>> {\n";
    }
    public String getStringElementEnd(){
        return "}\n";
    }
    public String getStringElementStartEnd(){
        return this.getStringElementStart() + this.getStringElementEnd();
    }
    public String getStringElementStartEndPlus(){
        return this.getStringElementStartPlus() + this.getStringElementEnd();
    }

}
