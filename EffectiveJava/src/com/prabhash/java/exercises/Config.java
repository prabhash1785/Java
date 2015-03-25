package com.prabhash.java.exercises;

/**
 * Builder Pattern Demo.
 * 
 * @author prrathore
 *
 */
public class Config {
	
	private String protocol;
	private String host;
	private String port;
	private String contextRoot; 
	private boolean useCache;

	private Config(Builder builder) {
		this.protocol = builder.protocol;
		this.host = builder.host;
		this.port = builder.port;
		this.contextRoot = builder.contextRoot;
		this.useCache = builder.useCache;
	}
	
	@Override
	public String toString() {
		return "http://" + this.host + ":" + this.port + "/" + this.contextRoot + "?useCache=" + this.useCache; 
	}
	
	public String getHost() {
		return this.host;
	}

	private static class Builder {

		private String protocol;
		private String host;
		private String port;
		private String contextRoot; 
		private boolean useCache;

		//mandatory field
		public Builder(String contextRoot) {
			this.contextRoot = contextRoot;
		}

		//optional fields
		public Builder protocol(String protocol) {
			this.protocol = protocol;
			return this;
		}

		public Builder host(String host) {
			this.host = host;
			return this;
		}

		public Builder port(String port) {
			this.port = port;
			return this;
		}

		public Builder useCache(boolean useCache) {
			this.useCache = useCache;
			return this;
		}

		public Config build() {
			return new Config(this);
		}

	}
	
	public static void main(String[] args) {
		Config config = new Config.Builder("scispike").host("www.scispike.com").useCache(true).build();
		System.out.printf("URL for %s: %s\n", config.getHost(), config);
	}

}
