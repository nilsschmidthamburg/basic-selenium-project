package tests.browser.pageobjects

import org.fluentlenium.assertj.FluentLeniumAssertions.assertThat
import org.fluentlenium.core.FluentPage
import org.fluentlenium.core.annotation.PageUrl
import org.fluentlenium.core.domain.FluentWebElement
import org.openqa.selenium.support.FindBy

@PageUrl("https://webauthn.io/")
@FindBy(xpath = "/html/body/div/div[1]/div/div/div/div/div[1]/h2")
open class WebauthnIoPage : FluentPage() {

    @FindBy(css = "#register-button")
    lateinit var registerButton: FluentWebElement

    @FindBy(css = "#login-button")
    lateinit var loginBUtton: FluentWebElement

    @FindBy(css = "#input-email")
    lateinit var usernameField: FluentWebElement

    @FindBy(css = "#select-verification")
    lateinit var verificationDropDown: FluentWebElement

    fun assertFormIsVisible(): WebauthnIoPage {
        assertThat(registerButton).isDisplayed
        assertThat(loginBUtton).isDisplayed
        assertThat(usernameField).isDisplayed
        return this
    }

    fun setUsername(username: String): WebauthnIoPage {
        usernameField.write(username)
        return this
    }

    fun register(): WebauthnIoPage {
        registerButton.click()
        return this
    }

}
