package pl.coderslab.zoomanager.keeper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.webjars.NotFoundException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class KeeperService {

    private final KeeperRepository keeperRepository;
    private final KeeperMapper keeperMapper;

    @Autowired
    public KeeperService(KeeperRepository keeperRepository, KeeperMapper keeperMapper) {
        this.keeperRepository = keeperRepository;
        this.keeperMapper = keeperMapper;
    }

    public KeeperDto createKeeper(KeeperDto keeperDto) {
        Keeper keeper = keeperMapper.fromDto(keeperDto);
        Keeper savedKeeper = keeperRepository.save(keeper);
        return keeperMapper.toDto(savedKeeper);
    }

    public KeeperDto getKeeper(Long id) {
        Keeper keeper = keeperRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Keeper with id " + id + " not found"));
        return keeperMapper.toDto(keeper);
    }

    public List<KeeperDto> getAllKeepers() {
        List<Keeper> keepers = keeperRepository.findAll();
        return keepers.stream()
                .map(keeperMapper::toDto)
                .collect(Collectors.toList());
    }

    public void updateKeeper(Long id, KeeperDto keeperDto) {
        Keeper keeper = keeperRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Keeper with id " + id + " not found"));

        keeper.setName(keeperDto.getName());
        keeper.setSurname(keeperDto.getSurname());
        keeper.setAddress(keeperDto.getAddress());
        keeper.setPhone(keeperDto.getPhone());
        keeper.setEmail(keeperDto.getEmail());
        keeper.setPassword(keeperDto.getPassword());
        keeper.setUsername(keeperDto.getUsername());

        keeperRepository.save(keeper);
    }

    public void deleteKeeper(Long id) {
        keeperRepository.deleteById(id);
    }

}
