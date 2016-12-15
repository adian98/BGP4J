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
 * File: org.bgp4.config.nodes.impl.ClientConfigurationImplTest.java 
 */
package org.bgp4j.config.nodes.impl;

import java.net.InetAddress;
import java.net.InetSocketAddress;

import org.apache.commons.configuration.ConfigurationException;
import org.bgp4j.config.nodes.ClientConfiguration;
import org.bgp4j.config.nodes.impl.ClientConfigurationImpl;
import org.junit.Assert;
import org.junit.Test;

/**
 * @author Rainer Bieniek (Rainer.Bieniek@web.de)
 *
 */
public class ClientConfigurationImplTest {

	@Test(expected=ConfigurationException.class)
	public void testNullAddressRejected() throws Exception {
		@SuppressWarnings("unused")
		ClientConfiguration config = new ClientConfigurationImpl(null, 0);
	}

	@Test(expected=ConfigurationException.class)
	public void testAnyLocalAddressRejected() throws Exception {
		@SuppressWarnings("unused")
		ClientConfiguration config = new ClientConfigurationImpl(InetAddress.getByName("0.0.0.0"), 0);
	}


	@Test(expected=ConfigurationException.class)
	public void testAnyLocalSocketAddressRejected() throws Exception {
		@SuppressWarnings("unused")
		ClientConfiguration config = new ClientConfigurationImpl(new InetSocketAddress(InetAddress.getByName("0.0.0.0"), 0));
	}
	
	@Test(expected=ConfigurationException.class)
	public void testNegativePortNumber() throws Exception {
		@SuppressWarnings("unused")
		ClientConfiguration config = new ClientConfigurationImpl(InetAddress.getByName("192.168.4.1"), -10);
	}

	@Test(expected=ConfigurationException.class)
	public void testLargePortNumber() throws Exception {
		@SuppressWarnings("unused")
		ClientConfiguration config = new ClientConfigurationImpl(InetAddress.getByName("192.168.4.1"), 70000);
	}

	@Test
	public void testAcceptedPortNumber() throws Exception {
		@SuppressWarnings("unused")
		ClientConfiguration config = new ClientConfigurationImpl(InetAddress.getByName("192.168.4.1"), 2048);
	}
	
	@Test
	public void testEquals() throws Exception {
		ClientConfigurationImpl c1 = new ClientConfigurationImpl(InetAddress.getByName("129.168.5.1"), 1000);
		ClientConfigurationImpl c2 = new ClientConfigurationImpl(InetAddress.getByName("129.168.5.1"), 1000);
		ClientConfigurationImpl c3 = new ClientConfigurationImpl(InetAddress.getByName("129.168.6.1"), 1000);
		ClientConfigurationImpl c4 = new ClientConfigurationImpl(InetAddress.getByName("129.168.5.1"), 2000);
		
		Assert.assertTrue(c1.equals(c2));
		Assert.assertFalse(c1.equals(c3));
		Assert.assertFalse(c1.equals(c4));
	}
	
	@Test
	public void testHashCode() throws Exception {
		ClientConfigurationImpl c1 = new ClientConfigurationImpl(InetAddress.getByName("129.168.5.1"), 1000);
		ClientConfigurationImpl c2 = new ClientConfigurationImpl(InetAddress.getByName("129.168.5.1"), 1000);
		ClientConfigurationImpl c3 = new ClientConfigurationImpl(InetAddress.getByName("129.168.6.1"), 1000);
		ClientConfigurationImpl c4 = new ClientConfigurationImpl(InetAddress.getByName("129.168.5.1"), 2000);
		
		Assert.assertEquals(c1.hashCode(), c2.hashCode());
		Assert.assertTrue(c1.hashCode() != c3.hashCode());
		Assert.assertTrue(c1.hashCode() != c4.hashCode());
	}
}
