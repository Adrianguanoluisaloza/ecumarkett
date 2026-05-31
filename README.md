# Ecumarkett

Ecumarkett es mi segundo proyecto y también una de las primeras ideas grandes que intenté construir. Nació cuando todavía estaba aprendiendo por mi cuenta, viendo tutoriales, probando cosas y tratando de entender cómo convertir una idea tipo marketplace en algo real.

Al principio fue un experimento hecho con lo que tenía a mano. Con el tiempo, el proyecto fue tomando forma y se fue reordenando hacia una base más clara, más mantenible y más cercana a algo publicable.

## Qué es

Ecumarkett es una app orientada a catálogo, inventario y gestión de productos. La idea es cubrir el flujo básico de un e-commerce pequeño o mediano: navegar productos, iniciar sesión, gestionar carrito, confirmar pedidos y administrar inventario.

## Enfoque técnico

- **Frontend:** React + Vite + TypeScript
- **Backend:** Cloudflare Workers con Hono
- **Base de datos:** Cloudflare D1
- **Storage:** Cloudflare R2
- **Autenticación:** JWT, cookies o una alternativa apoyada en Cloudflare

## Flujo general

1. El usuario entra al catálogo y navega categorías.
2. El usuario se registra o inicia sesión para guardar su experiencia.
3. El carrito permite sumar, quitar y actualizar productos.
4. El checkout confirma la compra y genera el pedido.
5. El panel admin administra productos, inventario y ventas.

## Contexto público

Este repositorio está compartido como parte de mi proceso de aprendizaje. No incluye credenciales, secretos ni datos personales.

---

Empecé este proyecto cuando apenas estaba entendiendo cómo funciona todo. Hoy queda como una muestra más honesta de ese proceso: una idea ambiciosa, mucho aprendizaje en el camino y una base mejor ordenada para seguir construyendo.
