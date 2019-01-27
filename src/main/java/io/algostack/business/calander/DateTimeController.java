package io.algostack.business.calander;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class DateTimeController {

    @RequestMapping("/time")
    public LocalDateTime time() {
        return LocalDateTime.now();
    }
}
