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
package com.jrestless.core.container.io;

import java.io.InputStream;
import java.net.URI;
import java.util.List;
import java.util.Map;

import javax.annotation.Nonnull;

/**
 * Request definition to feed Jersey.
 *
 * @author Bjoern Bilger
 *
 */
public interface JRestlessContainerRequest {

	/**
	 *
	 * @return the base uri; either the request base uri, of if none is given that of the server.
	 */
	@Nonnull
	URI getBaseUri();

	/**
	 *
	 * @return the request uri
	 */
	@Nonnull
	URI getRequestUri();

	/**
	 *
	 * @return the HTTP method (upper-case) e.g. GET, PUT, POST, DELETE, ...
	 */
	@Nonnull
	String getHttpMethod();

	/**
	 * @return the request body
	 */
	@Nonnull
	InputStream getEntityStream();

	/**
	 *
	 * @return the headers of the request.
	 */
	@Nonnull
	Map<String, List<String>> getHeaders();
}
