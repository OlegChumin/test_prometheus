# Grafana Monitoring Guide

## 🔍 Что такое Grafana?
**Grafana** — это мощный инструмент для визуализации и анализа метрик. Он используется для построения дашбордов, которые отображают данные из источников вроде Prometheus, InfluxDB, Elasticsearch и других.

Grafana позволяет:
- Строить графики, таблицы и алерты
- Делать дашборды интерактивными с фильтрами
- Работать с множеством источников данных

---

## 🚀 Как открыть Grafana

После запуска `docker-compose`:
Открой браузер и перейди по адресу:

```
http://localhost:3000
```

### 🧑‍💻 Данные для входа по умолчанию:
- **Login:** `admin`
- **Password:** `admin` (при первом входе попросят изменить)

---

## ⚙️ Подключение Prometheus как источника данных

1. Перейди в левом меню в `⚙️ Configuration > Data sources`
2. Нажми `Add data source`
3. Выбери `Prometheus`
4. В поле URL укажи:

```
http://prometheus:9090
```

(имя контейнера, а не localhost)

5. Нажми `Save & Test`

---

## 📊 Построение графика

1. Перейди в `+ Create > Dashboard`
2. Нажми `Add new panel`
3. В поле запроса укажи, например:

```
rate(http_server_requests_seconds_count[1m])
```

4. Выбирай тип графика, указывай легенды (например, `{{method}} {{uri}}`) и сохраняй панель

---

## 🧠 Полезные PromQL-запросы

| Цель | Запрос |
|------|--------|
| Кол-во HTTP-запросов по методам | `sum by (method) (http_server_requests_seconds_count)` |
| Скорость запросов | `rate(http_server_requests_seconds_count[1m])` |
| Увеличение за 5 минут | `increase(http_server_requests_seconds_count[5m])` |

---

## ✅ Готово!
Теперь ты можешь анализировать метрики своего Spring Boot приложения прямо в Grafana!