// HookWindowsDemo.cpp : �������̨Ӧ�ó������ڵ㡣
//

#include "stdafx.h"
#include<windows.h>
#include<iostream>

typedef bool(*FUN)();

int main()
{
	HINSTANCE hDll = LoadLibrary(L"HookDllDemo.dll");
	if (hDll)
	{

		FUN fun = (FUN)GetProcAddress(hDll, "StartHook");
		if (fun)
		{
			fun(); //�¹���
		}

		char szInput[MAXBYTE] = {0};
		while (true)
		{
			std::cin >> szInput;
			if (0 == strcmp(szInput,"yes"))
			{
				break; //����yes ����
			}
		}

	}
	return 0;
}

