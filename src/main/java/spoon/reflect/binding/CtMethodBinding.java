package spoon.reflect.binding;

import java.util.List;

import spoon.reflect.reference.CtExecutableReference;

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

	boolean isPublic();

	boolean isPrivate();

	<T extends CtMethodBinding> T setPublic(boolean ispublic);

	<T extends CtMethodBinding> T setPrivate(boolean isprivate);

	@Override
	CtExecutableReference<?> getReference();
}
