Create database Control2BD;
use  Control2BD;

create table Producto (
id int auto_increment primary key ,
nombre varchar(40),
descripcion varchar(40),
cantidad int,
fechaVencimiento date
);

	INSERT INTO Producto values(1,'gaseosa', 'delicioso', 10, 12/08/2023);
	INSERT INTO Producto values  (2,'pastel', 'rico', 5, '2024-05-10');
  INSERT INTO Producto values  (3,'arroz', '1kg', 20, '2023-08-12');
   INSERT INTO Producto values (4,'pollo', '1 y medio', 8, '2024-06-20');