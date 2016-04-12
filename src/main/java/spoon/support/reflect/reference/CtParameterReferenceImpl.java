/*
 * Spoon - http://spoon.gforge.inria.fr/
 * Copyright (C) 2006 INRIA Futurs <renaud.pawlak@inria.fr>
 *
 * This software is governed by the CeCILL-C License under French law and
 * abiding by the rules of distribution of free software. You can use, modify
 * and/or redistribute the software under the terms of the CeCILL-C license as
 * circulated by CEA, CNRS and INRIA at http://www.cecill.info.
 *
 * This program is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the CeCILL-C License for more details.
 *
 * The fact that you are presently reading this means that you have had
 * knowledge of the CeCILL-C license and that you accept its terms.
 */

package spoon.support.reflect.reference;

import java.util.List;

import spoon.reflect.declaration.CtExecutable;
import spoon.reflect.declaration.CtParameter;
import spoon.reflect.reference.CtExecutableReference;
import spoon.reflect.reference.CtParameterReference;
import spoon.reflect.visitor.CtVisitor;

public class CtParameterReferenceImpl<T> extends CtVariableReferenceImpl<T>
		implements CtParameterReference<T> {
	private static final long serialVersionUID = 1L;

	CtExecutableReference<?> executable;

	public CtParameterReferenceImpl() {
		super();
	}

	@Override
	public void accept(CtVisitor visitor) {
		visitor.visitCtParameterReference(this);
	}

	@Override
	@SuppressWarnings("unchecked")
	public CtParameter<T> getDeclaration() {
		CtExecutable<?> exec = executable.getDeclaration();
		if (exec == null) {
			return null;
		}
		List<CtParameter<?>> params = exec.getParameters();
		for (CtParameter<?> p : params) {
			if (this.getSimpleName().equals(p.getSimpleName())) {
				return (CtParameter<T>) p;
			}
		}
		throw new IllegalStateException(
				"Cannot found declaration for parameter " + getSimpleName());
	}

	@Override
	public CtExecutableReference<?> getDeclaringExecutable() {
		return executable;
	}

	@Override
	public int hashCode() {
		return super.hashCode() ^ executable.hashCode();
	}

	@Override
	public boolean equals(Object o) {
		if (executable == null || !(o instanceof CtParameterReferenceImpl)) {
			return super.equals(o);
		} else {
			return super.equals(o) && executable.equals(((CtParameterReferenceImpl<?>) o).executable);
		}
	}

	@Override
	public <C extends CtParameterReference<T>> C setDeclaringExecutable(CtExecutableReference<?> executable) {
		this.executable = executable;
		return (C) this;
	}
}
