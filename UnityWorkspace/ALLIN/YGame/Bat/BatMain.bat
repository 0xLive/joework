cls
rem ����

@echo off 
rem �رջ���

title BatMain , Author:joeshifu

rem ���ÿ���̨ǰ���ͱ�����ɫ
color 0a

mode con:cols=120 lines=40

rem Unity.exe��·��
set unityExePath="D:\Program Files\Unity\Editor\Unity.exe"

goto  MENU

:MENU
rem ��������������Ŀ¼
cd /d %~dp0 

rem echo.%~dp0
rem ��ǰ�̷���·��

rem echo.%cd%
rem ��ǰĿ¼

set currentpath=%cd%
rem echo.��ǰ·����:%currentpath%

cd..
set currentProjPath=%cd%
rem echo.��һ����Ŀ¼��:%currentpath%

cd..
set parent=%cd%
rem echo.�ʹ��빤��ͬ����Ŀ¼��:%parent%

rem ���ô��빤�̵�Ŀ¼ ProjectName �Զ��� eg.ShiHuanJueLOL
set codeProjPath=%parent%\ShiHuanJueLOL

echo.
echo.=========================================================
echo.
echo.    0.�˳�
echo.    1.[Windows]:������Դ����StreamingAssets/Windows�ļ����µ���Դ�����빤�̶�ӦĿ¼
echo.    2.[Android]:������Դ����StreamingAssets/Android�ļ����µ���Դ�����빤�̶�ӦĿ¼
echo.    3.[ALL]:������Դ����StreamingAssets��������Դ�����빤��
echo.    4.[Protobuf]:��.proto�����ļ�����.cs�ļ��������������빤��Scripts/Config/Protos(δ���)
echo.    5.���Windows64λƽ̨��AssetBundle
echo.
echo.=========================================================

set /p id=������:
if  "%id%" =="0" goto CMD0
if  "%id%" =="1" goto CMD1
if  "%id%" =="2" goto CMD2
if  "%id%" =="3" goto CMD3
if  "%id%" =="4" goto CMD4
if  "%id%" =="5" goto CMD5
pause

:CMD0
exit

:CMD1
rem ɾ�����빤���µľ���Դ�ļ���Windows��/s �ݹ�ɾ����Ŀ¼��/q ����ʾ
rd /s /q %codeProjPath%\Assets\StreamingAssets\Windows
md %codeProjPath%\Assets\StreamingAssets\Windows
rem del ֻ��ɾ���ļ�
rem del /s /q %codeProjPath%\Assets\StreamingAssets\*

rem ���п������� /y ���� /e �ݹ飬������Ŀ¼�Ϳ��ļ�
Xcopy "%currentProjPath%\Assets\StreamingAssets\Windows" "%codeProjPath%\Assets\StreamingAssets\Windows" /y /e 
goto  MENU

:CMD2
rd /s /q %codeProjPath%\Assets\StreamingAssets\Android
md %codeProjPath%\Assets\StreamingAssets\Android
Xcopy "%currentProjPath%\Assets\StreamingAssets\Android" "%codeProjPath%\Assets\StreamingAssets\Android" /y /e 
goto  MENU

:CMD3
Xcopy "%currentProjPath%\Assets\StreamingAssets" "%codeProjPath%\Assets\StreamingAssets" /y /e 
goto  MENU

:CMD4
rem ����protoתcs��������
call %currentpath%\proto2cs\proto2cs.bat 
goto  MENU

:CMD5
echo.[%time%] ���Ե� 
rem ��������ο�unitymanual Command line arguments
%unityExePath% -quit -batchmode -executeMethod Builder.BuildAssetBundle_Windows64 
echo.[%time%] ��� 
goto  MENU
