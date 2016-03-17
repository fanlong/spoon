package spoon.support.reflect.binding;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import spoon.reflect.binding.CtFieldBinding;
import spoon.reflect.binding.CtMethodBinding;
import spoon.reflect.binding.CtTypeBinding;
import spoon.reflect.declaration.CtPackage;
import spoon.reflect.declaration.CtType;
import spoon.reflect.factory.Factory;
import spoon.reflect.reference.CtTypeReference;
import spoon.reflect.visitor.CtVisitor;

public class CtTypeBindingImpl implements CtTypeBinding, Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private transient Factory factory;
	
	private String qualName;
	private CtPackage pack;
	private CtTypeBinding supertype;
	private ArrayList<CtTypeBinding> interfaces = new ArrayList<CtTypeBinding>();
	private ArrayList<CtFieldBinding> fields = new ArrayList<CtFieldBinding>();
	private ArrayList<CtMethodBinding> methods = new ArrayList<CtMethodBinding>();
	
	/**
	 * Tells if a given Java qualified name is that of an inner type.
	 */
	protected int hasInnerType(String qualifiedName) {
		int ret = qualifiedName.lastIndexOf(CtType.INNERTTYPE_SEPARATOR);
		return ret;
	}

	/**
	 * Tells if a given Java qualified name contains a package name.
	 */
	protected int hasPackage(String qualifiedName) {
		return qualifiedName.lastIndexOf(CtPackage.PACKAGE_SEPARATOR);
	}
	
	@Override
	public <T extends CtTypeBinding> T setQualifiedName(String qualName) {
		this.qualName = qualName;
		return (T) this;
	}

	@Override
	public String getFullName() {
		if (pack == null)
			return "?." + qualName;
		else {
			return pack.getQualifiedName() + "." + qualName;
		}
	}
	
	@Override
	public String getQualifiedName() {
		return qualName;
	}
	
	@Override
	public String getSimpleName() {
		if (hasInnerType(qualName) > 0) {
			return qualName.substring(hasInnerType(qualName) + 1);
		} else if (hasPackage(qualName) > 0) {
			return qualName.substring(hasPackage(qualName) + 1);
		} else {
			return qualName;
		}
	}

	@Override
	public CtPackage getPackage() {
		return pack;
	}

	@Override
	public CtTypeBinding getSuperType() {
		return supertype;
	}

	@Override
	public List<CtTypeBinding> getSuperInterfaces() {
		return interfaces;
	}

	@Override
	public List<CtFieldBinding> getFields() {
		return fields;
	}

	@Override
	public List<CtMethodBinding> getMethods() {
		return methods;
	}

	@Override
	public CtTypeReference<?> getReference() {
		return factory.Type().createReference(qualName);
	}

	@Override
	public <T extends CtTypeBinding> T addField(CtFieldBinding fb) {
		fields.add(fb);
		return (T) this;
	}

	@Override
	public <T extends CtTypeBinding> T addMethod(CtMethodBinding mb) {
		methods.add(mb);
		return (T) this;
	}

	@Override
	public <T extends CtTypeBinding> T setPackage(CtPackage p) {
		pack = p;
		return (T) this;
	}

	@Override
	public <T extends CtTypeBinding> T setSuperType(CtTypeBinding typeBinding) {
		supertype = typeBinding;
		return (T) this;
	}

	@Override
	public <T extends CtTypeBinding> T addInterface(CtTypeBinding typeBinding) {
		interfaces.add(typeBinding);
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
	public void accept(CtVisitor visitor) {
		visitor.visitCtTypeBinding(this);
	}

}
