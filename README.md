Задание
1. Настроить рабочий стол:
Вариант 1:
- https://autotest.how/appium-setup-for-local-android-tutorial-md

Вариант 2:
- Установить android studio https://developer.android.com/studio
- Прописать настройки:
Параметры Path:
Windows:
%ANDROID_HOME%\tools
%ANDROID_HOME%\tools\bin
%ANDROID_HOME%\platform-tools
Одной строкой, можно скопировать и добавить в конец Path: ;%ANDROID_HOME%\tools;%ANDROID_HOME%\tools\bin;%ANDROID_HOME%\platform-tools

- В Android Studio -> SDK Manager скачать 11 андроид (если не скачан по умолчанию)
- В AVD Manager скачать образ Pixel 4 для 11 андроида (если не скачан по умолчанию)
-- Запустить эмулятор телефона, опробовать кнопки и функционал
- Установить node.js - https://nodejs.org/en/download
- Установить Appium Server https://github.com/appium/appium
sudo npm install -g appium@next
- Установить драйвер uiautomator2
sudo appium driver install --source=npm uiautomator2 (если команда не подходит - можно выполнить эту appium driver install uiautomator2)

- Установить Appium Ispector https://github.com/appium/appium-inspector
- Запустить Appium Server
appium server --base-path /wd/hub
2. Открыть Appium Inspector, подключиться к эмулятору
- Изучить функционал Appium Inspector, попробовать найти локатор
3. Разработать автотест на getting started (onboarding screen) в приложении википедии - пройти по 4м экранам, на каждом сделать проверку
4. Доработать возможность запуска на разных стендах (передать из командной строки -DdeviceHost=browserstack / emulation / real
Для каждого сделать драйвер и конфиг с owner

Для запуска тестов Browserstack на ОС android:
```shell
gradle clean android -DdeviceHost=browserstack -DenvMobile=android
```
Для запуска тестов на ОС ios:
```shell
gradle clean ios -DdeviceHost=browserstack -DenvMobile=ios
```
Для запуска тестов на эмуляторе:
```shell
gradle clean emulator -DdeviceHost=emulation -DenvMobile=emulator
```
