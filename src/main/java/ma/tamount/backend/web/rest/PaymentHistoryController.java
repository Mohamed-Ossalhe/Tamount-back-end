package ma.tamount.backend.web.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import ma.tamount.backend.models.requests.PaymentHistoryRequest;
import ma.tamount.backend.models.responses.PaymentHistoryResponse;
import ma.tamount.backend.services.PaymentHistoryService;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

/**
 * Controller class handling payment-history-related endpoints.
 *
 * <p>This class provides REST full endpoints for retrieving different categories of payment history.
 * It utilizes the {@link PaymentHistoryService} to fetch payment history data and returns the results in the form of {@link PaymentHistoryResponse}.
 * </p>
 *
 * @author Mohamed Ossalhe
 */
@Slf4j
@Validated
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/payments-history")
public class PaymentHistoryController extends AbstractController<UUID, PaymentHistoryRequest, PaymentHistoryResponse, PaymentHistoryService> {
}
