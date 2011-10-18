; Script generated by the Inno Setup Script Wizard.
; SEE THE DOCUMENTATION FOR DETAILS ON CREATING INNO SETUP SCRIPT FILES!

#define MyAppName "CanReg5"
#define MyAppPublisher "IARC"
#define MyAppURL "http://www.iacr.com.fr"
#define MyAppExeName "CanReg.exe"
#include "inno-settings.txt"

[Setup]
; NOTE: The value of AppId uniquely identifies this application.
; Do not use the same AppId value in installers for other applications.
; (To generate a new GUID, click Tools | Generate GUID inside the IDE.)
AppId={{B8398F6C-55C8-40CC-9053-DBBA21741E39}
AppName={#MyAppName}
AppVersion={#MyAppVersion}
;AppVerName={#MyAppName} {#MyAppVersion}
AppPublisher={#MyAppPublisher}
AppPublisherURL={#MyAppURL}
AppSupportURL={#MyAppURL}
AppUpdatesURL={#MyAppURL}
DefaultDirName={pf}\{#MyAppName}
DefaultGroupName={#MyAppName}
OutputDir=C:\Documents and Settings\ervikm\My Documents\NetBeansProjects\CanReg\dist
InfoBeforeFile=C:\Documents and Settings\ervikm\My Documents\NetBeansProjects\CanReg\changelog.txt
LicenseFile=C:\Documents and Settings\ervikm\My Documents\NetBeansProjects\CanReg\src\canreg\client\gui\resources\gpl-3.0-standalone.txt
OutputBaseFilename=CanReg5-Setup
Compression=lzma
SolidCompression=yes

[Languages]
Name: "english"; MessagesFile: "compiler:Default.isl"
Name: "brazilianportuguese"; MessagesFile: "compiler:Languages\BrazilianPortuguese.isl"
Name: "french"; MessagesFile: "compiler:Languages\French.isl"
Name: "russian"; MessagesFile: "compiler:Languages\Russian.isl"
Name: "spanish"; MessagesFile: "compiler:Languages\Spanish.isl"

[Tasks]
Name: "desktopicon"; Description: "{cm:CreateDesktopIcon}"; GroupDescription: "{cm:AdditionalIcons}"; Flags: unchecked

[Files]
Source: "C:\Documents and Settings\ervikm\My Documents\NetBeansProjects\CanReg\CanReg.exe"; DestDir: "{app}"; Flags: ignoreversion
Source: "C:\Documents and Settings\ervikm\My Documents\NetBeansProjects\CanReg\conf\*"; DestDir: "{app}\conf"; Flags: ignoreversion recursesubdirs createallsubdirs
Source: "C:\Documents and Settings\ervikm\My Documents\NetBeansProjects\CanReg\demo\*"; DestDir: "{app}\demo"; Flags: ignoreversion recursesubdirs createallsubdirs
Source: "C:\Documents and Settings\ervikm\My Documents\NetBeansProjects\CanReg\dist\lib\*"; DestDir: "{app}\lib"; Flags: ignoreversion recursesubdirs createallsubdirs
Source: "C:\Documents and Settings\ervikm\My Documents\NetBeansProjects\CanReg\dist\CanReg.jar"; DestDir: "{app}"; Flags: ignoreversion
Source: "C:\Documents and Settings\ervikm\My Documents\NetBeansProjects\CanReg\dist\README.TXT"; DestDir: "{app}"; Flags: ignoreversion
Source: "C:\Documents and Settings\ervikm\My Documents\NetBeansProjects\CanReg\changelog.txt"; DestDir: "{app}"; Flags: ignoreversion
Source: "C:\Documents and Settings\ervikm\My Documents\NetBeansProjects\CanReg\doc\CanReg5-Instructions\CanReg5-Instructions.pdf"; DestDir: "{app}\doc"; Flags: ignoreversion
; NOTE: Don't use "Flags: ignoreversion" on any shared system files

[Icons]
Name: "{group}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"
Name: "{commondesktop}\{#MyAppName}"; Filename: "{app}\{#MyAppExeName}"; Tasks: desktopicon

[Run]
Filename: "{app}\{#MyAppExeName}"; Description: "{cm:LaunchProgram,{#StringChange(MyAppName, "&", "&&")}}"; Flags: nowait postinstall skipifsilent

