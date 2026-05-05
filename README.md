# GooseBuddy

Android-приложение для головного устройства автомобиля GAC GS8 II, расширяющее штатную автоматизацию климата и обогревов.


Работает только на автомобилях с Android Auto и следующими прошивками:
- A60_ZD_B_AVN_S0_250417_00.01_R (ОД дорест 2024 - 2025)

[![CI](https://github.com/OWNER/GooseBuddy/actions/workflows/ci.yml/badge.svg)](https://github.com/OWNER/GooseBuddy/actions/workflows/ci.yml)
[![Release](https://github.com/OWNER/GooseBuddy/actions/workflows/release.yml/badge.svg)](https://github.com/OWNER/GooseBuddy/actions/workflows/release.yml)

## Возможности

- **Снижение скорости вентилятора** при включении обогрева переднего стекла скорость вентилятора автоматически уменьшается
- **Автоотключение обогрева переднего стекла** через заданное время.
- **Автоотключение обогрева руля** через заданное время.
- **Автоотключение подогрева сидений** через заданное время (единое для всех сидений).
- **Автосценарии обогрева после запуска двигателя** — включение обогревов переднего/заднего стекла, руля и сидений по пороговой температуре с задержкой между запусками.

## Установка

### Вручную

Программа должа быть установлена в системный раздел `/system/priv-app/`

```bash
adb root
adb remount
adb push app-debug.apk /system/priv-app/GooseBuddy/GooseBuddy.apk
adb reboot
```

### Скриптом

В корне исходников лежит скрипт `install.bat`, в котором прописаны все те же самые команды. 

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
