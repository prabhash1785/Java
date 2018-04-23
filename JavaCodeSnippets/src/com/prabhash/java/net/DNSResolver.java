package com.prabhash.java.net;

import java.net.InetAddress;
import java.net.UnknownHostException;
import java.security.Security;

/**
 * Resolve DNS names
 * 
 * @author prathore
 *
 */
public class DNSResolver {

	public static InetAddress getIPName(final String hostName) throws UnknownHostException {
		if (hostName == null || hostName.length() == 0) {
			return null;
		}

		InetAddress inetAddress = InetAddress.getByName(hostName);
		return inetAddress;
	}

	public static void main(String[] args) {
		Security.setProperty("networkaddress.cache.ttl", "0");
		System.out.println("After sec prop set, networkaddress.cache.ttl=" + Security.getProperty("networkaddress.cache.ttl"));
		
		Security.setProperty("networkaddress.cache.negative.ttl", "0");
		System.out.println("After sec prop set, networkaddress.cache.negative.ttl=" + Security.getProperty("networkaddress.cache.negative.ttl"));
		
		final String hostName = "relay.mx.aol.com";
		while (true) {
			try {
				InetAddress ipAddress = getIPName(hostName);
				System.out.println("IP Address=" + ipAddress);
				Thread.currentThread().sleep(1000);
			} catch (UnknownHostException e) {
				System.out.println("Failed to resolve host: " + hostName);
			} catch (InterruptedException i) {
				System.out.println("Interrupted Exception..");
			}
		}
	}
}