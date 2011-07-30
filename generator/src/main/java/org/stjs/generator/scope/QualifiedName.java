/**
 *  Copyright 2011 Alexandru Craciun, Eyal Kaspi
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 */
package org.stjs.generator.scope;

import static org.stjs.generator.handlers.utils.PreConditions.checkNotNull;

public class QualifiedName<T extends NameType> {
	private final String scopeName;
	private final String name;
	private final NameScope scope;
	private final boolean isStatic; // use an int to encode modifiers a la java.lang.reflect?
	private final boolean accessingOuterScope;

	public QualifiedName(String scopeName, String name, NameScope scope, boolean isStatic) {
	  this(scopeName, name, scope, isStatic, false);
	}
	
	public QualifiedName(String scopeName, String name, NameScope scope, boolean isStatic, boolean accessingOuterScope) {
		this.scopeName = scopeName;
		this.name = name;
		this.scope = checkNotNull(scope);
		this.isStatic = isStatic;
		this.accessingOuterScope = accessingOuterScope;
	}

	/**
	 * the scope name can be null for parameters and variables, can be "this" for immediate fields, FullClass.this for
	 * references to outer class FullClass for static references.
	 * 
	 * @return
	 */
	public String getScopeName() {
		return scopeName;
	}

	public String getName() {
		return name;
	}

	/**
	 * This is the name scope in which the name was found
	 * 
	 * @return
	 */
	public NameScope getScope() {
		return scope;
	}

	@Override
	public String toString() {
		StringBuilder s = new StringBuilder();
		if (scopeName != null) {
			s.append(scopeName).append(".");
		}
		s.append(name);
		s.append("[" + scope.getPath() + "]");
		return s.toString();
	}

  public boolean isStatic() {
    return isStatic;
  }

  public boolean isAccessingOuterScope() {
    return accessingOuterScope;
  }

  public static <T extends NameType> QualifiedName<T> outerScope(String scopeName, String name, NameScope scope, boolean isStatic) {
    return new QualifiedName<T>(scopeName, name, scope, isStatic, true);
  }

}
