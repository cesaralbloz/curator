/*
 *
 *  Copyright 2011 Netflix, Inc.
 *
 *     Licensed under the Apache License, Version 2.0 (the "License");
 *     you may not use this file except in compliance with the License.
 *     You may obtain a copy of the License at
 *
 *         http://www.apache.org/licenses/LICENSE-2.0
 *
 *     Unless required by applicable law or agreed to in writing, software
 *     distributed under the License is distributed on an "AS IS" BASIS,
 *     WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *     See the License for the specific language governing permissions and
 *     limitations under the License.
 *
 */

package com.netflix.curator.x.discovery.server.jetty_resteasy;

import com.netflix.curator.x.discovery.server.rest.DiscoveryContext;
import com.netflix.curator.x.discovery.server.rest.DiscoveryResource;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Providers;

@Path("/")
public class StringDiscoveryResource extends DiscoveryResource<String>
{
    public StringDiscoveryResource(@Context Providers providers)
    {
        super(getContextFromProvider(providers));
    }

    @SuppressWarnings({ "unchecked", "rawtypes" })
	private static DiscoveryContext<String> getContextFromProvider(Providers providers)
    {
        ContextResolver<DiscoveryContext> contextResolver = providers.getContextResolver(DiscoveryContext.class, MediaType.WILDCARD_TYPE);
        //noinspection unchecked
        return contextResolver.getContext(DiscoveryContext.class);
    }
}
