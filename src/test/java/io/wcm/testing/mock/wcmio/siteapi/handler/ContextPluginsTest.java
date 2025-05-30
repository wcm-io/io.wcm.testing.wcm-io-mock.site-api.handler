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

import static io.wcm.testing.mock.wcmio.caconfig.ContextPlugins.WCMIO_CACONFIG;
import static io.wcm.testing.mock.wcmio.handler.ContextPlugins.WCMIO_HANDLER;
import static io.wcm.testing.mock.wcmio.siteapi.handler.ContextPlugins.WCMIO_SITEAPI_HANDLER;
import static io.wcm.testing.mock.wcmio.siteapi.processor.ContextPlugins.WCMIO_SITEAPI_PROCESSOR;
import static io.wcm.testing.mock.wcmio.sling.ContextPlugins.WCMIO_SLING;
import static io.wcm.testing.mock.wcmio.wcm.ContextPlugins.WCMIO_WCM;
import static org.apache.sling.testing.mock.caconfig.ContextPlugins.CACONFIG;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import io.wcm.handler.link.LinkHandler;
import io.wcm.handler.media.MediaHandler;
import io.wcm.handler.richtext.RichTextHandler;
import io.wcm.handler.url.UrlHandler;
import io.wcm.testing.mock.aem.junit.AemContext;
import io.wcm.testing.mock.aem.junit.AemContextBuilder;

public class ContextPluginsTest {

  @Rule
  public AemContext context = new AemContextBuilder()
      .plugin(CACONFIG)
      .plugin(WCMIO_SLING, WCMIO_CACONFIG, WCMIO_WCM, WCMIO_SITEAPI_PROCESSOR, WCMIO_HANDLER, WCMIO_SITEAPI_HANDLER)
      .build();

  @Before
  public void setUp() {
    context.currentPage(context.create().page("/content/region/site/en", "/apps/templates/sample"));
  }

  @Test
  public void testHandler() {
    assertNotNull(context.request().adaptTo(UrlHandler.class));
    assertNotNull(context.request().adaptTo(MediaHandler.class));
    assertNotNull(context.request().adaptTo(LinkHandler.class));
    assertNotNull(context.request().adaptTo(RichTextHandler.class));
  }

}
