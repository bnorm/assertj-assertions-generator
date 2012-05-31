/*
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in compliance with
 * the License. You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License.
 * 
 * Copyright @2010-2011 the original author or authors.
 */
package org.fest.assertions.generator;

import static java.lang.String.format;
import static java.lang.System.out;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

public class AssertionGeneratorLauncher {

  public static void main(String[] classNames) throws FileNotFoundException, IOException, ClassNotFoundException {
    AssertionGenerator customAssertionGenerator = new AssertionGenerator();
    for (String className : classNames) {
      Class<?> clazz = Class.forName(className);
      File playerAssertJavaFile = customAssertionGenerator.generateCustomAssertion(clazz);
      out.println(format("Generated %s assertions file -> %s ", clazz.getSimpleName(), playerAssertJavaFile.getAbsolutePath()));
    }
  }
}
