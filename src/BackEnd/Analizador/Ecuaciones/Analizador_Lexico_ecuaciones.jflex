package BackEnd.Analizador.Ecuaciones;

import java_cup.runtime.Symbol;

%%

%cupsym Simbolo
%class Lexico_ecuaciones
%cup
%public
%unicode
%line
%char
%column

%{
		
%}

Variable = [a-zA-ZÑñ]([a-zA-ZÑñ]|[0-9]|\_)*
numero =[0-9]+ "."? [0-9]*
%%
"Ptn"     		{return new Symbol(Simbolo.potencia, yycolumn,yyline,yytext()); }
"Rq"     		{return new Symbol(Simbolo.raiz, yycolumn,yyline,yytext()); }
"*"     	    	{return new Symbol(Simbolo.multiplicacion, yycolumn,yyline,yytext()); }
"/"     	    	{return new Symbol(Simbolo.division, yycolumn,yyline,yytext()); }
"+"                     {return new Symbol(Simbolo.suma, yycolumn,yyline,yytext()); }
"-"                     {return new Symbol(Simbolo.resta, yycolumn,yyline,yytext()); }
{numero}                {return new Symbol(Simbolo.numero, yycolumn,yyline,yytext()); }
"["                     {return new Symbol(Simbolo.corchetei,yycolumn,yyline,yytext()); }
"]"                     {return new Symbol(Simbolo.corchetef, yycolumn,yyline,yytext()); }
"("			{return new Symbol(Simbolo.parentesisi, yycolumn,yyline,yytext()); }
")"			{return new Symbol(Simbolo.parentesisf, yycolumn,yyline,yytext()); }
"{"			{return new Symbol(Simbolo.llavesi, yycolumn,yyline,yytext()); }
"}"			{return new Symbol(Simbolo.llavesf, yycolumn,yyline,yytext()); }
","                     {return new Symbol(Simbolo.coma, yycolumn,yyline,yytext()); }
{Variable}		{return new Symbol(Simbolo.identificador, yycolumn,yyline,yytext()); }
