package net.Engineeringdigest.Controller;

import net.Engineeringdigest.entity.Journalentry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/_journal")
public class JornalEntryControlller {
    public Map<Long,Journalentry> JournalEntries=new HashMap<>();

    @GetMapping
    public List<Journalentry> getAll(){
        return new ArrayList<Journalentry>(JournalEntries.values());
    }
    @PostMapping
    public boolean createEntry(@RequestBody Journalentry myentry){
        JournalEntries.put(myentry.getId(),myentry);
        return true;
    }
    @GetMapping("/id/{myid}")
    public Journalentry getJournalentryById(@PathVariable Long myid){
        return JournalEntries.get(myid);
    }

    @DeleteMapping("/id/{myid}")
    public Journalentry deleteJournalentryById(@PathVariable Long myid){
        return JournalEntries.remove(myid);
    }

    @PutMapping("/id/myid")
    public Journalentry updateEntry(@RequestBody Journalentry myentry){
        return JournalEntries.put(myentry.getId(),myentry);
    }


}
