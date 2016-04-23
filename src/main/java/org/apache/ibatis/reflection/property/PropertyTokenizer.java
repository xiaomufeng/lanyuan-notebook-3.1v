/*
 *    Copyright 2009-2012 the original author or authors.
 *
 *    Licensed under the Apache License, Version 2.0 (the "License");
 *    you may not use this file except in compliance with the License.
 *    You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 *    Unless required by applicable law or agreed to in writing, software
 *    distributed under the License is distributed on an "AS IS" BASIS,
 *    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *    See the License for the specific language governing permissions and
 *    limitations under the License.
 */
package org.apache.ibatis.reflection.property;

import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/**
 * @author Clinton Begin
 */
public class PropertyTokenizer implements Iterable<PropertyTokenizer>, Iterator<PropertyTokenizer> {
  private String name;
  private String indexedName;
  private String index;
  private String children;

  public PropertyTokenizer(String fullname) {
    int delim = fullname.indexOf('.');
    if (delim > -1) {
      name = fullname.substring(0, delim);
      children = fullname.substring(delim + 1);
    } else {
      name = fullname;
      children = null;
    }
    indexedName = name;
    delim = name.indexOf('[');
    if (delim > -1) {
      index = name.substring(delim + 1, name.length() - 1);
      name = name.substring(0, delim);
    }
  }

  public String getName() {
    return name;
  }

  public String getIndex() {
    return index;
  }

  public String getIndexedName() {
    return indexedName;
  }

  public String getChildren() {
    return children;
  }

  public boolean hasNext() {
    return children != null;
  }

  public PropertyTokenizer next() {
    return new PropertyTokenizer(children);
  }

  public void remove() {
    throw new UnsupportedOperationException("Remove is not supported, as it has no meaning in the context of properties.");
  }

  public Iterator<PropertyTokenizer> iterator() {
    return this;
  }

/* (non-Javadoc)
 * @see java.util.Iterator#forEachRemaining(java.util.function.Consumer)
 */
public void forEachRemaining(Consumer<? super PropertyTokenizer> action) {
    // TODO Auto-generated method stub
    
}

/* (non-Javadoc)
 * @see java.lang.Iterable#forEach(java.util.function.Consumer)
 */
public void forEach(Consumer<? super PropertyTokenizer> action) {
    // TODO Auto-generated method stub
    
}

/* (non-Javadoc)
 * @see java.lang.Iterable#spliterator()
 */
public Spliterator<PropertyTokenizer> spliterator() {
    // TODO Auto-generated method stub
    return null;
}
}
