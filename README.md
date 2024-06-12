Задание
- Зарегистрировать аккаунт в browserstack.com
- Запустить автотест локально
- Разработать еще один автотест на открытие любой статьи
-* Разработать еще один автотест на iOS
-* Адаптировать TestBase / Driver для работы с двумя типами платформ - Android, iOS
- Вынести данные (логин, пароль, урл браузерстека и т.д.) в .properties с owner
- Сделать сборку в дженкинсе


Для запуска тестов на ОС android:
```shell
gradle clean android -Denv=android
```

Для запуска тестов на ОС ios:
```shell
gradle clean ios -Denv=ios
```

Для запуска тестов на ОС ios:
```shell
gradle clean ios -Denv=ios
```

* <a href="https://jenkins.autotests.cloud/job/Artemy-jzs-161_mobile_tests_26_browserstack/">Jenkins</a>

