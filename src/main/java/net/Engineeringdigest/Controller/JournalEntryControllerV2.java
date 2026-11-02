package net.Engineeringdigest.Controller;

import net.Engineeringdigest.Repository.JournalEntryRepository;
import net.Engineeringdigest.entity.JournalEntry;
import net.Engineeringdigest.service.JournalEntryService;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryControllerV2 {
    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public List<JournalEntry> getAll(){
        return journalEntryService.getAll();
    }

    @PostMapping
    public JournalEntry createEntry(@RequestBody JournalEntry myEntry){
        myEntry.setDate(LocalDateTime.now());
        journalEntryService.saveEntry( myEntry );
        return myEntry;
    }

    @GetMapping("id/{myid}")
    public JournalEntry getJournalEntryById(@PathVariable ObjectId myid){
        return journalEntryService.findById(myid).orElse(null);
    }

    @DeleteMapping("id/{myid}")
    public boolean deleteEntry(@PathVariable ObjectId myid){
        journalEntryService.deleteById(myid);
        return true;
    }

    @PutMapping("id/{myid}")
    public JournalEntry updateJournalById(@PathVariable ObjectId myid,@RequestBody JournalEntry myentry ){
        JournalEntry old=journalEntryService.findById(myid).orElse(null);
        if(old!=null){
            old.setTitle(myentry.getTitle()!=null && !myentry.getTitle().equals("")? myentry.getTitle() : old.getTitle());
            old.setContent(myentry.getContent()!=null && !myentry.getContent().equals("")? myentry.getContent() : old.getContent());
        }
        journalEntryService.saveEntry(myentry);
        return old;

    }
}
