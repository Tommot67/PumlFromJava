package pumlFromJava;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import java.util.List;
import java.util.Set;

public class CreateConstructorElement {
    private Set<Modifier> modifiers;
    private List<? extends AnnotationMirror> annotationMirrors;
    private ExecutableElement executableElement;
    public CreateConstructorElement(Element element){
        this.executableElement = (ExecutableElement) element;
        getConstructor();
    }
    public String getName(){
        return this.executableElement.getEnclosingElement().toString().substring(this.executableElement.getEnclosingElement().toString().lastIndexOf(".") + 1);
    }
    public Set<Modifier> getModifiers(){
        if(this.modifiers == null) {
            this.modifiers = this.executableElement.getModifiers();
        }
        return this.modifiers;
    }

    public String getConstructor(){
        String temp = "\t";
        temp += Helper.getStringModifier(this.getModifiers());
        temp += "<<Create>> " ;
        temp += this.getName() + "(";
        temp += this.getStringParametre() + ")\n";
        return temp;
    }

    public String getStringParametre(){
        String temp = "";
        for (int i = 0 ; i < this.executableElement.getParameters().size() ; i++){
            temp += this.executableElement.getParameters().get(i).getSimpleName() + " : " + Helper.getStringType(this.executableElement.getParameters().get(i).asType()) + " , ";
        }
        if(temp.lastIndexOf(",") != -1) {
            return temp.substring(0 , temp.lastIndexOf(",") - 1);
        }
        else{
            return  "";
        }
    }
}
