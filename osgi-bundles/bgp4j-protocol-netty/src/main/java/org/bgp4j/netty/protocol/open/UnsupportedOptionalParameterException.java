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
 * File: org.bgp4j.netty.protocol.UnsupportedOptionalParameterException.java 
 */
package org.bgp4j.netty.protocol.open;

import org.bgp4j.net.packets.NotificationPacket;
import org.bgp4j.net.packets.open.UnsupportedOptionalParameterNotificationPacket;

/**
 * @author Rainer Bieniek (Rainer.Bieniek@web.de)
 *
 */
public class UnsupportedOptionalParameterException extends OpenPacketException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 6193635931471963435L;

	public UnsupportedOptionalParameterException() {
	}

	public UnsupportedOptionalParameterException(String message) {
		super(message);
	}

	@Override
	public NotificationPacket toNotificationPacket() {
		return new UnsupportedOptionalParameterNotificationPacket();
	}

}
