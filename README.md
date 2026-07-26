# TarkBank – Banca Móvil 📱💳

Aplicación móvil de banca digital desarrollada como proyecto para producción, construida de forma nativa con **Kotlin** y **Jetpack Compose**. Simula las funciones principales de una app bancaria moderna: inicio de sesión, gestión de tarjetas, transferencias, pago de servicios, Yape y más.

## ✨ Funcionalidades

- **Autenticación**: pantallas de bienvenida, inicio de sesión y registro de usuario.
- **Dashboard principal (Home)**: resumen de cuenta y accesos directos a las demás secciones.
- **Tarjetas**: visualización de tarjetas del usuario.
- **Movimientos**: historial de transacciones (ingresos y gastos).
- **Transferencias**: envío de dinero entre cuentas.
- **Pagar servicios**: módulo para pago de servicios (luz, agua, etc.).
- **Yape**: pantalla dedicada a transferencias tipo Yape.
- **Compras**: módulo de compras/consumos.
- **Ajustes**: configuración de la cuenta y cierre de sesión.

## 🛠️ Tecnologías

- **Kotlin**
- **Jetpack Compose** (UI declarativa)
- **Material 3**
- **Navigation Compose** (navegación entre pantallas)
- Arquitectura basada en modelos de datos simples (`Account`, `Transaction`) para simular el backend bancario

## 📂 Estructura del proyecto

```
app/src/main/java/com/theylor/proyecto_banco/
├── MainActivity.kt
├── model/
│   └── BankingModels.kt        # Modelos: Account, Transaction, TransactionType
├── navigation/
│   └── AppNavigation.kt        # Definición de rutas y NavHost
└── ui/
    ├── components/
    │   └── BankCard.kt         # Componente reutilizable de tarjeta
    ├── screens/
    │   ├── WelcomeScreen.kt
    │   ├── Login.kt
    │   ├── Registro.kt
    │   ├── Home.kt
    │   ├── Tarjetas.kt
    │   ├── Movimientos.kt
    │   ├── Transferencias.kt
    │   ├── PagarServicios.kt
    │   ├── Yape.kt
    │   ├── Compras.kt
    │   └── Ajustes.kt
    └── theme/
        ├── Color.kt
        ├── Theme.kt
        └── Type.kt
```

## 🚀 Cómo ejecutar el proyecto

### Requisitos previos
- [Android Studio](https://developer.android.com/studio) (versión reciente, con soporte para Compose)
- JDK 11
- SDK de Android con `compileSdk 36` / `minSdk 24`

### Pasos

1. Clona el repositorio:
   ```bash
   git clone https://github.com/tarkramirez23-gif/TarkBank_BancaMovil.git
   ```
2. Abre el proyecto en Android Studio.
3. Espera a que Gradle sincronice las dependencias.
4. Ejecuta la app en un emulador o dispositivo físico con `Run ▶️`.

También puedes compilarlo desde la terminal:
```bash
./gradlew assembleDebug
```

## 📱 Navegación de la app

El flujo de pantallas está gestionado con `Navigation Compose`:

```
Welcome → Login → Home (Dashboard)
                    ├── Transacciones
                    ├── Tarjetas
                    ├── Transferencias
                    ├── Pagar servicios
                    ├── Yape
                    ├── Compras
                    └── Ajustes → Logout → Welcome
```

## 📌 Estado del proyecto

Proyecto académico en desarrollo. Próximas mejoras posibles:
- Persistencia de datos (Room / DataStore)
- Autenticación real (Firebase Auth o backend propio)
- Pruebas unitarias e instrumentadas adicionales

## 👤 Autor

**THEYLOR RAMIREZ VASQUEZ**
- GitHub: (tarkramirez23-gif)
- LinkedIn: (https://www.linkedin.com/in/theylor-ramirez-vasquez-4799112a6/)

## 📄 Licencia

Este proyecto se distribuye con fines académicos.
