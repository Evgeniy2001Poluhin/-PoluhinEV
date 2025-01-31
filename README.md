# Сервис коротких ссылок

## Описание

Сервис коротких ссылок позволяет пользователям сокращать длинные URL-адреса, управлять ими и получать доступ к оригинальным ссылкам через короткие URL. Программа реализована на языке Java и использует консольный интерфейс для взаимодействия с пользователем.

## Функционал

- **Создание короткой ссылки**: Пользователь может ввести длинный URL и получить короткую ссылку.
- **Перенаправление**: При переходе по короткой ссылке пользователь перенаправляется на оригинальный длинный URL.
- **Лимит кликов**: Пользователь может задать лимит кликов для каждой короткой ссылки.
- **Просмотр истории**: Пользователь может просмотреть все созданные короткие ссылки.
- **Удаление короткой ссылки**: Пользователь может удалить существующую короткую ссылку.
- **Редактирование короткой ссылки**: Пользователь может изменить лимит кликов и время жизни для существующей короткой ссылки.
- **Обработка ошибок**: Программа обрабатывает недействительные URL и некорректный ввод.

## Установка

1. Убедитесь, что у вас установлен JDK (Java Development Kit) версии 8 или выше.
2. Клонируйте репозиторий на свой компьютер:

   ```bash
   git clone <URL_вашего_репозитория>
   ```

3. Перейдите в директорию проекта:

   ```bash
   cd <имя_папки_проекта>
   ```

4. Скомпилируйте проект:

   ```bash
   javac src/main/java/com/example/urlshortener/*.java
   ```

5. Запустите программу:

   ```bash
   java -cp src/main/java com.example.urlshortener.Main
   ```

## Использование

1. Запустите программу.
2. Выберите опцию из меню:
   - `1`: Создать короткую ссылку.
   - `2`: Просмотреть все сокращенные ссылки.
   - `3`: Удалить короткую ссылку.
   - `4`: Обновить короткую ссылку.
   - `5`: Выйти из программы.
3. Следуйте инструкциям на экране.

## Пример
1. Create Short URL
2. View Shortened URLs
Delete Short URL
Update Short URL
Exit
Choose an option: 1
Enter a long URL: https://www.example.com/some/long/url
Enter the limit of clicks (default is 10): 5
Shortened URL: http://short.url/abc12345
Redirecting...
Redirected to: https://www.exam
