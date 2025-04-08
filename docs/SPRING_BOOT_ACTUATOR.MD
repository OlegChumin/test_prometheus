# 📘 Spring Boot Actuator — эндпоинты мониторинга

> Приложение работает на порту `8080`, доступ по адресу:  
> `http://localhost:8080`

Prometheus (если используется) слушает на `http://localhost:9090`

---

## 🔍 Основные эндпоинты Actuator

| URL | Что даёт |
|-----|----------|
| `/actuator/health` | Статус живости приложения |
| `/actuator/info` | Инфо из `application.yml` |
| `/actuator/metrics` | Все метрики (JVM, CPU, HTTP и др.) |
| `/actuator/metrics/http.server.requests` | Метрики HTTP-запросов по эндпоинтам |
| `/actuator/env` | Все переменные окружения |
| `/actuator/beans` | Все Spring-бины |
| `/actuator/loggers` | Управление логами на лету |
| `/actuator/threaddump` | Stack trace всех потоков |
| `/actuator/heapdump` | Heap dump памяти (открыть в VisualVM) |

Пример:  
`http://localhost:8080/actuator/metrics`

---

## ⚙️ Настройка в `application.yml`

```yaml
management:
  endpoints:
    web:
      exposure:
        include: "*"
  endpoint:
    health:
      show-details: always
```

### 📡 Примеры запросов

```http
GET http://localhost:8080/actuator/health
GET http://localhost:8080/actuator/info
GET http://localhost:8080/actuator/metrics/http.server.requests
GET http://localhost:8080/actuator/env
```

## ✨ Spring Boot Actuator Endpoints

> Полезные endpoint-ы для отладки, мониторинга и просмотра состояния Spring Boot приложения.

### Основные endpoint'ы

| Назначение                         | URL                                                                 |
|-----------------------------------|----------------------------------------------------------------------|
| 📚 Список всех endpoint'ов       | [http://localhost:8080/actuator](http://localhost:8080/actuator)   |
| ❤️ Health check                  | [http://localhost:8080/actuator/health](http://localhost:8080/actuator/health) |
| 💾 Info (application.yml)        | [http://localhost:8080/actuator/info](http://localhost:8080/actuator/info)     |
| 🌍 Env переменные                | [http://localhost:8080/actuator/env](http://localhost:8080/actuator/env)       |
| 🧠 Spring beans                  | [http://localhost:8080/actuator/beans](http://localhost:8080/actuator/beans)   |
| 🤖 Mapping controller'ов        | [http://localhost:8080/actuator/mappings](http://localhost:8080/actuator/mappings) |
| 📊 Все метрики                  | [http://localhost:8080/actuator/metrics](http://localhost:8080/actuator/metrics) |
| 🔍 HTTP metrics                 | [http://localhost:8080/actuator/metrics/http.server.requests](http://localhost:8080/actuator/metrics/http.server.requests) |
| 🧠 JVM Memory                   | [http://localhost:8080/actuator/metrics/jvm.memory.used](http://localhost:8080/actuator/metrics/jvm.memory.used) |
| ⚖️ CPU usage                   | [http://localhost:8080/actuator/metrics/process.cpu.usage](http://localhost:8080/actuator/metrics/process.cpu.usage) |
| 🔛 Loggers config               | [http://localhost:8080/actuator/loggers](http://localhost:8080/actuator/loggers) |
| 🔄 Thread dump                  | [http://localhost:8080/actuator/threaddump](http://localhost:8080/actuator/threaddump) |
| 🧠 Heap dump                    | [http://localhost:8080/actuator/heapdump](http://localhost:8080/actuator/heapdump) |
| 📅 Запланированные задачи       | [http://localhost:8080/actuator/scheduledtasks](http://localhost:8080/actuator/scheduledtasks) |
| ⚙️ Условия `@Conditional`      | [http://localhost:8080/actuator/conditions](http://localhost:8080/actuator/conditions) |
| ⚙️ Config props                | [http://localhost:8080/actuator/configprops](http://localhost:8080/actuator/configprops) |
| 🔍 HTTP trace                  | [http://localhost:8080/actuator/httptrace](http://localhost:8080/actuator/httptrace) |

### Если добавлен Prometheus:

| Интеграция | URL |
|------------|-----|
| 📈 Prometheus metrics | [http://localhost:8080/actuator/prometheus](http://localhost:8080/actuator/prometheus) |

---


