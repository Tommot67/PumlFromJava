package pumlFromJava;

import jdk.javadoc.doclet.Doclet;
import jdk.javadoc.doclet.DocletEnvironment;
import jdk.javadoc.doclet.Reporter;

import javax.lang.model.SourceVersion;
import java.util.*;

public class PumlDoclet implements Doclet {
    abstract class Option implements Doclet.Option {
        private final String name;
        private final boolean hasArg;
        private final String description;
        private final String parameters;

        Option(String name, boolean hasArg,
               String description, String parameters) {
            this.name = name;
            this.hasArg = hasArg;
            this.description = description;
            this.parameters = parameters;
        }

        @Override
        public int getArgumentCount() {
            return hasArg ? 1 : 0;
        }

        @Override
        public String getDescription() {
            return description;
        }

        @Override
        public Kind getKind() {
            return Kind.STANDARD;
        }

        @Override
        public List<String> getNames() {
            return List.of(name);
        }

        @Override
        public String getParameters() {
            return hasArg ? parameters : "";
        }
    }

    private final Set<Option> options = Set.of(

            // An option that takes no arguments.
            new Option("-out", true, "Parametre output name", "<string>") {

                @Override
                public boolean process(String option,
                                       List<String> arguments) {
                    out = arguments.get(0);
                    if (out.isEmpty()){
                        out = getName();
                    }
                    out += ".puml";
                    System.out.println(d + "    " + out);
                    return true;
                }
            },

            // An option that takes a single string-valued argument.
            new Option("-d", true, "Parametre output dir", "<string>") {
                @Override
                public boolean process(String option,
                                       List<String> arguments) {
                    d = arguments.get(0);
                    System.out.println(d + "    " + out);
                    return true;
                }
            }
    );

    private String out = null;
    private String d = null;

    @Override
    public void init(Locale locale, Reporter reporter) {}

    @Override
    public String getName() {
        return getClass().getSimpleName();
    }

    @Override
    public Set<? extends Option> getSupportedOptions() {
        return options;
    }

    @Override
    public SourceVersion getSupportedSourceVersion() {
        return SourceVersion.latest();
    }

    @Override
    public boolean run(DocletEnvironment environment) {
        try{
            PumlDiagram.genereStart(out,d);
            PumlDiagram.generePrincipal(environment);
            PumlDiagram.genereEnd();
        }
        catch (Exception err){
            System.out.println(err.getMessage());
            return false;
        }
        return true;
    }
}
