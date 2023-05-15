package pumlFromJava;

import javax.lang.model.type.TypeMirror;

public class Helper {

    private static final String classPrimitiveForObjectType = "java.lang.";
    private static final String classArrayForObjectType = "java.util.";
    public static boolean isPrimitiveObject(TypeMirror type_test){
        return type_test.toString().contains(classPrimitiveForObjectType);
    }

    public static boolean isArrayObject(TypeMirror type_test){
        return type_test.toString().contains(classArrayForObjectType);
    }
}
