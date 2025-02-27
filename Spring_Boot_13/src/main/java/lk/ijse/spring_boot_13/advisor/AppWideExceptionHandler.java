package lk.ijse.spring_boot_13.advisor;

import lk.ijse.spring_boot_13.util.ResponseUtil;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class AppWideExceptionHandler {
    @ExceptionHandler(Exception.class)
    public ResponseUtil exceptionHandler(Exception e) {
        return new ResponseUtil(500,"e.getMessage()",null);
    }

}
