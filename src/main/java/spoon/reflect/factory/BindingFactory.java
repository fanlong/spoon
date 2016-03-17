package spoon.reflect.factory;

import spoon.reflect.binding.CtFieldBinding;
import spoon.reflect.binding.CtMethodBinding;
import spoon.reflect.binding.CtTypeBinding;
import spoon.reflect.declaration.CtPackage;
import spoon.support.reflect.binding.CtFieldBindingImpl;
import spoon.support.reflect.binding.CtMethodBindingImpl;
import spoon.support.reflect.binding.CtTypeBindingImpl;

public class BindingFactory extends SubFactory {
	public BindingFactory(Factory f) {
		super(f);
	}
	
	public CtTypeBinding createTypeBinding() {
		CtTypeBindingImpl ret = new CtTypeBindingImpl();
		ret.setFactory(factory);
		return ret;
	}
	
	public CtMethodBinding createMethodBinding() {
		CtMethodBindingImpl ret = new CtMethodBindingImpl();
		ret.setFactory(factory);
		return ret;
	}
	
	public CtFieldBinding createFieldBinding() {
		CtFieldBindingImpl ret = new CtFieldBindingImpl();
		ret.setFactory(factory);
		return ret;
	}
}
