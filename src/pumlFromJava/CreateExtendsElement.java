package pumlFromJava;

import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeKind;

public class CreateExtendsElement {

    private static final String objectClass = "java.lang.Object";
    private boolean isExtends = false;
    private String nameExtends;
    private TypeElement typeElement;
    public CreateExtendsElement(Element element){
        typeElement = (TypeElement)element;
        this.setIsExtends();
        this.setNameExtends();
    }

    private void setIsExtends(){
        this.isExtends = this.typeElement.getSuperclass().getKind() != TypeKind.NONE && !this.typeElement.getSuperclass().toString().contains(objectClass) ? true : false;
    }
    public boolean getIsExtendsVal(){
        return this.isExtends;
    }

    private void setNameExtends(){
        this.nameExtends = this.isExtends ? this.typeElement.getSuperclass().toString() : "";
    }

    public String getNameExtends(){
        return this.nameExtends;
    }

    public String getStringExtends(){
        return this.isExtends ? "extends " + this.nameExtends : "";
    }
}
