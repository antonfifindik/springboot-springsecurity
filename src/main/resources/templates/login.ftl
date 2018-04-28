
<!doctype html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <meta name="description" content="Пример на bootstrap 4: Пользовательская форма и дизайн для простой формы входа.">
    <meta name="author" content="">
    <link rel="icon" href="https://www.javacodegeeks.com/wp-content/uploads/2014/07/spring-security-project.png">

    <title>Страница входа</title>

    <!-- Bootstrap core CSS -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="css/signin.css" rel="stylesheet">
</head>

<body class="text-center">

<form class="form-signin" method="post">
    <input name="${_csrf.parameterName}" value="${_csrf.token}" type="hidden">
    <img class="mb-4" src="https://www.javacodegeeks.com/wp-content/uploads/2014/07/spring-security-project.png" alt="" width="72" height="72">
    <#if logout>
        <div class="alert alert-info" style="margin-top: 20px" role="alert">You've been logged out successfully.</div>
    </#if>
    <#if error>
        <div class="alert alert-danger" style="margin-top: 20px;" role="alert">Invalid Username or Password!</div>
    </#if>
    <h1 class="h3 mb-3 font-weight-normal">Please sign in</h1>
    <label for="username" class="sr-only">Username</label>
    <input type="username" id="username" class="form-control" placeholder="Username" name="username" required autofocus>
    <label for="password" class="sr-only">Password</label>
    <input type="password" id="password" class="form-control" placeholder="Password" name="password" required>
    <div class="checkbox mb-3">
        <label>
            <input type="checkbox" value="remember-me"> Remember me
        </label>
    </div>
    <button class="btn btn-lg btn-primary btn-block" style="margin-top: 20px" type="submit">Sign in</button>
    <p class="mt-5 mb-3 text-muted" style="margin-top: 20px">&copy; 2017-2018</p>
</form>
</body>
</html>
