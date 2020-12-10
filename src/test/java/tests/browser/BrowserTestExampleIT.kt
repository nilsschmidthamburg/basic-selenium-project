package tests.browser

import config.BrowserTest
import config.annotations.Browser
import config.driver.Breakpoint
import io.github.artsok.RepeatedIfExceptionsTest
import org.fluentlenium.assertj.FluentLeniumAssertions.assertThat
import org.fluentlenium.core.annotation.Page
import tests.browser.pageobjects.StartPage

@Browser(dimension = Breakpoint.XLARGE)
class BrowserTestExampleIT : BrowserTest() {

    @Page
    lateinit var page: StartPage

    @RepeatedIfExceptionsTest(repeats = 2)
    fun `an example test using page object pattern`() {
        goTo(page)
        assertThat(page.searchField).isDisplayed
    }
}