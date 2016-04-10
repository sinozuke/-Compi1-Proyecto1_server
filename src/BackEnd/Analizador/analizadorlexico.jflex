package BackEnd.Analizador;

import java_cup.runtime.Symbol;
import java.util.*;

             
%%

%cupsym Simbolo
%class Lexico_Proyecto
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
Correo = ([A-Za-zÑñ]|[0-9]|\_|\-)+"@compi1.com"	

cadena = [\"] [^\"]* [\"] 
ComentarioLinea = "//"([^\n\t])*(\t|\n) 
ComentarioMultilinea= "#*" ([^*#]|[*])* "*#"
Hacer = [\"]"crear"[\"]
Modi = ([\"]"modificar"[\"]|[\"]"modificación"[\"])
Borrar = [\"]"eliminar"[\"]
Tiendas =[\"]"tiendas"[\"]
Productos = [\"]"productos"[\"]
%%


"cons"        		{return new Symbol(Simbolo.Constante, yycolumn,yyline,yytext()); }
"$"                     {return new Symbol(Simbolo.InstrucI, yycolumn,yyline,yytext()); }
"-$"			{return new Symbol(Simbolo.InstrucF, yycolumn,yyline,yytext()); }
"lista"         	{return new Symbol(Simbolo.ListaI, yycolumn,yyline,yytext()); }
"lista-"        	{return new Symbol(Simbolo.ListaF, yycolumn,yyline,yytext()); }
"get"        		{return new Symbol(Simbolo.GetI, yycolumn,yyline,yytext()); }
"request-" 		{return new Symbol(Simbolo.RequestF, yycolumn,yyline,yytext());}
"request"  		{return new Symbol(Simbolo.RequestI, yycolumn,yyline,yytext());}
"InicioUsuario" 	{return new Symbol(Simbolo.InicioUsuarioI, yycolumn,yyline,yytext()); }
"InicioUsuario-" 	{return new Symbol(Simbolo.InicioUsuarioF, yycolumn,yyline,yytext()); }
"id"             	{return new Symbol(Simbolo.IdI, yycolumn,yyline, yytext()); }
"id-"           	{return new Symbol(Simbolo.IdF, yycolumn,yyline,yytext()); }
"sucursal"              {return new Symbol(Simbolo.SucursalI, yycolumn,yyline,yytext()); }
"sucursal-"             {return new Symbol(Simbolo.SucursalF, yycolumn,yyline,yytext()); }
"password-"          	{return new Symbol(Simbolo.PasswordF, yycolumn,yyline,yytext()); }
"password"           	{return new Symbol(Simbolo.PasswordI, yycolumn,yyline,yytext()); }
"reply-"           	{return new Symbol(Simbolo.ReplyF, yycolumn,yyline,yytext()); }
"reply"           	{return new Symbol(Simbolo.ReplyI, yycolumn,yyline,yytext()); }
"Usuario-"           	{return new Symbol(Simbolo.UsuarioF, yycolumn,yyline,yytext()); }
"Usuario"           	{return new Symbol(Simbolo.UsuarioI, yycolumn,yyline,yytext()); }
"access"           	{return new Symbol(Simbolo.AccessI, yycolumn,yyline,yytext()); }
"access-"           	{return new Symbol(Simbolo.AccessF, yycolumn,yyline,yytext()); }
"True"                  {return new Symbol(Simbolo.Boolean, yycolumn,yyline,yytext()); }
"Falso"                 {return new Symbol(Simbolo.Boolean, yycolumn,yyline,yytext()); }
"Fail"                  {return new Symbol(Simbolo.Boolean, yycolumn,yyline,yytext()); }
"CrearUsuario"      	{return new Symbol(Simbolo.CrearUsuarioI, yycolumn,yyline,yytext()); }
"CrearUsuario-"      	{return new Symbol(Simbolo.CrearUsuarioF, yycolumn,yyline,yytext()); }
"nombre"                {return new Symbol(Simbolo.NombreI, yycolumn,yyline,yytext()); }
"nombre-"               {return new Symbol(Simbolo.NombreF, yycolumn,yyline,yytext()); }
"apellido"      	{return new Symbol(Simbolo.ApellidoI, yycolumn,yyline,yytext()); }
"apellido-"      	{return new Symbol(Simbolo.ApellidoF, yycolumn,yyline,yytext()); }
"telefono"      	{return new Symbol(Simbolo.TelefonoI, yycolumn,yyline,yytext()); }
"telefono-"      	{return new Symbol(Simbolo.TelefonoF, yycolumn,yyline,yytext()); }
"email"                 {return new Symbol(Simbolo.EmailI, yycolumn,yyline,yytext()); }
"email-"                {return new Symbol(Simbolo.EmailF, yycolumn,yyline,yytext()); }
"registro"              {return new Symbol(Simbolo.RegistroI, yycolumn,yyline,yytext()); }
"registro-"             {return new Symbol(Simbolo.RegistroF, yycolumn,yyline,yytext()); }
"eliminar"              {return new Symbol(Simbolo.EliminacionI, yycolumn,yyline,yytext()); }
"eliminar-"             {return new Symbol(Simbolo.EliminacionF, yycolumn,yyline,yytext()); }
"dirección"      	{return new Symbol(Simbolo.DireccionI, yycolumn,yyline,yytext()); }
"dirección-"      	{return new Symbol(Simbolo.DireccionF, yycolumn,yyline,yytext()); }
"tienda"          	{return new Symbol(Simbolo.TiendaI, yycolumn,yyline,yytext()); }
"tienda-"       	{return new Symbol(Simbolo.TiendaF, yycolumn,yyline,yytext()); }
"código"                {return new Symbol(Simbolo.CodigoI, yycolumn,yyline,yytext()); }
"código-"               {return new Symbol(Simbolo.CodigoF, yycolumn,yyline,yytext()); }
"propietario"      	{return new Symbol(Simbolo.PropietarioI, yycolumn,yyline,yytext()); }
"propietario-"      	{return new Symbol(Simbolo.PropietarioF, yycolumn,yyline,yytext()); }
"img"           	{return new Symbol(Simbolo.ImagenI, yycolumn,yyline,yytext()); }
"img-"                  {return new Symbol(Simbolo.ImagenF, yycolumn,yyline,yytext()); }
"tipo"          	{return new Symbol(Simbolo.Tipo, yycolumn,yyline,yytext()); }
"modificar"          	{return new Symbol(Simbolo.ModificarI, yycolumn,yyline,yytext()); }
"modificar-"          	{return new Symbol(Simbolo.ModificarF, yycolumn,yyline,yytext()); }
"Ptn"     		{return new Symbol(Simbolo.Potencia, yycolumn,yyline,yytext()); }
"Rq"     		{return new Symbol(Simbolo.Raiz, yycolumn,yyline,yytext()); }
"*"     	    	{return new Symbol(Simbolo.Multiplicacion, yycolumn,yyline,yytext()); }
"/"     	    	{return new Symbol(Simbolo.Division, yycolumn,yyline,yytext()); }
"+"                     {return new Symbol(Simbolo.Suma, yycolumn,yyline,yytext()); }
"-"                     {return new Symbol(Simbolo.Resta, yycolumn,yyline,yytext()); }
"producto"              {return new Symbol(Simbolo.ProductoI, yycolumn,yyline,yytext()); }
"producto-"             {return new Symbol(Simbolo.ProductoF, yycolumn,yyline,yytext()); }
"cantidad"              {return new Symbol(Simbolo.CantidadI, yycolumn,yyline,yytext()); }
"cantidad-"             {return new Symbol(Simbolo.CantidadF, yycolumn,yyline,yytext()); }
"marca"                 {return new Symbol(Simbolo.MarcaI, yycolumn,yyline,yytext()); }
"marca-"                {return new Symbol(Simbolo.MarcaF, yycolumn,yyline,yytext()); }
"color"                 {return new Symbol(Simbolo.ColorI, yycolumn,yyline,yytext()); }
"color-"                {return new Symbol(Simbolo.ColorF, yycolumn,yyline,yytext()); }
"tamaño"                {return new Symbol(Simbolo.TamanoI, yycolumn,yyline,yytext()); }
"tamaño-"               {return new Symbol(Simbolo.TamanoF, yycolumn,yyline,yytext()); }
";"                     {return new Symbol(Simbolo.PUNTOYCOMA, yycolumn,yyline,yytext()); }
{numero}                {return new Symbol(Simbolo.Numero, yycolumn,yyline,yytext()); }
","                     {return new Symbol(Simbolo.Coma, yycolumn,yyline,yytext()); }
"="                     {return new Symbol(Simbolo.Igual, yycolumn,yyline,yytext()); }
"["                     {return new Symbol(Simbolo.CorcheteI,yycolumn,yyline,yytext()); }
"]"                     {return new Symbol(Simbolo.CorcheteF, yycolumn,yyline,yytext()); }
"("			{return new Symbol(Simbolo.ParentesisI, yycolumn,yyline,yytext()); }
")"			{return new Symbol(Simbolo.ParentesisF, yycolumn,yyline,yytext()); }
"{"			{return new Symbol(Simbolo.LlavesI, yycolumn,yyline,yytext()); }
"}"			{return new Symbol(Simbolo.LlavesF, yycolumn,yyline,yytext()); }
"mate"        		{return new Symbol(Simbolo.MateI, yycolumn,yyline,yytext()); }
"mate-"        		{return new Symbol(Simbolo.MateF, yycolumn,yyline,yytext()); }
"query"             	{return new Symbol(Simbolo.ConsultaI ,yycolumn,yyline,yytext()); }
"query-"          	{return new Symbol(Simbolo.ConsultaF, yycolumn,yyline,yytext()); }
"Vacio"         	{return new Symbol(Simbolo.ATRVACIO, yycolumn,yyline,yytext()); }
"%%"            	{return new Symbol(Simbolo.AND, yycolumn,yyline,yytext()); }
"##"             	{return new Symbol(Simbolo.OR, yycolumn,yyline,yytext()); }
"N"               	{return new Symbol(Simbolo.NOT, yycolumn,yyline,yytext()); }
"Extraer"        	{return new Symbol(Simbolo.Extraer, yycolumn,yyline,yytext()); }
"de"             	{return new Symbol(Simbolo.De, yycolumn,yyline,yytext()); }
"donde"          	{return new Symbol(Simbolo.Donde, yycolumn,yyline,yytext()); }
{Hacer}    		{return new Symbol(Simbolo.CREACION, yycolumn,yyline,yytext()); }
{Modi}  		{return new Symbol(Simbolo.MODIFICACION, yycolumn,yyline,yytext()); }
{Borrar}    		{return new Symbol(Simbolo.ELIMINACION, yycolumn,yyline,yytext()); }
{Tiendas}    		{return new Symbol(Simbolo.PIDIENDOTIENDAS, yycolumn,yyline,yytext()); }
{Productos}    		{return new Symbol(Simbolo.PIDIENDOPRODUCTOS, yycolumn,yyline,yytext()); }
{cadena}		{	String Cadenita=yytext();
                     		Cadenita = Cadenita.substring(1,Cadenita.length()-1);
 				System.out.println(Cadenita);
				return new Symbol(Simbolo.Cadena, yycolumn,yyline,Cadenita);
			}
{Correo}                {return new Symbol(Simbolo.CorreoE, yycolumn,yyline,yytext()); }
{Variable}		{return new Symbol(Simbolo.Identificador, yycolumn,yyline,yytext()); }


{ComentarioLinea}       {}
[ \t\r\f\n]+		{}
.			{ }