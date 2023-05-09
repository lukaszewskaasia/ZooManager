package pl.coderslab.zoomanager.keeper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/keepers")
public class KeeperController {

    private final KeeperService keeperService;

    @Autowired
    public KeeperController(KeeperService keeperService) {
        this.keeperService = keeperService;
    }

    @PostMapping
    public ResponseEntity<KeeperDto> createKeeper(@RequestBody KeeperDto keeperDto) {
        KeeperDto createdKeeperDto = keeperService.createKeeper(keeperDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdKeeperDto);
    }

    @GetMapping("/{id}")
    public ResponseEntity<KeeperDto> getKeeper(@PathVariable Long id) {
        KeeperDto keeperDto = keeperService.getKeeper(id);
        return ResponseEntity.ok(keeperDto);
    }

    @GetMapping
    public ResponseEntity<List<KeeperDto>> getAllKeepers() {
        List<KeeperDto> allKeepersDto = keeperService.getAllKeepers();
        return ResponseEntity.ok(allKeepersDto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Void> updateKeeper(@PathVariable Long id, @RequestBody KeeperDto keeperDto) {
        keeperService.updateKeeper(id, keeperDto);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteKeeper(@PathVariable Long id) {
        keeperService.deleteKeeper(id);
        return ResponseEntity.ok().build();
    }

}
