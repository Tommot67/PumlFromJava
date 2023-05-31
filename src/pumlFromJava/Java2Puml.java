package pumlFromJava;

import java.util.spi.ToolProvider;

public class Java2Puml
{
    /*
    String[] perso_args = new String[]{
                "-private",
                "-sourcepath",
                "./exemples/Western/",
                "-doclet",
                "pumlFromJava.FirstDoclet",
                "-docletpath",
                "",
                "Lib"
        };
    */

    public static void main(String[] args)
    {

        String[] perso_args = new String[]{
        "-private",
        "-sourcepath",
        "./exemples/P21_Western/src/",
        "-doclet",
        "pumlFromJava.PumlDoclet",
        "-d",
        "./",
        "-out",
        "Diagram_test5_DCA",
        "--dca",
        "-docletpath",
        "",
        "western",
    };

        ToolProvider toolProvider = ToolProvider.findFirst("javadoc").get();
        System.out.println(toolProvider.name());

/*
    javadoc -private -sourcepath <src> -doclet pumlFromJava.FirstDoclet -docletpath out/production/<projet>
      <package> ... <fichiers>
 */
        toolProvider.run(System.out, System.err, perso_args);
    }
}
/*
    javadoc -private -sourcepath </home/yglady/Documents/P21/SAE/src/pumlFromJava/Java2Puml.java> -doclet pumlFromJava.FirstDoclet -docletpath out/production/<projet> <package> ... <fichiers>
 */