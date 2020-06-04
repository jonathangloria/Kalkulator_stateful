<%-- 
    Document   : index
    Created on : May 22, 2020, 3:12:48 PM
    Author     : se7en
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Kalkulator Stateful</title>
    </head>
    <body>
        <h2>Kalkulator Stateful - Jonathan</h2>
        <form method="post" name="kalk" action="Kalkulator">
            <input type="text" readonly name="ans" value="${display}">
            <input type="text" readonly name="op" value="${display2}" style="width:50px"><br/>
            <input type="submit" name="reset" value="CE"><br/>
            <input type="button" name="number" value="7" onClick="document.kalk.ans.value+='7'">
            <input type="button" name="number" value="8" onClick="document.kalk.ans.value+='8'">
            <input type="button" name="number" value="9" onClick="document.kalk.ans.value+='9'">
            <input type="submit" name="Add" value="+"><br />
            <input type="button" name="number" value="4" onClick="document.kalk.ans.value+='4'">
            <input type="button" name="number" value="5" onClick="document.kalk.ans.value+='5'">
            <input type="button" name="number" value="6" onClick="document.kalk.ans.value+='6'">
            <input type="submit" name="Sub" value="-"><br />
            <input type="button" name="number" value="1" onClick="document.kalk.ans.value+='1'">
            <input type="button" name="number" value="2" onClick="document.kalk.ans.value+='2'">
            <input type="button" name="number" value="3" onClick="document.kalk.ans.value+='3'">
            <input type="submit" name="Mul" value="*"><br />
            <input type="button" value="." onClick="document.kalk.ans.value+='.'">
            <input type="button" name="number" value="0" onClick="document.kalk.ans.value+='0'">
            <input type="submit" name="Div" value=" /">
            <input type="submit" name="Res" value="="><br />
        </form>
    </body>
 </html>
