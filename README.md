<h1>Проект автоматизации тестирования <a target="_blank" href="https://habitica.com/"> Habitica.com </a> </h1>

<p align="center">
<img src="images/logo/habitica_logo.png"  >
</p>

## Содержание
+ [Описание](#Описание)
+ [Технологии и инструменты](#Технологии-и-инструменты)
+ [Реализованные проверки](#Реализованные-проверки)
+ [Запуск тестов](#Запуск-тестов)
    + [Допустимые комбинации](#Допустимые-комбинации)
    + [Локальный запуск тестов](#Локальный-запуск-тестов)
    + [Удаленный запуск тестов](#Удаленный-запуск-тестов)
+ [Cборка тестов в Jenkins](#Cборка-тестов-в-Jenkins)
+ [Интеграция с Allure Report](#интеграция-с-allure-report)
    + [Диаграммы прохождения тестов](#Диаграммы-прохождения-тестов)
    + [Развернутый результат прохождения тестов](#Развернутый-результат-прохождения-тестов)
+ [Интеграция с Allure TestOps](#Интеграция-с-Allure-TestOps)
+ [Интеграция с Jira](#Интеграция-с-Jira)
+ [Уведомления в Telegram с использованием бота](#Уведомления-в-Telegram-с-использованием-бота)
+ [Пример выполнения теста в Selenoid](#Пример-выполнения-теста-в-Selenoid)
  

## Описание
Habitica — трекер задач, который позволяет пользователю планировать свою жизнь и не только. Habitica доступна в веб-версии и приложениях для Android и iOS.
Проект состоит из UI-тестов, API и мобильных тестов на Android. <br/>

**Особенности проекта**:
- `Page Object` шаблон проектирования
- Использование техноголии `Owner` для придания тестам гибкости и легкости конфигурации
- Возможность запуска тестов: локально, удалённо, по тегам
- Использование `Faker` для генерации данных
- Использование `Lombok` для моделей в API тестах
- Использование собственных расширений:
    - `@WithLogin` для предварительной авторизации
- Интеграция Allure TestOps
- Интеграция с Jira
- Уведомление о результатах прохождения в Telegram
- По итогу прохождения автотестов генерируется Allure отчет. Содержание отчета:
    - Шаги теста
    - Скриншот страницы на последнем шаге
    - Исходный код страницы в браузере
    - Логи консоли браузера
    - Видео выполнения автотеста

## Технологии и инструменты

<div align="center">
<a href="https://www.jetbrains.com/idea/"><img alt="InteliJ IDEA" height="50" src="images/logo/Idea.svg" width="50"/></a>
<a href="https://github.com/"><img alt="GitHub" height="50" src="images/logo/GitHub.svg" width="50"/></a>  
<a href="https://www.java.com/"><img alt="Java" height="50" src="images/logo/Java.svg" width="50"/></a>
<a href="https://gradle.org/"><img alt="Gradle" height="50" src="images/logo/Gradle.svg" width="50"/></a>  
<a href="https://junit.org/junit5/"><img alt="JUnit 5" height="50" src="images/logo/Junit5.svg" width="50"/></a>
<a href="https://selenide.org/"><img alt="Selenide" height="50" src="images/logo/Selenide.svg" width="50"/></a>
<a href="https://aerokube.com/selenoid/"><img alt="Selenoid" height="50" src="images/logo/Selenoid.svg" width="50"/></a>
<a href="https://rest-assured.io/"><img alt="RestAssured" height="50" src="images/logo/RestAssured.svg" width="50"/></a>
<a href="https://www.browserstack.com/"><img alt="Browserstack" height="50" src="images/logo/Browserstack.svg" width="50"/></a>
<a href="https://appium.io/"><img alt="Appium" height="50" src="images/logo/Appium.svg" width="50"/></a>
<a href="https://developer.android.com/studio"><img alt="Android Studio" height="50" src="images/logo/Android_Studio.svg" width="50"/></a>
<a href="https://www.jenkins.io/"><img alt="Jenkins" height="50" src="images/logo/Jenkins.svg" width="50"/></a>
<a href="https://github.com/allure-framework/"><img alt="Allure Report" height="50" src="images/logo/Allure.svg" width="50"/></a>
<a href="https://qameta.io/"><img alt="Allure TestOps" height="50" src="images/logo/Allure_TO.svg" width="50"/></a>
<a href="https://www.atlassian.com/software/jira"><img alt="Jira" height="50" src="images/logo/Jira.svg" width="50"/></a>  
<a href="https://telegram.org/"><img alt="Telegram" height="50" src="images/logo/Telegram.svg" width="50"/></a>




<details>
<summary>Подробное описание используемых в проекте технологий</summary>

> </br>
> 
> | Логотип                                                                                                                            | Название               | Предназначение                                                                                                    |
> | :---:                                                                                                                              | :---:                  | :---                                                                                                              |
> | <a href="https://www.jetbrains.com/idea"><img src="images/logo/Idea.svg" width="64" height="64" alt="Intellij IDEA"/></a>  | `Intellij`</br>`IDEA`  | Среда разработки программного обеспечения                                                                         |
> | <a href="https://www.java.com"><img src="images/logo/Java.svg" width="64" height="64" alt="Java"/></a>                             | `Java`                 | Язык программирования, на котором написаны тесты                                                                  |
> | <a href="https://junit.org/junit5"><img src="images/logo/Junit5.svg" width="64" height="64" alt="JUnit 5"/></a>                    | `JUnit 5`              | Фреймворк для модульного тестирования                                                                             |
> | <a href="https://gradle.org"><img src="images/logo/Gradle.svg" width="64" height="64" alt="Gradle"/></a>                           | `Gradle`               | Система автоматической сборки                                                                                     |
> | <a href="https://selenide.org"><img src="images/logo/Selenide.svg" width="64" height="64" alt="Selenide"/></a>                     | `Selenide`             | Фреймворк для автоматизированного тестирования веб-приложений                                                     |
> | <a href="https://github.com"><img src="images/logo/GitHub.svg" width="64" height="64" alt="Github"/></a>                           | `Github`               | Веб-сервис для хостинга и совместной разработки IT-проектов                                                       |
> | <a href="https://www.jenkins.io"><img src="images/logo/Jenkins.svg" width="64" height="64" alt="Jenkins"/></a>                     | `Jenkins`              | Программная система для обеспечения процесса непрерывной интеграции программного обеспечения                      |
> | <a href="https://allurereport.org"><img src="images/logo/Allure.svg" width="64" height="64" alt="Allure Report"/></a>              | `Allure`</br>`Report`  | Инструмент для визуализации результатов тестового запуска                                                         |
> | <a href="https://qameta.io"><img src="images/logo/Allure_TO.svg" width="64" height="64" alt="Allure TestOps"/></a>             | `Allure`</br>`TestOps` | Инструмент для управления тестированием, который помогает автоматизировать и оптимизировать процессы тестирования |
> | <a href="https://www.atlassian.com/software/jira"><img src="images/logo/Jira.svg" width="64" height="64" alt="Jira"/></a>          | `Jira`                 | Система отслеживания ошибок и управления проектами                                                                |
> | <a href="https://telegram.org/"><img src="images/logo/Telegram.svg" width="64" height="64" alt="Telegram"/></a>                    | `Telegram`             | Кроссплатформенная система мгновенного обмена сообщениями (мессенджер)                                            |
> | <a href="https://aerokube.com/selenoid"><img src="images/logo/Selenoid.svg" width="64" height="64" alt="Selenoid"/></a>            | `Selenoid`             | Сервер, который позволяет запускать браузеры в docker-контейнерах                                                 |
> | <a href="https://www.browserstack.com"><img src="images/logo/Browserstack.svg" width="64" height="64" alt="Selenoid"/></a>            | `BrowserStack`             | Облачная платформа для тестирования веб-сайтов и мобильных приложений, позволяющая использовать настоящие мобильные девайсы и не только                                                 |
> | <a href="https://rest-assured.io/"><img src="images/logo/RestAssured.svg" width="64" height="64" alt="Selenoid"/></a>            | `Rest Assured`             | Технология, разработанная для упрощения тестирования и проверки REST API                                                 |
> | <a href="https://developer.android.com/studio"><img src="images/logo/Android_Studio.svg" width="64" height="64" alt="Selenoid"/></a>            | `Android Studio`             | IDE для работы с платформой Android                                                 |
> | <a href="https://appium.io/"><img src="images/logo/Appium.svg" width="64" height="64" alt="Selenoid"/></a>            | `Appium`             | Проект с открытым исходным кодом и экосистема связанного с ним программного обеспечения, предназначенная для автоматизации пользовательского интерфейса многих платформ приложений, включая мобильные (iOS, Android, Tizen), браузерные (Chrome, Firefox, Safari) и др.                                                |
> 
> </details>

</br>
</br>

</div>

## Реализованные проверки
### Web
- [x] Проверка перехода к разделу "Мобильные приложения" при нажатии на соответствующую кнопку
- [x] Проверка открытия документа Terms of Service по пути перехода пользователя со стартовой страницы сайта на страницу регистрации нового пользователя
- [x] Проверки появления уведомления об ошибке регистрации пользователя на домашней странице в случаях, когда пользователь не заполняет требующиеся поля
- [x] Проверка ошибок регистрации и успешной регистрации пользователя на странице регистрации с использованием технологии Faker
- [x] Проверка включения фильтра предметов по классу в разделе Shops/Market (@ParameterizedTest + @WithLogin)

### Api
- [x] Выполнение запроса на проверку статуса серверов Habitica
- [x] Выполнение успешного запроса на авторизацию
- [x] Выполнение неудачного запроса на вход с пустым паролем
- [x] Выполнение неудачного запроса на вход с пустым телом
- [x] Запрос текущего списка тегов
- [x] Выполнение запроса на удаление тега

### Mobile
- [x] Проверка пропуска этапа онбординга через кнопку Skip
- [x] Появление ошибки логина пользователя в случае, если пользователь не ввел полностью требующиеся данные
- [x] Успешный логин в аккаунт существующего пользователя

## Запуск тестов
> [!NOTE]
> Убедитесь, что у вас установлены Java, Gradle, IntelliJ IDEA и в качестве браузера используется Chrome
>

Конфигурационные файлы `.properties` лежат в папке `resources`. <br/>
При необходимости можно изменить их.

### Допустимые комбинации

```mermaid 
flowchart LR
    A(gradle) --> B(clean)
    B --> C{Выбрать тег}
    C --> D[test]
    C --> E[web]
    C --> F[api]
    C --> G[android]
    E --> H[-Denv=local]
    E --> I[-Denv=remote]
    G --> J[-DdeviceHost=browserstack]
    G --> K[-DdeviceHost=emulator]
    G --> L[-DdeviceHost=real]
```

### Локальный запуск тестов
#### Запуск всех тестов

Для запуска следует открыть IntelliJ IDEA и выполнить в терминале:
```
gradle clean test
```

или 

```
gradle clean test -Denv=local
```

#### WEB

```
gradle clean web
```


#### API
```
gradle clean api 
```

#### Mobile

```
gradle clean android -DdeviceHost=${DEVICE_HOST}
```
Для запуска мобильных тестов нужно определить значение envMobile:
- [ ] <code>-DdeviceHost=browserstack</code> : тесты будут запущены в облачной платформе <a target="_blank" href="https://www.browserstack.com/"> Browserstack </a> 
- [ ] <code>-DdeviceHost=emulator</code> : тесты будут запущены в эмуляторе, созданном средствами Appium Server & Appium Inspector. <br/> <a target="_blank" href="https://autotest.how/appium-setup-for-local-android-tutorial-md"> Инструкция по настройке </a> 
- [ ] <code>-DdeviceHost=real</code> : тесты будут запущены на устройстве, подключенному по usb. <br/> Так же требуется настройка Appium Server & Appium Inspector

<details>
   <summary>Дополнительные команды:</summary>
  
1. Выполнить запрос на формирование отчета:
```
gradle allureReport
```
2. Открыть отчет в браузере:
```
gradle allureServe
```

</details>

### Удаленный запуск тестов
Тесты можно запустить из терминала IntelliJ IDEA, а выполнены они будут в удаленно запущенном браузере в Docker-контейнере Selenoid:

```
gradle clean test -Denv=remote
```

## Cборка тестов в <b><a target="_blank" href="https://jenkins.autotests.cloud/job/C30-mentiza-diploma/">Jenkins</a></b>

>Для запуска сборки необходимо перейти в раздел `Build with Parameters` и нажать кнопку `Build`

<img src="images/screenshots/jenkins-project.png">

> Сборка с параметрами позволяет перед запуском задать нужные параметры для сборки:

<p align="center">
<img src="images/screenshots/jenkins-build.png"/>
</p>

## Интеграция с <b><a target="_blank" href="https://jenkins.autotests.cloud/job/C30-mentiza-diploma/allure/">Allure report</a></b>
#### Диаграммы прохождения тестов
`ALLURE REPORT` - отображает дату и время теста, общее количество запущенных тестов, а также диаграмму с процентом и количеством успешных, упавших и сломавшихся в процессе выполнения тестов <br/>
`TREND` - отображает тенденцию выполнения тестов для всех запусков <br/>
`SUITES` - отображает распределение тестов по сьютам <br/>
`CATEGORIES` - отображает распределение неудачных тестов по типам дефектов

<img src="images/screenshots/allure-main-report.png">

#### Развернутый результат прохождения тестов:
1. Общий список автотестов
2. Содержание автотеста
3. Вложения
<img src="images/screenshots/allure-suites.png">


## Интеграция с <b><a target="_blank" href="https://allure.autotests.cloud/project/4579/dashboards">Allure TestOps</a></b>

>Диаграммы прохождения тестов
>
<img src="images/screenshots/allure-testops-dashboards.png">

## Интеграция с <b><a target="_blank" href="https://jira.autotests.cloud/browse/HOMEWORK-1387">Jira</a></b>

>В Jira создана задача
>
<img src="images/screenshots/jira-integration.png">

>В разделе `Allure:Test Cases` отображаются интегрированные автоматизированные и ручные тесты
<img src="images/screenshots/jira-with-allure-test-cases.png">

## Уведомления в Telegram с использованием бота

> Бот, созданный в Telegram, после завершения сборки отправляет сообщение с отчетом о прохождении тестов
> 
<img src="images/screenshots/telegram-notification.png">

## Пример выполнения теста в Selenoid

> К каждому UI-тесту в отчете прилагается видео
<p align="center">
  <img src="images/video/ui-test.gif">
</p>

> К каждому мобильному тесту, выполняемому в Browserstack, к отчету прилагается видео
<p align="center">
  <img src="images/video/mobile-test.gif">
</p>
