<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<html>
<title>Калькулятор</title>
<body>
<hr>
<input type="text" size="25" name="monitor" value= ${monitorValue}>
<hr>

<%--таблица функционала--%>
<table>
    <tr>
        <td>
            <form action="/in/inputNumbers/plus" method="get">
                <button name="buttonPlus" type="submit" value= ${monitorValue}> +</button>
            </form>
        </td>
        <td>
            <form action="/in/inputNumbers/minus" method="get">
                <button name="buttonMinus" type="submit" value= ${monitorValue}> -</button>
            </form>
        </td>
        <td>
            <form action="/in/inputNumbers/multiply" method="get">
                <button name="buttonMultiply" type="submit" value= ${monitorValue}> * </button>
            </form>
        </td>
        <td>
            <form action="/in/inputNumbers/divide" method="get">
                <button name="buttonDivide" type="submit" value= ${monitorValue}> / </button>
            </form>
        </td>
        <td>
            <form action="/in/inputNumbers/result">
                <button name="buttonResult" type="submit" value= ${monitorValue}> = </button>
            </form>
        </td>
        <td>
            <form action="/in/clean">
                <button name="buttonResult" type="submit" value= ${monitorValue}> Clean </button>
            </form>
        </td>
    </tr>
</table>
<hr>

<%--таблица с цифрами--%>
<table>
    <c:forEach begin="0" end="8" step="1" varStatus="varStatus">
    <c:if test="${varStatus.current % 3 == 0}">
    <tr>
        </c:if>
        <td>
            <form action="/in/inputNumbers" method="get"><input type="submit" value=${varStatus.count}  name="number"></form>
        </td>
        </c:forEach>
    <tr>
        <td>
            <form action="/in/inputNumbers" method="get"><input type="submit" value="0"  name="number"></form>
        </td>
        <td>
            <form action="/in/inputNumbers" method="get"><input type="submit" value="."  name="number"></form>
        </td>
        <td>
           <form action="/in/convertInputNumberValue" method="get"><button name="buttonConvert" value=${monitorValue}> +/- </button></form>
        </td>
    </tr>
</table>
<hr>
<label> ${informationLabel} </label>
<hr>



</body>
</html>
