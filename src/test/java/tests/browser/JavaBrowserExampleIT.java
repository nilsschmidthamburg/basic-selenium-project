package tests.browser;

import static org.fluentlenium.assertj.FluentLeniumAssertions.assertThat;

import config.BrowserTest;
import config.annotations.Browser;
import config.driver.Breakpoint;
import io.github.artsok.RepeatedIfExceptionsTest;
import org.fluentlenium.core.annotation.Page;
import tests.browser.pageobjects.StartPage;

@Browser(dimension = Breakpoint.XLARGE)
class JavaBrowserExampleIT extends BrowserTest {

  @Page
  private StartPage startPage;

  @RepeatedIfExceptionsTest(repeats = 2)
  void an_example_test_using_page_object_pattern() {
    goTo(startPage);
    assertThat(startPage.searchField).isDisplayed();
  }
}
