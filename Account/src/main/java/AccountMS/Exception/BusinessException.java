package AccountMS.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
public class BusinessException extends RuntimeException {
    private static final long serialVersionUID = -8460356990632230194L;
    private String errorCode;
    private String errorMessage;
}
