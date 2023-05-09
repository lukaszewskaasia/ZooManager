package pl.coderslab.zoomanager.keeper.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND, reason = "Keeper not found")
public class KeeperNotFoundException extends RuntimeException {
}
