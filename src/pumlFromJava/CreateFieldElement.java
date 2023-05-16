package pumlFromJava;

import javax.lang.model.element.Element;
import javax.lang.model.element.Modifier;
import javax.lang.model.type.TypeKind;
import java.util.HashSet;
import java.util.Set;

public class CreateFieldElement extends ElementDefault{
    private boolean isPrimitive;
    private Set<Modifier> modifiier = new HashSet();
    private CreateFieldSpecialElement fieldSpecialElement;
    public CreateFieldElement(Element element){
        super(element);
        this.CheckPrimitive();
    }
    public boolean CheckPrimitive(){
        boolean verif = false;
        if(super.getElement().asType().getKind() != TypeKind.DECLARED){
            verif = true;
        }
        else if(Helper.isPrimitiveObject(super.getElement().asType())){
            verif = true;
        }
        else{
            this.setFieldNotPrimitive();
        }
        this.isPrimitive = verif;
        return verif;
    }
    public Set<Modifier> giveModifier(){
        this.modifiier = super.getElement().getModifiers();
        return this.modifiier;
    }
    public boolean getIsPrimitive(){
        return this.isPrimitive;
    }
    public String getFieldPrimitive(){
        if(this.isPrimitive){
            return "\t" + super.getName() + "\n";
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

    public String getFieldNotPrimitive(){
        if(!this.isPrimitive && this.fieldSpecialElement != null){
            return this.fieldSpecialElement.getStringElement();
        }
        else {
            return "";
        }
    }
}
