# Ecumarkett

Ecumarkett nació como mi **segundo proyecto**.  
Al inicio, la idea fue hacer algo tipo Temu en NetBeans, pero en ese momento todavía no tenía clara la arquitectura correcta. Con el tiempo, el enfoque cambió hacia una base web más moderna y mantenible.

Este repositorio se mantiene con un enfoque educativo: documentar el proceso real de aprendizaje, desde una idea inicial hasta una arquitectura más clara.

## Arquitectura objetivo (moderna)

- **Frontend:** React + Vite + TypeScript  
- **Backend:** Cloudflare Workers con Hono  
- **Base de datos:** Cloudflare D1  
- **Storage:** Cloudflare R2  
- **Autenticación:** JWT/cookies o una alternativa basada en Cloudflare

## Árbol de carpetas sugerido

```txt
ecumarkett/
├─ frontend/
│  └─ src/
│     ├─ components/
│     ├─ pages/
│     ├─ routes/
│     ├─ services/
│     └─ main.tsx
├─ backend/
│  └─ src/
│     ├─ routes/
│     ├─ controllers/
│     ├─ services/
│     ├─ middlewares/
│     └─ app.ts
├─ shared/
│  └─ types/
└─ docs/
   └─ architecture.md
```

## Flujo base de la app

1. **Browse products:** el usuario entra, navega categorías y ve detalles de productos.
2. **Login/Register:** crea cuenta o inicia sesión para guardar carrito y órdenes.
3. **Cart:** agrega, quita y actualiza cantidades antes de comprar.
4. **Checkout:** confirma dirección, método de pago y crea el pedido.
5. **Admin:** gestiona productos, inventario, pedidos y estado de ventas.

## Nota pública del proyecto

Este README no incluye secretos, credenciales, variables de entorno, correos personales ni datos privados.

---

Y así queda Ecumarkett como un capítulo cerrado de aprendizaje: empezó como una idea confusa, pero con la nueva arquitectura evolucionó a una base real de lo que quería construir.
