# Команды для запуска тестов из терминала.

Для удаленного запуска с Browserstack:
```
./gradlew clean test -DdeviceHost=browserstack
```
Для запуска на эмуляторе Android Studio:
```
./gradlew clean test -DdeviceHost=emulation
```
Для запуска на локальном устройстве:
```
./gradlew clean test -DdeviceHost=real
```
