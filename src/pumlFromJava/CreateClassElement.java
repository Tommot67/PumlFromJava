package pumlFromJava;

import javax.lang.model.element.Element;
import javax.lang.model.element.ElementKind;
import java.util.ArrayList;

public class CreateClassElement extends ElementDefault{
    private ArrayList<CreateFieldElement> fields;
    private ArrayList<CreateConstructorElement> constructors;
    private ArrayList<CreateMethodElement> methods;

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
    public String getStringElementStartWithExtends(){
        return "class " + super.getNameAndEnclosing() + " " + this.extendsElement.getStringExtends() + " " + this.impleElement.getStringImplements() +" {\n";
    }
    public String getStringElementEnd(){
        return "}\n";
    }
    public String getStringElementStartEnd(){
        return this.getStringElementStart() + this.getStringElementEnd();
    }
    public String getStringElementAllPlus(){
        return this.getStringElementStart() + this.getStringFieldsPrimitive() + this.getStringConstructors() + this.getStringMethods() + this.getStringElementEnd() /* + this.getStringFildsNotPrimitive()*/;
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
        return this.getStringElementStartWithExtends() + this.getStringFieldsPrimitive() + this.getStringConstructors() + this.getStringMethods() + this.getStringElementEnd() + this.getStringFieldsNotPrimitive();
    }
    public String getStringElementDCA(){
        return this.getStringElementStartWithExtends() + this.getStringFieldsPrimitiveForDCA() + this.getStringElementEnd() + this.getStringFieldsNotPrimitive();
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
    public ArrayList<CreateConstructorElement> getConstructor(){
        if(this.constructors == null){
            this.constructors = new ArrayList<>();
            for (Element element1: super.getElementEnclosed()) {
                if(element1.getKind() == ElementKind.CONSTRUCTOR){
                    CreateConstructorElement newConstructorElement = new CreateConstructorElement(element1);
                    this.constructors.add(newConstructorElement);
                }
            }
        }
        return this.constructors;
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

    //Convertit l'array en String
    public String getStringFieldsPrimitive(){
        String temp = "";
        for (CreateFieldElement fieldElement: this.getFields()) {
            temp += fieldElement.getFieldPrimitive();
        }
        return temp;
    }
    public String getStringFieldsPrimitiveForDCA(){
        String temp = "";
        for (CreateFieldElement fieldElement: this.getFields()) {
            temp += fieldElement.getFieldPrimitiveForDCA();
        }
        return temp;
    }
    public String getStringFieldsNotPrimitive(){
        String temp = "\n";
        for (CreateFieldElement fieldElement: this.getFields()) {
            temp += fieldElement.getFieldNotPrimitive();
        }
        temp += "\n";
        return temp;
    }
    public String getStringMethods(){
        String temp = "";
        for (CreateMethodElement methodElement: this.getMethods()) {
            temp += methodElement.getMethod();
        }
        return temp;
    }
    public String getStringConstructors(){
        String temp = "";
        for (CreateConstructorElement constructorElement: this.getConstructor()) {
            temp += constructorElement.getConstructor();
        }
        return temp;
    }

}
