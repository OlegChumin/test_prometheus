package org.chumin.test_prometheus.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Random;

/**
 * REST-контроллер для демонстрации базовых HTTP-эндпоинтов
 * с целью тестирования мониторинга и логирования.
 *
 * Эндпоинты:
 * <ul>
 *     <li><b>GET /api/hello</b> — простой ответ с текстом "Hello, monitoring!".</li>
 *     <li><b>GET /api/users/{id}</b> — эмуляция запроса пользователя:
 *         <ul>
 *             <li>Добавлена случайная задержка до 500 мс для имитации нагрузки.</li>
 *             <li>Каждый 5-й запрос возвращает 500 Internal Server Error.</li>
 *         </ul>
 *     </li>
 *     <li><b>POST /api/users</b> — принимает JSON с параметром "name" и возвращает подтверждение создания.</li>
 * </ul>
 *
 * Используется для целей демонстрации Prometheus, ELK и других систем мониторинга.
 */

@RestController
@RequestMapping("/api")
public class UserController {

    private final Random random = new Random();

    @GetMapping("/hello")
    public String hello() {
        return "Hello, monitoring!";
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<String> getUser(@PathVariable Long id) {
        // Имитация разного времени обработки
        try {
            Thread.sleep(random.nextInt(500)); // до полсекунды задержка
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        // Искусственно бросаем ошибку для разнообразия
        if (id % 5 == 0) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Server error!");
        }

        return ResponseEntity.ok("User " + id);
    }

    @PostMapping("/users")
    public ResponseEntity<String> createUser(@RequestBody Map<String, String> body) {
        String name = body.get("name");
        return ResponseEntity.status(HttpStatus.CREATED).body("Created user: " + name);
    }
}
