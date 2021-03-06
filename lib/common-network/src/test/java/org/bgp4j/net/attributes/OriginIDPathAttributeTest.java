/**
 *  Copyright 2012 Rainer Bieniek (Rainer.Bieniek@web.de)
 *
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 * 
 * File: org.bgp4j.net.attributes.OriginIDPathAttributeTest.java 
 */
package org.bgp4j.net.attributes;

import org.bgp4j.net.Origin;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Rainer Bieniek (Rainer.Bieniek@web.de)
 *
 */
public class OriginIDPathAttributeTest {

	@Test
	public void testEquals() {
		OriginPathAttribute a = new OriginPathAttribute(Origin.IGP);
		OriginPathAttribute b = new OriginPathAttribute(Origin.IGP);
		
		Assert.assertTrue(a.equals(b));
		Assert.assertTrue(a.hashCode() == b.hashCode());
		Assert.assertTrue(a.compareTo(b) == 0);
	}
	
	@Test
	public void testSmaller() {
		OriginPathAttribute a = new OriginPathAttribute(Origin.IGP);
		OriginPathAttribute b = new OriginPathAttribute(Origin.EGP);
		
		Assert.assertFalse(a.equals(b));
		Assert.assertFalse(a.hashCode() == b.hashCode());
		Assert.assertTrue(a.compareTo(b) < 0);
	}
	
	@Test
	public void testLarger() {
		OriginPathAttribute a = new OriginPathAttribute(Origin.EGP);
		OriginPathAttribute b = new OriginPathAttribute(Origin.IGP);
		
		Assert.assertFalse(a.equals(b));
		Assert.assertFalse(a.hashCode() == b.hashCode());
		Assert.assertTrue(a.compareTo(b) > 0);
	}
}
