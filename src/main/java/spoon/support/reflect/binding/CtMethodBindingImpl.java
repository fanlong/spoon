package spoon.support.reflect.binding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import spoon.reflect.binding.CtMethodBinding;
import spoon.reflect.binding.CtTypeBinding;
import spoon.reflect.factory.Factory;
import spoon.reflect.reference.CtExecutableReference;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.visitor.CtVisitor;

public class CtMethodBindingImpl implements CtMethodBinding, Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;

	private transient Factory factory;

	private String name;

	private CtTypeBinding declaringType;

	private CtTypeBinding returnType;

	private ArrayList<CtTypeBinding> parameters = new ArrayList<CtTypeBinding>();

	private boolean isstatic;
	private boolean ispublic;
	private boolean isprivate;

	@Override
	public <T extends CtMethodBinding> T setSimpleName(String name) {
		this.name = name;
		return (T) this;
	}

	@Override
	public String getSimpleName() {
		return name;
	}

	@Override
	public CtTypeBinding getReturnType() {
		return returnType;
	}

	@Override
	public List<CtTypeBinding> getParameterTypes() {
		return parameters;
	}

	@Override
	public CtExecutableReference<?> getReference() {
		ArrayList<CtTypeReference<?>> tmp = new ArrayList<CtTypeReference<?>>();
		for (CtTypeBinding r : parameters) {
			tmp.add(r.getReference());
		}
		CtExecutableReference<?> ret = factory.Executable().createReference(
				(CtTypeReference<Object>) declaringType.getReference(), isstatic,
				(CtTypeReference<Object>) returnType.getReference(), name, tmp);
		return ret;
	}

	@Override
	public <T extends CtMethodBinding> T setReturnType(CtTypeBinding typeBinding) {
		returnType = typeBinding;
		return (T) this;
	}

	@Override
	public <T extends CtMethodBinding> T addParameter(CtTypeBinding typeBinding) {
		parameters.add(typeBinding);
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
	public <T extends CtMethodBinding> T setDeclaringType(CtTypeBinding typeBinding) {
		declaringType = typeBinding;
		return (T) this;
	}

	@Override
	public <T extends CtMethodBinding> T setStatic(boolean isstatic) {
		this.isstatic = isstatic;
		return (T) this;
	}

	@Override
	public boolean isConstructor() {
		return name.equals(CtExecutableReference.CONSTRUCTOR_NAME);
	}

	@Override
	public boolean isStatic() {
		return isstatic;
	}

	@Override
	public void accept(CtVisitor visitor) {
		visitor.visitCtMethodBinding(this);
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
	public <T extends CtMethodBinding> T setPublic(boolean ispublic) {
		this.ispublic = ispublic;
		return (T) this;
	}

	@Override
	public <T extends CtMethodBinding> T setPrivate(boolean isprivate) {
		this.isprivate = isprivate;
		return (T) this;
	}

}
