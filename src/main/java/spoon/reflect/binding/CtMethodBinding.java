package spoon.reflect.binding;

import java.util.List;

import spoon.processing.FactoryAccessor;
import spoon.reflect.declaration.CtNamedElement;
import spoon.reflect.reference.CtExecutableReference;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.visitor.CtVisitable;

public interface CtMethodBinding extends CtBinding {
	
	<T extends CtMethodBinding> T setSimpleName(String name);
	
	CtTypeBinding getDeclaringType();
	
	CtTypeBinding getReturnType();
	
	List<CtTypeBinding> getParameterTypes();

	<T extends CtMethodBinding> T setReturnType(CtTypeBinding typeBinding);
	
	<T extends CtMethodBinding> T setDeclaringType(CtTypeBinding typeBinding);

	<T extends CtMethodBinding> T addParameter(CtTypeBinding typeBinding);
	
	<T extends CtMethodBinding> T setStatic(boolean isstatic);
	
	boolean isConstructor();
	
	boolean isStatic();
	
	CtExecutableReference<?> getReference();
}
