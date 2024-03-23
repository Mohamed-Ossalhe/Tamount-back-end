package ma.tamount.backend.services.implementation;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.tamount.backend.mappers.PaymentHistoryMapper;
import ma.tamount.backend.models.entities.PaymentHistory;
import ma.tamount.backend.models.requests.PaymentHistoryRequest;
import ma.tamount.backend.models.responses.PaymentHistoryResponse;
import ma.tamount.backend.repositories.PaymentHistoryRepository;
import ma.tamount.backend.services.PaymentHistoryService;
import org.springframework.stereotype.Service;
import org.springframework.validation.annotation.Validated;

import java.util.UUID;

/**
 * Service class for managing payment-history-related operations.
 *
 * <p>This service class provides methods for retrieving payment history data based on various criteria.</p>
 *
 * @author Mohamed Ossalhe
 */
@Slf4j
@Service
@Validated
@RequiredArgsConstructor
public class PaymentHistoryServiceImplementation extends AbstractService<UUID, PaymentHistoryRequest, PaymentHistoryResponse, PaymentHistory, PaymentHistoryRepository, PaymentHistoryMapper> implements PaymentHistoryService {
}
