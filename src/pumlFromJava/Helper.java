package pumlFromJava;

import javax.lang.model.element.Modifier;
import javax.lang.model.type.TypeMirror;
import java.util.Set;

public class Helper {
    private static final String classPrimitiveForObjectType = "java.lang.";
    private static final String classArrayForObjectType = "java.util.";
    public static boolean isPrimitiveObject(TypeMirror type_test){
        return type_test.toString().contains(classPrimitiveForObjectType);
    }
    public static boolean isArrayObject(TypeMirror type_test){
        return type_test.toString().contains(classArrayForObjectType);
    }

    public static String stringPrimitveObject(TypeMirror type_test){
        return type_test.toString().replace(classPrimitiveForObjectType,"");
    }

    public static String stringArrayObject(TypeMirror type_test){
        return type_test.toString().split("<")[1].replace(">", "");
    }
    public static String upperFirstChar(String string){
        return string.substring(0,1).toUpperCase() + string.substring(1);
    }

    public static String getStringType(TypeMirror type_test){
        String temp = "";
        if(Helper.isPrimitiveObject(type_test)){
            temp = Helper.stringPrimitveObject(type_test);
            temp = temp.substring(temp.lastIndexOf(".") + 1);
        }
        else if (Helper.isArrayObject(type_test)){
            temp = Helper.stringArrayObject(type_test);
            if(temp.lastIndexOf(".") != -1){
                temp = temp.substring(temp.lastIndexOf(".") + 1) + "[*]";
            }
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
