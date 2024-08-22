package nz.co.bnz.lapworkshop.persistence.repository;

import nz.co.bnz.lapworkshop.persistence.repository.entity.AccountEntity;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface CustomerFeedbackRepository extends JpaRepository<AccountEntity, UUID> {

    List<AccountEntity> findByType(String type, Pageable pageable);
}
