package pumlFromJava;

import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.type.TypeKind;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class CreateFieldElement extends ElementDefault{
    private boolean isPrimitive;
    private Set<Modifier> modifiers;
    private CreateFieldSpecialElement fieldSpecialElement;
    public CreateFieldElement(Element element){
        super(element);
        this.CheckPrimitiveAndMap();
    }
    public void CheckPrimitiveAndMap(){
        boolean verif1 = false;
        if(this.getElement().asType().getKind() != TypeKind.DECLARED){
            verif1 = true;
        }
        else if(Helper.isPrimitiveObject(this.getElement().asType())){
            verif1 = true;
        }
        else {
            this.setFieldNotPrimitive();
        }
        this.isPrimitive = verif1;
    }
    public Set<Modifier> getModifiers(){
        if(this.modifiers == null) {
            this.modifiers = this.getElement().getModifiers();
        }
        return this.modifiers;
    }
    public boolean getIsPrimitive(){
        return this.isPrimitive;
    }
    public String getFieldPrimitive(){
        String temp = "";
        if(this.isPrimitive){
            temp = "\t"  + Helper.getStringModifier(this.getModifiers())  + super.getName() + " : " + Helper.getStringType(super.getElement().asType());
        }
        if(this.isPrimitive && this.getModifiers().contains(Modifier.FINAL)){
            temp += " {readOnly}\n";
        }
        else if (this.isPrimitive) {
            temp += "\n";
        }
        return temp;
    }
    public String getFieldPrimitiveForDCA(){
        if(this.isPrimitive){
            return "\t"  + super.getName() + "\n";
        }
        else {
            return "";
        }
    }
    public void setFieldNotPrimitive(){
        if(!this.isPrimitive){
            CreateFieldSpecialElement newFieldSpecialElement = new CreateFieldSpecialElement(super.getElement());
            this.fieldSpecialElement = newFieldSpecialElement;
        }
    }

    public String getFieldNotPrimitive(boolean val){
        if(!this.isPrimitive && this.fieldSpecialElement != null){
            return  this.fieldSpecialElement.getStringElementFromBool(val);
        }
        else {
            return "";
        }
    }
}
