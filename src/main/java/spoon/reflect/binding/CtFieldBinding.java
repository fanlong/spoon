package spoon.reflect.binding;

import spoon.processing.FactoryAccessor;
import spoon.reflect.reference.CtFieldReference;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.visitor.CtVisitable;

public interface CtFieldBinding extends CtBinding {

	<T extends CtFieldBinding> T setSimpleName(String name);
	
	CtTypeBinding getDeclaringType();
	
	CtTypeBinding getType();

	<T extends CtFieldBinding> T setDeclaringType(CtTypeBinding typeBinding);
	
	<T extends CtFieldBinding> T setType(CtTypeBinding typeBinding);
	
	CtFieldReference<?> getReference();
}
