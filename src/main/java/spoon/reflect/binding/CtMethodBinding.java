package spoon.reflect.binding;

import java.util.List;

import spoon.processing.FactoryAccessor;
import spoon.reflect.declaration.CtNamedElement;
import spoon.reflect.reference.CtExecutableReference;

public interface CtMethodBinding extends FactoryAccessor {
	
	<T extends CtMethodBinding> T setSimpleName(String name);
	
	String getSimpleName();
	
	CtTypeBinding getDeclaringType();
	
	CtTypeBinding getReturnType();
	
	List<CtTypeBinding> getParameterTypes();
	
	CtExecutableReference<?> getReference();

	<T extends CtMethodBinding> T setReturnType(CtTypeBinding typeBinding);
	
	<T extends CtMethodBinding> T setDeclaringType(CtTypeBinding typeBinding);

	<T extends CtMethodBinding> T addParameter(CtTypeBinding typeBinding);
	
	<T extends CtMethodBinding> T setStatic(boolean isstatic);
	
	boolean isConstructor();
	
	boolean isStatic();
}
