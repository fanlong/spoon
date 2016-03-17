package spoon.reflect.binding;

import spoon.processing.FactoryAccessor;
import spoon.reflect.reference.CtReference;
import spoon.reflect.visitor.CtVisitable;

public interface CtBinding extends FactoryAccessor, CtVisitable {

	String getSimpleName();

	<T extends CtReference> T getReference();
}
