package pumlFromJava;

import javax.lang.model.element.Element;
import javax.lang.model.element.VariableElement;
import java.util.ArrayList;

public class CreateFieldSpecialElement extends ElementDefault{
    public static ArrayList<createFieldSpecialElement> specialElements = new ArrayList<>();
    private String elementFirst;
    private String elementSecond;
    private boolean elementSecondIsArray;
    public CreateFieldSpecialElement(Element element){
        super(element);
        specialElements.add(this);
        this.setElementFirst();
        this.setElementSecondIsArray();
        this.setElementSecond();
    }

    public String getElementFirst(){
        return this.elementFirst;
    }

    public String getElementSecond(){
        return this.elementSecond;
    }
    public boolean getElementSecondIsArray(){
        return this.elementSecondIsArray;
    }
    public void setElementFirst(){
        this.elementFirst = super.getEnclosing();
    }
    public void setElementSecond(){
        if(this.elementSecondIsArray) {
            this.elementSecond = super.getElement().asType().toString().split("<")[1].replace(">", "");
        }
        else {
            this.elementSecond = super.getElement().asType().toString();
        }
    }
    public void setElementSecondIsArray(){
        this.elementSecondIsArray =  Helper.isArrayObject(super.getElement().asType());
    }

    public String getStringElement(){
        return this.elementFirst + " -- " + this.elementSecond + "\n";
    }
}
