package pumlFromJava;

import javax.lang.model.element.AnnotationMirror;
import javax.lang.model.element.Element;
import javax.lang.model.element.ExecutableElement;
import javax.lang.model.element.Modifier;
import java.util.List;
import java.util.Set;

public class CreateMethodElement {
    private Set<Modifier> modifiers;
    private List<? extends AnnotationMirror> annotationMirrors;
    private ExecutableElement executableElement;
    public CreateMethodElement(Element element){
        this.executableElement = (ExecutableElement) element;
    }


    public Set<Modifier> getModifiers(){
        if(this.modifiers == null) {
            this.modifiers = this.executableElement.getModifiers();
        }
        return this.modifiers;
    }

    public List<? extends AnnotationMirror> getAnnotation(){
        if(this.annotationMirrors == null){
            this.annotationMirrors = this.executableElement.getAnnotationMirrors();
        }
        return annotationMirrors;
    }

    public String getMethod(){
        String temp = "\t";
        temp += Helper.getStringModifier(this.getModifiers());
        temp += this.executableElement.getSimpleName() + "(";
        temp += this.getStringParametre() + ")";
        temp += getStringRetour();
        temp += getStringAnnotation() + "\n";
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

    public String getStringRetour(){
        String temp = " : ";
        temp += Helper.getStringType(this.executableElement.getReturnType());
        if(temp.length() < 4){
            temp = "";
        }
        return temp;
    }

    public String getStringAnnotation(){
        String temp = "";
        for (AnnotationMirror annotationMirror: getAnnotation()) {
            switch (annotationMirror.toString()){
                case "@java.lang.Override":
                    temp += " {redefine}";
                    break;
                default:
                    break;
            }
        }
        return temp;
    }
}
