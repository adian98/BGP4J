/**
 * 
 */
package org.bgp4j.extension.snmp4j.web;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author rainer
 *
 */
@XmlRootElement(name="status")
public class StatusResult {
	
	private boolean running;
	private UptimeResult uptime;
	private InterfaceResult[] interfaces;
	
	/**
	 * @return the running
	 */
	@XmlElement
	public boolean isRunning() {
		return running;
	}

	/**
	 * @return the uptime
	 */
	@XmlElement
	public UptimeResult getUptime() {
		return uptime;
	}

	/**
	 * @param running the running to set
	 */
	void setRunning(boolean running) {
		this.running = running;
	}

	/**
	 * @param uptime the uptime to set
	 */
	void setUptime(UptimeResult uptime) {
		this.uptime = uptime;
	}

	/**
	 * @return the interfaces
	 */
	@XmlElement
	public InterfaceResult[] getInterfaces() {
		return interfaces;
	}

	/**
	 * @param interfaces the interfaces to set
	 */
	void setInterfaces(InterfaceResult[] interfaces) {
		this.interfaces = interfaces;
	}
}
