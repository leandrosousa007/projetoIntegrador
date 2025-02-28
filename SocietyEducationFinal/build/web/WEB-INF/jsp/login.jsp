<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="pt-BR">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Tela de Login</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css" rel="stylesheet">
    <style>
        body {
            background-color: #f8f9fa;
        }
        .login-container {
            max-width: 400px;
            margin: auto;
            padding: 20px;
            border: 1px solid #ddd;
            border-radius: 8px;
            background-color: #fff;
            box-shadow: 0 4px 8px rgba(0, 0, 0, 0.1);
            margin-top: 100px;
        }
    </style>
</head>
<body>
    <div class="login-container">
        <h2 class="text-center">Login</h2>
        
        <!-- Formulário de login integrado com Spring MVC -->
        <form:form action="${pageContext.request.contextPath}/login" method="post" modelAttribute="funcionario">
            <div class="mb-3">
                <label for="login" class="form-label">Usuário</label>
                <form:input path="login" type="text" class="form-control" id="login" required="true" />
            </div>
            <div class="mb-3">
                <label for="senha" class="form-label">Senha</label>
                <form:password path="senha" class="form-control" id="senha" required="true" />
            </div>
            
            <!-- Exibe mensagens de erro ou sucesso -->
            <c:if test="${mensagem != null}">
                <div class="alert alert-danger" role="alert">
                    ${mensagem}
                </div>
            </c:if>

            <button type="submit" class="btn btn-primary w-100">Entrar</button>
        </form:form>
    </div>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
