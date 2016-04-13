package spoon.support.reflect.binding;

import java.io.Serializable;

import spoon.reflect.binding.CtFieldBinding;
import spoon.reflect.binding.CtTypeBinding;
import spoon.reflect.factory.Factory;
import spoon.reflect.reference.CtFieldReference;
import spoon.reflect.visitor.CtVisitor;

public class CtFieldBindingImpl implements CtFieldBinding, Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private transient Factory factory;

	private String name;

	private CtTypeBinding type;

	private CtTypeBinding declaringType;

	private boolean isstat;
	private boolean ispublic;
	private boolean isprivate;

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
		CtFieldReference<?> ret = factory.Field().createReference(declaringType.getReference(), type.getReference(),
				name);
		return ret;
	}

	@Override
	public <T extends CtFieldBinding> T setType(CtTypeBinding typeBinding) {
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

	@SuppressWarnings("unchecked")
	@Override
	public <T extends CtFieldBinding> T setDeclaringType(CtTypeBinding typeBinding) {
		this.declaringType = typeBinding;
		return (T) this;
	}

	@Override
	public void accept(CtVisitor visitor) {
		visitor.visitCtFieldBinding(this);
	}

	@SuppressWarnings("unchecked")
	@Override
	public <T extends CtFieldBinding> T setStatic(boolean isstatic) {
		isstat = isstatic;
		return (T) this;
	}

	@Override
	public boolean isStatic() {
		return isstat;
	}

	@Override
	public boolean isPublic() {
		return ispublic;
	}

	@Override
	public boolean isPrivate() {
		return isprivate;
	}

	@Override
	public <T extends CtFieldBinding> T setPublic(boolean ispublic) {
		this.ispublic = ispublic;
		return (T) this;
	}

	@Override
	public <T extends CtFieldBinding> T setPrivate(boolean isprivate) {
		this.isprivate = isprivate;
		return (T) this;
	}

}
