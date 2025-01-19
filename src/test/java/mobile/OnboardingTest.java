package mobile;

import mobile.components.OnboardingComponent;
import mobile.screens.AuthorizationScreen;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

@Tag("android")
public class OnboardingTest extends MobileTestBase {

    OnboardingComponent onboardingComponent = new OnboardingComponent();
    AuthorizationScreen authorizationScreen = new AuthorizationScreen();

    @Test
    @DisplayName("Пропуск онбординга через кнопку Skip и переход к экрану авторизации пользователя")
    public void successfulOnboardingTest() {
        onboardingComponent.checkDescriptionText("It’s time to have fun while you get things done. Join over 2,000,000 others improving their life one task at a time.")
                .clickSkipButton();
        authorizationScreen.checkLoginScreen();

    }
}
