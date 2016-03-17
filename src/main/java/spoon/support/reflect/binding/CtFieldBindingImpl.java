package spoon.support.reflect.binding;

import spoon.reflect.binding.CtFieldBinding;
import spoon.reflect.binding.CtTypeBinding;
import spoon.reflect.factory.Factory;
import spoon.reflect.reference.CtFieldReference;

public class CtFieldBindingImpl implements CtFieldBinding {

	private transient Factory factory;
	
	private String name;
	
	private CtTypeBinding type;
	
	private CtTypeBinding declaringType;
	
	@Override
	public <T extends CtFieldBinding> T setSimpleName(String name) {
		this.name = name;
		return (T) this;
	}

	@Override
	public String getSimpleName() {
		return name;
	}

	@Override
	public CtTypeBinding getType() {
		return type;
	}

	@Override
	public CtFieldReference<?> getReference() {
		CtFieldReference<?> ret = factory.Field().createReference(declaringType.getReference(), type.getReference(), name);
		return ret;
	}

	@Override
	public <T extends CtFieldBinding>  T setType(CtTypeBinding typeBinding) {
		this.type = typeBinding;
		return (T) this;
	}

	@Override
	public Factory getFactory() {
		return factory;
	}

	@Override
	public void setFactory(Factory factory) {
		this.factory = factory;
	}

	@Override
	public CtTypeBinding getDeclaringType() {
		return declaringType;
	}

	@Override
	public <T extends CtFieldBinding> T setDeclaringType(CtTypeBinding typeBinding) {
		this.declaringType = typeBinding;
		return (T) this;
	}

}
