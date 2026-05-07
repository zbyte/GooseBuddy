[![CI](https://github.com/zbyte/GooseBuddy/actions/workflows/ci.yml/badge.svg)](https://github.com/zbyte/GooseBuddy/actions/workflows/ci.yml)
[![Release](https://github.com/zbyte/GooseBuddy/actions/workflows/release.yml/badge.svg)](https://github.com/zbyte/GooseBuddy/actions/workflows/release.yml)
# GooseBuddy

Android-приложение для головного устройства автомобиля GAC GS8 II, расширяющее штатную автоматизацию климата и обогревов.


Работает только на автомобилях с Android Auto и следующими прошивками:
- A60_ZD_B_AVN_S0_250417_00.01_R (ОД дорест 2024 - 2025)


## Возможности

- **Снижение скорости вентилятора** при включении обогрева переднего стекла скорость вентилятора автоматически уменьшается
- **Автоотключение обогрева переднего стекла** через заданное время.
- **Автоотключение обогрева руля** через заданное время.
- **Автоотключение подогрева сидений** через заданное время (единое для всех сидений).
- **Автосценарии обогрева после запуска двигателя** — включение обогревов переднего/заднего стекла, руля и сидений по пороговой температуре с задержкой между запусками.

> [!CAUTION]
> Установка и использование данного приложения осуществляются исключительно **на ваш страх и риск**. Авторы и участники проекта не несут ответственности за любые последствия, включая (но не ограничиваясь): нарушение работы головного устройства, потерю гарантии, повреждение автомобиля или его компонентов, а также любой иной прямой или косвенный ущерб. Перед установкой убедитесь, что вы понимаете, что делаете, и имеете возможность восстановить штатное состояние устройства.


## Установка

Скачать последнюю стабильную релизную версию apk можно вот тут: [![Latest Release](https://img.shields.io/github/v/release/zbyte/GooseBuddy)](https://github.com/zbyte/GooseBuddy/releases/latest)

### Вручную

Программа должа быть установлена в системный раздел `/system/priv-app/`

```bash
adb root
adb remount
adb push GooseBuddy-latest.apk /system/priv-app/GooseBuddy/GooseBuddy.apk
adb reboot
```

### Скриптом

В корне исходников лежит скрипт `install.bat`, в котором прописаны все те же самые команды. 

## Удаление

```bash
adb root
adb remount
adb shell rm -rf /system/priv-app/GooseBuddy/
adb reboot
```

## Сборка

### Требования

- JDK 17 (Temurin или любой совместимый)
- Android SDK (API 36 для сборки, минимальный поддерживаемый — API 28)
- Подключение к интернету для Gradle и JitPack

### Сборка debug-APK

```bash
./gradlew assembleDebug
```

APK будет в `app/build/outputs/apk/debug/`.

## Участие в разработке

PR приветствуются. Перед отправкой убедитесь, что:

- `./gradlew assembleDebug` успешно собирается
- `./gradlew testDebugUnitTest` проходит
- `./gradlew lintDebug` не добавляет новых ошибок

Шаблоны issue и PR — в `.github/`.

## Лицензия

[Apache License 2.0](LICENSE).
