package pumlFromJava;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import java.util.ArrayList;

public class CreateEnumElement extends ElementDefault{
    private ArrayList<String> AttributEnum;
    public CreateEnumElement(Element element){
        super(element);
    }
    public String getStringElementStart(){
        return "enum " + super.getNameAndEnclosing() + " <<enumeration>> {\n";
    }
    public String getStringElementEnd(){
        return "}\n";
    }
    public String getStringElementStartEnd(){
        return this.getStringElementStart() + this.getStringElementEnd();
    }
    public String getStringElementAll(){
        return this.getStringElementStart() + this.getStringAttributEnum() + this.getStringElementEnd();
    }
    public ArrayList<String> getAttributEnum(){
        if(this.AttributEnum == null) {
            this.AttributEnum = new ArrayList<>();
            for (Element element1 : super.getElementEnclosed()) {
                if(element1.getKind() == ElementKind.ENUM_CONSTANT) {
                    this.AttributEnum.add(element1.getSimpleName().toString());
                }
            }
        }
        return this.AttributEnum;
    }
    public String getStringAttributEnum(){
        String temp = "";
        for (String attribut: this.getAttributEnum()) {
            temp += "\t" + attribut + "\n";
        }
        return temp;
    }
}
