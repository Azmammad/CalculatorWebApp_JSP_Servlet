<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>My Calculator</title>
</head>
<body>
    <div align="center">
        <h1>Web Calculator</h1>
        <form action="calculate" method="post">
            <p>
                Input number one<input type="number" name="a" required/>
            </p>
            <p>
                Input number two<input type="number" name="b" required/>
            </p>
            <p>
                Select operation:
                <select name="operation">
                    <option value="add">Addition (+)</option>
                    <option value="subtract">Subtraction (-)</option>
                    <option value="multiply">Multiplication (*)</option>
                    <option value="divide">Division (/)</option>
                    <option value="modulus">Modulus (%)</option>
                    <option value="power">Exponentiation (A^B)</option>
                    <option value="sqrtA">Square Root of A (√A)</option>
                    <option value="sqrtB">Square Root of B (√B)</option>
                </select>
            </p>
            <p>
               <input type="submit" name="RUN" value="RUN" />
            </p>
        </form>
    </div>
</body>
</html>