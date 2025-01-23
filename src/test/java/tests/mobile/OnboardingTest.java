package tests.mobile;

import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.Story;
import tests.mobile.components.OnboardingComponent;
import tests.mobile.screens.AuthorizationScreen;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;

import static io.qameta.allure.SeverityLevel.BLOCKER;

@Feature("Android. Тестирование онбординга приложения.")
@Tag("android")
public class OnboardingTest extends MobileTestBase {

    final OnboardingComponent onboardingComponent = new OnboardingComponent();
    final AuthorizationScreen authorizationScreen = new AuthorizationScreen();

    @Test
    @Severity(BLOCKER)
    @DisplayName("Пропуск онбординга через кнопку Skip и переход к экрану авторизации пользователя")
    @Story("Проверка того, что пользователь может покинуть онбординг при нажатии соответствуюшей кнопки")
    public void successfulOnboardingTest() {
        onboardingComponent.checkDescriptionText("It’s time to have fun while you get things done. Join over 2,000,000 others improving their life one task at a time.")
                .clickSkipButton();
        authorizationScreen.checkLoginScreen();

    }
}
