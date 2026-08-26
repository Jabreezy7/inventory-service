# Architecture Decision Log

Short record of non-obvious choices and the reasoning behind them.

---

## PostgreSQL over DynamoDB

**Context:** Need a datastore for inventory, orders, and warehouse data.

**Decision:** PostgreSQL.

**Why:** Inventory requires strong consistency.

**Tradeoff:** Harder to scale horizontally than DynamoDB. 