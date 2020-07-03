// Copyright (C) 2013 The Android Open Source Project
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
// http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.
package com.googlesource.gerrit.plugins.its.bugzilla;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.google.gerrit.extensions.annotations.PluginName;
import com.google.gerrit.extensions.config.FactoryModule;
import com.google.gerrit.server.config.GerritServerConfig;
import com.google.inject.Guice;
import com.google.inject.Injector;
import com.googlesource.gerrit.plugins.its.base.testutil.LoggingMockingTestCase;
import org.eclipse.jgit.lib.Config;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class BugzillaItsFacadeTest extends LoggingMockingTestCase {
  private Injector injector;
  private Config serverConfig;

  @Test
  public void testCreateLinkForWebUiPlain() {
    mockUnconnectableBugzilla();

    BugzillaItsFacade itsFacade = createBugzillaItsFacade();
    String actual = itsFacade.createLinkForWebui("Test-Url", "Test-Text");

    assertNotNull("Created link is null", actual);
    assertTrue("Created link does not contain url", actual.contains("Test-Url"));
    assertTrue("Created link does not contain text", actual.contains("Test-Text"));

    assertUnconnectableBugzilla();
  }

  @Test
  public void testCreateLinkForWebUiUrlEqualsText() {
    mockUnconnectableBugzilla();

    BugzillaItsFacade itsFacade = createBugzillaItsFacade();
    String actual = itsFacade.createLinkForWebui("Test-Url", "Test-Url");

    assertNotNull("Created link is null", actual);
    assertEquals("Created link does not match", "Test-Url", actual);

    assertUnconnectableBugzilla();
  }

  @Test
  public void testCreateLinkForWebUiUrlEqualsNull() {
    mockUnconnectableBugzilla();

    BugzillaItsFacade itsFacade = createBugzillaItsFacade();
    String actual = itsFacade.createLinkForWebui("Test-Url", null);

    assertNotNull("Created link is null", actual);
    assertEquals("Created link does not match", "Test-Url", actual);

    assertUnconnectableBugzilla();
  }

  private BugzillaItsFacade createBugzillaItsFacade() {
    return injector.getInstance(BugzillaItsFacade.class);
  }

  private void mockUnconnectableBugzilla() {
    when(serverConfig.getString("its-bugzilla", null, "url")).thenReturn("<no-url>");
    when(serverConfig.getString("its-bugzilla", null, "username")).thenReturn("none");
  }

  private void assertUnconnectableBugzilla() {
    assertLogMessageContains("Connecting to bugzilla");
    assertLogMessageContains("Unable to connect");
    assertLogMessageContains("Bugzilla is currently not available");
  }

  @Override
  @Before
  public void setUp() throws Exception {
    super.setUp();

    injector = Guice.createInjector(new TestModule());
  }

  private class TestModule extends FactoryModule {
    @Override
    protected void configure() {
      serverConfig = mock(Config.class);
      bind(Config.class).annotatedWith(GerritServerConfig.class).toInstance(serverConfig);
      bind(String.class).annotatedWith(PluginName.class).toInstance("its-bugzilla");
    }
  }
}
