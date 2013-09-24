/*
    Copyright 2013 Immutables.org authors

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
 */
package org.immutables.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Instructs generator to generate marshaller.
 * When applied to abstract {@link GenerateImmutable immutable} it will generate corresponding
 * marshaler class in the same package. It will have name of abstract immutable class with
 * 'Marshaler' suffix.
 * When applied to package it will include imported routines as static imports for each generated
 * marshaler in the package.
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ ElementType.TYPE, ElementType.PACKAGE })
public @interface GenerateMarshaler {
  /**
   * Specify classes that will be imported with a static import.
   * In order to share imported routines between classes in a package, you can place this
   * annotation on a enclosing package (using package-info.java).
   * @return class literals
   */
  Class<?>[] importRoutines() default {};
}
