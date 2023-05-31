package pumlFromJava;

import javax.lang.model.element.Modifier;
import javax.lang.model.type.TypeMirror;
import java.util.Arrays;
import java.util.Set;

public class Helper {
    private static final String classPrimitiveForObjectType = "java.lang.";
    private static final String classArrayForObjectType = "java.util.";
    private static final String classMapForObjectType = "java.util.Map";
    public static boolean isPrimitiveObject(TypeMirror type_test){
        return (type_test.toString().contains(classPrimitiveForObjectType) && !isMapObject(type_test));
    }
    public static boolean isArrayObject(TypeMirror type_test){
        return (type_test.toString().contains(classArrayForObjectType) && !isMapObject(type_test) && type_test.toString().contains("<"));
    }
    public static boolean isMapObject(TypeMirror type_test){
        return type_test.toString().contains(classMapForObjectType);
    }
    public static boolean isOtherObject(TypeMirror type_test){
        return (!isPrimitiveObject(type_test) && !isArrayObject(type_test) && isMapObject(type_test) && type_test.toString().contains("."));
    }
    public static String stringPrimitveObject(TypeMirror type_test){
        return type_test.toString().substring(type_test.toString().lastIndexOf(".") + 1);
    }
    public static String stringArrayObject(TypeMirror type_test){
        return type_test.toString().split("<")[1].replace(">", "").replace("? extends ", "");
    }
    public static String stringMapObject(TypeMirror type_test , String package_name){
        String temp = "";
        temp = type_test.toString().split("<")[1].replace(">", "");
        String tempArray[] = temp.split(",");
        if(tempArray[0].contains(package_name)){
            temp = tempArray[0].substring(tempArray[0].lastIndexOf('.') + 1);
        }
        else if (tempArray[1].contains(package_name)){
            temp = tempArray[1].substring(tempArray[1].lastIndexOf('.') + 1);
        }
        else {
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
        if(Helper.isPrimitiveObject(type_test)){
            temp = Helper.stringPrimitveObject(type_test);
            if(temp.contains(">")){
                temp = temp.replace(">", "[*]");
            }
        }
        else if (Helper.isArrayObject(type_test)){
            temp = Helper.stringArrayObject(type_test);
            if(temp.lastIndexOf(".") != -1){
                temp = temp.substring(temp.lastIndexOf(".") + 1) + "[*]";
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
        return temp;
    }
}
