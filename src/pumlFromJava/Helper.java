package pumlFromJava;

import javax.lang.model.element.Modifier;
import javax.lang.model.type.TypeKind;
import javax.lang.model.type.TypeMirror;
import java.util.Arrays;
import java.util.Set;

public class Helper {
    private static final String classPrimitiveForObjectType = "java.lang.";
    private static final String classArrayForObjectType = "java.util.";
    private static final String classMapForObjectType = "java.util.";
    public static boolean isPrimitiveObject(TypeMirror type_test){
        return (type_test.toString().contains(classPrimitiveForObjectType) && !isMapObject(type_test));
    }
    public static boolean isArrayObject(TypeMirror type_test){
        return ((type_test.toString().contains(classArrayForObjectType) && !isMapObject(type_test) && type_test.toString().contains("<")) || type_test.getKind() == TypeKind.ARRAY);
    }
    public static boolean isMapObject(TypeMirror type_test){
        return type_test.toString().contains(classMapForObjectType) && type_test.toString().contains("Map");
    }
    public static boolean isOtherObject(TypeMirror type_test){
        return (!isPrimitiveObject(type_test) && !isArrayObject(type_test) && isMapObject(type_test) && type_test.toString().contains("."));
    }
    public static boolean isMapPrimitive(TypeMirror type_test){
        return (type_test.toString().split(",")[1].contains(classPrimitiveForObjectType));
    }
    public static String stringPrimitveObject(TypeMirror type_test){
        String temp = type_test.toString().substring(type_test.toString().lastIndexOf(".") + 1);
        if(temp.contains("Character")){
            temp = "Char";
        }
        return temp;
    }
    public static String stringArrayObject(TypeMirror type_test){
        String temp = "";
        temp = type_test.toString().split("<")[type_test.toString().split("<").length - 1].replace(">", "").replace("[]", "").replace("? extends", "");
        if(temp.contains(",")){
            temp = temp.split(",")[1];
        }
        return temp;
    }
    public static String stringMapObject(TypeMirror type_test){
        String temp = type_test.toString();
        while (temp.contains(",")) {
            temp = temp.toString().substring(temp.toString().indexOf(',') + 1, temp.toString().length() - 1);
            if (temp.contains(classPrimitiveForObjectType)) {
                temp = temp.substring(temp.lastIndexOf('.') + 1);
            } else if (temp.contains(classArrayForObjectType)) {
                temp = temp.substring(temp.lastIndexOf("<"), temp.indexOf(">"));
            }
            temp = temp.replace("[]", "").replace("<", "").replace(">", "");
        }
        temp.replace("? extends", "");
        if(temp.contains(type_test.toString())) {
            temp = "";
        }
        return temp;
    }
    public static String stringOtherObject(TypeMirror type_test){
        return type_test.toString().substring(type_test.toString().lastIndexOf('.') + 1);
    }
    public static String upperFirstChar(String string){
        return string.substring(0,1).toUpperCase() + string.substring(1);
    }
    public static String getStringType(TypeMirror type_test){
        String temp = "";
        if(Helper.isMapObject(type_test)){
            temp = Helper.stringMapObject(type_test) + "[*]";
        }
        else if (Helper.isArrayObject(type_test)){
            temp = Helper.stringArrayObject(type_test);
            if(temp.contains("int")){
                temp = "Integer";
            }
            else if(temp.contains("Character")){
                temp = "Char";
            }
            else {
                temp = Helper.upperFirstChar(temp);
            }
            if(temp.lastIndexOf(".") != -1){
                temp = temp.substring(temp.lastIndexOf(".") + 1);
            }
            temp += "[*]";
        }
        else if(Helper.isPrimitiveObject(type_test)){
            temp = Helper.stringPrimitveObject(type_test);
            if(temp.contains(">")){
                temp = temp.replace(">", "[*]");
            }
        }
        else if (isOtherObject(type_test)) {
            temp = stringOtherObject(type_test);
        }
        else if(!"void int".contains(type_test.toString())){
            temp = Helper.upperFirstChar(type_test.toString());
            if(temp.lastIndexOf(".") != -1){
                temp = temp.substring(temp.lastIndexOf(".") + 1);
            }
        }
        else if (type_test.toString().contains("int")) {
            temp = "Integer";
        }
        return temp;
    }
    public static String getStringModifier(Set<Modifier> modifiers){
        String temp = "";
        for (Modifier modifier: modifiers) {
            switch (modifier){
                case PUBLIC:
                    temp += "+ ";
                    break;
                case PRIVATE:
                    temp += "- ";
                    break;
                case PROTECTED:
                    temp += "# ";
                    break;
                case STATIC:
                    temp += "{static} ";
                    break;
                case ABSTRACT:
                    temp += "{abstract} ";
                    break;
                default:
                    break;
            }
        }
        if(temp == "" || !"+-#".contains(temp.substring(0,1))){
            String before = temp;
            temp = "~ " + before;
        }
        return temp;
    }
}
