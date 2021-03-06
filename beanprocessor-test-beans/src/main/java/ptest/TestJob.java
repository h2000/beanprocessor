/* BeanProcessor -- a JavaBean generator.
 * 
 * Copyright 2012 Ross Judson
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except in 
 * compliance with the License. You may obtain a copy of the license at http://www.apache.org/licenses/LICENSE-2.0.
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the License is distributed on
 * an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the License for the
 * specific language governing permissions and limitations under the License. 
 */
package ptest;

import java.util.Date;

import javax.xml.bind.annotation.XmlRootElement;

import com.soletta.beanprocessor.JAXBMemberType;
import com.soletta.beanprocessor.SBean;
import com.soletta.beanprocessor.SKind;
import com.soletta.beanprocessor.SProperty;

@XmlRootElement
@SBean(properties={ 
        @SProperty(name="title"),
        @SProperty(name="running", type=boolean.class, javadoc="Determines if the job is running."),
        @SProperty(name="started", type=Date.class, jaxbType=JAXBMemberType.ELEMENT),
        @SProperty(name="number", type=double.class, jaxbType=JAXBMemberType.TRANSIENT),
        @SProperty(name="perm", type=boolean.class, final_=true, init="true"),
        @SProperty(name="listOfStrings", type=String.class, kind=SKind.LIST),
        @SProperty(name="builder", type=StringBuilder.class, delegate=Appendable.class, create = true, jaxbType=JAXBMemberType.TRANSIENT),
        @SProperty(name="del", type=DelegationTest.class, delegate=DelegationTest.class, init = "new DelegationTestImpl()", jaxbType=JAXBMemberType.TRANSIENT)
}, bound=true, predicates=true, extractors=true, fluent=true, jaxbType=JAXBMemberType.ATTRIBUTE, propertyEnum=true)
public class TestJob extends TestJobBase {      
}     