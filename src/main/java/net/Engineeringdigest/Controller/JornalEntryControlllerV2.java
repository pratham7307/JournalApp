package net.Engineeringdigest.Controller;

import net.Engineeringdigest.entity.Journalentry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JornalEntryControlllerV2 {

    @GetMapping
    public List<Journalentry> getAll(){
        return null;
    }
    @PostMapping
    public boolean createEntry(@RequestBody Journalentry myentry){
        return true;
    }
    @GetMapping("/id/{myid}")
    public Journalentry getJournalentryById(@PathVariable Long myid){
        return null;
    }

    @DeleteMapping("/id/{myid}")
    public Journalentry deleteJournalentryById(@PathVariable Long myid){
        return null;
    }

    @PutMapping("/id/myid")
    public Journalentry updateEntry(@RequestBody Journalentry myentry){
        return null;
    }


}
