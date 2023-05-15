package pumlFromJava;

import javax.lang.model.element.Element;
import java.util.ArrayList;

public class CreateInterElement extends ElementDefault{
    public CreateInterElement(Element element){
        super(element);
    }

    public String getStringElementStart(){
        return "interface " + super.getNameAndEnclosing() + " <<interface>> {\n";
    }
    public String getStringElementEnd(){
        return "}\n";
    }
    public String getStringElementStartEnd(){
        return this.getStringElementStart() + this.getStringElementEnd();
    }
}
