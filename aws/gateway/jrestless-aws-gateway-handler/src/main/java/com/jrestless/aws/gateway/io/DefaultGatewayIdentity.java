/*
 * Copyright 2016 Bjoern Bilger
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.jrestless.aws.gateway.io;

import java.util.Objects;

/**
 * Implementation of {@link GatewayIdentity}.
 * <p>
 * The implementation makes sure that the request object passed from AWS API
 * Gateway can get de-serialized into this representation.
 *
 * @author Bjoern Bilger
 *
 */
public final class DefaultGatewayIdentity implements GatewayIdentity {

	private String cognitoIdentityPoolId;
	private String accountId;
	private String cognitoIdentityId;
	private String caller;
	private String apiKey;
	private String sourceIp;
	private String accessKey;
	private String cognitoAuthenticationType;
	private String cognitoAuthenticationProvider;
	private String userArn;
	private String userAgent;
	private String user;

	public DefaultGatewayIdentity() {
		// for de-serialization
	}

	// for unit testing, only
	// CHECKSTYLE:OFF
	DefaultGatewayIdentity(String cognitoIdentityPoolId, String accountId, String cognitoIdentityId, String caller,
			String apiKey, String sourceIp, String accessKey, String cognitoAuthenticationType, String cognitoAuthenticationProvider,
			String userArn, String userAgent, String user) {
		setCognitoIdentityPoolId(cognitoIdentityPoolId);
		setAccountId(accountId);
		setCognitoIdentityId(cognitoIdentityId);
		setCaller(caller);
		setApiKey(apiKey);
		setSourceIp(sourceIp);
		setAccessKey(accessKey);
		setCognitoAuthenticationType(cognitoAuthenticationType);
		setCognitoAuthenticationProvider(cognitoAuthenticationProvider);
		setUserArn(userArn);
		setUserAgent(userAgent);
		setUser(user);
	}
	// CHECKSTYLE:ON


	@Override
	public String getCognitoIdentityPoolId() {
		return cognitoIdentityPoolId;
	}

	public void setCognitoIdentityPoolId(String cognitoIdentityPoolId) {
		this.cognitoIdentityPoolId = cognitoIdentityPoolId;
	}

	@Override
	public String getAccountId() {
		return accountId;
	}

	public void setAccountId(String accountId) {
		this.accountId = accountId;
	}

	@Override
	public String getCognitoIdentityId() {
		return cognitoIdentityId;
	}

	public void setCognitoIdentityId(String cognitoIdentityId) {
		this.cognitoIdentityId = cognitoIdentityId;
	}

	@Override
	public String getCaller() {
		return caller;
	}

	public void setCaller(String caller) {
		this.caller = caller;
	}

	@Override
	public String getApiKey() {
		return apiKey;
	}

	public void setApiKey(String apiKey) {
		this.apiKey = apiKey;
	}

	@Override
	public String getSourceIp() {
		return sourceIp;
	}

	public void setSourceIp(String sourceIp) {
		this.sourceIp = sourceIp;
	}

	@Override
	public String getAccessKey() {
		return accessKey;
	}

	public void setAccessKey(String accessKey) {
		this.accessKey = accessKey;
	}

	@Override
	public String getCognitoAuthenticationType() {
		return cognitoAuthenticationType;
	}

	public void setCognitoAuthenticationType(String cognitoAuthenticationType) {
		this.cognitoAuthenticationType = cognitoAuthenticationType;
	}

	@Override
	public String getCognitoAuthenticationProvider() {
		return cognitoAuthenticationProvider;
	}

	public void setCognitoAuthenticationProvider(String cognitoAuthenticationProvider) {
		this.cognitoAuthenticationProvider = cognitoAuthenticationProvider;
	}

	@Override
	public String getUserArn() {
		return userArn;
	}

	public void setUserArn(String userArn) {
		this.userArn = userArn;
	}

	@Override
	public String getUserAgent() {
		return userAgent;
	}

	public void setUserAgent(String userAgent) {
		this.userAgent = userAgent;
	}

	@Override
	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	@Override
	public boolean equals(final Object other) {
		if (this == other) {
			return true;
		}
		if (other == null) {
			return false;
		}
		if (!getClass().equals(other.getClass())) {
			return false;
		}
		DefaultGatewayIdentity castOther = (DefaultGatewayIdentity) other;
		return Objects.equals(cognitoIdentityPoolId, castOther.cognitoIdentityPoolId)
				&& Objects.equals(accountId, castOther.accountId)
				&& Objects.equals(cognitoIdentityId, castOther.cognitoIdentityId)
				&& Objects.equals(caller, castOther.caller) && Objects.equals(apiKey, castOther.apiKey)
				&& Objects.equals(sourceIp, castOther.sourceIp)
				&& Objects.equals(accessKey, castOther.accessKey)
				&& Objects.equals(cognitoAuthenticationType, castOther.cognitoAuthenticationType)
				&& Objects.equals(cognitoAuthenticationProvider, castOther.cognitoAuthenticationProvider)
				&& Objects.equals(userArn, castOther.userArn) && Objects.equals(userAgent, castOther.userAgent)
				&& Objects.equals(user, castOther.user);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cognitoIdentityPoolId, accountId, cognitoIdentityId, caller, apiKey, sourceIp, accessKey,
				cognitoAuthenticationType, cognitoAuthenticationProvider, userArn, userAgent, user);
	}

	@Override
	public String toString() {
		return "DefaultGatewayIdentity [cognitoIdentityPoolId=" + cognitoIdentityPoolId + ", accountId=" + accountId
				+ ", cognitoIdentityId=" + cognitoIdentityId + ", caller=" + caller + ", apiKey=" + apiKey
				+ ", sourceIp=" + sourceIp + ", accessKey=" + accessKey + ", cognitoAuthenticationType="
				+ cognitoAuthenticationType + ", cognitoAuthenticationProvider=" + cognitoAuthenticationProvider
				+ ", userArn=" + userArn + ", userAgent=" + userAgent + ", user=" + user + "]";
	}
}
