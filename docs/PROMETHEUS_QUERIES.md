# 📊 Prometheus Queries for Spring Boot (Micrometer + Actuator)

Этот файл содержит набор полезных PromQL-запросов для анализа HTTP-запросов в Spring Boot-приложении, использующем Micrometer + Prometheus.

---

## 🔢 Общее количество HTTP-запросов по методам
```promql
sum by (method) (http_server_requests_seconds_count)
```
Считает суммарное количество запросов (GET, POST и т.д.) за всё время.

---

## ⏱️ Общее время обработки запросов по URI
```promql
sum by (uri) (http_server_requests_seconds_sum)
```
Показывает, сколько времени в сумме заняло выполнение каждого типа запроса (например, на `/api/users`).

---

## 🚀 Средняя скорость запросов в секунду (за последнюю минуту)
```promql
rate(http_server_requests_seconds_count[1m])
```
Показывает, сколько запросов в среднем выполняется в секунду за последние 60 секунд.

---

## 🧭 Скорость запросов в разрезе HTTP-методов
```promql
sum by (method) (rate(http_server_requests_seconds_count[1m]))
```
Показывает, сколько запросов выполняется в секунду по каждому HTTP-методу.

---

## ⚠️ Количество запросов с ошибками 4xx
```promql
sum by (status) (http_server_requests_seconds_count{status=~"4.."})
```
Показывает количество клиентских ошибок (например, 400, 404).

---

## 🔥 Количество запросов с ошибками 5xx
```promql
sum by (status) (http_server_requests_seconds_count{status=~"5.."})
```
Показывает количество серверных ошибок (например, 500, 503).

---

## ✅ Количество POST-запросов на /api/users
```promql
http_server_requests_seconds_count{method="POST", uri="/api/users"}
```
Полезно, если хочешь трекать отдельно какие-то важные эндпоинты.

---

## 🔎 Количество запросов по методам и статусам
```promql
sum by (method, status) (http_server_requests_seconds_count)
```
Детализированная разбивка: сколько GET с 200, сколько POST с 201 и т.д.

---

## ⏱️ Среднее время запроса по URI
```promql
rate(http_server_requests_seconds_sum[1m]) / rate(http_server_requests_seconds_count[1m])
```
Показывает среднюю продолжительность запроса (в секундах) по каждому URI.

---

## ⏱️ Средняя длительность POST-запросов
```promql
rate(http_server_requests_seconds_sum{method="POST"}[1m]) / rate(http_server_requests_seconds_count{method="POST"}[1m])
```
Если нужно следить за скоростью обработки конкретного типа запросов, например POST.

---

## 🧼 Общее количество запросов без ошибок
```promql
sum by (status) (http_server_requests_seconds_count{error="none"})
```
Полезно для оценки успешных запросов.

---

## 🔄 Количество запросов за последние 5 минут (в абсолютных цифрах)
```promql
increase(http_server_requests_seconds_count[5m])
```
Показывает, сколько запросов произошло за 5 минут (по всем методам/эндпоинтам).

---

## 🛠️ Все доступные метрики
```promql
{__name__=~".*"}
```
Выводит список всех метрик, которые доступны в Prometheus. Используй для изучения структуры и доступных лейблов.

---

> 💡 **Подсказка**: Используй `/actuator/prometheus` как endpoint метрик в Spring Boot, и настрой `PrometheusText` в `scrape_protocols`, если используешь последнюю версию Prometheus.