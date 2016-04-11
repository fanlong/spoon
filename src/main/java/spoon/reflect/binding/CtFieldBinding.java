package spoon.reflect.binding;

import spoon.reflect.reference.CtFieldReference;

public interface CtFieldBinding extends CtBinding {

	<T extends CtFieldBinding> T setSimpleName(String name);

	CtTypeBinding getDeclaringType();

	CtTypeBinding getType();

	<T extends CtFieldBinding> T setDeclaringType(CtTypeBinding typeBinding);

	<T extends CtFieldBinding> T setType(CtTypeBinding typeBinding);

	<T extends CtFieldBinding> T setStatic(boolean isstatic);

	boolean isStatic();

	CtFieldReference<?> getReference();
}
