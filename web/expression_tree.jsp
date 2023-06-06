<%@page import="java.util.List" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="./css/expression_tree.css">
        <title>Expression tree</title>
    </head>

    <body>

        <div class="main-container">
            <div id="itt-logo">
                <img src="./images/logo_tec_tapa.png" alt="tecnolÃ³gico de tapachula logo">
            </div>


            <div id="tecnm-logo">
                <img src="./images/logo_tecnm.png" alt="tecnm logo">
            </div>



            <div id="place-button">
                <form action="PrefixNotation" method="post">

                    <div id="insert-expression">
                        <input  type="text" placeholder="Enter arithmetic expression" name="infix-notation" id="input-expression">
                    </div>

                    <button type="submit" id="generete" class="generate">Resolve</button>

                </form>

            </div>

            <ul>
                <%
                
                List<String> fullStack = (List<String>)
                        (request.getAttribute("prefix"));
                
                if(fullStack!=null){
                for (String string : fullStack) {
                %>
                <div class="card">
                    <h2><%=string%></h2>
                </div>
                <%
                    }
    }
                %>
            </ul>


        </div>
    </body>

    <script src="./conversion.js"></script>
    <script src="./prefix_notation.js"></script>

</html>