package com.crop.shennong.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties(prefix = "app")
public class AppProperties {
	private final Auth auth = new Auth();

	public static class Auth {
		private String tokenSecret;
		private long tokenExpirationMilliSec;

		public String getTokenSecret() {
			return tokenSecret;
		}

		public void setTokenSecret(String tokenSecret) {
			this.tokenSecret = tokenSecret;
		}

		public long getTokenExpirationMilliSec() {
			return tokenExpirationMilliSec;
		}

		public void setTokenExpirationMilliSec(long tokenExpirationMilliSec) {
			this.tokenExpirationMilliSec = tokenExpirationMilliSec;
		}
	}

	public Auth getAuth() {
		return auth;
	}
}
