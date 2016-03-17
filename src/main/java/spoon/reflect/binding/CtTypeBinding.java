package spoon.reflect.binding;

import java.util.List;

import spoon.reflect.declaration.CtPackage;
import spoon.reflect.reference.CtTypeReference;

// The binding class contains the meta information for
// the program to use a type. The difference between CtType
// and CtTypeBinding is that if the code of the type is not
// present, you may still get CtTypeBinding but you will not
// get CtType.
public interface CtTypeBinding extends CtBinding {

	<T extends CtTypeBinding> T setQualifiedName(String qualName);

	String getQualifiedName();

	String getSimpleName();

	CtPackage getPackage();

	CtTypeBinding getSuperType();

	List<CtTypeBinding> getSuperInterfaces();

	List<CtFieldBinding> getFields();

	List<CtMethodBinding> getMethods();

	<T extends CtTypeBinding> T addField(CtFieldBinding fb);

	<T extends CtTypeBinding> T addMethod(CtMethodBinding methodBinding);

	<T extends CtTypeBinding> T setPackage(CtPackage p);

	<T extends CtTypeBinding> T setSuperType(CtTypeBinding typeBinding);

	<T extends CtTypeBinding> T addInterface(CtTypeBinding typeBinding);

	CtTypeReference<?> getReference();

	String getFullName();
}
