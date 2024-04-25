@echo off
echo.
echo [��Ϣ] ʹ�� Vue CLI �������� Web ���̡�
echo.

%~d0
cd %~dp0

cd ..
set NODE_OPTIONS=--openssl-legacy-provider
npm run dev

pause
