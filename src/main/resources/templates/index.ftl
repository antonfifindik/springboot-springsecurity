<html>
<head>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <style>
        .mrg {
            margin: 20px;
        }
    </style>
</head>
<body>
<div class="mrg">
    <h1 class="text-info">Hello World</h1>
    <div class="alert alert-success" role="alert">
        Вы успешно зашли! Токен: "${_csrf.token}"
    </div>
    <a href="/logout" class="btn-warning btn-lg">Log out</a>
</div>
</body>
</html>