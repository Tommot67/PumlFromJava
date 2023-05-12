package pumlFromJava;

import javax.lang.model.type.TypeMirror;

public class Helper {

    private static final String classForObjectType = "java.lang.";
    public static boolean isPrimitiveObject(TypeMirror type_test){
        return type_test.toString().contains(classForObjectType);
    }
}
