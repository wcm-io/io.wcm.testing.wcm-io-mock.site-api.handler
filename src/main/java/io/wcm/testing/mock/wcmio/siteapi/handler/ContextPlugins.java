/*
 * #%L
 * wcm.io
 * %%
 * Copyright (C) 2022 wcm.io
 * %%
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 * #L%
 */
package io.wcm.testing.mock.wcmio.siteapi.handler;

import org.apache.sling.testing.mock.osgi.context.AbstractContextPlugin;
import org.apache.sling.testing.mock.osgi.context.ContextPlugin;
import org.jetbrains.annotations.NotNull;

import io.wcm.siteapi.handler.caconfig.impl.property.ContentPathPropertyMapper;
import io.wcm.siteapi.handler.link.impl.LinkDecoratorManagerImpl;
import io.wcm.siteapi.handler.media.impl.MediaDecoratorManagerImpl;
import io.wcm.siteapi.handler.url.impl.HandlerUrlBuilder;
import io.wcm.testing.mock.aem.context.AemContextImpl;

/**
 * Mock context plugins.
 */
public final class ContextPlugins {

  private ContextPlugins() {
    // constants only
  }

  /**
   * Context plugin for wcm.io Handler and Site API
   */
  public static final @NotNull ContextPlugin<AemContextImpl> WCMIO_SITEAPI_HANDLER = new AbstractContextPlugin<AemContextImpl>() {
    @Override
    public void afterSetUp(@NotNull AemContextImpl context) throws Exception {
      setUp(context);
    }
  };

  /**
   * Set up all mandatory OSGi services.
   * @param context Aem context
   */
  static void setUp(AemContextImpl context) {
    context.registerInjectActivateService(HandlerUrlBuilder.class);
    context.registerInjectActivateService(LinkDecoratorManagerImpl.class);
    context.registerInjectActivateService(MediaDecoratorManagerImpl.class);
    context.registerInjectActivateService(ContentPathPropertyMapper.class);
  }

}
