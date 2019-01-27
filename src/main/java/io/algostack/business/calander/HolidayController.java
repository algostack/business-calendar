package io.algostack.business.calander;

import com.google.common.base.Preconditions;
import com.google.common.collect.ImmutableList;
import javafx.print.Collation;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/holidays")
public class HolidayController {

    final Map<Long, Holiday> store = new HashMap<>();

    public HolidayController() {
        store.put(1l, new Holiday(1, LocalDate.now(), "USD", "Indepe day"));
    }

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Collection<Holiday> findAll() {
        return store.values();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Holiday findOne(@PathVariable("id") Long id) {
        Holiday holiday = store.get(id);
        if (holiday == null) {
            throw new IllegalArgumentException("Resource doesnt exist " + id);
        }
        return holiday;
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Long create(@RequestBody Holiday resource) {
        Preconditions.checkNotNull(resource);
        store.put(resource.getId(), resource);
        return resource.getId();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    @ResponseStatus(HttpStatus.OK)
    public void update(@PathVariable( "id" ) Long id, @RequestBody Holiday resource) {
        Preconditions.checkNotNull(resource);
        Holiday holiday = store.get(id);
        if (holiday != null) {
            throw new IllegalArgumentException("Resource doesnt exist " + id);
        }
        store.put(resource.getId(), resource);

    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void delete(@PathVariable("id") Long id) {
        store.remove(id);
    }



}
