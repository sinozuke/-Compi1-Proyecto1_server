package BackEnd.Analizador.Consola;

import java_cup.runtime.Symbol;

%%

%cupsym Simbolo
%class Lexico_Request_consola
%cup
%public
%unicode
%line
%char
%column

%{
		
%}

Variable = [a-zA-ZÑñ]([a-zA-ZÑñ]|[0-9]|\_)*
numero =[0-9] "."? [0-9]*
Correo = ([A-Za-zÑñ]|[0-9]|\_|\-)+"@compi1.com"	

cadena = [\"] [^\"]* [\"] 
ComentarioLinea = "//"([^\n\t])*(\t|\n) 
ComentarioMultilinea= "#*" ([^*#]|[*])* "*#"
Hacer = [\"]"crear"[\"]
Modi = ([\"]"modificar"[\"]|[\"]"modificacion"[\"])
Borrar = [\"]"eliminar"[\"]
%%


"cons"        		{return new Symbol(Simbolo.constante, yycolumn,yyline,yytext()); }
"$"                     {return new Symbol(Simbolo.DI, yycolumn,yyline,yytext()); }
"-$"			{return new Symbol(Simbolo.DF, yycolumn,yyline,yytext()); }
"get"        		{return new Symbol(Simbolo.get, yycolumn,yyline,yytext()); }
"request"  		{return new Symbol(Simbolo.request, yycolumn,yyline,yytext());}
"InicioUsuario" 	{return new Symbol(Simbolo.iniciousuario, yycolumn,yyline,yytext()); }
"id"             	{return new Symbol(Simbolo.id, yycolumn,yyline, yytext()); }
"sucursal"              {return new Symbol(Simbolo.sucursal, yycolumn,yyline,yytext()); }
"password"           	{return new Symbol(Simbolo.password, yycolumn,yyline,yytext()); }
"Usuario"           	{return new Symbol(Simbolo.usuario, yycolumn,yyline,yytext()); }
"CrearUsuario"      	{return new Symbol(Simbolo.crearusuario, yycolumn,yyline,yytext()); }
"nombre"                {return new Symbol(Simbolo.nombre, yycolumn,yyline,yytext()); }
"apellido"      	{return new Symbol(Simbolo.apellido, yycolumn,yyline,yytext()); }
"telefono"      	{return new Symbol(Simbolo.telefono, yycolumn,yyline,yytext()); }
"email"                 {return new Symbol(Simbolo.email, yycolumn,yyline,yytext()); }
"direccion"      	{return new Symbol(Simbolo.direccion, yycolumn,yyline,yytext()); }
"tienda"          	{return new Symbol(Simbolo.tienda, yycolumn,yyline,yytext()); }
"codigo"                {return new Symbol(Simbolo.codigo, yycolumn,yyline,yytext()); }
"propietario"      	{return new Symbol(Simbolo.propietario, yycolumn,yyline,yytext()); }
"img"           	{return new Symbol(Simbolo.imagen, yycolumn,yyline,yytext()); }
"tipo"          	{return new Symbol(Simbolo.tipo, yycolumn,yyline,yytext()); }
"Ptn"     		{return new Symbol(Simbolo.potencia, yycolumn,yyline,yytext()); }
"Rq"     		{return new Symbol(Simbolo.raiz, yycolumn,yyline,yytext()); }
"*"     	    	{return new Symbol(Simbolo.multiplicacion, yycolumn,yyline,yytext()); }
"/"     	    	{return new Symbol(Simbolo.division, yycolumn,yyline,yytext()); }
"+"                     {return new Symbol(Simbolo.suma, yycolumn,yyline,yytext()); }
"-"                     {return new Symbol(Simbolo.resta, yycolumn,yyline,yytext()); }
"producto"              {return new Symbol(Simbolo.producto, yycolumn,yyline,yytext()); }
"cantidad"              {return new Symbol(Simbolo.cantidad, yycolumn,yyline,yytext()); }
"marca"                 {return new Symbol(Simbolo.marca, yycolumn,yyline,yytext()); }
"color"                 {return new Symbol(Simbolo.color, yycolumn,yyline,yytext()); }
"tamaño"                {return new Symbol(Simbolo.tamano, yycolumn,yyline,yytext()); }
";"                     {return new Symbol(Simbolo.pyc, yycolumn,yyline,yytext()); }
{numero}                {return new Symbol(Simbolo.numero, yycolumn,yyline,yytext()); }
","                     {return new Symbol(Simbolo.coma, yycolumn,yyline,yytext()); }
"="                     {return new Symbol(Simbolo.igual, yycolumn,yyline,yytext()); }
"["                     {return new Symbol(Simbolo.corchetei,yycolumn,yyline,yytext()); }
"]"                     {return new Symbol(Simbolo.corchetef, yycolumn,yyline,yytext()); }
"("			{return new Symbol(Simbolo.parentesisi, yycolumn,yyline,yytext()); }
")"			{return new Symbol(Simbolo.parentesisf, yycolumn,yyline,yytext()); }
"{"			{return new Symbol(Simbolo.llavesi, yycolumn,yyline,yytext()); }
"}"			{return new Symbol(Simbolo.llavesf, yycolumn,yyline,yytext()); }
"mate"        		{return new Symbol(Simbolo.mate, yycolumn,yyline,yytext()); }
"query"             	{return new Symbol(Simbolo.consulta ,yycolumn,yyline,yytext()); }
"Vacio"         	{return new Symbol(Simbolo.avacio, yycolumn,yyline,yytext()); }
"%%"            	{return new Symbol(Simbolo.AND, yycolumn,yyline,yytext()); }
"##"             	{return new Symbol(Simbolo.OR, yycolumn,yyline,yytext()); }
"N"               	{return new Symbol(Simbolo.NOT, yycolumn,yyline,yytext()); }
"Extraer"        	{return new Symbol(Simbolo.extraer, yycolumn,yyline,yytext()); }
"de"             	{return new Symbol(Simbolo.de, yycolumn,yyline,yytext()); }
"donde"          	{return new Symbol(Simbolo.donde, yycolumn,yyline,yytext()); }
{Hacer}    		{return new Symbol(Simbolo.CREACION, yycolumn,yyline,yytext()); }
{Modi}  		{return new Symbol(Simbolo.MODIFICACION, yycolumn,yyline,yytext()); }
{Borrar}    		{return new Symbol(Simbolo.ELIMINACION, yycolumn,yyline,yytext()); }
{cadena}		{return new Symbol(Simbolo.cadena, yycolumn,yyline,yytext());}
{Correo}                {return new Symbol(Simbolo.correo, yycolumn,yyline,yytext()); }
{Variable}		{return new Symbol(Simbolo.identificador, yycolumn,yyline,yytext()); }


{ComentarioLinea}       {}
{ComentarioMultilinea}  {}
[ \t\r\f\n]+		{}
.			{}