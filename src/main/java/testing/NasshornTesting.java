package testing;

import java.io.FileNotFoundException;
import java.io.FileReader;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

public class NasshornTesting {
    public static void main(String[] args) throws ScriptException, FileNotFoundException {
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("nashorn");
        FileReader file = new FileReader("js_files/selenese-rollups.js");
        engine.eval(file);
    }

}