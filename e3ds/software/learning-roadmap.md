
# Learning Roadmap - Kaiju Management System Tech Stack

> Work through the stages in order. Stages 4 and 5 can run in parallel once you're comfortable with stages 1–3.

---

## Stage 1 — Python Fundamentals

**Estimated time:** 2–4 weeks · No prior experience needed

|Topic|What to learn|
|---|---|
|Syntax & data types|Variables, strings, numbers, lists, dicts|
|Functions & control flow|`def`, loops, `if/else`, return values|
|Classes & objects|OOP basics, methods, inheritance|
|`pip` & virtual environments|Installing packages, isolating projects|

**Resources:** [freeCodeCamp Python course](https://www.freecodecamp.org/learn) · [Official Python tutorial](https://docs.python.org/3/tutorial/)

---

## Stage 2 — Web & API Basics

**Estimated time:** 2–3 weeks · After Stage 1

|Topic|What to learn|
|---|---|
|HTTP basics|Requests, responses, GET/POST, status codes|
|REST APIs|Endpoints, JSON, CRUD operations|
|FastAPI intro|Routes, path params, request body|
|CORS|Why it exists, how to configure it in FastAPI|

**Resources:** [FastAPI official docs](https://fastapi.tiangolo.com/) · [MDN HTTP overview](https://developer.mozilla.org/en-US/docs/Web/HTTP/Overview)

---

## Stage 3 — Databases & Async Python

**Estimated time:** 3–4 weeks · Builds on Stage 2

|Topic|What to learn|
|---|---|
|SQL basics|`SELECT`, `INSERT`, `UPDATE`, `DELETE`, joins|
|SQLModel & ORM|Defining models, querying with Python objects|
|Async / await|`AsyncSession`, non-blocking I/O in FastAPI|
|PostgreSQL vs SQLite|When to use which, basic setup|

**Resources:** [SQLModel docs](https://sqlmodel.tiangolo.com/) · [PostgreSQL tutorial](https://www.postgresqltutorial.com/)

---

## Stage 4 — DevOps & Infrastructure

**Estimated time:** 3–5 weeks · Can run in parallel with Stage 3

|Topic|What to learn|
|---|---|
|Docker basics|Containers, `Dockerfile`, images|
|Docker Compose|Multi-service apps, networking, volumes|
|Kubernetes intro|Pods, services, deployments, namespaces|
|GitLab CI/CD|Pipeline stages, `.gitlab-ci.yml`, runners|
|Helm charts|Packaging K8s apps, `helm upgrade --install`|
|Keycloak & auth|OAuth2, JWT tokens, roles, FastAPI integration|

**Resources:** [Docker getting started](https://docs.docker.com/get-started/) · [Kubernetes basics](https://kubernetes.io/docs/tutorials/kubernetes-basics/) · [GitLab CI/CD docs](https://docs.gitlab.com/ee/ci/)

---

## Stage 5 — Frontend with Flutter

**Estimated time:** 4–6 weeks · Can start independently of Stages 3–4

|Topic|What to learn|
|---|---|
|Dart fundamentals|Syntax, types, null safety (easy if you know Python)|
|Flutter & widgets|Stateless vs stateful, the widget tree|
|BLoC pattern|State management, events, streams|
|go_router|Navigation, deep links, route definitions|
|REST clients in Flutter|`http`/`dio`, JSON parsing, error handling|

**Resources:** [Flutter learning docs](https://flutter.dev/learn) · [Dart language tour](https://dart.dev/language)

---

## Practical Tips

- **Start immediately:** Once Docker is installed, run `docker compose up --build` in the project root and open `http://localhost:8000/docs`. Seeing the real app running is a great motivator.
- **Realistic timeline:** Learning part-time (1–2 hours/day), expect 6–12 months to feel comfortable with the full stack.
- **Don't rush stages:** It's better to feel solid on Python and FastAPI than to skim ahead to Kubernetes.
- **Use the project as a reference:** Once you learn a concept, find it in the codebase (`backend/app/`, `frontend/lib/`, `deploy/helm/`) and read real usage.

