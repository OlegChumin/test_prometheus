# Spring Boot Monitoring Service

Сервис на Spring Boot с интеграцией Prometheus и Grafana для сбора и отображения метрик.

## 📦 Функциональность

- REST API (пример: `/api/users`, `/api/hello`)
- Экспонирование метрик через Spring Boot Actuator
- Интеграция с Prometheus для сбора метрик
- Визуализация метрик в Grafana

## 🛠️ Технологии

- Java + Spring Boot
- Spring Actuator
- Prometheus
- Grafana
- Docker + Docker Compose

## 🚀 Запуск

1. Собрать проект:
   ```bash
   ./gradlew build
   ```

2. Запустить `docker-compose`:
   ```bash
   docker-compose up
   ```

3. Приложение будет доступно по:
   - `http://localhost:8080` – API
   - `http://localhost:8080/actuator/prometheus` – метрики
   - `http://localhost:9090` – Prometheus UI
   - `http://localhost:3000` – Grafana UI

## 📊 Настройка Grafana

1. Перейти на [http://localhost:3000](http://localhost:3000)
2. Войти (по умолчанию: admin / admin)
3. Добавить Data Source – Prometheus (`http://prometheus:9090`)
4. Импортировать дашборд:
   - Через меню **Dashboards → Import**
   - Загрузить файл `grafana_dashboard_prometheus.json` из корня проекта

## 🧪 Пример запроса метрик

Пример PromQL запроса:
```promql
sum(rate(http_server_requests_seconds_count[1m])) by (method)
```

## 🧑‍💻 Автор

Чумин Олег
