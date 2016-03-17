package spoon.reflect.binding;

import spoon.processing.FactoryAccessor;
import spoon.reflect.reference.CtFieldReference;

public interface CtFieldBinding extends FactoryAccessor {
	
	<T extends CtFieldBinding> T setSimpleName(String name);
	
	String getSimpleName();
	
	CtTypeBinding getDeclaringType();
	
	CtTypeBinding getType();
	
	CtFieldReference<?> getReference();

	<T extends CtFieldBinding> T setDeclaringType(CtTypeBinding typeBinding);
	
	<T extends CtFieldBinding> T setType(CtTypeBinding typeBinding);
}
