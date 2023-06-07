package pumlFromJava;

import javax.lang.model.element.*;
import javax.lang.model.type.ArrayType;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public abstract class ElementDefault {
    private Element element;
    private String name;
    private String enclosing;
    private List<? extends Element> elementEnclosed;
    public ElementDefault(Element element){
        this.element = element;
        this.name = this.element.getSimpleName().toString();
        this.enclosing = this.element.getEnclosingElement().toString();
        this.elementEnclosed = this.element.getEnclosedElements();
    }

    public Element getElement() {
        return this.element;
    }
    public String getName(){
        return this.name;
    }
    public String getEnclosing(){
        return this.enclosing;
    }
    public String getNameAndEnclosing(){
        if(this.enclosing.contains("unnamed package")){
            return this.name;
        }
        else {
            return this.enclosing + "." + this.name;
        }
    }
    public List<? extends Element> getElementEnclosed() {
        return elementEnclosed;
    }
}
