db = connect('mongodb://localhost:27017/uniEventosTests');

// Insertar eventos
db.eventos.insertMany([
    {
        "nombre": "Feria de Arte",
        "descripcion": "Una exposición de artistas emergentes en un entorno vibrante.",
        "poster": "url_poster_arte.jpg",
        "imgLocalidades": "url_imagen_arte.jpg",
        "fecha": "2024-09-30T14:00:00Z",
        "direccion": {
            "departamento": "Valle del Cauca",
            "ciudad": "Cali",
            "barrio": "San Antonio",
            "calle": "Avenida 5",
            "numResidencia": "203"
        },
        "listaLocalidades": [
            {
                "nombre": "VIP",
                "descripcion": "Acceso a la galería privada y encuentro con artistas.",
                "capacidadMaxima": 50,
                "cantidadOcupada": 0,
                "cantidadDisponible": 50,
                "precio": 100000  // 100,000 COP
            },
            {
                "nombre": "General",
                "descripcion": "Entrada general a la exposición.",
                "capacidadMaxima": 500,
                "cantidadOcupada": 0,
                "cantidadDisponible": 500,
                "precio": 50000   // 50,000 COP
            },
            {
                "nombre": "Estudiante",
                "descripcion": "Entradas con descuento para estudiantes.",
                "capacidadMaxima": 200,
                "cantidadOcupada": 0,
                "cantidadDisponible": 200,
                "precio": 30000   // 30,000 COP
            }
        ],
        "isActivo": true
    },
    {
        "nombre": "Festival de Jazz",
        "descripcion": "Una celebración de la música jazz con artistas internacionales.",
        "poster": "url_poster_jazz.jpg",
        "imgLocalidades": "url_imagen_jazz.jpg",
        "fecha": "2024-11-20T18:00:00Z",
        "direccion": {
            "departamento": "Cundinamarca",
            "ciudad": "Bogotá",
            "barrio": "La Candelaria",
            "calle": "Carrera 7",
            "numResidencia": "45"
        },
        "listaLocalidades": [
            {
                "nombre": "VIP",
                "descripcion": "Área preferencial frente al escenario.",
                "capacidadMaxima": 150,
                "cantidadOcupada": 0,
                "cantidadDisponible": 150,
                "precio": 120000  // 120,000 COP
            },
            {
                "nombre": "General",
                "descripcion": "Asientos generales al aire libre.",
                "capacidadMaxima": 2000,
                "cantidadOcupada": 0,
                "cantidadDisponible": 2000,
                "precio": 40000   // 40,000 COP
            },
            {
                "nombre": "Palco",
                "descripcion": "Palcos exclusivos con servicios adicionales.",
                "capacidadMaxima": 30,
                "cantidadOcupada": 0,
                "cantidadDisponible": 30,
                "precio": 200000  // 200,000 COP
            }
        ],
        "isActivo": true
    },
    {
        "nombre": "Concierto de Rock",
        "descripcion": "Un concierto de rock al aire libre con bandas locales.",
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
                "cantidadOcupada": 0,
                "cantidadDisponible": 100,
                "precio": 80000   // 80,000 COP
            },
            {
                "nombre": "General",
                "descripcion": "Zona general de pie.",
                "capacidadMaxima": 1000,
                "cantidadOcupada": 0,
                "cantidadDisponible": 1000,
                "precio": 25000   // 25,000 COP
            },
            {
                "nombre": "Palco",
                "descripcion": "Palcos privados con vista privilegiada.",
                "capacidadMaxima": 50,
                "cantidadOcupada": 0,
                "cantidadDisponible": 50,
                "precio": 150000  // 150,000 COP
            }
        ],
        "isActivo": true
    }
]);

// Insertar usuarios
db.usuarios.insertMany([
    {
        "username": "admin1@ejemplo.com",
        "password": "admin1",
        "rol": "ADMINISTRADOR",
        "estadoCuenta": "ACTIVA"
    },
    {
        "username": "admin2@ejemplo.com",
        "password": "admin2",
        "rol": "ADMINISTRADOR",
        "estadoCuenta": "ACTIVA"
    },
    {
        "username": "usuario1@ejemplo.com",
        "password": "contrasenia3",
        "rol": "CLIENTE",
        "estadoCuenta": "ACTIVA"
    },
    {
        "username": "usuario2@ejemplo.com",
        "password": "contrasenia4",
        "rol": "CLIENTE",
        "estadoCuenta": "ACTIVA"
    },
    {
        "username": "usuario3@ejemplo.com",
        "password": "contrasenia5",
        "rol": "CLIENTE",
        "estadoCuenta": "INACTIVA"
    },
    {
        "username": "usuario4@ejemplo.com",
        "password": "contrasenia6",
        "rol": "CLIENTE",
        "estadoCuenta": "INACTIVA"
    },
    {
        "username": "usuario5@ejemplo.com",
        "password": "contrasenia7",
        "rol": "CLIENTE",
        "estadoCuenta": "ACTIVA"
    }
]);

// Insertar clientes
db.clientes.insertMany([
    {
        "cedula": "123456789",
        "nombre": "Juan",
        "apellido": "Pérez",
        "telefono": "1234567890",
        "usuario": {
            "username": "usuario1@ejemplo.com",
            "password": "usuario1",
            "rol": "CLIENTE",
            "estadoCuenta": "ACTIVA"
        },
        "carrito": {
            "total": 0.0,
            "listaItems": []
        },
        "idOrdenesCompra": []
    },
    {
        "cedula": "987654321",
        "nombre": "Ana",
        "apellido": "Gómez",
        "telefono": "0987654321",
        "usuario": {
            "username": "usuario2@ejemplo.com",
            "password": "usuario2",
            "rol": "CLIENTE",
            "estadoCuenta": "ACTIVA"
        },
        "carrito": {
            "total": 0.0,
            "listaItems": []
        },
        "idOrdenesCompra": []
    },
    {
        "cedula": "456789123",
        "nombre": "Luis",
        "apellido": "Martínez",
        "telefono": "4567891230",
        "usuario": {
            "username": "usuario3@ejemplo.com",
            "password": "usuario3",
            "rol": "CLIENTE",
            "estadoCuenta": "INACTIVA"
        },
        "carrito": {
            "total": 0.0,
            "listaItems": []
        },
        "idOrdenesCompra": []
    },
    {
        "cedula": "321654987",
        "nombre": "María",
        "apellido": "López",
        "telefono": "3216549870",
        "usuario": {
            "username": "usuario4@ejemplo.com",
            "password": "usuario4",
            "rol": "CLIENTE",
            "estadoCuenta": "INACTIVA"
        },
        "carrito": {
            "total": 0.0,
            "listaItems": []
        },
        "idOrdenesCompra": []
    },
    {
        "cedula": "789123456",
        "nombre": "Carlos",
        "apellido": "Hernández",
        "telefono": "7891234560",
        "usuario": {
            "username": "usuario5@ejemplo.com",
            "password": "usuario5",
            "rol": "CLIENTE",
            "estadoCuenta": "ACTIVA"
        },
        "carrito": {
            "total": 0.0,
            "listaItems": []
        },
        "idOrdenesCompra": []
    }
]);

// Insertar administradores
db.administradores.insertMany([
    {
        "cedula": "111222333",
        "nombre": "Pedro",
        "apellido": "Ramírez",
        "telefono": "1112223333",
        "usuario": {
            "username": "admin1@ejemplo.com",
            "password": "admin1",
            "rol": "ADMINISTRADOR",
            "estadoCuenta": "ACTIVA"
        }
    },
    {
        "cedula": "333222111",
        "nombre": "Laura",
        "apellido": "Torres",
        "telefono": "3332221111",
        "usuario": {
            "username": "admin2@ejemplo.com",
            "password": "admin2",
            "rol": "ADMINISTRADOR",
            "estadoCuenta": "ACTIVA"
        }
    }
]);

// Insertar cupones
db.cupones.insertMany([
    {
        "codigo": "CUPO1",
        "nombre": "Descuento Primavera",
        "porcentajeDescuento": 15.0,
        "fechaVencimiento": "2024-12-31",
        "cantidadRedenciones": 5,
        "redencionesActuales": 2,
        "montoMinimoCompra": 50000.0
    },
    {
        "codigo": "CUPO2",
        "nombre": "Black Friday",
        "porcentajeDescuento": 30.0,
        "fechaVencimiento": "2024-11-30",
        "cantidadRedenciones": 10,
        "redencionesActuales": 5,
        "montoMinimoCompra": 100000.0
    },
    {
        "codigo": "CUPO3",
        "nombre": "Navidad Feliz",
        "porcentajeDescuento": 25.0,
        "fechaVencimiento": "2025-01-05",
        "cantidadRedenciones": 8,
        "redencionesActuales": 3,
        "montoMinimoCompra": 75000.0
    },
    {
        "codigo": "CUPO4",
        "nombre": "Descuento Estudiantil",
        "porcentajeDescuento": 10.0,
        "fechaVencimiento": "2024-10-15",
        "cantidadRedenciones": 12,
        "redencionesActuales": 4,
        "montoMinimoCompra": 30000.0
    },
    {
        "codigo": "CUPO5",
        "nombre": "Ofertas de Verano",
        "porcentajeDescuento": 20.0,
        "fechaVencimiento": "2024-08-31",
        "cantidadRedenciones": 6,
        "redencionesActuales": 1,
        "montoMinimoCompra": 40000.0
    }
]);


var idCliente1 = '66f1bc8228a74d346b2d011f'; //Juan Perez
var idCliente2 = '987654321';  //Ana Gomez

db.ordenesCompra.insertMany([
    {
        "codigo": "ORD-001",
        "idUsuario": idCliente1,
        "total": 136000,
        "fecha": "2024-09-30T14:00:00Z",
        "estadoOrden": "COMPLETADA",
        "cupon": {
            "codigo": "CUPO1",
            "nombre": "Descuento Primavera",
            "porcentajeDescuento": 15,
            "fechaVencimiento": "2024-12-31",
            "cantidadRedenciones": 5,
            "redencionesActuales": 2,
            "montoMinimoCompra": 50000
        },
        "listaItems": [
            {
                "idEvento": '66f1bc8128a74d346b2d0115',
                "localidad": [
                        {
                            "nombre": "VIP",
                            "descripcion": "Área exclusiva cerca del escenario.",
                            "capacidadMaxima": 100,
                            "cantidadOcupada": 0,
                            "cantidadDisponible": 100,
                            "precio": 80000   // 80,000 COP
                        }
                ],
                "unidades": 2,
                "subtotal": 160000
            },
            {
                "idEvento": '66f1bc8128a74d346b2d0116',
                "localidad": [
                    {
                        "nombre": "VIP",
                        "descripcion": "Área exclusiva cerca del escenario.",
                        "capacidadMaxima": 100,
                        "cantidadOcupada": 0,
                        "cantidadDisponible": 100,
                        "precio": 80000   // 80,000 COP
                    }
                ],
                "unidades": 2,
                "subtotal": 160000
            },
        ]
    }
]);