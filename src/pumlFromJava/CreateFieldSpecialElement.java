package pumlFromJava;

import jdk.jfr.Description;

import javax.lang.model.element.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class CreateFieldSpecialElement extends ElementDefault{
    //public static ArrayList<CreateFieldSpecialElement> specialElements = new ArrayList<>();
    private String elementFirst;
    private String elementSecond;
    private boolean elementSecondIsArray;
    private boolean elementSecndIsStatic;
    private boolean elementSecondIsMap;
    private Set<Modifier> modifiers;
    private List<? extends AnnotationMirror> annotationMirrors;

    public CreateFieldSpecialElement(Element element){
        super(element);
        //specialElements.add(this);
        this.setElementFirst();
        this.setElementSecondIsArray();
        this.setElementSecondIsMap();
        this.setElementSecondIsStatic();
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
        if (this.elementSecondIsMap){
            this.elementSecond = Helper.stringMapObject(super.getElement().asType() , this.getEnclosing().substring(0 , this.getEnclosing().indexOf('.')));
        }
        else if(this.elementSecondIsArray) {
            this.elementSecond = Helper.stringArrayObject(super.getElement().asType());
        }
        else {
            this.elementSecond = super.getElement().asType().toString();
        }
    }
    public void setElementSecondIsMap() {
        this.elementSecondIsMap =  Helper.isMapObject(super.getElement().asType());
    }
    public void setElementSecondIsArray(){
        this.elementSecondIsArray =  Helper.isArrayObject(super.getElement().asType());
    }
    public void setElementSecondIsStatic(){
        this.elementSecndIsStatic = false;
        if(this.getModifiers().contains(Modifier.STATIC)){
            this.elementSecndIsStatic = true;
        }
    }
    public Set<Modifier> getModifiers(){
        if(this.modifiers == null) {
            this.modifiers = this.getElement().getModifiers();
        }
        return this.modifiers;
    }

    public String getStringElementFromBool(boolean val){
        if(val){
            return this.getStringElementDCA();
        }
        else {
            return this.getStringElementDCC();
        }
    }
    public String getStringElementDCC() {
        if (elementSecond != "") {
            return this.elementFirst + " --> " + this.getStringCardinalAndName() + this.elementSecond + "\n";
        } else {
            return "";
        }
    }
    public String getStringElementDCA() {
        if (elementSecond != "") {
            return this.elementFirst + " --> " + this.getStringCardinal() + this.elementSecond + "\n";
        } else {
            return "";
        }
    }
    public String getStringCardinal(){
        String temp = "";
        if(this.elementSecondIsArray){
            temp += "\"\\t*\\n\\t";
        }
        else{
            temp += "\"\\t1\\n\\t";
        }
        temp += "\\n\" ";
        return temp;
    }
    public String getStringCardinalAndName()
    {
        String temp = "";
        if(this.elementSecondIsArray){
            temp += "\"\\t*\\n\\t";
        }
        else{
            temp += "\"\\t1\\n\\t";
        }
        if(this.elementSecndIsStatic){
            temp += "<u>";
        }
        temp += Helper.getStringModifier(this.getModifiers()).replace("{static}" , "").replace("{abstract}", "");
        temp +=  this.getName();
        if(this.elementSecndIsStatic){
            temp += "</u>";
        }
        temp += "\\n\" ";
        return temp;
    }

    //Complement possible
    /*
    public List<? extends AnnotationMirror> getAnnotation(){
        if(this.annotationMirrors == null){
            this.annotationMirrors = this.getElement().getAnnotationMirrors();
        }
        return annotationMirrors;
    }
    public String getStringAnnotation(){
        String temp = "";
        for (AnnotationMirror annotationMirror: getAnnotation()) {
            System.out.println("Annotation : " + annotationMirror.toString());
        }
        return temp;
    }
    */
}
