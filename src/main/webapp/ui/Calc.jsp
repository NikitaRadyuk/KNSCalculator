<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Регистрация</title>
</head>
<body>
<form action="${pageContext.request.contextPath}/calculator" method="GET">
<p style="text-align:center">Канализационная насосная станция</p>
        <label>Диаметр КНС внутренний:
                <c:set var="diamKNS"/>
                <p><input name="diamKNS" required="required" size="10" type="number" value="${diamKNS}"></p>
        </label>


<p>Приток 1:</p>

        <label><p>Отобразить:
                <c:set var="inf1visibility">
                <select name="inf1visibility" required="required" size="5">
                <option selected="selected" value="true">да</option><option value="false">нет</option></select></p>
        </label>

        <label><p>Угол поворота от востока, град:
                <c:set var="inf1Angle">
                <input maxlength="3" name="inf1Angle" required="required" size="4" type="text" value="${inf1Angle}" /></p>
        </label>

        <label><p>Ду,мм:
                <c:set var="diamInf1">
                <input name="diamInf1" required="required" size="10" type="text" value="${diamInf1}" /></p>
        </label>

        <label><p>Наличие мусороулавливающей корзины:
                <c:set var="trash1Visible">
                <select name="trash1Visible" required="required" size="5">
                <option selected="selected" value="true">да</option><option value="false">нет</option></select></p>
        </label>

<p>Приток 2:</p>

        <label><p>Отобразить:
                <c:set var="inf2visibility">
                <select name="inf2visibility" required="required" size="5">
                <option selected="selected" value="true">да</option><option value="false">нет</option></select></p>
        </label>

        <label><p>Угол поворота от востока, град:
                <c:set var="inf2Angle">
                <input maxlength="3" name="inf2Angle" required="required" size="4" type="text" value="${inf2Angle}" /></p>
        </label>

        <label><p>Ду,мм:
                <c:set var="diamInf2">
                <input name="diamInf2" required="required" size="10" type="text" value="${diamInf2}" /></p>
        </label>

        <label><p>Наличие мусороулавливающей корзины:
                <set var="trash2Visible">
                <select name="trash2Visible" required="required" size="5">
                    <option value="true" selected>да</option>
                    <option value="false">нет</option>
                </select></p>
        </label>

<p>Напорные линии:</p>

         <label><p>Ду,мм:
                        <c:set var="diamPressureLines">
                        <input name="diamPressureLines" required="required" size="10" type="text" value="${diamPressureLines}" /></p>
         </label>

<p>Мусороулавливающая корзина:</p>

         <label><p>Длина,мм:
                         <c:set var="trashLength">
                         <input name="trashLength" required="required" size="10" type="text" value="${trashLength}" /></p>
         </label>

         <label><p>Глубина,мм:
                         <c:set var="trashDepth">
                         <input name="trashDepth" required="required" size="10" type="text" value="${trashDepth}" /></p>
         </label>

          <label><p>Ширина,мм:
                         <c:set var="trashHeight">
                         <input name="trashHeight" required="required" size="10" type="text" value="${trashHeight}" /></p>
          </label>

<p>Насосы на трубной муфте:</p>

          <label><p>Расстояние от оси колодца до оси насоса,мм:
                         <c:set var="wellToPumpAxes">
                         <input name="wellToPumpAxes" required="required" size="10" type="text" value="${wellToPumpAxes}" /></p>
          </label>

          <label><p>Расстояние от оси напора до оси насоса,мм:
                          <c:set var="pressureToPumpAxes">
                          <input name="pressureToPumpAxes" required="required" size="10" type="text" value="${pressureToPumpAxes}" /></p>
          </label>

          <label><p>Диаметр насоса,мм:
                           <c:set var="diamPump">
                           <input name="diamPump" required="required" size="10" type="text" value="${diamPump}" /></p>
          </label>

          <label><p>Ду напорного патрубка,мм:
                           <c:set var="diamPipeBranch">
                           <input name="diamPipeBranch" required="required" size="10" type="text" value="${diamPipeBranch}" /></p>
          </label>



<p><input type="submit" value="Отрисовать" /></p>
</form>

${requestScope.svgData}
</body>