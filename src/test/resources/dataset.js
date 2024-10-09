db = connect('mongodb://localhost:27017/uniEventosTests');

// Insertar eventos
db.eventos.insertMany([
    {
        "nombre": "Concierto de Rock",
        "descripcion": "Un concierto de rock al aire libre con bandas locales.",
        "tipoEvento": "MUSICAL",
        "poster": "url_poster_concierto.jpg",
        "imgLocalidades": "url_imagen_localidades.jpg",
        "fecha": "2024-10-15T20:00:00Z",
        "direccion": {
            "departamento": "Antioquia",
            "ciudad": "Medellín",
            "barrio": "El Poblado",
            "calle": "Calle 10",
            "numResidencia": "101"
        },
        "listaLocalidades": [
            {
                "nombre": "VIP",
                "descripcion": "Área exclusiva cerca del escenario.",
                "capacidadMaxima": 100,
                "precio": 150000
            },
            {
                "nombre": "General",
                "descripcion": "Zona general de pie.",
                "capacidadMaxima": 1000,
                "precio": 60000
            },
            {
                "nombre": "Palco",
                "descripcion": "Palcos privados con vista privilegiada.",
                "capacidadMaxima": 50,
                "precio": 300000
            }
        ]
    },
    {
        "nombre": "Feria de Artesanía",
        "descripcion": "Una feria con lo mejor de la artesanía local y talleres creativos.",
        "tipoEvento": "CULTURAL",
        "poster": "url_poster_feria.jpg",
        "imgLocalidades": "url_imagen_localidades_feria.jpg",
        "fecha": "2024-10-25T10:00:00Z",
        "direccion": {
            "departamento": "Cundinamarca",
            "ciudad": "Bogotá",
            "barrio": "La Candelaria",
            "calle": "Carrera 7",
            "numResidencia": "50"
        },
        "listaLocalidades": [
            {
                "nombre": "Entrada General",
                "descripcion": "Acceso a todas las áreas de la feria.",
                "capacidadMaxima": 500,
                "precio": 20000
            },
            {
                "nombre": "Talleres",
                "descripcion": "Acceso a talleres creativos con materiales incluidos.",
                "capacidadMaxima": 100,
                "precio": 80000
            }
        ]
    },
    {
        "nombre": "Festival Gastronómico",
        "descripcion": "Un festival con lo mejor de la cocina local e internacional.",
        "tipoEvento": "CULTURAL",
        "poster": "url_poster_festival_gastronomico.jpg",
        "imgLocalidades": "url_imagen_localidades_festival.jpg",
        "fecha": "2024-11-01T12:00:00Z",
        "direccion": {
            "departamento": "Valle del Cauca",
            "ciudad": "Cali",
            "barrio": "Granada",
            "calle": "Avenida 9",
            "numResidencia": "20"
        },
        "listaLocalidades": [
            {
                "nombre": "Entrada General",
                "descripcion": "Acceso a todos los stands de comida.",
                "capacidadMaxima": 1000,
                "precio": 25000
            },
            {
                "nombre": "Zona VIP",
                "descripcion": "Acceso a degustaciones exclusivas.",
                "capacidadMaxima": 200,
                "precio": 150000
            }
        ]
    },
    {
        "nombre": "Maratón Ciudad de Cartagena",
        "descripcion": "Una maratón abierta a todos los corredores, con diferentes categorías.",
        "tipoEvento": "DEPORTIVO",
        "poster": "url_poster_maratón.jpg",
        "imgLocalidades": "url_imagen_localidades_maratón.jpg",
        "fecha": "2024-11-15T06:00:00Z",
        "direccion": {
            "departamento": "Bolívar",
            "ciudad": "Cartagena",
            "barrio": "Centro Histórico",
            "calle": "Calle de la Paz",
            "numResidencia": "1"
        },
        "listaLocalidades": [
            {
                "nombre": "5K",
                "descripcion": "Carrera de 5 kilómetros.",
                "capacidadMaxima": 500,
                "precio": 30000
            },
            {
                "nombre": "10K",
                "descripcion": "Carrera de 10 kilómetros.",
                "capacidadMaxima": 500,
                "precio": 50000
            },
            {
                "nombre": "Maratón Completo",
                "descripcion": "Carrera de 42 kilómetros.",
                "capacidadMaxima": 200,
                "precio": 80000
            }
        ]
    },
    {
        "nombre": "Exposición de Arte Moderno",
        "descripcion": "Una exposición que reúne lo mejor del arte moderno contemporáneo.",
        "tipoEvento": "CULTURAL",
        "poster": "url_poster_exposicion.jpg",
        "imgLocalidades": "url_imagen_localidades_exposicion.jpg",
        "fecha": "2024-11-20T18:00:00Z",
        "direccion": {
            "departamento": "Antioquia",
            "ciudad": "Medellín",
            "barrio": "Poblado",
            "calle": "Calle 5",
            "numResidencia": "12"
        },
        "listaLocalidades": [
            {
                "nombre": "Entrada General",
                "descripcion": "Acceso a la exposición principal.",
                "capacidadMaxima": 300,
                "precio": 15000
            },
            {
                "nombre": "Visitas Guiadas",
                "descripcion": "Incluye visita guiada con el curador.",
                "capacidadMaxima": 50,
                "precio": 50000
            }
        ]
    },
    {
        "nombre": "Cine al Aire Libre",
        "descripcion": "Proyección de películas clásicas en un ambiente familiar.",
        "tipoEvento": "CINE",
        "poster": "url_poster_cine.jpg",
        "imgLocalidades": "url_imagen_localidades_cine.jpg",
        "fecha": "2024-11-30T19:00:00Z",
        "direccion": {
            "departamento": "Atlántico",
            "ciudad": "Barranquilla",
            "barrio": "El Prado",
            "calle": "Carrera 54",
            "numResidencia": "200"
        },
        "listaLocalidades": [
            {
                "nombre": "Entrada General",
                "descripcion": "Acceso a la proyección de la película.",
                "capacidadMaxima": 300,
                "precio": 10000
            },
            {
                "nombre": "Zona Familiar",
                "descripcion": "Área reservada para familias con actividades adicionales.",
                "capacidadMaxima": 150,
                "precio": 25000
            }
        ]
    },
    {
        "nombre": "Conferencia de Innovación Tecnológica",
        "descripcion": "Una conferencia sobre las últimas tendencias en tecnología y negocios.",
        "tipoEvento": "CIENCIA",
        "poster": "url_poster_conferencia.jpg",
        "imgLocalidades": "url_imagen_localidades_conferencia.jpg",
        "fecha": "2024-10-30T09:00:00Z",
        "direccion": {
            "departamento": "Cundinamarca",
            "ciudad": "Bogotá",
            "barrio": "Chapinero",
            "calle": "Calle 63",
            "numResidencia": "45"
        },
        "listaLocalidades": [
            {
                "nombre": "Asistente General",
                "descripcion": "Acceso a todas las charlas y paneles.",
                "capacidadMaxima": 500,
                "precio": 100000
            },
            {
                "nombre": "VIP",
                "descripcion": "Acceso a sesiones exclusivas con ponentes.",
                "capacidadMaxima": 100,
                "precio": 300000
            }
        ]
    },
    {
        "nombre": "Festival Internacional de Jazz",
        "descripcion": "Un festival que reúne a los mejores artistas de jazz a nivel internacional.",
        "tipoEvento": "MUSICAL",
        "poster": "url_poster_jazz.jpg",
        "imgLocalidades": "url_imagen_localidades_jazz.jpg",
        "fecha": "2024-11-10T19:00:00Z",
        "direccion": {
            "departamento": "Caldas",
            "ciudad": "Manizales",
            "barrio": "Centro",
            "calle": "Calle 23",
            "numResidencia": "100"
        },
        "listaLocalidades": [
            {
                "nombre": "Entrada General",
                "descripcion": "Acceso a todas las presentaciones del festival.",
                "capacidadMaxima": 800,
                "precio": 70000
            },
            {
                "nombre": "Zona VIP",
                "descripcion": "Acceso a áreas exclusivas y asientos reservados.",
                "capacidadMaxima": 200,
                "precio": 200000
            }
        ]
    },
    {
        "nombre": "Concurso de Talentos",
        "descripcion": "Un evento donde los participantes muestran sus habilidades artísticas.",
        "tipoEvento": "CULTURAL",
        "poster": "url_poster_talentos.jpg",
        "imgLocalidades": "url_imagen_localidades_talentos.jpg",
        "fecha": "2024-11-25T17:00:00Z",
        "direccion": {
            "departamento": "Santander",
            "ciudad": "Bucaramanga",
            "barrio": "Centro",
            "calle": "Calle 35",
            "numResidencia": "150"
        },
        "listaLocalidades": [
            {
                "nombre": "Entrada General",
                "descripcion": "Acceso a todas las presentaciones.",
                "capacidadMaxima": 400,
                "precio": 30000
            },
            {
                "nombre": "Jurado VIP",
                "descripcion": "Acceso exclusivo para el jurado del concurso.",
                "capacidadMaxima": 50,
                "precio": 50000
            }
        ]
    },
    {
        "nombre": "Noche de Teatro Clásico",
        "descripcion": "Una representación de obras clásicas en un ambiente único.",
        "tipoEvento": "TEATRO",
        "poster": "url_poster_teatro.jpg",
        "imgLocalidades": "url_imagen_localidades_teatro.jpg",
        "fecha": "2024-11-15T19:30:00Z",
        "direccion": {
            "departamento": "Cundinamarca",
            "ciudad": "Bogotá",
            "barrio": "La Candelaria",
            "calle": "Calle 10",
            "numResidencia": "30"
        },
        "listaLocalidades": [
            {
                "nombre": "Palco",
                "descripcion": "Palcos con vista privilegiada.",
                "capacidadMaxima": 40,
                "precio": 120000
            },
            {
                "nombre": "Entrada General",
                "descripcion": "Acceso a todas las funciones.",
                "capacidadMaxima": 500,
                "precio": 50000
            }
        ]
    }
]);

// Insertar clientes
db.clientes.insertMany([
    {
        "cedula": "1012345678",
        "nombre": "Sofía",
        "apellido": "Ramírez",
        "telefono": "3123456789",
        "usuario": {
            "username": "sofia.ramirez@gmail.com",
            "password": "qwerty123"
        }
    },
    {
        "cedula": "2023456789",
        "nombre": "Andrés",
        "apellido": "Mendoza",
        "telefono": "3209876543",
        "usuario": {
            "username": "andres.mendoza@gmail.com",
            "password": "abc12345"
        }
    },
    {
        "cedula": "3034567890",
        "nombre": "Laura",
        "apellido": "García",
        "telefono": "3156789012",
        "usuario": {
            "username": "laura.garcia@gmail.com",
            "password": "password1"
        }
    },
    {
        "cedula": "4045678901",
        "nombre": "Diego",
        "apellido": "Hernández",
        "telefono": "3182345678",
        "usuario": {
            "username": "diego.hernandez@gmail.com",
            "password": "letmein2024"
        }
    },
    {
        "cedula": "5056789012",
        "nombre": "Valentina",
        "apellido": "Córdoba",
        "telefono": "3176543210",
        "usuario": {
            "username": "valentina.cordoba@gmail.com",
            "password": "mypassword!"
        }
    },
    {
        "cedula": "6067890123",
        "nombre": "Javier",
        "apellido": "Pérez",
        "telefono": "3143210987",
        "usuario": {
            "username": "javier.perez@gmail.com",
            "password": "javier2024"
        }
    },
    {
        "cedula": "7078901234",
        "nombre": "Camila",
        "apellido": "Lozano",
        "telefono": "3134567890",
        "usuario": {
            "username": "camila.lozano@gmail.com",
            "password": "camilita1"
        }
    },
    {
        "cedula": "8089012345",
        "nombre": "Fernando",
        "apellido": "Ríos",
        "telefono": "3198765432",
        "usuario": {
            "username": "fernando.rios@gmail.com",
            "password": "fer12345"
        }
    },
    {
        "cedula": "9090123456",
        "nombre": "Isabella",
        "apellido": "Salazar",
        "telefono": "3167890123",
        "usuario": {
            "username": "isabella.salazar@gmail.com",
            "password": "isabella2024"
        }
    },
    {
        "cedula": "1011234567",
        "nombre": "Felipe",
        "apellido": "Castillo",
        "telefono": "3112345678",
        "usuario": {
            "username": "felipe.castillo@gmail.com",
            "password": "felipe@2024"
        }
    }
]);

// Insertar usuarios
db.usuarios.insertMany([
    {
        "username": "sofia.ramirez@gmail.com",
        "password": "qwerty123",
        "estadoCuenta": "ACTIVA",
        "rol": "CLIENTE"
    },
    {
        "username": "andres.mendoza@gmail.com",
        "password": "abc12345",
        "estadoCuenta": "ACTIVA",
        "rol": "CLIENTE"
    },
    {
        "username": "laura.garcia@gmail.com",
        "password": "password1",
        "estadoCuenta": "ACTIVA",
        "rol": "CLIENTE"
    },
    {
        "username": "diego.hernandez@gmail.com",
        "password": "letmein2024",
        "estadoCuenta": "ACTIVA",
        "rol": "CLIENTE"
    },
    {
        "username": "valentina.cordoba@gmail.com",
        "password": "mypassword!",
        "estadoCuenta": "ACTIVA",
        "rol": "CLIENTE"
    },
    {
        "username": "javier.perez@gmail.com",
        "password": "javier2024",
        "estadoCuenta": "ACTIVA",
        "rol": "CLIENTE"
    },
    {
        "username": "camila.lozano@gmail.com",
        "password": "camilita1",
        "estadoCuenta": "ACTIVA",
        "rol": "CLIENTE"
    },
    {
        "username": "fernando.rios@gmail.com",
        "password": "fer12345",
        "estadoCuenta": "ACTIVA",
        "rol": "CLIENTE"
    },
    {
        "username": "isabella.salazar@gmail.com",
        "password": "isabella2024",
        "estadoCuenta": "ACTIVA",
        "rol": "CLIENTE"
    },
    {
        "username": "felipe.castillo@gmail.com",
        "password": "felipe@2024",
        "estadoCuenta": "ACTIVA",
        "rol": "CLIENTE"
    },
    {
        "username": "dario.cordoba@gmail.com",
        "password": "12345678",
        "estadoCuenta": "ACTIVA",
        "rol": "ADMINISTRADOR"
    }
]);

//Insertar Administrador
db.administradores.insertMany([
    {
        "nombre": "Dario",
        "apellido": "Cordoba",
        "cedula": "1234567890",
        "telefono": "3233955523",
        "usuario": {
            "username": "dario.cordoba@gmail.com",
            "password": "$2a$12$X8zVsxTdMwGhYYrqjqoqOeIWOS9325gPjkkr9IvdCNRjYmfbqq3Ni\n",
            "rol": "ADMINISTRADOR",
            "estadoCuenta": "ACTIVA"
        }
    }
]);

//Insertar Cupones
db.cupones.insertMany([
        {
            "codigo": "CUPON10",
            "nombre": "Descuento de Bienvenida",
            "descripcion": "10% de descuento en tu primera compra.",
            "descuento": 10.0,
            "fechaInicio": "2024-10-01",
            "fechaFin": "2024-10-31",
            "montoMinimoCompra": 50000.0,
            "estado": "DISPONIBLE",
            "tipo": "UNICO"
        },
        {
            "codigo": "CUPON20",
            "nombre": "Descuento Especial",
            "descripcion": "20% de descuento en compras superiores a $100,000.",
            "descuento": 20.0,
            "fechaInicio": "2024-10-15",
            "fechaFin": "2024-11-15",
            "montoMinimoCompra": 100000.0,
            "estado": "DISPONIBLE",
            "tipo": "MULTIPLE"
        },
        {
            "codigo": "CUPON5",
            "nombre": "Descuento en Productos Seleccionados",
            "descripcion": "5% de descuento en productos seleccionados.",
            "descuento": 5.0,
            "fechaInicio": "2024-10-05",
            "fechaFin": "2024-10-25",
            "montoMinimoCompra": 30000.0,
            "estado": "DISPONIBLE",
            "tipo": "UNICO"
        },
        {
            "codigo": "CUPON50",
            "nombre": "Descuento de Fiesta",
            "descripcion": "50% de descuento en tu segunda compra.",
            "descuento": 50.0,
            "fechaInicio": "2024-11-01",
            "fechaFin": "2024-11-30",
            "montoMinimoCompra": 80000.0,
            "estado": "DISPONIBLE",
            "tipo": "MULTIPLE"
        },
        {
            "codigo": "CUPON15",
            "nombre": "Descuento por Referido",
            "descripcion": "15% de descuento por cada amigo referido.",
            "descuento": 15.0,
            "fechaInicio": "2024-10-20",
            "fechaFin": "2024-11-20",
            "montoMinimoCompra": 60000.0,
            "estado": "DISPONIBLE",
            "tipo": "MULTIPLE"
        },
        {
            "codigo": "CUPON30",
            "nombre": "Promoción de Otoño",
            "descripcion": "30% de descuento en compras de temporada.",
            "descuento": 30.0,
            "fechaInicio": "2024-10-10",
            "fechaFin": "2024-11-10",
            "montoMinimoCompra": 70000.0,
            "estado": "DISPONIBLE",
            "tipo": "UNICO"
        },
        {
            "codigo": "CUPON25",
            "nombre": "Día del Cliente",
            "descripcion": "25% de descuento en tu compra durante el día del cliente.",
            "descuento": 25.0,
            "fechaInicio": "2024-11-05",
            "fechaFin": "2024-11-05",
            "montoMinimoCompra": 100000.0,
            "estado": "DISPONIBLE",
            "tipo": "UNICO"
        },
        {
            "codigo": "CUPON40",
            "nombre": "Fin de Temporada",
            "descripcion": "40% de descuento en artículos de fin de temporada.",
            "descuento": 40.0,
            "fechaInicio": "2024-11-15",
            "fechaFin": "2024-11-30",
            "montoMinimoCompra": 90000.0,
            "estado": "DISPONIBLE",
            "tipo": "MULTIPLE"
        },
        {
            "codigo": "CUPON12",
            "nombre": "Descuento por Newsletter",
            "descripcion": "12% de descuento al suscribirte a nuestro newsletter.",
            "descuento": 12.0,
            "fechaInicio": "2024-10-25",
            "fechaFin": "2024-11-25",
            "montoMinimoCompra": 40000.0,
            "estado": "DISPONIBLE",
            "tipo": "UNICO"
        },
        {
            "codigo": "CUPON35",
            "nombre": "Descuento en Compras Múltiples",
            "descripcion": "35% de descuento en la compra de 3 o más productos.",
            "descuento": 35.0,
            "fechaInicio": "2024-11-01",
            "fechaFin": "2024-11-15",
            "montoMinimoCompra": 50000.0,
            "estado": "DISPONIBLE",
            "tipo": "MULTIPLE"
        }
]);