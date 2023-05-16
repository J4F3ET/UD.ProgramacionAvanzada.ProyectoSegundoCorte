<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>Bootstrap demo</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-KK94CHFLLe+nY2dmCWGMq91rCGa5gtU4mk92HdvYe+M/SXH301p5ILy+dN9+nJOZ" crossorigin="anonymous">
  </head>
  <body>
      <div class = "container mt-4 col-lg-4">
          <div class ="card col-sm-10" >
              <div class = "card-body">
                  <form class="form-sign" action="Validar" method="POST">
                      <div class="form-group text-center">
                          <h3>Login</h3>
                          <img src="img/wizard cat.png" alt="70" width="170"/>
                          <label>Bienvenidos al sistema</label>
                      </div>
                      <div class="form-group">
                          <label>Usuario:</label>
                          <input type = "text" name="txtuser" class="form-control">
                      </div>
                      <div class="form-group">
                          <label>Password:</label>
                          <input type = "text" name="txtpassword" class="form-control">
                      </div>
                      <input type="submit" name="accion" value="Ingresar" class="btn btn-primary btn_block">
                  </form>
              </div>
          </div> 
      </div>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ENjdO4Dr2bkBIFxQpeoTz1HIcje39Wm4jDKdf19U8gI4ddQ3GYNS7NTKfAdVQSZe" crossorigin="anonymous"></script>
  </body>
</html>
