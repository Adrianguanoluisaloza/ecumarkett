# Ecumarkett Architecture Plan

This document captures the agreed technical direction for a public, Temu-like ecommerce project.

## Intended Stack

- **Frontend:** React + Vite + TypeScript
- **Backend:** Cloudflare Workers with Hono
- **Database:** Cloudflare D1
- **File storage:** Cloudflare R2
- **Authentication:** JWT + secure cookies, or an equivalent Cloudflare-based auth strategy

## Suggested Project Structure

```text
ecumarkett/
├── frontend/                 # React + Vite + TypeScript app
│   ├── src/
│   │   ├── components/
│   │   ├── pages/
│   │   ├── services/
│   │   ├── hooks/
│   │   ├── routes/
│   │   └── types/
│   ├── public/
│   ├── vite.config.ts
│   └── tsconfig.json
├── backend/                  # Cloudflare Worker (Hono API)
│   ├── src/
│   │   ├── routes/
│   │   ├── controllers/
│   │   ├── services/
│   │   ├── middlewares/
│   │   └── db/
│   ├── wrangler.toml
│   ├── package.json
│   └── tsconfig.json
├── shared/                   # Shared types/contracts
│   └── types/
├── docs/                     # Additional technical docs
│   ├── api.md
│   └── data-model.md
└── deploy/                   # Deployment/config scripts
    ├── cloudflare/
    └── env/
```

## High-Level App Flow

1. **Browse products:** Users open the storefront, search, filter, and view product details.
2. **Login/Register:** Users create an account or sign in to save cart and place orders.
3. **Cart:** Users add/remove items and review totals before checkout.
4. **Checkout:** User confirms address/payment flow; backend validates stock and creates the order.
5. **Admin:** Admin users manage products, images, pricing, categories, and order status.

## Notes for Public Repository Readiness

- Keep business logic in the backend (Worker + Hono), not in UI components.
- Use shared TypeScript types between frontend and backend to reduce contract drift.
- Store media in R2 and persist product/order data in D1.
- Keep auth tokens/cookies secure and environment secrets outside source control.
