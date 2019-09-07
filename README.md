# TPV-Java-SQL
El proyecto es un TPV para un comercio de hostelería. El TPV se crea con un usuario “admin” cuya contraseña es “1234”, 
también se crea un cliente “Cliente” que será el seleccionado por defecto.

El programa se inicia con una ventana de validación de usuarios, sin un usuario valido no se podrá usar. 
A modo de recordatorio del usuario validado, este será mostrado en el título de la ventana. 
Los usuarios que no sean “admin” solo podrán acceder a la función de ventas. El usuario “admin” será el único que pueda realizar 
cambios en el resto de empleados, en las familias y sus productos y quien podrá ver las facturas y eliminarlas. En caso de editar 
un empleado se requerirá la contraseña antigua del empleado (siendo empleado en activo tendría que ser conocedor de los cambios 
que sufra), pero se podrán crear y eliminar empleados libremente por “admin”. El usuario “admin” no admite cambios. Los empleados 
han de tener nombre y apellidos. 

Para poder crear un producto primero ha de existir una familia a la que vincularlo. Se añaden unas imágenes en la ruta del proyecto 
para que sea más sencillo añadirles un icono tanto a las familias como a los productos. Eliminar una familia con productos no 
elimina los productos, por si en un futuro se vuelve a crear dicha familia, simplemente no serán accesibles desde la función de 
ventas, si se quiere eliminar un producto se ha de hacer directamente. Las facturas se podrán filtrar por el cliente de la venta 
o por la fecha. Las facturas se podrán abrir o eliminar, pero una factura emitida no puede ser editada. 

En el apartado de ventas se muestra el propio TPV, donde se podrán escoger el vendedor, cliente, mesa o barra además de los 
productos vendidos. La gestión de los clientes se realiza desde el propio apartado de ventas. Para hacer más dinámico el servicio, 
cualquier empleado podrá crear, modificar o eliminar un cliente. Con la creación de un cliente se podrá establecer un porcentaje 
de descuento sobre la factura, con un límite de un 20%. El cliente “Cliente” por defecto no podrá sufrir modificaciones. 
Con la selección de un producto para su venta se indicará su cantidad, este se añade a la cuenta. 
En la cuenta hay opción de eliminar una línea seleccionada o bien de vaciarla. Con el botón de guardar se dará por finalizada esa 
venta y se añadirá a la base de datos.
