package pumlFromJava;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import java.util.ArrayList;

public class CreateClassElement extends ElementDefault{
    private ArrayList<CreateFieldElement> fields;
    private CreateExtendsElement extendsElement;
    private CreateImpleElement impleElement;
    public CreateClassElement(Element element){
        super(element);
        this.extendsElement = new CreateExtendsElement(element);
        this.impleElement = new CreateImpleElement(element);
    }
    public String getStringElementStart(){
        return "class " + super.getNameAndEnclosing() + " {\n";
    }
    public String getStringElementStartPlus(){
        return "class " + super.getNameAndEnclosing() + " " + this.extendsElement.getStringExtends() + " " + this.impleElement.getStringImplements() +" {\n";
    }
    public String getStringElementEnd(){
        return "}\n";
    }
    public String getStringElementStartEnd(){
        return this.getStringElementStart() + this.getStringElementEnd();
    }
    public String getStringElementAll(){
        return this.getStringElementStart() + this.getStringFieldsPrimitive() + this.getStringElementEnd();
    }
    public String getStringElementAllPlus(){
        return this.getStringElementStartPlus() + this.getStringFieldsPrimitive() + this.getStringElementEnd() + this.getStringFildsNotPrimitive();
    }

    //Enregistre le contenu de l'élément
    public ArrayList<CreateFieldElement> getFields(){
        if(this.fields == null){
            this.fields = new ArrayList<>();
            for (Element element1: super.getElementEnclosed()) {
                if(element1.getKind() == ElementKind.FIELD){
                    CreateFieldElement newFieldElement = new CreateFieldElement(element1);
                    this.fields.add(newFieldElement);
                }
            }
        }
        return this.fields;
    }

    //Convertit l'array en String
    public String getStringFieldsPrimitive(){
        String temp = "";
        for (CreateFieldElement fieldElement: this.getFields()) {
            temp += fieldElement.getFieldPrimitive();
        }
        return temp;
    }

    public String getStringFildsNotPrimitive(){
        String temp = "\n";
        for (CreateFieldElement fieldElement: this.getFields()) {
            temp += fieldElement.getFieldNotPrimitive();
        }
        temp += "\n";
        return temp;
    }
}
