<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="row d-flex justify-content-between">
            <div class="col-sm-6">
                <form>
                    <div class="form-group">
                        <label>Dni</label>
                        <input type="text" name="txtDni" class="form-control">
                    </div>
                    <div class="form-group">
                        <label>IDEmpleado</label>
                        <input type="text" name="txtIdEmpleado" class="form-control">
                    </div>                      
                    <div class="form-group">
                        <label>Nombres</label>
                        <input type="text" name="txtNombres" class="form-control">
                    </div> 
                    <div class="form-group">
                        <label>Telefono</label>
                        <input type="text" name="txtTelefono" class="form-control">
                    </div> 
                    <div class="form-group">
                        <label>Estado</label>
                        <input type="text" name="txtEstado" class="form-control">
                    </div> 
                    <div class="form-group">
                        <label>Usuario</label>
                        <input type="text" name="txtUsuario" class="form-control">
                    </div>
                    <input type = "submit" name = "accion" value="Agregar" class="btn btn-info">
                </form>               
            </div>
        </div>
        <div class="col-sm-6">
            <table class="table table-hover">
              <tr>
                <th>DNI</th>
                <th>ID empleado</th>
                <th>NOMBRES</th>
                <th>TELEFONO</th>
                <th>ESTADO</th>
                <th>USER</th>
                <th>ACCIONES</th>
              </tr>
              <tr>
                <td>Dato 1</td>
                <td>Dato 2</td>
                <td>Dato 3</td>
                <td>Dato 1</td>
                <td>Dato 2</td>
                <td>Dato 3</td>
              </tr>
              <tr>
                <td>Dato 4</td>
                <td>Dato 5</td>
                <td>Dato 6</td>
                <td>Dato 1</td>
                <td>Dato 2</td>
                <td>Dato 3</td>
              </tr>
            </table>            
        </div>
        
        
        
        
    <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.14.3/dist/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.1.3/dist/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>        
    </body>
</html>
