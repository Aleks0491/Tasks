call runcrud.bat
if "%ERRORLEVEL%" == "0" goto checkstatus
echo.
echo It is something wrong
goto fail

:checkstatus
tasklist /FI "NAZWA_OBRAZU eq %CATALINA_HOME%\bin\startup.bat" 2>NUL | find /I /N "%CATALINA_HOME%\bin\startup.bat">NUL
goto runapp

:runapp
start "" "C:\Program Files (x86)\Google\Chrome\Application\chrome.exe"  http://localhost:8080/crud/v1/task/getTasks
if "%ERRORLEVEL%" == "0" goto end
echo.
echo The application is running...
echo.
echo Upss...
goto fail

:fail
echo.
echo There were errors

:end
echo.
echo Work is successful