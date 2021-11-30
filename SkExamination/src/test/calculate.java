package test;

import java.io.FileReader;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class calculate {

	public static void main(String sk[]) {
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		try {
			engine.eval("print('welcome to js')");
			engine.eval(new FileReader(""));
			Invocable invocable = (Invocable) engine;
			invocable.invokeFunction("hello", 45, 45);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static int mul2value(int a, int b) {
		return a * b;

	}
}
