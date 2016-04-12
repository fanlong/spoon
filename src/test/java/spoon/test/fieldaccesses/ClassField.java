package spoon.test.fieldaccesses;

public class ClassField {

	public void foo() {
    	Object a = null;
    	a.getClass().isAssignableFrom(java.lang.annotation.Annotation.class);
    }
}