package tests.browser

import config.BrowserTest
import config.annotations.Browser
import config.driver.Breakpoint
import io.github.artsok.RepeatedIfExceptionsTest
import org.apache.commons.lang3.RandomStringUtils
import org.fluentlenium.core.annotation.Page
import tests.browser.pageobjects.WebauthnIoPage

@Browser(dimension = Breakpoint.XLARGE)
class WebauthnIoIT : BrowserTest() {

    @Page
    lateinit var page: WebauthnIoPage

    @RepeatedIfExceptionsTest()
    fun `go to webauthn-io and register fido device`() {
        goTo(page)
            .assertFormIsVisible()
            .setUsername("test_user_" + RandomStringUtils.randomAlphanumeric(6))
            .register()
    }
}