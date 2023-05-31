package pumlFromJava;


import javax.lang.model.element.Element;
import javax.lang.model.element.TypeElement;
import javax.lang.model.type.TypeMirror;
import java.util.List;

public class CreateImpleElement {
    private TypeElement typeElement;
    private boolean isImplements;
    private List<TypeMirror> interfacesImplements;
    public CreateImpleElement(Element element){
        this.typeElement = (TypeElement) element;
        this.setIsImplements();
        this.setinterfacesImplements();
    }
    private void setIsImplements(){
        this.isImplements = this.typeElement.getInterfaces().size() != 0 ? true : false;
    }
    public boolean getIsImplementVal(){
        return this.isImplements;
    }
    private void setinterfacesImplements(){
        if(this.isImplements){
             this.interfacesImplements = (List<TypeMirror>) this.typeElement.getInterfaces();
        }
    }
    public List<TypeMirror> getinterfacesImplements(){
        return this.interfacesImplements;
    }
    public String getStringImplements(){
        return this.isImplements ? "implements " + this.interfacesImplements.toString().replace("[", "").replace("]", "") : "";
    }
    public String getStringExtendsInterface(){
        return this.isImplements ? this.typeElement.getSimpleName() +" --^ " + this.interfacesImplements.toString().replace("[", "").replace("]", "") + "\n" : "";
    }
}
