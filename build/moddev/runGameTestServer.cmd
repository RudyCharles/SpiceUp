@echo off
setlocal
for /f "tokens=2 delims=:." %%x in ('chcp') do set _codepage=%%x
chcp 65001>nul
cd C:\Users\user\IdeaProjects\SpiceUp\run
C:\Users\user\.jdks\temurin-21.0.5\bin\java.exe @C:\Users\user\IdeaProjects\SpiceUp\build\moddev\gameTestServerRunClasspath.txt @C:\Users\user\IdeaProjects\SpiceUp\build\moddev\gameTestServerRunVmArgs.txt -Dfml.modFolders=spiceup%%%%C:\Users\user\IdeaProjects\SpiceUp\build\classes\java\main;spiceup%%%%C:\Users\user\IdeaProjects\SpiceUp\build\resources\main net.neoforged.devlaunch.Main @C:\Users\user\IdeaProjects\SpiceUp\build\moddev\gameTestServerRunProgramArgs.txt
if not ERRORLEVEL 0 (  echo Minecraft failed with exit code %ERRORLEVEL%  pause)
chcp %_codepage%>nul
endlocal