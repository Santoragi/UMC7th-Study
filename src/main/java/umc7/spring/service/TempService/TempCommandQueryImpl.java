package umc7.spring.service.TempService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class TempCommandQueryImpl implements TempCommandService{

    @Override
    public void CheckFlag(Integer flag) {

    }
}
