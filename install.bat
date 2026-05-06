@echo off
setlocal enabledelayedexpansion

set "APK_FILE="

for /f "delims=" %%i in ('dir /b /o-n GooseBuddy-v*.apk') do (
    set "APK_FILE=%%i"
    goto :found
)

:found
if not defined APK_FILE (
    echo APK файл не найден
    exit /b 1
)

echo Найден файл: %APK_FILE%

adb root
adb remount
adb push "%APK_FILE%" /system/priv-app/GooseBuddy/GooseBuddy.apk
adb reboot